package com.realcomp.address;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author BGoering
 */
public class RawAddress implements Serializable {

    private List<String> address;
    private String city;
    private String state;
    private String zip;
    private String fips;

    public RawAddress() {
        address = new ArrayList<String>();
    }

    public RawAddress(RawAddress copy) {
        address = new ArrayList<String>(copy.address);
        city = copy.city;
        state = copy.state;
        zip = copy.zip;
        fips = copy.fips;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
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

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        if (fips == null)
            throw new IllegalArgumentException("fips is null");
        if (!fips.trim().isEmpty())
            this.fips = fips.trim();
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
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RawAddress other = (RawAddress) obj;
        if (this.address != other.address && (this.address == null || !this.address.equals(other.address)))
            return false;
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city))
            return false;
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state))
            return false;
        if ((this.zip == null) ? (other.zip != null) : !this.zip.equals(other.zip))
            return false;
        if ((this.fips == null) ? (other.fips != null) : !this.fips.equals(other.fips))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.address != null ? this.address.hashCode() : 0);
        hash = 67 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 67 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 67 * hash + (this.zip != null ? this.zip.hashCode() : 0);
        hash = 67 * hash + (this.fips != null ? this.fips.hashCode() : 0);
        return hash;
    }

}
