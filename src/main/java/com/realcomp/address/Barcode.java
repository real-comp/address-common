package com.realcomp.address;

/**
 *
 * @author BGoering
 */
public class Barcode {
    
    private String barcode;
    private String imbarcode;

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Barcode other = (Barcode) obj;
        if ((this.barcode == null) ? (other.barcode != null) : !this.barcode.equals(other.barcode))
            return false;
        if ((this.imbarcode == null) ? (other.imbarcode != null)
                : !this.imbarcode.equals(other.imbarcode))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.barcode != null ? this.barcode.hashCode() : 0);
        hash = 67 * hash + (this.imbarcode != null ? this.imbarcode.hashCode() : 0);
        return hash;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImbarcode() {
        return imbarcode;
    }

    public void setImbarcode(String imbarcode) {
        this.imbarcode = imbarcode;
    }

}
