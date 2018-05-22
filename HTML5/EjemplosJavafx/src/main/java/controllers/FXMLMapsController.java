/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MVCArray;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import dao.BusDao;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Arrive;
import model.Arrives;
import model.ListLineInfo;
import model.ListsLinesInfo;
import model.StopsLine;
import netscape.javascript.JSObject;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLMapsController implements Initializable, MapComponentInitializedListener {
    
    @FXML
    private GoogleMapView mapView;
    
    @FXML
    private ComboBox<ListLineInfo> fxCombo;
    
    @FXML
    private VBox fxVBox;
    
    @FXML
    private Label fxParada;
    
    private Stage stage;
    
    private ListLineInfo lineaActual;
    
    private Marker autobus;
    
    private StopsLine stopsActual;
    
    private GoogleMap map;
    
    private String busActual = "08";
    
    private BusDao bus;
    
    private Polyline pp;
    
    private Marker comienzoLinea;
    
    private Marker finalLinea;
    
    private InfoWindow infoWindowComienzoLinea;
    
    private InfoWindow infoWindowFinalLinea;
    
    private String colorLinea;
    
    @FXML
    public void handleCombo(ActionEvent event) throws IOException {
        
        if (pp != null) {
            map.removeMarker(comienzoLinea);
            map.removeMarker(finalLinea);
            map.removeMapShape(pp);
            infoWindowComienzoLinea.close();
            infoWindowFinalLinea.close();
            fxParada.setVisible(false);
            fxVBox.setVisible(false);
        }
        pintarLinea(fxCombo.getSelectionModel().getSelectedItem());
    }
    
    private void pintarLinea(ListLineInfo linea) throws IOException {

        if (fxCombo.getSelectionModel().getSelectedItem() != lineaActual) {
            if(pp != null){
                map.removeMapShape(pp);
            }
            map.clearMarkers();
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            colorLinea = "#" + Integer.toHexString(randomColor.getRGB()).substring(2);
        }
        lineaActual = linea;
        
        map.clearMarkers();
        //Crear color hexadecimal aleatorio

        //Sacar las paradas de la linea actual
        stopsActual = bus.GetStopsLine(linea.getLine(), linea.getNameA());
        if (stopsActual == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error al cargar", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            //Crear array para guardar las posiciones de las paradas
            LatLong[] latlongs = new LatLong[stopsActual.getStop().size()];
            
            putMarkers(latlongs, stopsActual, 0);

            //Pintar la línea actual con todas sus paradas
            MVCArray array = new MVCArray(latlongs);
            
            PolylineOptions polyOpts = new PolylineOptions()
                    .path(array)
                    .strokeColor(colorLinea)
                    .strokeWeight(5);
            pp = new Polyline(polyOpts);
            
            map.addMapShape(pp);

            //Poner un marcador en la primera parada de cada línea
            //Opciones Marcador
            MarkerOptions opcionesMarcadorStart = new MarkerOptions()
                    .position(new LatLong(latlongs[0].getLatitude(), latlongs[0].getLongitude()))
                    .label(linea.getLabel())
                    .title(linea.getLine());

            //Opciones Marcador final de línea
            MarkerOptions opcionesMarcadorEnd = new MarkerOptions()
                    .position(new LatLong(latlongs[latlongs.length - 1].getLatitude(), latlongs[latlongs.length - 1].getLongitude()))
                    .label(linea.getLabel())
                    .title(linea.getLine());

            //Marcador
            comienzoLinea = new Marker(opcionesMarcadorStart);
            finalLinea = new Marker(opcionesMarcadorEnd);
//        map.addMarker(marcadorStart);
//        map.addMarker(marcadorEnd);

            //Opciones InfoWindowStart
            InfoWindowOptions infoWindowOptionsStart = new InfoWindowOptions();
            infoWindowOptionsStart.content("Línea " + linea.getLabel()
                    + "</br>" + linea.getNameA())
                    .position(new LatLong(latlongs[0].getLatitude(), latlongs[0].getLongitude()));

            //Opciones InfoWindowEnd
            InfoWindowOptions infoWindowOptionsEnd = new InfoWindowOptions();
            infoWindowOptionsEnd.content("Línea " + linea.getLabel()
                    + "</br>" + linea.getNameB())
                    .position(new LatLong(latlongs[latlongs.length - 1].getLatitude(), latlongs[latlongs.length - 1].getLongitude()));
            //InfoWindow
            infoWindowComienzoLinea = new InfoWindow(infoWindowOptionsStart);
            infoWindowFinalLinea = new InfoWindow(infoWindowOptionsEnd);
            infoWindowComienzoLinea.open(map);
            infoWindowFinalLinea.open(map);
        }
    }
    
    private void putMarkers(LatLong[] latlongs, StopsLine stops, int opcion) throws IOException {
        if (opcion == 1) {
            map.clearMarkers();
        }
        for (int j = 0; j < stops.getStop().size(); j++) {
            LatLong x = new LatLong(stops.getStop().get(j).getLatitude(), stops.getStop().get(j).getLongitude());
            latlongs[j] = x;
            
            MarkerOptions opcionesMarcadorParada = new MarkerOptions()
                    .position(new LatLong(stops.getStop().get(j).getLatitude(), stops.getStop().get(j).getLongitude()))
                    .label(stops.getStop().get(j).getStopId());
            Marker parada = new Marker(opcionesMarcadorParada);
            map.addMarker(parada);
            
            Arrives arrives = bus.GetArrivesStop(stops.getStop().get(j).getStopId());
            String paradaNombre = stops.getStop().get(j).getName();
            map.addUIEventHandler(parada, UIEventType.click, (JSObject obj) -> {
                
                try {
                    arrivesParada(arrives);
                    fxParada.setText(paradaNombre);
                    fxParada.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLMapsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }
    
    private void arrivesParada(Arrives arrives) throws IOException {
        fxVBox.getChildren().clear();
        
        Button cerrar = new Button();
        cerrar.setText("Cerrar ventana");
        cerrar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fxVBox.setVisible(false);
            }
        });
        
        fxVBox.getChildren().add(cerrar);

        //LINEA
        Label titulo1 = new Label("Líneas");
        titulo1.setMinWidth(120);
        titulo1.setAlignment(Pos.CENTER_LEFT);
        titulo1.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill:#000000");

        //TIEMPO        
        Label titulo2 = new Label("Tiempo");
        titulo2.setMaxWidth(Double.MAX_VALUE);
        titulo2.setAlignment(Pos.CENTER_RIGHT);
        titulo2.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill:#000000");
        titulo2.setAlignment(Pos.CENTER_RIGHT);
        
        HBox lineaTitulo = new HBox(titulo1, titulo2);
        lineaTitulo.setMaxWidth(Double.MAX_VALUE);
        lineaTitulo.setStyle("-fx-border-style:solid;-fx-border-width:2px;-fx-border-color:black;");
        fxVBox.getChildren().add(lineaTitulo);
        
        int i;
        for (i = 0; i < arrives.getArrives().size(); i++) {
            List<String> x = new ArrayList<>();
            x.add(arrives.getArrives().get(i).getLineId());
            //Añado otro porque si no hay problemas en como devuelve el json
            x.add("008");
            ListsLinesInfo listaLinea = bus.GetListLines(x);
            ListLineInfo linea = listaLinea.getResultValues().get(0);

            //Coger el tiempo que va a tardar el bus
            Integer segundos = new Integer(arrives.getArrives().get(i).getBusTimeLeft());
            String tiempo;
            int ancho;
            if (segundos == 0) {
                tiempo = "En parada";
                ancho = 140;
            } else if (segundos >= 1200) {
                tiempo = ">20";
                ancho = 170;
            } else {
                tiempo = segundos / 60 + " min";
                ancho = 160;
            }
            Label destino = new Label("Destino: " + arrives.getArrives().get(i).getDestination());
            VBox lineaCosa = new VBox(new Label(arrives.getArrives().get(i).getLineId() + "    "), destino);

            //Para hacer el vbox mas alto cuando mas buses haya
            lineaCosa.setMaxWidth(ancho);
            lineaCosa.setMinWidth(ancho);
            VBox tiempoCosa = new VBox(new Label(tiempo));
            HBox fila = new HBox(new VBox(lineaCosa), tiempoCosa);
            fila.setStyle("-fx-border-style:solid;-fx-border-width:1px;-fx-border-color: #000000;-fx-background-color: #00B4FF;");
            
            busActual = arrives.getArrives().get(i).getBusId();
            String stopSelected = arrives.getArrives().get(i).getStopId() + "";
            //Añadir evento
            fila.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        loadBus(busActual, stopSelected);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLMapsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            fxVBox.getChildren().add(fila);
            
        }
        fxVBox.setMaxHeight(stage.getHeight());
        fxVBox.setPrefHeight(i * 50);
        fxVBox.setMinHeight(i * 60);
        
        fxVBox.setVisible(true);
    }
    
    public void loadBus(String idBus, String idStop) throws IOException {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(10), e -> {
                    try {
                        System.out.println("BUS");
                        Arrives arrives = bus.GetArrivesStop(idStop);
                        
                        for (Arrive auto : arrives.getArrives()) {
                            if (auto.getBusId().equals(idBus)) {
                                if (autobus != null) {
                                    map.removeMarker(autobus);
                                }
                                LatLong[] latlongs = new LatLong[stopsActual.getStop().size()];
                                LatLong punto = new LatLong(Double.parseDouble(auto.getLatitude()),
                                        Double.parseDouble(auto.getLongitude()));
                                
                                MarkerOptions markerOptions = new MarkerOptions();
                                markerOptions.position(punto);
                                markerOptions.title(auto.getBusId());
                                markerOptions.label("BUS");
                                
                                autobus = new Marker(markerOptions);
                                map.addMarker(autobus);
                                map.setCenter(punto);
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLMapsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                })
        );
        timeline.setCycleCount(20);
        timeline.play();
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mapView.addMapInializedListener(this);
        fxVBox.setSpacing(7);
        bus = new BusDao();
        
        List<String> line = new ArrayList();
        try {
            fxCombo.getItems().addAll(
                    bus.GetListLines(line).getResultValues());
        } catch (IOException ex) {
            Logger.getLogger(FXMLMapsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setWindowListener() {
        stage.maximizedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.               
                if (stage.isMaximized()) {
                    fxVBox.setLayoutX(1718);
                    fxVBox.setMaxHeight(1080);
                } else {
                    fxVBox.setLayoutX(400);                    
                    fxVBox.setMaxHeight(438);
                }
            }
        });
//        stage.resizableProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
////                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                System.out.println("cambia de tamaño");
//            }
//        });
//        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
//            
//        });
//        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue)
//                -> fxVBox.setLayoutX(stage.getWidth()*0.7);
//        stage.widthProperty().addListener(stageSizeListener);
    }
    
    @Override
    public void mapInitialized() {

        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(40.400999, -3.694545))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);
        map = mapView.createMap(mapOptions);
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
