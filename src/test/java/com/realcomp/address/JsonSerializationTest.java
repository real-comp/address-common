package com.realcomp.address;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krenfro
 */
public class JsonSerializationTest {
    
    public JsonSerializationTest() {
    }
    
    
    @Test
    public void testAddressSerialization() throws IOException{
        
        
        ObjectMapper jackson = new ObjectMapper();
        
        jackson.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        
        
        Address expected = new Address();
        expected.setAddress("8665 EPHRAIM RD");
        expected.setCity("AUSTIN");
        expected.setState("TX");
        expected.setZip("78717");
        expected.setCrrt("C100");
        expected.setLatitude(2d);
        expected.setLongitude(3d);
        expected.setLatLongAccuracy(LatLongAccuracy.ADDRESS);
        expected.setQuality(AddressQuality.VALID);
        
        ParsedStreetAddress parsed = new ParsedStreetAddress();
        parsed.setStreet("EPHRAIM");
        parsed.setHouseNum("8665");
        parsed.setStreetSuffix("RD");
        expected.setParsed(parsed);
        
        String json = jackson.writeValueAsString(expected);
        
        System.out.println(json);
        Address actual = jackson.readValue(json, Address.class);
        
        assertEquals(expected, actual);
        
        
    }
    
    
    @Test
    public void testRawAddressSerialization() throws IOException{
        
        
        ObjectMapper jackson = new ObjectMapper();
        
        jackson.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        
        
        RawAddress expected = new RawAddress();
        expected.addAddressLine("8665 EPHRAIM RD");
        expected.addAddressLine("AUSTIN, TX  78717");
        expected.setHint("fips","48491");
        String json = jackson.writeValueAsString(expected);
        
        System.out.println(json);
        RawAddress actual = jackson.readValue(json, RawAddress.class);
        
        assertEquals(expected, actual);
        
        
    }
}
