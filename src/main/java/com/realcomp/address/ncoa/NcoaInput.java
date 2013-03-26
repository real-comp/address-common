package com.realcomp.address.ncoa;

import com.realcomp.address.Address;
import com.realcomp.names.Name;

/**
 * An Address and associated Name for NCOA testing.
 * 
 * @author krenfro
 */
public class NcoaInput{

    protected Name name;
    protected Address address;

    /**
     * 
     * @param address not null.
     * @param name not null.
     */
    public NcoaInput(Address address, Name name){
        if (address == null){
            throw new IllegalArgumentException("address is null");
        }
        if (name == null){
            throw new IllegalArgumentException("name is null");
        }
        
        /* The inputs are not defensively copied as a performance improvement.
         * The primary use case is reading a group of Names and Addresses and sending them
         * off for ncoa.  
         */
        this.name = name;
        this.address = address;
    }

    public NcoaInput(NcoaInput copy) {
        this.address = copy.address;
        this.name = copy.name;
    }

    /**
     * 
     * @return the Name. never null.
     */
    public Name getName(){
        return name;
    }

    /**
     * 
     * @param name not null.
     */
    public void setName(Name name){
        if (name == null){
            throw new IllegalArgumentException("name is null");
        }
        this.name = name;
    }

    /**
     * 
     * @return the Address. never null
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address not null.
     */
    public void setAddress(Address address) {
        if (address == null){
            throw new IllegalArgumentException("address is null");
        }
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 19 * hash + (this.address != null ? this.address.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NcoaInput other = (NcoaInput) obj;
        if (this.name != other.name && (this.name == null || !this.name.equals(other.name))) {
            return false;
        }
        if (this.address != other.address && (this.address == null || !this.address.equals(other.address))) {
            return false;
        }
        return true;
    }
    
    
}
