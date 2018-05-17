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
import java.util.ArrayList;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ArrayMap;
import com.google.api.client.util.GenericData;

import controllers.FXMLMapsController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arrive;
import model.Arrives;
import model.ListLineInfo;
import model.ListsLinesInfo;
import model.Stop;
import model.StopsLine;

/**
 *
 * @author user
 */
public class BusDao {

    public static void main(String[] args) throws IOException {
        BusDao b = new BusDao();

        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//        StopsLines stops = m.readValue(b.GetStopsLine("76", "PLAZA BEATA"), 
//          new TypeReference<StopsLines>() {
//        });
        StopsLine stops = (b.GetStopsLine("76", "PLAZA BEATA"));

        for (Stop stop : stops.getStop()) {
            System.out.println(stop.getStopId());
        }

        System.out.println(b.GetArrivesStop("2794"));

        Arrives arrives = m.readValue(b.GetArrivesStop("2794"), new TypeReference<Arrives>() {
        });
        for (Arrive stop : arrives.getArrives()) {
            System.out.println(stop.getStopId());
            System.out.println(stop.getBusTimeLeft());
            System.out.println(stop.getLatitude());
            System.out.println(stop.getLongitude());
            System.out.println(stop.getBusPositionType());
        }

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
        StopsLine stops = m.readValue(requestGoogle.execute().parseAsString(), new TypeReference<StopsLine>() {
        });

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
                if(i==0){
                    ln += lineas.get(i);
                }else{
                    ln += "|" + lineas.get(i);
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
        while (intentos == 0) {
            try {
                lines = m.readValue(requestGoogle.execute().parseAsString(), new TypeReference<ListsLinesInfo>() {
                });
                intentos++;
            } catch (Exception ex) {
                Logger.getLogger(BusDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lines;
    }

    public String GetArrivesStop(String idStop) throws IOException {
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
        return requestGoogle.execute().parseAsString();
    }

}
