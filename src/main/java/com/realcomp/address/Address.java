package com.realcomp.address;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author BGoering
 * @author krenfro
 */
@XmlRootElement
public class Address implements Serializable{

    private String id;
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
    private LatLongAccuracy latLongAccuracy = LatLongAccuracy.UNKNOWN;
    private AddressType type = AddressType.UNKNOWN;
    private AddressQuality quality = AddressQuality.UNKNOWN;
    private boolean vacant = false;
    private ParsedStreetAddress parsed;

    public Address(){
    }

    public Address(Address copy){
        id = copy.id;
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

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
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

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("id", id);
        map.put("address", address);
        map.put("city", city);
        map.put("state", state);
        map.put("zip5", zip5);
        map.put("zip4", zip4);
        map.put("crrt", crrt);
        map.put("fips", fips);
        map.put("latitude", latitude == null ? null : latitude.toString());
        map.put("longitude", longitude == null ? null : longitude.toString());
        map.put("deliveryPoint", deliveryPoint);
        map.put("dpvFlag", dpvFlag);
        map.put("latLongAccuracy", latLongAccuracy == null ? null : latLongAccuracy.name());
        map.put("type", type == null ? null : type.name());
        map.put("quality", quality == null ? null : quality.name());
        map.put("vacant", Boolean.toString(vacant));

        if (parsed != null){
            map.putAll(parsed.toMap());
        }

        return map;
    }

    public static Address fromMap(Map map){
        Address address = new Address();
        address.setId(asString(map.get("id")));
        address.setAddress(asString(map.get("address")));
        address.setCity(asString(map.get("city")));
        address.setState(asString(map.get("state")));
        address.setZip5(asString(map.get("zip5")));
        address.setZip4(asString(map.get("zip4")));
        address.setCrrt(asString(map.get("crrt")));
        address.setFips(asString(map.get("fips")));
        String s = asString(map.get("latitude"));
        if (s != null && !s.isEmpty()){
            address.setLatitude(Double.parseDouble(s));
        }
        s =asString( map.get("longitude"));
        if (s != null && !s.isEmpty()){
            address.setLongitude(Double.parseDouble(s));
        }
        address.setDeliveryPoint(asString(map.get("deliveryPoint")));
        address.setDpvFlag(asString(map.get("dpvFlag")));
        s = asString(map.get("latLongAccuracy"));
        if (s != null && !s.isEmpty()){
            address.setLatLongAccuracy(LatLongAccuracy.valueOf(s));
        }
        s = asString(map.get("type"));
        if (s != null && !s.isEmpty()){
            address.setType(AddressType.valueOf(s));
        }
        s = asString(map.get("quality"));
        if (s != null && !s.isEmpty()){
            address.setQuality(AddressQuality.valueOf(s));
        }
        s = asString(map.get("vacant"));
        if (s != null && !s.isEmpty()){
            address.setVacant(Boolean.valueOf(s));
        }
        ParsedStreetAddress parsed = ParsedStreetAddress.fromMap(map);
        if (!parsed.toString().trim().isEmpty()) {
            address.setParsed(parsed);
        }

        return address;
    }

    private static String asString(Object value){
        return value == null ? null : value.toString();
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

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.address);
        hash = 19 * hash + Objects.hashCode(this.city);
        hash = 19 * hash + Objects.hashCode(this.state);
        hash = 19 * hash + Objects.hashCode(this.zip5);
        hash = 19 * hash + Objects.hashCode(this.zip4);
        hash = 19 * hash + Objects.hashCode(this.crrt);
        hash = 19 * hash + Objects.hashCode(this.fips);
        hash = 19 * hash + Objects.hashCode(this.latitude);
        hash = 19 * hash + Objects.hashCode(this.longitude);
        hash = 19 * hash + Objects.hashCode(this.deliveryPoint);
        hash = 19 * hash + Objects.hashCode(this.dpvFlag);
        hash = 19 * hash + Objects.hashCode(this.latLongAccuracy);
        hash = 19 * hash + Objects.hashCode(this.type);
        hash = 19 * hash + Objects.hashCode(this.quality);
        hash = 19 * hash + (this.vacant ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.parsed);
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
        if (!Objects.equals(this.id, other.id)){
            return false;
        }
        if (!Objects.equals(this.address, other.address)){
            return false;
        }
        if (!Objects.equals(this.city, other.city)){
            return false;
        }
        if (!Objects.equals(this.state, other.state)){
            return false;
        }
        if (!Objects.equals(this.zip5, other.zip5)){
            return false;
        }
        if (!Objects.equals(this.zip4, other.zip4)){
            return false;
        }
        if (!Objects.equals(this.crrt, other.crrt)){
            return false;
        }
        if (!Objects.equals(this.fips, other.fips)){
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)){
            return false;
        }
        if (!Objects.equals(this.longitude, other.longitude)){
            return false;
        }
        if (!Objects.equals(this.deliveryPoint, other.deliveryPoint)){
            return false;
        }
        if (!Objects.equals(this.dpvFlag, other.dpvFlag)){
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
        if (!Objects.equals(this.parsed, other.parsed)){
            return false;
        }
        return true;
    }

    
    
}
