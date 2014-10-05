package org.apd.model.domain;

import org.apd.model.enums.PhoneType;

public class PhoneNumber extends Base {
    private String number;
    private String extension;
    private PhoneType type;

    public PhoneNumber() {
        this(null, null, null);
    }

    public PhoneNumber(String number) {
        this(number, null, PhoneType.Home);
    }

    public PhoneNumber(String number, String extension, PhoneType type) {
        this.setNumber(number);
        this.setExtension(extension);
        this.setType(type);
    }

    public String toCsv() {
        return Base.PrintStringNull(this.getNumber());
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }
}
