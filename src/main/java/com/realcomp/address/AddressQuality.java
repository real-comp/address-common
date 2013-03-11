package com.realcomp.address;



public enum AddressQuality {

    VALID, //Address was DPV confirmed for both primary and (if present) secondary numbers.
    UNCONFIRMED_UNIT, //Address was DPV confirmed for the primary number only, and Secondary number information was missing.
    MISSING_UNIT, //Address was DPV confirmed for the primary number only, and Secondary number information was present but unconfirmed.
    INVALID, //Both Primary and (if present) Secondary number information failed to DPV Confirm.
    VACANT,
    UNKNOWN;

    public static AddressQuality decode(String code){

        AddressQuality quality = AddressQuality.UNKNOWN;

        if (code != null){
            if (code.startsWith("Y"))
                quality = AddressQuality.VALID;
            else if (code.startsWith("S"))
                quality = AddressQuality.UNCONFIRMED_UNIT;
            else if (code.startsWith("D"))
                quality = AddressQuality.MISSING_UNIT;
            else if (code.startsWith("N"))
                quality = AddressQuality.INVALID;

            if (code.length() >= 4){
                if (code.charAt(3) == 'Y'){
                    quality = AddressQuality.VACANT;
                }
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
