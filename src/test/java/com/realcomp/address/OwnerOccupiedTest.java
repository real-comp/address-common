/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realcomp.address;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krenfro
 */
public class OwnerOccupiedTest {
    
    public OwnerOccupiedTest() {
    }
    
    @Test
    public void testIsOwnerOccupied() {
        Address a = new Address();
        a.setAddress("12345 main st");
        a.setQuality(AddressQuality.VALID);
        a.setZip("12345");
        
        Address b = new Address();
        b.setAddress("12345 main st");
        b.setQuality(AddressQuality.VALID);
        b.setZip("12345");
        
        assertTrue(OwnerOccupied.isOwnerOccupied(a, b));
        
         b = new Address();
        b.setAddress("12345 main");
        b.setQuality(AddressQuality.MISSING_UNIT);
        b.setZip("12345");
        
        assertTrue(OwnerOccupied.isOwnerOccupied(a, b));
        
    }

    @Test
    public void testIs40PercentTokenMatch() {
        
        Address a = new Address();
        Address b = new Address();
        
        assertFalse(OwnerOccupied.is40PercentTokenMatch(a, b));
        a.setAddress("12345 main st");
        assertFalse(OwnerOccupied.is40PercentTokenMatch(a, b));
        b.setAddress("12345 main st");
        assertTrue(OwnerOccupied.is40PercentTokenMatch(a, b));
        
        b.setAddress("12345 main");
        assertTrue(OwnerOccupied.is40PercentTokenMatch(a, b));
        
    }

    @Test
    public void testIsSameHouseNumber() {
        Address a = new Address();
        Address b = new Address();
        
        assertFalse(OwnerOccupied.isSameHouseNumber(a, b));
        a.setAddress("my st");
        assertFalse(OwnerOccupied.isSameHouseNumber(a, b));
        a.setAddress("12345 my st");
        assertFalse(OwnerOccupied.isSameHouseNumber(a, b));
        b.setAddress("54321 your st");
        assertFalse(OwnerOccupied.isSameHouseNumber(a, b));
        b.setAddress("12345 my st");
        assertTrue(OwnerOccupied.isSameHouseNumber(a, b));
    }

    @Test
    public void testGetHouseNumber() {
        
        Address a = new Address();
        assertNull(OwnerOccupied.getHouseNumber(a));
        a.setAddress("my st");
        assertNull(OwnerOccupied.getHouseNumber(a));
        a.setAddress("12345 my st");
        assertEquals("12345", OwnerOccupied.getHouseNumber(a));
    }

    @Test
    public void testIsSameZip() {
        
        Address a = new Address();
        a.setZip("12345");        
        Address b = new Address();
        b.setZip("12345");        
        assertTrue(OwnerOccupied.isSameZip(a, b));
        
        a.setZip("12345-1234");
        b.setZip("12345-1234");
        assertTrue(OwnerOccupied.isSameZip(a, b));
        
        b.setZip(null);
        assertFalse(OwnerOccupied.isSameZip(a, b));
        
        a.setZip(null);
        assertFalse(OwnerOccupied.isSameZip(a, b));
        
        a.setZip("12345");
        b.setZip("54321");
        assertFalse(OwnerOccupied.isSameZip(a, b));
    }

    @Test
    public void testIsDeliverable() {
        
        Address a = new Address();
        a.setQuality(AddressQuality.VALID);
        
        Address b = new Address();
        b.setQuality(AddressQuality.VALID);
        
        assertTrue(OwnerOccupied.isDeliverable(a, b));
        
        b.setQuality(AddressQuality.MISSING_UNIT);
        assertTrue(OwnerOccupied.isDeliverable(a, b));
        
        b.setQuality(AddressQuality.UNCONFIRMED_UNIT);
        assertTrue(OwnerOccupied.isDeliverable(a, b));
        
        b.setQuality(AddressQuality.INVALID);
        assertFalse(OwnerOccupied.isDeliverable(a, b));
        
        b.setQuality(AddressQuality.ERROR);
        assertFalse(OwnerOccupied.isDeliverable(a, b));
        
        a.setQuality(null);
        assertFalse(OwnerOccupied.isDeliverable(a, b));
        b.setQuality(null);
        assertFalse(OwnerOccupied.isDeliverable(a, b));
        
    }
}
