package com.realcomp.address;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BGoering
 * @author krenfro
 */
@XmlRootElement
public class Address implements Serializable {

    private String address;
    private String city;
    private String state;
    private String zip;
    private String crrt;
    private String postnetBarcode;
    private String imBarcode;
    private String fips;
    private Double latitude;
    private Double longitude;
    private LatLongAccuracy latLongAccuracy;
    private AddressType type;
    private AddressQuality quality;

    /*
     * Including the parsed address for legacy (ash) purposes.
     * Eventually, a full text search of the address line should satisfy walk-the-street searches.
     * Alternatively, if we had a reliable address parser, this could be eliminated.
     */
    private ParsedStreetAddress parsed;


    public Address(){
    }

    public Address(Address copy){
        address = copy.address;
        city = copy.city;
        state = copy.state;
        zip = copy.zip;
        crrt = copy.crrt;
        postnetBarcode = copy.postnetBarcode;
        imBarcode = copy.imBarcode;
        fips = copy.fips;
        latitude = copy.latitude;
        longitude = copy.longitude;
        latLongAccuracy = copy.latLongAccuracy;
        type = copy.type;
        quality = copy.quality;

        if (copy.parsed != null){
            parsed = new ParsedStreetAddress(copy.parsed);
        }

    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressQuality getQuality() {
        return quality;
    }

    public void setQuality(AddressQuality quality) {
        this.quality = quality;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCrrt() {
        return crrt;
    }

    public void setCrrt(String crrt) {
        this.crrt = crrt;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public String getImBarcode() {
        return imBarcode;
    }

    public void setImBarcode(String imBarcode) {
        this.imBarcode = imBarcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPostnetBarcode() {
        return postnetBarcode;
    }

    public void setPostnetBarcode(String postnetBarcode) {
        this.postnetBarcode = postnetBarcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public LatLongAccuracy getLatLongAccuracy() {
        return latLongAccuracy;
    }

    public void setLatLongAccuracy(LatLongAccuracy latLongAccuracy) {
        this.latLongAccuracy = latLongAccuracy;
    }

    public ParsedStreetAddress getParsed(){
        return parsed;
    }

    public void setParsed(ParsedStreetAddress parsed){
        this.parsed = parsed;
    }

    @Override
    public String toString() {
        StringAppender sa = new StringAppender(" ");
        sa.append(address.toString());
        sa.append(city);
        if (city != null && state != null && !city.isEmpty() && !state.isEmpty())
            sa.append(",", "");
        sa.append(state);
        sa.append(zip);
        if (fips != null) {
            sa.append("[fips:");
            sa.append(fips, "");
            sa.append("]", "");
        }
        return sa.toString().trim();
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 89 * hash + (this.address != null ? this.address.hashCode() : 0);
        hash = 89 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 89 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 89 * hash + (this.zip != null ? this.zip.hashCode() : 0);
        hash = 89 * hash + (this.crrt != null ? this.crrt.hashCode() : 0);
        hash = 89 * hash + (this.postnetBarcode != null ? this.postnetBarcode.hashCode() : 0);
        hash = 89 * hash + (this.imBarcode != null ? this.imBarcode.hashCode() : 0);
        hash = 89 * hash + (this.fips != null ? this.fips.hashCode() : 0);
        hash = 89 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 89 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 89 * hash + (this.latLongAccuracy != null ? this.latLongAccuracy.hashCode() : 0);
        hash = 89 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 89 * hash + (this.quality != null ? this.quality.hashCode() : 0);
        hash = 89 * hash + (this.parsed != null ? this.parsed.hashCode() : 0);
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
        if ((this.zip == null) ? (other.zip != null) : !this.zip.equals(other.zip)){
            return false;
        }
        if ((this.crrt == null) ? (other.crrt != null) : !this.crrt.equals(other.crrt)){
            return false;
        }
        if ((this.postnetBarcode == null) ? (other.postnetBarcode != null) : !this.postnetBarcode.equals(other.postnetBarcode)){
            return false;
        }
        if ((this.imBarcode == null) ? (other.imBarcode != null) : !this.imBarcode.equals(other.imBarcode)){
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
        if (this.latLongAccuracy != other.latLongAccuracy){
            return false;
        }
        if (this.type != other.type){
            return false;
        }
        if (this.quality != other.quality){
            return false;
        }
        if (this.parsed != other.parsed && (this.parsed == null || !this.parsed.equals(other.parsed))){
            return false;
        }
        return true;
    }

}
