package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 * @author krenfro
 */
public class Geolocation implements Serializable {

    protected double latitude;
    protected double longitude;
    protected LatLongAccuracy accuracy;

    protected String censusTract;
    protected String censusBlockGroup;

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

    /**
     *
     * @return the accuracy, never null
     */
    public LatLongAccuracy getAccuracy(){
        return accuracy;
    }

    /**
     *
     * @param accuracy not null
     */
    public void setAccuracy(LatLongAccuracy accuracy){
        if (accuracy == null){
            throw new IllegalArgumentException("accuracy is null");
        }

        this.accuracy = accuracy;
    }

    public String getCensusTract(){
        return censusTract;
    }

    public void setCensusTract(String censusTract){
        this.censusTract = censusTract;
    }

    public String getCensusBlockGroup(){
        return censusBlockGroup;
    }

    public void setCensusBlockGroup(String censusBlockGroup){
        this.censusBlockGroup = censusBlockGroup;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 41 * hash + (this.accuracy != null ? this.accuracy.hashCode() : 0);
        hash = 41 * hash + (this.censusTract != null ? this.censusTract.hashCode() : 0);
        hash = 41 * hash + (this.censusBlockGroup != null ? this.censusBlockGroup.hashCode() : 0);
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
        if ((this.censusTract == null) ? (other.censusTract != null) : !this.censusTract.equals(other.censusTract)){
            return false;
        }
        if ((this.censusBlockGroup == null) ? (other.censusBlockGroup != null) : !this.censusBlockGroup.equals(other.censusBlockGroup)){
            return false;
        }
        return true;
    }

}
