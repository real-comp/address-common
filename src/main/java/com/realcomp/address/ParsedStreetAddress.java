package com.realcomp.address;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class ParsedStreetAddress implements Serializable {

    private String houseNum;
    private String preDir;
    private String street;
    private String streetSuffix;
    private String postDir;
    private String unitAbbrev;
    private String unit;

    public ParsedStreetAddress(){
    }

    public ParsedStreetAddress(ParsedStreetAddress copy) {
        this.houseNum = copy.houseNum;
        this.preDir = copy.preDir;
        this.street = copy.street;
        this.streetSuffix = copy.streetSuffix;
        this.postDir = copy.postDir;
        this.unitAbbrev = copy.unitAbbrev;
        this.unit = copy.unit;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getPreDir() {
        return preDir;
    }

    public void setPreDir(String preDir) {
        this.preDir = preDir;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public String getPostDir() {
        return postDir;
    }

    public void setPostDir(String postDir) {
        this.postDir = postDir;
    }

    public String getUnitAbbrev() {
        return unitAbbrev;
    }

    public void setUnitAbbrev(String unitAbbrev) {
        this.unitAbbrev = unitAbbrev;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("houseNum", houseNum);
        map.put("preDir", preDir);
        map.put("street", street);
        map.put("streetSuffix", streetSuffix);
        map.put("postDir", postDir);
        map.put("unitAbbrev", unitAbbrev);
        map.put("unit", unit);
        return map;
    }

    public static ParsedStreetAddress fromMap(Map map){
        ParsedStreetAddress parsed = new ParsedStreetAddress();
        if (map != null){
            parsed.setHouseNum(asString(map.get("houseNum")));
            parsed.setPreDir(asString(map.get("preDir")));
            parsed.setStreet(asString(map.get("street")));
            parsed.setStreetSuffix(asString(map.get("streetSuffix")));
            parsed.setUnitAbbrev(asString(map.get("unitAbbrev")));
            parsed.setUnit(asString(map.get("unit")));
            parsed.setPostDir(asString(map.get("postDir")));
        }

        return parsed;
    }

    private static String asString(Object value){
        return value == null ? null : value.toString();
    }


    @Override
    public String toString() {
        StringAppender sa = new StringAppender(" ");
        sa.append(houseNum);
        sa.append(preDir);
        sa.append(street);
        sa.append(streetSuffix);
        sa.append(postDir);
        sa.append(unitAbbrev);
        sa.append(unit);
        return sa.toString().trim();
    }

    @Generated("NetBeans")
    @Override
    public int hashCode(){
        int hash = 3;
        hash = 53 * hash + (this.houseNum != null ? this.houseNum.hashCode() : 0);
        hash = 53 * hash + (this.preDir != null ? this.preDir.hashCode() : 0);
        hash = 53 * hash + (this.street != null ? this.street.hashCode() : 0);
        hash = 53 * hash + (this.streetSuffix != null ? this.streetSuffix.hashCode() : 0);
        hash = 53 * hash + (this.postDir != null ? this.postDir.hashCode() : 0);
        hash = 53 * hash + (this.unitAbbrev != null ? this.unitAbbrev.hashCode() : 0);
        hash = 53 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        return hash;
    }

    @Generated("NetBeans")
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final ParsedStreetAddress other = (ParsedStreetAddress) obj;
        if ((this.houseNum == null) ? (other.houseNum != null) : !this.houseNum.equals(other.houseNum)){
            return false;
        }
        if ((this.preDir == null) ? (other.preDir != null) : !this.preDir.equals(other.preDir)){
            return false;
        }
        if ((this.street == null) ? (other.street != null) : !this.street.equals(other.street)){
            return false;
        }
        if ((this.streetSuffix == null) ? (other.streetSuffix != null) : !this.streetSuffix.equals(other.streetSuffix)){
            return false;
        }
        if ((this.postDir == null) ? (other.postDir != null) : !this.postDir.equals(other.postDir)){
            return false;
        }
        if ((this.unitAbbrev == null) ? (other.unitAbbrev != null) : !this.unitAbbrev.equals(other.unitAbbrev)){
            return false;
        }
        if ((this.unit == null) ? (other.unit != null) : !this.unit.equals(other.unit)){
            return false;
        }
        return true;
    }


}
