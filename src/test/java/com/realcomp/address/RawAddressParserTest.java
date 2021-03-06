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

        RawAddressParser parser = new RawAddressParser();
        RawAddress rawAddress = new RawAddress();
        rawAddress.addAddressLine(addressLine);
        RawAddress modifiedRawAddress = parser.parse(rawAddress);

         assertEquals("3520 OHIO AVE", modifiedRawAddress.getAddressLines().get(0));
        assertEquals("SPC #7", modifiedRawAddress.getAddressLines().get(1));
        assertEquals("DICKINSON", modifiedRawAddress.getAddressLines().get(2));
        assertEquals("TX", modifiedRawAddress.getAddressLines().get(3));

        assertEquals("77539", modifiedRawAddress.getZip());
    }

    @Test
    public void testExtractZip4() {

        String addressLine = "3520 OHIO AVE, SPC #7 ,  DICKINSON, TX  77539-1234";

        RawAddressParser parser = new RawAddressParser();
        RawAddress rawAddress = new RawAddress();
        rawAddress.addAddressLine(addressLine);
        RawAddress modifiedRawAddress = parser.parse(rawAddress);

        assertEquals("3520 OHIO AVE", modifiedRawAddress.getAddressLines().get(0));
        assertEquals("SPC #7", modifiedRawAddress.getAddressLines().get(1));
        assertEquals("DICKINSON", modifiedRawAddress.getAddressLines().get(2));
        assertEquals("TX", modifiedRawAddress.getAddressLines().get(3));
        assertEquals("77539-1234", modifiedRawAddress.getZip());

    }

    @Test
    public void testExtractBadZip() {

        String addressLine = "3520 OHIO AVE, SPC #7 ,  DICKINSON, TX  7753";

        RawAddressParser parser = new RawAddressParser();
        RawAddress rawAddress = new RawAddress();
        rawAddress.addAddressLine(addressLine);
        RawAddress modifiedRawAddress = parser.parse(rawAddress);

        assertEquals("3520 OHIO AVE", modifiedRawAddress.getAddressLines().get(0));
        assertEquals("SPC #7", modifiedRawAddress.getAddressLines().get(1));
        assertEquals("DICKINSON", modifiedRawAddress.getAddressLines().get(2));
        assertEquals("TX  7753", modifiedRawAddress.getAddressLines().get(3));

        assertNull(modifiedRawAddress.getZip());
    }

}
