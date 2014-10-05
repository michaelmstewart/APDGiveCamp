package org.apd.model.domain;

public class County extends Base {
    private int code;
    private String name;
    private State state;

    public County(int code, String name, State state) {
        this.setCode(code);
        this.setName(name);
        this.setState(state);
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
