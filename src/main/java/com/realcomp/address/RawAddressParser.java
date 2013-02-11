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

    private String zipRegEx;
    private Pattern zipPattern;

    public RawAddressParser() {

        zipRegEx = "[0-9]{5}([\\-][0-9]{4})?";
        zipPattern = Pattern.compile(zipRegEx);
    }

    private void splitAddress(RawAddress rawAddress, String splitChar) {

        List<String> address = rawAddress.getAddressLines();
        List<String> splitAddr = new ArrayList<String>();

        for (String addrLine : address) {
            String[] addrParts = addrLine.split(splitChar);

            for (String addrPart : addrParts)
                splitAddr.add(addrPart.trim());
        }
        if (splitAddr != null && splitAddr.size() <= 10)
            rawAddress.setAddressLines(splitAddr);
    }

    private void extractZip(RawAddress rawAddress) {

        if (rawAddress.getAddressLines().isEmpty() || (rawAddress.getZip() != null && !rawAddress.getZip().isEmpty()))
            return;
        List<String> address = rawAddress.getAddressLines();
        int lastElement = address.size() - 1;
        Matcher m = zipPattern.matcher(address.get(lastElement));
        if (lastElement > 0 && m.matches()) {
            String zip = address.remove(lastElement);
            rawAddress.setZip(zip);
        }
        else {
            String lastLine = address.get(lastElement);
            int lastSpace = lastLine.lastIndexOf(" ");

            if (lastSpace > 0) {
                String lastWord = lastLine.substring(lastSpace + 1);
                m = zipPattern.matcher(lastLine.substring(lastSpace + 1));

                if (m.matches()) {
                    rawAddress.setZip(lastWord);
                    address.set(lastElement, lastLine.substring(0, lastSpace).trim());
                }
            }
        }
    }

    public RawAddress parse(RawAddress rawAddress) {

        RawAddress modifiedAddr = new RawAddress(rawAddress);

        if (modifiedAddr.getCity() == null || modifiedAddr.getCity().isEmpty())
            splitAddress(modifiedAddr, ",");

        extractZip(modifiedAddr);

        return modifiedAddr;
    }

}
