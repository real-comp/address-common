package com.realcomp.address;

/**
 *
 * @author BGoering
 */
public class ZipCode {

    private String zip;
    private String zip4;

    @Override
    public String toString() {
        StringAppender sa = new StringAppender("-");
        if (zip != null && !zip.isEmpty()) {
            sa.append(zip);
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
        if ((this.zip == null) ? (other.zip != null) : !this.zip.equals(other.zip))
            return false;
        if ((this.zip4 == null) ? (other.zip4 != null) : !this.zip4.equals(other.zip4))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.zip != null ? this.zip.hashCode() : 0);
        hash = 97 * hash + (this.zip4 != null ? this.zip4.hashCode() : 0);
        return hash;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip4() {
        return zip4;
    }

    public void setZip4(String zip4) {
        this.zip4 = zip4;
    }

}
