package com.realcomp.address.ncoa;

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

    public String encode(){
        switch(this){
            case BUSINESS:
                return "B";
            case INDIVIDUAL:
                return "I";
            case FAMILY:
                return "F";
        }
        throw new IllegalStateException("No code known for MoveType: " + this);
    }
}
