package com.realcomp.address;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BGoering
 * @author krenfro
 */
@XmlRootElement
public class Address implements Serializable{

    private String address;
    private String city;
    private String state;
    private String zip5;
    private String zip4;
    private String crrt;
    private String fips;
    private Double latitude;
    private Double longitude;
    private String deliveryPoint;
    private String dpvFlag;
    private LatLongAccuracy latLongAccuracy;
    private AddressType type;
    private AddressQuality quality;
    private boolean vacant = false;
    private ParsedStreetAddress parsed;

    public Address(){
    }

    public Address(Address copy){
        address = copy.address;
        city = copy.city;
        state = copy.state;
        zip5 = copy.zip5;
        zip4 = copy.zip4;
        crrt = copy.crrt;
        fips = copy.fips;
        latitude = copy.latitude;
        longitude = copy.longitude;
        latLongAccuracy = copy.latLongAccuracy;
        type = copy.type;
        quality = copy.quality;
        vacant = copy.vacant;
        deliveryPoint = copy.deliveryPoint;
        dpvFlag = copy.dpvFlag;

        if (copy.parsed != null){
            parsed = new ParsedStreetAddress(copy.parsed);
        }

    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public AddressQuality getQuality(){
        return quality;
    }

    public void setQuality(AddressQuality quality){
        this.quality = quality;
    }

    public AddressType getType(){
        return type;
    }

    public void setType(AddressType type){
        this.type = type;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCrrt(){
        return crrt;
    }

    public void setCrrt(String crrt){
        this.crrt = crrt;
    }

    public String getFips(){
        return fips;
    }

    public void setFips(String fips){
        this.fips = fips;
    }

    public Double getLatitude(){
        return latitude;
    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public Double getLongitude(){
        return longitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getZip5(){
        return zip5;
    }

    public void setZip5(String zip5){
        this.zip5 = zip5;
    }

    public String getZip4(){
        return zip4;
    }

    public void setZip4(String zip4){
        this.zip4 = zip4;
    }

    public LatLongAccuracy getLatLongAccuracy(){
        return latLongAccuracy;
    }

    public void setLatLongAccuracy(LatLongAccuracy latLongAccuracy){
        this.latLongAccuracy = latLongAccuracy;
    }

    public ParsedStreetAddress getParsed(){
        return parsed;
    }

    public void setParsed(ParsedStreetAddress parsed){
        this.parsed = parsed;
    }

    /**
     * A delivery point was active in the past, but is currently vacant (in most cases, unoccupied over 90 days) and not
     * receiving delivery.
     *
     * @return
     */
    public boolean isVacant(){
        return vacant;
    }

    public void setVacant(boolean vacant){
        this.vacant = vacant;
    }

    /**
     *
     * @return delivery point
     */
    public String getDeliveryPoint(){
        return deliveryPoint;
    }

    public void setDeliveryPoint(String dp){
        this.deliveryPoint = dp;
    }

    /**
     * @return vendor dpv flag (e.g., "BB", "CC", "N1", "M1", "M3", ...)
     */
    public String getDpvFlag(){
        return dpvFlag;
    }

    public void setDpvFlag(String dpvFlag){
        this.dpvFlag = dpvFlag;
    }

    @Override
    public String toString(){
        StringAppender sa = new StringAppender(" ");
        sa.append(address);
        sa.append(city);
        if (city != null && state != null && !city.isEmpty() && !state.isEmpty()){
            sa.append(",", "");
        }
        sa.append(state);
        sa.append(zip5);
        if (fips != null){
            sa.append(" [fips:");
            sa.append(fips, "");
            sa.append("]", "");
        }
        return sa.toString().trim();
    }

    @Generated("NetBeans")
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + (this.address != null ? this.address.hashCode() : 0);
        hash = 97 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 97 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 97 * hash + (this.zip5 != null ? this.zip5.hashCode() : 0);
        hash = 97 * hash + (this.zip4 != null ? this.zip4.hashCode() : 0);
        hash = 97 * hash + (this.crrt != null ? this.crrt.hashCode() : 0);
        hash = 97 * hash + (this.fips != null ? this.fips.hashCode() : 0);
        hash = 97 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 97 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 97 * hash + (this.deliveryPoint != null ? this.deliveryPoint.hashCode() : 0);
        hash = 97 * hash + (this.dpvFlag != null ? this.dpvFlag.hashCode() : 0);
        hash = 97 * hash + (this.latLongAccuracy != null ? this.latLongAccuracy.hashCode() : 0);
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 97 * hash + (this.quality != null ? this.quality.hashCode() : 0);
        hash = 97 * hash + (this.vacant ? 1 : 0);
        hash = 97 * hash + (this.parsed != null ? this.parsed.hashCode() : 0);
        return hash;
    }

    @Generated("NetBeans")
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Address other = (Address) obj;
        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)){
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)){
            return false;
        }
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state)){
            return false;
        }
        if ((this.zip5 == null) ? (other.zip5 != null) : !this.zip5.equals(other.zip5)){
            return false;
        }
        if ((this.zip4 == null) ? (other.zip4 != null) : !this.zip4.equals(other.zip4)){
            return false;
        }
        if ((this.crrt == null) ? (other.crrt != null) : !this.crrt.equals(other.crrt)){
            return false;
        }
        if ((this.fips == null) ? (other.fips != null) : !this.fips.equals(other.fips)){
            return false;
        }
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))){
            return false;
        }
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))){
            return false;
        }
        if ((this.deliveryPoint == null) ? (other.deliveryPoint != null) : !this.deliveryPoint.equals(other.deliveryPoint)){
            return false;
        }
        if ((this.dpvFlag == null) ? (other.dpvFlag != null) : !this.dpvFlag.equals(other.dpvFlag)){
            return false;
        }
        if (this.latLongAccuracy != other.latLongAccuracy){
            return false;
        }
        if (this.type != other.type){
            return false;
        }
        if (this.quality != other.quality){
            return false;
        }
        if (this.vacant != other.vacant){
            return false;
        }
        if (this.parsed != other.parsed && (this.parsed == null || !this.parsed.equals(other.parsed))){
            return false;
        }
        return true;
    }

     public int test(){
        int hash = 7;
        hash = 97 * hash + (this.address != null ? this.address.hashCode() : 0);
        hash = 97 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 97 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 97 * hash + (this.zip5 != null ? this.zip5.hashCode() : 0);
        hash = 97 * hash + (this.zip4 != null ? this.zip4.hashCode() : 0);
        hash = 97 * hash + (this.crrt != null ? this.crrt.hashCode() : 0);
        hash = 97 * hash + (this.fips != null ? this.fips.hashCode() : 0);
        hash = 97 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 97 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 97 * hash + (this.deliveryPoint != null ? this.deliveryPoint.hashCode() : 0);
        hash = 97 * hash + (this.dpvFlag != null ? this.dpvFlag.hashCode() : 0);
        hash = 97 * hash + (this.latLongAccuracy != null ? this.latLongAccuracy.hashCode() : 0);
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 97 * hash + (this.quality != null ? this.quality.hashCode() : 0);
        hash = 97 * hash + (this.vacant ? 1 : 0);
        hash = 97 * hash + (this.parsed != null ? this.parsed.hashCode() : 0);
        return hash;
    }
}
