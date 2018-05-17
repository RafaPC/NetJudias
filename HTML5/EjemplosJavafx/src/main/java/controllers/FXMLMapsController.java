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
    private ComboBox fxCombo;

    private GoogleMap map;

    @FXML
    public void handleCombo(ActionEvent event) {
        System.out.println(fxCombo.getSelectionModel().getSelectedItem().toString());
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
            //Opciones Marcador
            MarkerOptions opcionesMarcador = new MarkerOptions();
            opcionesMarcador.position(new LatLong(latlongs[0].getLatitude(), latlongs[0].getLongitude()));
            opcionesMarcador.label(lines.getResultValues().get(i).getLabel());
            opcionesMarcador.title(lines.getResultValues().get(i).getLine());

            //Marcador
            Marker marcador = new Marker(opcionesMarcador);
            map.addMarker(marcador);

            //Opciones InfoWindow
            InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
            infoWindowOptions.content("Línea " + lines.getResultValues().get(i).getLabel()
                    + "</br>" + lines.getResultValues().get(i).getNameA() + " - " + lines.getResultValues().get(i).getNameB())
                    .position(new LatLong(latlongs[0].getLatitude(), latlongs[0].getLongitude()));
            //infoWindowOptions.maxWidth(10);
            //InfoWindow
            InfoWindow infoWindow = new InfoWindow(infoWindowOptions);
            infoWindow.open(map, marcador);
        }

        map.setZoom(16);

        BusDao b = new BusDao();

        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Arrives arrives = m.readValue(b.GetArrivesStop("2794"), new TypeReference<Arrives>() {
        });
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

        fxCombo.getItems().add("hola");
        fxCombo.getItems().add("hola1");
        fxCombo.getItems().add("hola2");
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

            fxCombo.getItems().add(ll.toString());
            InfoWindowOptions infoWindowOptions1 = new InfoWindowOptions();
            infoWindowOptions1.content("<h2>Fred Wilkie</h2>"
                    + "Current Location: Safeway<br>"
                    + "ETA: 45 minutes");

            InfoWindow fredWilkeInfoWindow1 = new InfoWindow(infoWindowOptions1);
            fredWilkeInfoWindow1.open(map, jbotanico);

        });

    }

//    public String GetListLines() throws IOException {
//        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//        JsonFactory JSON_FACTORY = new JacksonFactory();
//        HttpRequestFactory requestFactory
//                = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
//                    request.setParser(new JsonObjectParser(JSON_FACTORY));
//                });
//
//        GenericUrl url = new GenericUrl("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/bus/GetListLines.php");
//
//        GenericData data = new GenericData();
//        data.put("idClient", Constantes.ID_Client);
//        data.put("passKey", Constantes.CONTRASEÑA);
//
//        //pasamos de LocalDate a String
//        LocalDate localDate = LocalDate.now();//For reference
//        String sDate = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        data.put("SelectDate", sDate);
//
//        HttpRequest requestGoogle = requestFactory.buildPostRequest(url, new UrlEncodedContent(data));
//        return requestGoogle.execute().parseAsString();
//    }
}
