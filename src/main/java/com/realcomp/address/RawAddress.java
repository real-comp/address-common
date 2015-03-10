package com.realcomp.address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public static final String HINT_FIPS = "fips";
    public static final String HINT_ADDRESS = "address";
    public static final String HINT_CITY = "city";
    public static final String HINT_STATE = "state";
    public static final String HINT_ZIP = "zip";
    public static final String HINT_JURISCITY = "jurisCity";

    private String id;
    private List<String> lines;
    private String city;
    private String state;
    private String zip;
    private Map<String,String> hints;

    public RawAddress() {
        lines = new ArrayList<>();
    }

    public RawAddress(RawAddress copy) {
        lines = new ArrayList<>(copy.lines);
        city = copy.city;
        state = copy.state;
        zip = copy.zip;
        if (copy.hints != null){
            hints = new HashMap<>();
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
        if (name == null){
            throw new IllegalArgumentException("hint name is null");
        }
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

    public Map<String, String> getHints(){
        return hints;
    }

    public void setHints(Map<String, String> hints){
        this.hints = hints;
    }

    public boolean hasHints(){
        return hints != null && !hints.isEmpty();
    }

    /**
     * @return lines . never null - but perhaps empty
     */
    public List<String> getAddressLines() {
        return lines;
    }

    /**
     *
     * @param lines to add. Existing entries are replaced.  Null and empty lines lines are ignored.
     */
    public void setAddressLines(List<String> lines) {
        this.lines.clear();
        if (lines != null && !lines.isEmpty()){
            for (String addr : lines){
                addAddressLine(addr);
            }
        }

    }

    /**
     *
     * @param lines lines line to append. Will be trimmed of leading and trailing whitespace. null and empty lines lines are ignored.
     */
    public void addAddressLine(String line) {
        if (line != null){
            line = line.trim();
            if (!line.isEmpty()){
                this.lines.add(line);
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
    public String toString(){
        return "RawAddress{" + "lines=" + lines + ", city=" + city + ", state=" + state + ", zip=" + zip + ", hints=" + hints + '}';
    }
    

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.lines);
        hash = 61 * hash + Objects.hashCode(this.city);
        hash = 61 * hash + Objects.hashCode(this.state);
        hash = 61 * hash + Objects.hashCode(this.zip);
        hash = 61 * hash + Objects.hashCode(this.hints);
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
        if (!Objects.equals(this.id, other.id)){
            return false;
        }
        if (!Objects.equals(this.lines, other.lines)){
            return false;
        }
        if (!Objects.equals(this.city, other.city)){
            return false;
        }
        if (!Objects.equals(this.state, other.state)){
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)){
            return false;
        }
        if (!Objects.equals(this.hints, other.hints)){
            return false;
        }
        return true;
    }
}
