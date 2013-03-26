package com.realcomp.address.ncoa;

import com.realcomp.address.Address;
import com.realcomp.address.MoveType;

/**
 * Output from NCOA is an Address with move information.
 * 
 * @author krenfro
 */
public class NcoaOutput extends Address{

    private MoveType moveType;
    private String yearMoved; //YYYY
    private String monthMoved; //MM

    public NcoaOutput(){
        super();
    }

    public NcoaOutput(NcoaOutput copy){        
        super(copy);
        moveType = copy.moveType;
        yearMoved = copy.yearMoved;
        monthMoved = copy.monthMoved;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public String getYearMoved() {
        return yearMoved;
    }

    public void setYearMoved(String year) {
        this.yearMoved = year;
    }

    public String getMonthMoved() {
        return monthMoved;
    }

    public void setMonthMoved(String month) {
        this.monthMoved = month;
    }
    
    
    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        //rolling my own equals, but relying on equals() from Address
        if (super.equals(obj)){
            final NcoaOutput other = (NcoaOutput) obj;
            if (this.moveType != other.moveType)
                return false;
            if ((this.monthMoved == null) ? (other.monthMoved != null) : !this.monthMoved.equals(other.monthMoved))
                return false;
            if ((this.yearMoved == null) ? (other.yearMoved != null) : !this.yearMoved.equals(other.yearMoved))
                return false;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 37 * hash + (this.moveType != null ? this.moveType.hashCode() : 0);
        hash = 37 * hash + (this.monthMoved != null ? this.monthMoved.hashCode() : 0);
        hash = 37 * hash + (this.yearMoved != null ? this.yearMoved.hashCode() : 0);
        return hash;
    }

}
