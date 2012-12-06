package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 */
public class Geolocation implements Serializable {

    private double latitude;
    private double longitude;
    private LatLongAccuracy accuracy;

    public Geolocation(double latitude, double longitude, LatLongAccuracy accuracy){
        if (accuracy == null){
            throw new IllegalArgumentException("accuracy is null");
        }
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;

    }

    public Geolocation(Geolocation copy){
        latitude = copy.latitude;
        longitude = copy.longitude;
        accuracy = copy.accuracy;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LatLongAccuracy getLatLongAccuracy() {
        return accuracy;
    }

    public void setLatLongAccuracy(LatLongAccuracy latLongAccuracy) {
        if (accuracy == null){
            throw new IllegalArgumentException("accuracy is null");
        }
        this.accuracy = latLongAccuracy;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 97 * hash + (this.accuracy != null ? this.accuracy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Geolocation other = (Geolocation) obj;
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)){
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)){
            return false;
        }
        if (this.accuracy != other.accuracy){
            return false;
        }
        return true;
    }
}
