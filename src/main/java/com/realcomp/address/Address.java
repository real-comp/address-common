package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 */
public class Address implements Serializable {

    private StreetAddress streetAddress = new StreetAddress();
    private String city;
    private String state;
    private ZipCode zipCode = new ZipCode();
    private String crrt;
    private Barcode barcode = new Barcode();
    private String county;
    private Fips fips = new Fips();
    private Geolocation geo = new Geolocation();
    private AddressType addressType;
    private AddressQuality addressQuality;

    @Override
    public String toString() {
        StringAppender sa = new StringAppender(" ");
        sa.append(streetAddress.toString());
        sa.append(city);
        if (city != null && state != null && !city.isEmpty() && !state.isEmpty())
            sa.append(",", "");
        sa.append(state);
        sa.append(zipCode.toString());
        return sa.toString().trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Address other = (Address) obj;
        if (this.streetAddress != other.streetAddress && (this.streetAddress == null
                || !this.streetAddress.equals(other.streetAddress)))
            return false;
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city))
            return false;
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state))
            return false;
        if (this.zipCode != other.zipCode && (this.zipCode == null
                || !this.zipCode.equals(other.zipCode)))
            return false;
        if ((this.crrt == null) ? (other.crrt != null) : !this.crrt.equals(other.crrt))
            return false;
        if (this.barcode != other.barcode && (this.barcode == null
                || !this.barcode.equals(other.barcode)))
            return false;
        if ((this.county == null) ? (other.county != null) : !this.county.equals(other.county))
            return false;
        if (this.fips != other.fips && (this.fips == null || !this.fips.equals(other.fips)))
            return false;
        if (this.geo != other.geo && (this.geo == null || !this.geo.equals(other.geo)))
            return false;
        if (this.addressType != other.addressType)
            return false;
        if (this.addressQuality != other.addressQuality)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (this.streetAddress != null ? this.streetAddress.hashCode() : 0);
        hash = 11 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 11 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 11 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 11 * hash + (this.crrt != null ? this.crrt.hashCode() : 0);
        hash = 11 * hash + (this.barcode != null ? this.barcode.hashCode() : 0);
        hash = 11 * hash + (this.county != null ? this.county.hashCode() : 0);
        hash = 11 * hash + (this.fips != null ? this.fips.hashCode() : 0);
        hash = 11 * hash + (this.geo != null ? this.geo.hashCode() : 0);
        hash = 11 * hash + (this.addressType != null ? this.addressType.hashCode() : 0);
        hash = 11 * hash + (this.addressQuality != null ? this.addressQuality.hashCode() : 0);
        return hash;
    }

    public String getHouseNum() {
        return streetAddress.getHouseNum();
    }

    public void setHouseNum(String houseNum) {
        streetAddress.setHouseNum(houseNum);
    }

    public String getPreDir() {
        return streetAddress.getPreDir();
    }

    public void setPreDir(String preDir) {
        streetAddress.setPreDir(preDir);
    }

    public String getStreet() {
        return streetAddress.getStreet();
    }

    public void setStreet(String street) {
        streetAddress.setStreet(street);
    }

    public String getStreetSuffix() {
        return streetAddress.getStreetSuffix();
    }

    public void setStreetSuffix(String streetSuffix) {
        streetAddress.setStreetSuffix(streetSuffix);
    }

    public String getPostDir() {
        return streetAddress.getPostDir();
    }

    public void setPostDir(String postDir) {
        streetAddress.setPostDir(postDir);
    }

    public String getUnitAbbrev() {
        return streetAddress.getUnitAbbrev();
    }

    public void setUnitAbbrev(String unitAbbrev) {
        streetAddress.setUnitAbbrev(unitAbbrev);
    }

    public String getUnit() {
        return streetAddress.getUnit();
    }

    public void setUnit(String unit) {
        streetAddress.setUnit(unit);
    }

    public String getStreetAddress() {
        return streetAddress.toString();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zipCode.getZip();
    }

    public void setZip(String zip) {
        zipCode.setZip(zip);
    }

    public String getZip4() {
        return zipCode.getZip4();
    }

    public void setZip4(String zip4) {
        zipCode.setZip4(zip4);
    }

    public String getZipCode() {
        return zipCode.toString();
    }

    public String getCrrt() {
        return crrt;
    }

    public void setCrrt(String crrt) {
        this.crrt = crrt;
    }

    public String getBarcode() {
        return barcode.getBarcode();
    }

    public void setBarcode(String barcd) {
        barcode.setBarcode(barcd);
    }

    public String getImbarcode() {
        return barcode.getImbarcode();
    }

    public void setImbarcode(String imbarcode) {
        barcode.setImbarcode(imbarcode);
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getFipsCounty() {
        return fips.getFipsCounty();
    }

    public void setFipsCounty(String fipsCounty) {
        fips.setFipsCounty(fipsCounty);
    }

    public String getFipsState() {
        return fips.getFipsState();
    }

    public void setFipsState(String fipsState) {
        fips.setFipsState(fipsState);
    }

    public String getFips() {
        return fips.toString();
    }

    public double getLatitude() {
        return geo.getLatitude();
    }

    public void setLatitude(double latitude) {
        geo.setLatitude(latitude);
    }

    public double getLongitude() {
        return geo.getLongitude();
    }

    public void setLongitude(double longitude) {
        geo.setLongitude(longitude);
    }

    public LatLongAccuracy getLatLongAccuracy() {
        return geo.getLatLongAccuracy();
    }

    public void setLatLongAccuracy(LatLongAccuracy latLongAccuracy) {
        geo.setLatLongAccuracy(latLongAccuracy);
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public AddressQuality getAddressQuality() {
        return addressQuality;
    }

    public void setAddressQuality(AddressQuality addressQuality) {
        this.addressQuality = addressQuality;
    }

}
