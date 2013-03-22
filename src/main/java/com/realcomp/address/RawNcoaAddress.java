package com.realcomp.address;

import com.realcomp.names.Name;

/**
 * A street address that needs standardization and NCOA.
 * A street address consists of:
 * <ul>
 *   <li>One or more address lines. (e.g., "13284 Pond Springs Rd")</li>
 *   <li>city</li>
 *   <li>state</li>
 *   <li>zip</li>
 * </ul>
 * and a name.
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
 * @author krenfro
 */
public class RawNcoaAddress extends RawAddress {

    protected Name name;

    public RawNcoaAddress(){
        super();
    }

    public RawNcoaAddress(RawNcoaAddress copy) {
        super((RawAddress) copy);
        this.name = copy.name;
    }

    public Name getName(){
        return name;
    }

    public void setName(Name name){
        this.name = name;
    }



    @Override
    public int hashCode(){
        int hash = super.hashCode();
        hash = 73 * hash + (this.name != null ? this.name.hashCode() : 0);
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
        final RawNcoaAddress other = (RawNcoaAddress) obj;
        if (this.lines != other.lines && (this.lines == null || !this.lines.equals(other.lines))){
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
        if (this.name != other.name && (this.name == null || !this.name.equals(other.name))){
            return false;
        }

        return true;
    }
}
