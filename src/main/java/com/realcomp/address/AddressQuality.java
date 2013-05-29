package com.realcomp.address;



public enum AddressQuality {

    /** Address was DPV confirmed for both primary and (if present) secondary numbers. */
    VALID,

    /** Address was DPV confirmed for the primary number only, and Secondary number information was missing. */
    UNCONFIRMED_UNIT,

    /** Address was DPV confirmed for the primary number only, and Secondary number information was present but unconfirmed. */
    MISSING_UNIT,

    /** Both Primary and (if present) Secondary number information failed to DPV Confirm. */
    INVALID,
    UNKNOWN;

    public static AddressQuality decode(String code){

        AddressQuality quality = AddressQuality.UNKNOWN;

        if (code != null){
            if (code.startsWith("Y")){
                quality = AddressQuality.VALID;
            }
            else if (code.startsWith("S")){
                quality = AddressQuality.UNCONFIRMED_UNIT;
            }
            else if (code.startsWith("D")){
                quality = AddressQuality.MISSING_UNIT;
            }
            else if (code.startsWith("N")){
                quality = AddressQuality.INVALID;
            }
        }

        return quality;
    }

    public boolean isDeliverable(){
        switch(this){
            case VALID:
            case UNCONFIRMED_UNIT:
            case MISSING_UNIT:
                return true;
            default:
                return false;
        }
    }
}
