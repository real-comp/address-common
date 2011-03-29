package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 */
public class Address extends StreetAddress implements Serializable {

    private StreetAddress streetAddress;
    private String city;
    private String state;
    private ZipCode zipCode;
    private String crrt;
    private Barcode barcode;
    private String county;
    private Fips fips;
    private Geolocation geo;
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

    /*
    public StreetAddress getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(StreetAddress streetAddress) {
        this.streetAddress = streetAddress;
    }
     * 
     */

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

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    public String getCrrt() {
        return crrt;
    }

    public void setCrrt(String crrt) {
        this.crrt = crrt;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Fips getFips() {
        return fips;
    }

    public void setFips(Fips fips) {
        this.fips = fips;
    }

    public Geolocation getGeo() {
        return geo;
    }

    public void setGeo(Geolocation geo) {
        this.geo = geo;
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
