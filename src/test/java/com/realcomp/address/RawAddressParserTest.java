package com.realcomp.address;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for RawAddressParser
 */
public class RawAddressParserTest {

    public RawAddressParserTest() {
    }

    @Test
    public void testExtractZip() {

        String addressLine = "3520 OHIO AVE, SPC #7 ,  DICKINSON, TX  77539";
        String expected = "[3520 OHIO AVE, SPC #7, DICKINSON, TX] 77539";
        String expectedZIP = "77539";

        RawAddressParser parser = new RawAddressParser();
        RawAddress rawAddress = new RawAddress();
        rawAddress.addAddress(addressLine);
        RawAddress modifiedRawAddress = parser.parse(rawAddress);

        assertEquals(expected, modifiedRawAddress.toString());
        assertEquals(expectedZIP, modifiedRawAddress.getZip());
    }

    @Test
    public void testExtractZip4() {

        String addressLine = "3520 OHIO AVE, SPC #7 ,  DICKINSON, TX  77539-1234";
        String expected = "[3520 OHIO AVE, SPC #7, DICKINSON, TX] 77539-1234";
        String expectedZIP = "77539-1234";

        RawAddressParser parser = new RawAddressParser();
        RawAddress rawAddress = new RawAddress();
        rawAddress.addAddress(addressLine);
        RawAddress modifiedRawAddress = parser.parse(rawAddress);

        assertEquals(expected, modifiedRawAddress.toString());
        assertEquals(expectedZIP, modifiedRawAddress.getZip());
    }

    @Test
    public void testExtractBadZip() {

        String addressLine = "3520 OHIO AVE, SPC #7 ,  DICKINSON, TX  7753";
        String expected = "[3520 OHIO AVE, SPC #7, DICKINSON, TX  7753]";

        RawAddressParser parser = new RawAddressParser();
        RawAddress rawAddress = new RawAddress();
        rawAddress.addAddress(addressLine);
        RawAddress modifiedRawAddress = parser.parse(rawAddress);

        assertEquals(expected, modifiedRawAddress.toString());
        assertNull(modifiedRawAddress.getZip());
    }

}
