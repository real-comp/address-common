package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 */
public class Fips implements Serializable {

    private String fipsCounty;
    private String fipsState;

    public Fips(){
    }

    public Fips(Fips copy){
        this.fipsCounty = copy.fipsCounty;
        this.fipsState = copy.fipsState;
    }

    @Override
    public String toString() {
        StringAppender sa = new StringAppender();
        if (fipsState != null && fipsCounty != null && !fipsState.isEmpty()
                && !fipsCounty.isEmpty()) {
            sa.append(fipsState);
            sa.append(fipsCounty);
            return sa.toString();
        } else {
            return "";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Fips other = (Fips) obj;
        if ((this.fipsCounty == null) ? (other.fipsCounty != null)
                : !this.fipsCounty.equals(other.fipsCounty))
            return false;
        if ((this.fipsState == null) ? (other.fipsState != null)
                : !this.fipsState.equals(other.fipsState))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.fipsCounty != null ? this.fipsCounty.hashCode() : 0);
        hash = 59 * hash + (this.fipsState != null ? this.fipsState.hashCode() : 0);
        return hash;
    }

    public String getFipsCounty() {
        return fipsCounty;
    }

    public void setFipsCounty(String fipsCounty) {
        this.fipsCounty = fipsCounty;
    }

    public String getFipsState() {
        return fipsState;
    }

    public void setFipsState(String fipsState) {
        this.fipsState = fipsState;
    }

}
