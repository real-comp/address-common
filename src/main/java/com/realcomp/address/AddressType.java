package com.realcomp.address;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BGoering
 */
public enum AddressType {

    STREET, HIGHRISE, POBOX, RURAL_ROUTE, GENERAL, FIRM, UNKNOWN;

    private static final Logger logger = Logger.getLogger(AddressType.class.getName());

    /**
     * Returns the AddressType from the USPS code (S,H,P,R,G,F)
     * @param code
     * @return
     */
    public static AddressType decode(String code){

        AddressType type = AddressType.UNKNOWN;

        if (code.equals("S")){
            type = AddressType.STREET;
        }
        else if (code.equals("H")){
            type = AddressType.HIGHRISE;
        }
        else if (code.equals("P")){
            type = AddressType.POBOX;
        }
        else if (code.equals("R")){
            type = AddressType.RURAL_ROUTE;
        }
        else if (code.equals("G")){
            type = AddressType.GENERAL;
        }
        else if (code.equals("F")){
            type = AddressType.FIRM;
        }
        else if (code.equals("0")){
            type = AddressType.UNKNOWN;
        }
        else if (code.equals("1")){
            type = AddressType.UNKNOWN;
        }
        else if (!code.trim().isEmpty()){
            logger.log(Level.WARNING, "Unhandled AddressType: [{0}]", code);
        }

        return type;
    }

    public String encode(){

        switch(this){
            case FIRM:
                return "F";
            case GENERAL:
                return "G";
            case HIGHRISE:
                return "H";
            case POBOX:
                return "P";
            case RURAL_ROUTE:
                return "R";
            case STREET:
                return "S";
            default:
                return "0";
        }
    }

}
