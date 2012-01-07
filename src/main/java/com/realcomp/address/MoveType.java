/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realcomp.address;

/**
 *
 * @author krenfro
 */
public enum MoveType {
    
    MOVED,
    MOVED_NO_FORWARDING_ADDRESS,
    MOVED_FOREIGN,
    PO_BOX_CLOSED;
    
    /**
     * Decode the matchflag field to determine the type of move.
     * @param code
     * @return MoveType or null if not moved.
     */
    public static MoveType decode(String code){
        
        MoveType moveType = null;
        
        if (code != null){
            if (code.startsWith("M"))
                moveType = MOVED;
            else if (code.startsWith("G"))
                moveType = PO_BOX_CLOSED;
            else if (code.startsWith("K"))
                moveType = MOVED_NO_FORWARDING_ADDRESS;
            else if (code.startsWith("F"))
                moveType = MOVED_FOREIGN;
        }

        return moveType;
    }
}
