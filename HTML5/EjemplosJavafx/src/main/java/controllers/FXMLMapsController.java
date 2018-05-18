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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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

    private GoogleMap map;

    private BusDao bus;

    private Polyline pp;

    private Marker comienzoLinea;

    private Marker finalLinea;

    private InfoWindow infoWindowComienzoLinea;

    private InfoWindow infoWindowFinalLinea;

    @FXML
    public void handleCombo(ActionEvent event) throws IOException {
        if (pp != null) {
            map.removeMarker(comienzoLinea);
            map.removeMarker(finalLinea);
            map.removeMapShape(pp);
            infoWindowComienzoLinea.close();
            infoWindowFinalLinea.close();
        }
        pintarLinea(fxCombo.getSelectionModel().getSelectedItem());
    }

    private void loadBud() throws IOException {
        BusDao bus = new BusDao();
//        StopsLine stops = bus.GetStopsLine("76", "PLAZA BEATA");
        List<String> z = new ArrayList<String>();
        z.add("76");
        z.add("85");
        ListsLinesInfo lines = bus.GetListLines(z);
        Random rand = new Random();
        boolean primero;
        map.clearMarkers();
        for (int i = 0; i < lines.getResultValues().size(); i++) {

            //Crear color hexadecimal aleatorio
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            String colorHex = "#" + Integer.toHexString(randomColor.getRGB()).substring(2);

            //Sacar las paradas de la linea actual
            StopsLine stops = bus.GetStopsLine(lines.getResultValues().get(i).getLine(), lines.getResultValues().get(i).getNameA());

            //Crear array para guardar las posiciones de las paradas
            LatLong[] latlongs = new LatLong[stops.getStop().size()];

            for (int j = 0; j < stops.getStop().size(); j++) {
                LatLong x = new LatLong(stops.getStop().get(j).getLatitude(), stops.getStop().get(j).getLongitude());
                latlongs[j] = x;
            }

            //Pintar la línea actual con todas sus paradas
            MVCArray array = new MVCArray(latlongs);

            PolylineOptions polyOpts = new PolylineOptions()
                    .path(array)
                    .strokeColor(colorHex)
                    .strokeWeight(2);
            Polyline pp = new Polyline(polyOpts);

            map.addMapShape(pp);

            //Poner un marcador en la primera parada de cada línea
            //Opciones Marcador principio de línea
            MarkerOptions opcionesMarcadorStart = new MarkerOptions();
            opcionesMarcadorStart.position(new LatLong(latlongs[0].getLatitude(), latlongs[0].getLongitude()));
            opcionesMarcadorStart.label(lines.getResultValues().get(i).getLabel());
            opcionesMarcadorStart.title(lines.getResultValues().get(i).getLine());

            //Opciones Marcador final de línea
            MarkerOptions opcionesMarcadorEnd = new MarkerOptions();
            opcionesMarcadorEnd.position(new LatLong(latlongs[latlongs.length].getLatitude(), latlongs[latlongs.length].getLongitude()));
            //Marcador
            Marker marcadorStart = new Marker(opcionesMarcadorStart);
            map.addMarker(marcadorStart);

            //Opciones InfoWindow
            InfoWindowOptions infoWindowOptionsStart = new InfoWindowOptions();
            infoWindowOptionsStart.content("Línea " + lines.getResultValues().get(i).getLabel()
                    + "</br>" + lines.getResultValues().get(i).getNameA() + " - " + lines.getResultValues().get(i).getNameB())
                    .position(new LatLong(latlongs[0].getLatitude(), latlongs[0].getLongitude()));
            //infoWindowOptions.maxWidth(10);
            //InfoWindow
            InfoWindow infoWindow = new InfoWindow(infoWindowOptionsStart);
            infoWindow.open(map, marcadorStart);
        }

        map.setZoom(16);

        BusDao b = new BusDao();

        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Arrives arrives = b.GetArrivesStop("2794");
        for (Arrive stop : arrives.getArrives()) {
            System.out.println(stop.getStopId());
            System.out.println(stop.getBusTimeLeft());
            System.out.println(stop.getLatitude());
            System.out.println(stop.getLongitude());
            System.out.println(stop.getBusPositionType());
            LatLong punto = new LatLong(Double.parseDouble(stop.getLatitude()),
                    Double.parseDouble(stop.getLongitude()));
            map.setCenter(punto);
            MarkerOptions markerOptions5 = new MarkerOptions();
            markerOptions5.position(punto);
            markerOptions5.title(stop.getBusId());

            Marker joeSmithMarker = new Marker(markerOptions5);
            map.addMarker(joeSmithMarker);

        }
    }

    private void pintarLinea(ListLineInfo linea) throws IOException {
        Random rand = new Random();
        map.clearMarkers();

        //Crear color hexadecimal aleatorio
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        String colorHex = "#" + Integer.toHexString(randomColor.getRGB()).substring(2);

        //Sacar las paradas de la linea actual
        StopsLine stops = bus.GetStopsLine(linea.getLine(), linea.getNameA());

        //Crear array para guardar las posiciones de las paradas
        LatLong[] latlongs = new LatLong[stops.getStop().size()];

        putMarkers(latlongs, stops);

//        for (int j = 0; j < stops.getStop().size(); j++) {
//            LatLong x = new LatLong(stops.getStop().get(j).getLatitude(), stops.getStop().get(j).getLongitude());
//            latlongs[j] = x;
//            if (j != 0 && j != stops.getStop().size()) {
//
//                MarkerOptions opcionesMarcadorParada = new MarkerOptions()
//                        .position(new LatLong(stops.getStop().get(j).getLatitude(), stops.getStop().get(j).getLongitude()))
//                        .label(stops.getStop().get(j).getStopId());
//                Marker parada = new Marker(opcionesMarcadorParada);
//                map.addMarker(parada);
//
//                Arrives arrives = bus.GetArrivesStop(stops.getStop().get(j).getStopId());
//                map.addUIEventHandler(parada, UIEventType.click, (JSObject obj) -> {
//
//                    arrivesParada(arrives);
//                });
//
//            }
//
//        }

        //Pintar la línea actual con todas sus paradas
        MVCArray array = new MVCArray(latlongs);

        PolylineOptions polyOpts = new PolylineOptions()
                .path(array)
                .strokeColor(colorHex)
                .strokeWeight(2);
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

    private void putMarkers(LatLong[] latlongs, StopsLine stops) throws IOException {
        for (int j = 0; j < stops.getStop().size(); j++) {
            LatLong x = new LatLong(stops.getStop().get(j).getLatitude(), stops.getStop().get(j).getLongitude());
            latlongs[j] = x;
//            if (j != 0 && j != stops.getStop().size()) {

                MarkerOptions opcionesMarcadorParada = new MarkerOptions()
                        .position(new LatLong(stops.getStop().get(j).getLatitude(), stops.getStop().get(j).getLongitude()))
                        .label(stops.getStop().get(j).getStopId());
                Marker parada = new Marker(opcionesMarcadorParada);
                map.addMarker(parada);

                Arrives arrives = bus.GetArrivesStop(stops.getStop().get(j).getStopId());
                map.addUIEventHandler(parada, UIEventType.click, (JSObject obj) -> {

                    arrivesParada(arrives);
                });
        }
    }

    private void arrivesParada(Arrives arrives) {
        System.out.println("Próximos buses");             
        for (int i = 0; i < arrives.getArrives().size(); i++) {
            System.out.println("Número bus: " + arrives.getArrives().get(i).getBusId());
            System.out.println("Tiempo id: " + arrives.getArrives().get(i).getBusTimeLeft()/60);
            System.out.println("Destino: " + arrives.getArrives().get(i).getDestination());
        }
    }

    @FXML
    public void handleButton(ActionEvent event) throws IOException {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(4), e -> {
                    try {
                        loadBud();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLMapsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                })
        );
        timeline.setCycleCount(0);
        timeline.play();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mapView.addMapInializedListener(this);
        bus = new BusDao();
//        fxCombo.getItems().add("hola");
//        fxCombo.getItems().add("hola1");
//        fxCombo.getItems().add("hola2");

        List<String> line = new ArrayList();
        try {
            fxCombo.getItems().addAll(
                    bus.GetListLines(line).getResultValues());
        } catch (IOException ex) {
            Logger.getLogger(FXMLMapsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void mapInitialized() {
        LatLong joeSmithLocation = new LatLong(47.6197, -122.3231);
        LatLong joshAndersonLocation = new LatLong(47.6297, -122.3431);
        LatLong bobUnderwoodLocation = new LatLong(47.6397, -122.3031);
        LatLong tomChoiceLocation = new LatLong(47.6497, -122.3325);
        LatLong fredWilkieLocation = new LatLong(47.6597, -122.3357);

        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(40.369991, -3.694543))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);
        map = mapView.createMap(mapOptions);

        //Add markers to the map
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(new LatLong(40.410757, -3.690594));
        markerOptions1.label("LABEL");
        markerOptions1.title("TITLE");
        //markerOptions1.icon("https://png.clipart.me/istock/previews/5059/50591994-bus-icon-glossy-green-round-button.jpg");
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(joshAndersonLocation);

        Marker jbotanico = new Marker(markerOptions1);
        Marker joshAndersonMarker = new Marker(markerOptions2);

        map.addMarker(jbotanico);
        map.addMarker(joshAndersonMarker);

        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Fred Wilkie</h2>"
                + "Current Location: Real Jardín Botánico<br>"
                + "ETA: 45 minutes")
                .position(new LatLong(40.429980, -3.704352));

        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
        fredWilkeInfoWindow.open(map, jbotanico);
        mapView.getMap().addUIEventHandler(jbotanico, UIEventType.click, (JSObject obj) -> {
            LatLong ll = new LatLong((JSObject) obj.getMember("latLng"));

//            fxCombo.getItems().add(ll.toString());
            InfoWindowOptions infoWindowOptions1 = new InfoWindowOptions();
            infoWindowOptions1.content("<h2>Fred Wilkie</h2>"
                    + "Current Location: Safeway<br>"
                    + "ETA: 45 minutes");

            InfoWindow fredWilkeInfoWindow1 = new InfoWindow(infoWindowOptions1);
            fredWilkeInfoWindow1.open(map, jbotanico);
        });
    }

}
