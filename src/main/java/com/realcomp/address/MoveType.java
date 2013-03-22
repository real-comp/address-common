package com.realcomp.address;

public enum MoveType {

    BUSINESS,
    INDIVIDUAL,
    FAMILY;

    public static MoveType decode(String code){

        MoveType moveType = null;
        if (code != null){
            if (code.equals("B"))
                moveType = BUSINESS;
            else if (code.equals("I"))
                moveType = INDIVIDUAL;
            else if (code.equals("F"))
                moveType = FAMILY;
        }

        return moveType;
    }
}
