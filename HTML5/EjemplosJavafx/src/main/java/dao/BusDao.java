/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.GenericData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Arrives;
import model.ListLineInfo;
import model.ListsLinesInfo;
import model.StopsLine;

/**
 *
 * @author user
 */
public class BusDao {

    public static void main(String[] args) throws IOException {

    }

    public StopsLine GetStopsLine(String idLine, String Direccion) throws IOException {
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JsonFactory JSON_FACTORY = new JacksonFactory();
        HttpRequestFactory requestFactory
                = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                    request.setParser(new JsonObjectParser(JSON_FACTORY));
                });

        GenericUrl url = new GenericUrl("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/geo/GetStopsLine.php");

        GenericData data = new GenericData();
        data.put("idClient", "WEB.SERV.rafitap.c@hotmail.com");
        data.put("passKey", "84802663-D65C-4C6B-8372-0E8206AB6808");
        data.put("line", idLine);
        data.put("direction", Direccion);

        HttpRequest requestGoogle = requestFactory.buildPostRequest(url, new UrlEncodedContent(data));

        //Pasarlo de string a stopslines
        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        int intentos = 0;
        StopsLine stops = null;
        //Si da error al mandar la petición porque la pagina del emt no funciona o algo, lo intenta dos veces y más y 
        //si sigue dando error sale y si el objeto es null salta un aviso
        while (intentos < 3) {
            try {
                stops = m.readValue(requestGoogle.execute().parseAsString(), new TypeReference<StopsLine>() {
                });
                intentos = 3;
            } catch (Exception ex) {
                Logger.getLogger(BusDao.class.getName()).log(Level.SEVERE, null, ex);
                intentos++;
            }
        }
        return stops;
    }

    public ListsLinesInfo GetListLines(List<String> lineas) throws IOException {
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JsonFactory JSON_FACTORY = new JacksonFactory();
        HttpRequestFactory requestFactory
                = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                    request.setParser(new JsonObjectParser(JSON_FACTORY));
                });

        GenericUrl url = new GenericUrl("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/bus/GetListLines.php");

        GenericData data = new GenericData();
        data.put("idClient", "WEB.SERV.rafitap.c@hotmail.com");
        data.put("passKey", "84802663-D65C-4C6B-8372-0E8206AB6808");
        if (lineas.size() > 0) {
            String ln = "";
            for (int i = 0; i < lineas.size(); i++) {
                if (i == 0) {
                    ln += lineas.get(i);
                } else {
                    ln += " | " + lineas.get(i);
                }

            }
            data.put("Lines", ln);
        }
        //pasamos de LocalDate a String
        LocalDate localDate = LocalDate.now();//For reference
        String sDate = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        data.put("SelectDate", sDate);

        HttpRequest requestGoogle = requestFactory.buildPostRequest(url, new UrlEncodedContent(data));
        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        int intentos = 0;
        ListsLinesInfo lines = null;
        while (intentos < 3) {
            try {
                lines = m.readValue(requestGoogle.execute().parseAsString(), new TypeReference<ListsLinesInfo>() {
                });
                intentos = 3;
            } catch (Exception ex) {
                Logger.getLogger(BusDao.class.getName()).log(Level.SEVERE, null, ex);
                intentos++;
                if (intentos == 3) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Error al cargar", ButtonType.CLOSE);
                    a.showAndWait();
                }
            }
        }
        return lines;
    }

    public ListLineInfo GetLine(String linea) throws IOException {
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JsonFactory JSON_FACTORY = new JacksonFactory();
        HttpRequestFactory requestFactory
                = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                    request.setParser(new JsonObjectParser(JSON_FACTORY));
                });

        GenericUrl url = new GenericUrl("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/bus/GetListLines.php");

        GenericData data = new GenericData();
        data.put("idClient", "WEB.SERV.rafitap.c@hotmail.com");
        data.put("passKey", "84802663-D65C-4C6B-8372-0E8206AB6808");
        data.put("Lines", linea);

        //pasamos de LocalDate a String
        LocalDate localDate = LocalDate.now();//For reference
        String sDate = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        data.put("SelectDate", sDate);

        HttpRequest requestGoogle = requestFactory.buildPostRequest(url, new UrlEncodedContent(data));
        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        int intentos = 0;
        ListsLinesInfo array = null;
        ListLineInfo line = null;
        while (intentos == 0) {
            try {
                array = m.readValue(requestGoogle.execute().parseAsString(), new TypeReference<ListsLinesInfo>() {
                });
                line = array.getResultValues().get(0);
                intentos++;
            } catch (Exception ex) {
                Logger.getLogger(BusDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return line;
    }

    public Arrives GetArrivesStop(String idStop) throws IOException {
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JsonFactory JSON_FACTORY = new JacksonFactory();
        HttpRequestFactory requestFactory
                = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                    request.setParser(new JsonObjectParser(JSON_FACTORY));
                });

        GenericUrl url = new GenericUrl("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/geo/GetArriveStop.php");

        GenericData data = new GenericData();
        data.put("idClient", "WEB.SERV.rafitap.c@hotmail.com ");
        data.put("passKey", "84802663-D65C-4C6B-8372-0E8206AB6808");
        data.put("idStop", idStop);

        HttpRequest requestGoogle = requestFactory.buildPostRequest(url, new UrlEncodedContent(data));

        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        int intentos = 0;
        Arrives arrives = null;
        while (intentos < 3) {
            try {
                arrives = m.readValue(requestGoogle.execute().parseAsString(), new TypeReference<Arrives>() {
                });
                intentos = 3;
            } catch (Exception ex) {
                Logger.getLogger(BusDao.class.getName()).log(Level.SEVERE, null, ex);
                intentos++;
            }
        }

        return arrives;
    }

}
