package com.realcomp.address.ncoa;

import com.realcomp.address.Address;

public class MovedAddress {

    private Address address;
    private MoveType moveType;
    private String yearMoved; //YYYY
    private String monthMoved; //MM
    private String moveFlag;
    private String dateChecked; //YYYYMMDD

    public MovedAddress(){
    }

    public MovedAddress(MovedAddress copy){
        if (copy.getAddress() != null){
            address = new Address(copy.getAddress());
        }
        moveType = copy.moveType;
        yearMoved = copy.yearMoved;
        monthMoved = copy.monthMoved;
        moveFlag = copy.moveFlag;
        dateChecked = copy.dateChecked;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public MoveType getMoveType(){
        return moveType;
    }

    public void setMoveType(MoveType moveType){
        this.moveType = moveType;
    }

    public String getYearMoved(){
        return yearMoved;
    }

    public void setYearMoved(String yearMoved){
        this.yearMoved = yearMoved;
    }

    public String getMonthMoved(){
        return monthMoved;
    }

    public void setMonthMoved(String monthMoved){
        this.monthMoved = monthMoved;
    }

    public String getMoveFlag(){
        return moveFlag;
    }

    public void setMoveFlag(String moveFlag){
        this.moveFlag = moveFlag;
    }

    public String getDateChecked(){
        return dateChecked;
    }

    public void setDateChecked(String dateChecked){
        this.dateChecked = dateChecked;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 97 * hash + (this.address != null ? this.address.hashCode() : 0);
        hash = 97 * hash + (this.moveType != null ? this.moveType.hashCode() : 0);
        hash = 97 * hash + (this.yearMoved != null ? this.yearMoved.hashCode() : 0);
        hash = 97 * hash + (this.monthMoved != null ? this.monthMoved.hashCode() : 0);
        hash = 97 * hash + (this.moveFlag != null ? this.moveFlag.hashCode() : 0);
        hash = 97 * hash + (this.dateChecked != null ? this.dateChecked.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final MovedAddress other = (MovedAddress) obj;
        if (this.address != other.address && (this.address == null || !this.address.equals(other.address))){
            return false;
        }
        if (this.moveType != other.moveType){
            return false;
        }
        if ((this.yearMoved == null) ? (other.yearMoved != null) : !this.yearMoved.equals(other.yearMoved)){
            return false;
        }
        if ((this.monthMoved == null) ? (other.monthMoved != null) : !this.monthMoved.equals(other.monthMoved)){
            return false;
        }
        if ((this.moveFlag == null) ? (other.moveFlag != null) : !this.moveFlag.equals(other.moveFlag)){
            return false;
        }
        if ((this.dateChecked == null) ? (other.dateChecked != null) : !this.dateChecked.equals(other.dateChecked)){
            return false;
        }
        return true;
    }

}
