package com.realcomp.address;

/**
 *
 * @author BGoering
 */
public enum AddressQuality {

    VALID, UNCONFIRMED_UNIT, MISSING_UNIT, INVALID, ERROR;

    /**
     * Says if Address is a deliverable USPS address
     * @return true if address is VALID, UNCONFIRMED_UNIT, or MISSING_UNIT or false if INVALID or
     * ERROR
     */
    public boolean isDeliverable() {

        switch(this){
            case VALID:
            case UNCONFIRMED_UNIT:
            case MISSING_UNIT:
                return true;
        }
        return false;
    }
            
}
