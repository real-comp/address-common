/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realcomp.address;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krenfro
 */
public class RawAddressTest{

    public RawAddressTest(){
    }

    @Test
    public void testHasHints(){

        RawAddress raw = new RawAddress();
        assertFalse(raw.hasHints());
        raw.setHint("asdf","1234");
        assertTrue(raw.hasHints());

    }

    @Test
    public void testCopyConstructor(){
        RawAddress original = new RawAddress();
        original.setHint("asdf","1234");

        assertEquals("1234", original.getHint("asdf"));

        RawAddress copy = new RawAddress(original);
        assertEquals("1234", copy.getHint("asdf"));

    }
}
