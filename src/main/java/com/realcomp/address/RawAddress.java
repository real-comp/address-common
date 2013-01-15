package com.realcomp.address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A street address that needs standardization.
 * A street address consists of:
 * <ul>
 *   <li>One or more address lines. (e.g., "13284 Pond Springs Rd")</li>
 *   <li>city</li>
 *   <li>state</li>
 *   <li>zip</li>
 * </ul>
 *
 *
 * <h2>Hints</h2>
 * Hints are used to standardize hard-to-standardize addresses.
 * They are used at the discretion of the standardizer.  Some examples of hints are:
 *
 * <p><b>fips</b> - The fips service can be queried for a list of cities in a county.  These cities can be used
 * to help standardize an address.</p>
 * <p><b>address,city,state,zip</b> -
 * Often an owner address for a tax property.  Often, the owner address contains better address data and can be
 * used to standardize an address.</p>
 * <p><b>jurisCity</b> -
 * The taxing city (or Jurisdiction) is often an indicator of the city where an address is located and is helpful
 * for address standardization.</p>
 *
 *
 *
 * @author BGoering
 * @author krenfro
 */
public class RawAddress implements Serializable {

    public static String HINT_FIPS = "fips";
    public static String HINT_ADDRESS = "address";
    public static String HINT_CITY = "city";
    public static String HINT_STATE = "state";
    public static String HINT_ZIP = "zip";
    public static String HINT_JURISCITY = "jurisCity";


    protected List<String> address;
    protected String city;
    protected String state;
    protected String zip;
    protected Map<String,String> hints;

    public RawAddress() {
        address = new ArrayList<String>();
    }

    public RawAddress(RawAddress copy) {
        address = new ArrayList<String>(copy.address);
        city = copy.city;
        state = copy.state;
        zip = copy.zip;
        if (copy.hints != null){
            hints = new HashMap<String,String>();
            hints.putAll(copy.hints);
        }
    }

    /**
     *
     * @param name not null
     * @param value
     * @return previous value of the hint.
     */
    public String setHint(String name, String value){
        if (name == null)
            throw new IllegalArgumentException("hint name is null");
        if (hints == null){
            hints = new HashMap<String,String>();
        }
        return hints.put(name, value);
    }

    /**
     *
     * @param name
     * @return the value for the specified hint, or null if not set.
     */
    public String getHint(String name){
        return hints == null ? null : hints.get(name);
    }

    /**
     * @return address lines. never null - but perhaps empty
     */
    public List<String> getAddress() {
        return address;
    }

    /**
     *
     * @param address to add. Existing entries are replaced.  Null and empty address lines are ignored.
     */
    public void setAddress(List<String> address) {
        this.address.clear();
        if (address != null && !address.isEmpty()){
            for (String addr : address){
                addAddress(addr);
            }
        }

    }

    /**
     *
     * @param address address line to append. Will be trimmed of leading and trailing whitespace. null and empty address lines are ignored.
     */
    public void addAddress(String address) {
        if (address != null){
            address = address.trim();
            if (!address.isEmpty()){
                this.address.add(address);
            }
        }
    }

    /**
     *
     * @return city name; may be null
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city city name.  trimmed.  null and empty city names are ignored.
     */
    public void setCity(String city) {
        this.city = null;
        if (city != null){
            city = city.trim();
            if (!city.isEmpty()){
                this.city = city;
            }
        }
    }

    /**
     *
     * @return state. may be null.  Usually a 2 letter abbreviation.
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state null and empty strings are ignored
     */
    public void setState(String state) {
        this.state = null;
        if (state != null){
            state = state.trim();
            if (!state.isEmpty()){
                this.state = state;
            }
        }
    }

    /**
     *
     * @return zipcode.  Unformatted. May be null.
     */
    public String getZip() {
        return zip;
    }

    /**
     *
     * @param zip null and empty strings are ignored.
     */
    public void setZip(String zip) {
        this.zip = null;
        if (zip != null){
            zip = zip.trim();
            if (!zip.isEmpty()){
                this.zip = zip;
            }
        }
    }


    @Override
    public String toString() {

        return new ToStringBuilder(this).
                append("address", address).
                append("city", city).
                append("state", state).
                append("zip", zip).
                append("hints", hints).toString();
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 73 * hash + (this.address != null ? this.address.hashCode() : 0);
        hash = 73 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 73 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 73 * hash + (this.zip != null ? this.zip.hashCode() : 0);
        hash = 73 * hash + (this.hints != null ? this.hints.hashCode() : 0);
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
        final RawAddress other = (RawAddress) obj;
        if (this.address != other.address && (this.address == null || !this.address.equals(other.address))){
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
        if (this.hints != other.hints && (this.hints == null || !this.hints.equals(other.hints))){
            return false;
        }
        return true;
    }
}
