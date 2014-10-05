package org.apd.model.domain;

public class State extends Base {
    private int code;
    private String name;
    private String shortName;

    public State(int code, String name, String shortName) {
        this.setCode(code);
        this.setName(name);
        this.setShortName(shortName);
    }

    public String toCsv() {
        return "" + this.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
