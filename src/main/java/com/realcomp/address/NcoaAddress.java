package com.realcomp.address;

/**
 *
 * @author krenfro
 */
public class NcoaAddress extends Address{

    private MoveType moveType;
    private String moveDate;

    public NcoaAddress(){
        super();
    }

    public NcoaAddress(Address address){
        super(address);
        if (address instanceof NcoaAddress){
            moveType = ((NcoaAddress) address).moveType;
            moveDate = ((NcoaAddress) address).moveDate;
        }
    }

    public String getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(String moveDate) {
        this.moveDate = moveDate;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public boolean hasMoved(){
        return moveType != null;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        //rolling my own equals, but relying on equals() from Address
        if (super.equals(obj)){
            final NcoaAddress other = (NcoaAddress) obj;
            if (this.moveType != other.moveType)
                return false;
            if ((this.moveDate == null) ? (other.moveDate != null) : !this.moveDate.equals(other.moveDate))
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
        hash = 37 * hash + (this.moveDate != null ? this.moveDate.hashCode() : 0);
        return hash;
    }

}
