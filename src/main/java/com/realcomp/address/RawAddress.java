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
        if (this.address != null && !this.address.isEmpty())
            this.address.clear();
        for (String addr : address)
            addAddress(addr);
    }

    public void addAddress(String address) {
        if (address == null)
            throw new IllegalArgumentException("address line is null");
        if (!address.trim().isEmpty())
            this.address.add(address.trim());
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null)
            throw new IllegalArgumentException("city is null");
        if (!city.trim().isEmpty())
            this.city = city.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state == null)
            throw new IllegalArgumentException("state is null");
        if (!state.trim().isEmpty())
            this.state = state.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        if (zip == null)
            throw new IllegalArgumentException("zip is null");
        if (!zip.trim().isEmpty())
            this.zip = zip.trim();
    }

}
