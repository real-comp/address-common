package com.realcomp.address;

import java.io.Serializable;

/**
 *
 * @author BGoering
 */
public class ZipCode implements Serializable {

    private String zip5;
    private String zip4;

    public ZipCode(){
    }

    public ZipCode(ZipCode copy){
        zip5 = copy.zip5;
        zip4 = copy.zip4;
    }

    public String getZip5() {
        return zip5;
    }

    public void setZip5(String zip5) {
        this.zip5 = zip5;
    }

    public String getZip4() {
        return zip4;
    }

    public void setZip4(String zip4) {
        this.zip4 = zip4;
    }

    /**
     * Returns the full ZIP code including +4, if available
     * @return Full ZIP code in XXXXX-XXXX or XXXXX format
     */
    @Override
    public String toString() {
        StringAppender sa = new StringAppender("-");
        if (zip5 != null && !zip5.isEmpty()) {
            sa.append(zip5);
            sa.append(zip4);
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
        final ZipCode other = (ZipCode) obj;
        if ((this.zip5 == null) ? (other.zip5 != null) : !this.zip5.equals(other.zip5))
            return false;
        if ((this.zip4 == null) ? (other.zip4 != null) : !this.zip4.equals(other.zip4))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.zip5 != null ? this.zip5.hashCode() : 0);
        hash = 97 * hash + (this.zip4 != null ? this.zip4.hashCode() : 0);
        return hash;
    }

}
