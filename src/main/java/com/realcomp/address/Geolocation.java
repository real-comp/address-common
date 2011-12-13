package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 * @deprecated
 */
public class Geolocation implements Serializable {

    private double latitude;
    private double longitude;
    private LatLongAccuracy latLongAccuracy;

    public Geolocation(){
    }

    public Geolocation(Geolocation copy){
        latitude = copy.latitude;
        longitude = copy.longitude;
        latLongAccuracy = copy.latLongAccuracy;
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
        return latLongAccuracy;
    }

    public void setLatLongAccuracy(LatLongAccuracy latLongAccuracy) {
        this.latLongAccuracy = latLongAccuracy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Geolocation other = (Geolocation) obj;
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude))
            return false;
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude))
            return false;
        if (this.latLongAccuracy != other.latLongAccuracy)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.latitude) ^
                (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.longitude) ^
                (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 29 * hash + (this.latLongAccuracy != null ? this.latLongAccuracy.hashCode() : 0);
        return hash;
    }

}
