package com.realcomp.address;

/**
 * Appends strings to the end of an existing string with a String delimiter (often a space)
 * @author BGoering
 */
public class StringAppender {

    protected StringBuilder sb;
    protected String delimiter;
    protected boolean empty = true;

    public StringAppender(){
        sb = new StringBuilder();
    }

    public StringAppender(String delimiter){
        if (delimiter == null)
            throw new IllegalArgumentException("delimiter is null");
        sb = new StringBuilder();
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Appends inData to the existing string separating it by the set delimiter
     * @param inData String to be appended to the existing string
     */
    public void append(String inData){
        append(inData, delimiter);
    }

    /**
     * Appends inData to the existing string separating it by the supplied delimiter
     * @param inData String to be appended to the existing string
     * @param delimiter String delimiter to separate the existing string from the inData string
     * (often a space)
     */
    public void append(String inData, String delimiter) {
        if (inData != null && !inData.isEmpty()) {
            if (delimiter != null && !empty)
                sb.append(delimiter);
            sb.append(inData);
            empty = false;
        }
    }

    @Override
    public String toString(){
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final StringAppender other = (StringAppender) obj;
        if (this.sb != other.sb && (this.sb == null || !this.sb.equals(other.sb)))
            return false;
        if ((this.delimiter == null) ? (other.delimiter != null)
                : !this.delimiter.equals(other.delimiter))
            return false;
        if (this.empty != other.empty)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.sb != null ? this.sb.hashCode() : 0);
        hash = 13 * hash + (this.delimiter != null ? this.delimiter.hashCode() : 0);
        hash = 13 * hash + (this.empty ? 1 : 0);
        return hash;
    }
}
