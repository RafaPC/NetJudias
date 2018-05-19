/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daw
 */
public class Arrive {
    private int stopId;
    private String lineId;
    private String destination;
    private String latitude;
    private String longitude;
    private int busPositionType;
    private int busTimeLeft;
    private String busId;

    
    
    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getBusPositionType() {
        return busPositionType;
    }

    public void setBusPositionType(int busPositionType) {
        this.busPositionType = busPositionType;
    }

    public int getBusTimeLeft() {
        return busTimeLeft;
    }

    public void setBusTimeLeft(int busTimeLeft) {
        this.busTimeLeft = busTimeLeft;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }
    
}
