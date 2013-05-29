package com.realcomp.address;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BGoering
 */
public class RawAddressParser {

    private static final int MAX_SPLIT_LINES = 10;
    private static final Pattern ZIP_PATTERN = Pattern.compile("[0-9]{5}([\\-][0-9]{4})?");

    private void splitAddress(RawAddress rawAddress, String splitChar) {

        List<String> address = rawAddress.getAddressLines();
        List<String> splitAddr = new ArrayList<String>();

        for (String addrLine : address) {
            String[] addrParts = addrLine.split(splitChar);

            for (String addrPart : addrParts){
                splitAddr.add(addrPart.trim());
            }
        }
        if (splitAddr.size() <= MAX_SPLIT_LINES){
            rawAddress.setAddressLines(splitAddr);
        }
    }

    private void extractZip(RawAddress rawAddress) {

        if (rawAddress.getAddressLines().isEmpty() || (rawAddress.getZip() != null && !rawAddress.getZip().isEmpty())){
            return;
        }
        List<String> address = rawAddress.getAddressLines();
        int lastElement = address.size() - 1;
        Matcher m = ZIP_PATTERN.matcher(address.get(lastElement));
        if (lastElement > 0 && m.matches()) {
            String zip = address.remove(lastElement);
            rawAddress.setZip(zip);
        }
        else {
            String lastLine = address.get(lastElement);
            int lastSpace = lastLine.lastIndexOf(' ');

            if (lastSpace > 0) {
                String lastWord = lastLine.substring(lastSpace + 1);
                m = ZIP_PATTERN.matcher(lastLine.substring(lastSpace + 1));

                if (m.matches()) {
                    rawAddress.setZip(lastWord);
                    address.set(lastElement, lastLine.substring(0, lastSpace).trim());
                }
            }
        }
    }

    public RawAddress parse(RawAddress rawAddress) {

        RawAddress modifiedAddr = new RawAddress(rawAddress);

        if (modifiedAddr.getCity() == null || modifiedAddr.getCity().isEmpty()){
            splitAddress(modifiedAddr, ",");
        }

        extractZip(modifiedAddr);

        return modifiedAddr;
    }

}
