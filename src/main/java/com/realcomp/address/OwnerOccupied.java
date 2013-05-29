package com.realcomp.address;

/**
 * A loose equals on two Addresses.
 *
 * @see http://http://dev.real-comp.com:8070/display/Engineering/Owner+Occupied
 *
 * @author krenfro
 */
public final class OwnerOccupied {

    private static final float TOKEN_MATCH_PERCENTAGE = .40f;


    private OwnerOccupied(){
    }

    /**
     *
     * @param owner
     * @param situs
     * @return true if both addresses probably represent the same physical address
     */
    public static boolean isOwnerOccupied(Address owner, Address situs){

        if (owner == null){
            throw new IllegalArgumentException("owner Address is null");
        }
        if (situs == null){
            throw new IllegalArgumentException("situs Address is null");
        }

        return isDeliverable(owner, situs)
                && isSameZip(owner, situs)
                && isSameHouseNumber(owner, situs)
                && is40PercentTokenMatch(owner, situs);
    }

    protected static boolean is40PercentTokenMatch(Address a, Address b){
        assert(a != null);
        assert(b != null);
        boolean match = false;
        if (a.getAddress() != null && b.getAddress() != null){
            String[] tokensA = a.getAddress().split(" ");
            String[] tokensB = b.getAddress().split(" ");

            int matches = 0;
            //ignore first token (house number)
            for (int x = 1; x < tokensA.length; x++){
                for (int y = 1; y < tokensB.length; y++){
                    if (tokensA[x].equals(tokensB[y])){
                        matches++;
                    }
                }
            }

            float div = (float) Math.max(tokensA.length, tokensB.length) - 1;
            if (matches / div >= TOKEN_MATCH_PERCENTAGE){
                match = true;
            }
        }

        return match;
    }

    protected static boolean isSameHouseNumber(Address a, Address b){
        assert(a != null);
        assert(b != null);
        String houseNumberA = getHouseNumber(a);
        String houseNumberB = getHouseNumber(b);
        return houseNumberA != null && houseNumberB != null && houseNumberA.equals(houseNumberB);

    }

    protected static String getHouseNumber(Address a){
        assert(a != null);
        String houseNumber = null;
        if (a.getAddress() != null){
            int pos = a.getAddress().indexOf(" ");
            if (pos > 0){
                try{
                    houseNumber = a.getAddress().substring(0, pos);
                    Integer.parseInt(houseNumber);
                }
                catch(NumberFormatException ignored){
                    houseNumber = null;
                }
            }
        }

        return houseNumber;
    }

    protected static boolean isSameZip(Address a, Address b){
        assert(a != null);
        assert(b != null);
        return a.getZip5() != null
                && b.getZip5() != null
                && a.getZip5().equals(b.getZip5());
    }

    protected static boolean isDeliverable(Address a, Address b){
        assert(a != null);
        assert(b != null);
        return a.getQuality() != null
                && b.getQuality() != null
                && a.getQuality().isDeliverable()
                && b.getQuality().isDeliverable();
    }
}
