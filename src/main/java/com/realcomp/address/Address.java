package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 */
public class Address implements Serializable {
    private String name1;
    private String name2;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zip;
    private String zipPlus4;
    private StringBuilder addressString = new StringBuilder();

    public String getFullAddress() {
        if (streetAddress1 != null && !streetAddress1.isEmpty())
            addressString.append(streetAddress1);
        if (streetAddress2 != null && !streetAddress2.isEmpty())
            addressString.append(" ").append(streetAddress2);
        if (city != null && !city.isEmpty())
            addressString.append(" ").append(city);
        if (state != null && !state.isEmpty()) {
            if (city != null && !city.isEmpty())
                addressString.append(",");
            addressString.append(" ").append(state);
        }
        if (zip != null && !zip.isEmpty()) {
            addressString.append(" ").append(zip);
            if (zipPlus4 != null && !zipPlus4.isEmpty())
                addressString.append(" ").append(zipPlus4);
        }
        return addressString.toString().trim();
    }
 
    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
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
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZipPlus4() {
        return zipPlus4;
    }

    public void setZipPlus4(String zipPlus4) {
        this.zipPlus4 = zipPlus4;
    }

}
