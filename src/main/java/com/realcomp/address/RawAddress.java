package com.realcomp.address;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author BGoering
 */
public class RawAddress implements Serializable {

    private ArrayList<String> address;
    private String city;
    private String state;
    private String zip;

    public RawAddress() {
        address = new ArrayList<String>();
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        if (address == null)
            throw new IllegalArgumentException("address is null");
        this.address = address;
    }

    public void addAddress(String address) {
        this.address.add(address);
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

}
