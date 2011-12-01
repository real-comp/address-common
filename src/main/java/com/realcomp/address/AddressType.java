package com.realcomp.address;

/**
 *
 * @author BGoering
 */
public enum AddressType {

    STREET, HIGHRISE, POBOX, RURAL_ROUTE, GENERAL, FIRM;
            
    /**
     * Returns the AddressType from the USPS code (S,H,P,R,G,F)
     * @param code
     * @return 
     */
    public static AddressType fromCode(String code){
       
        AddressType type = null;
        
        if (code.equals("S"))
            type = AddressType.STREET;
        else if (code.equals("H"))
            type = AddressType.HIGHRISE;
        else if (code.equals("P"))
            type = AddressType.POBOX;
        else if (code.equals("R"))
            type = AddressType.RURAL_ROUTE;
        else if (code.equals("G"))
            type = AddressType.GENERAL;
        else if (code.equals("F"))
            type = AddressType.FIRM;
        else if (code != null && !code.trim().isEmpty())
            throw new IllegalStateException("Unhandled Address Type: " + code);
        
        return type;        
    }
}
