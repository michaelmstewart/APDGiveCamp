package org.apd.model.domain;

import org.apd.model.parsers.LocaleParser;

public class Address extends Base {
    private String streetAddressLine1;
    private String streetAddressLine2;
    private String city;
    private State state;
    private County county;
    private Integer zip;
    private LocaleParser locales;

    public Address() {
        this(null, null, null, "", "", null);
    }

    public Address(String streetAddressLine1, String streetAddressLine2, String city, String stateShortCode, String countyName, Integer zip) {
        this.setLocales(new LocaleParser());
        this.setStreetAddressLine1(streetAddressLine1);
        this.setStreetAddressLine2(streetAddressLine2);
        this.setCity(city);
        this.setState(this.getLocales().getStatesByShortCode().get(stateShortCode));
        this.setCounty(this.getLocales().getCountiesByStateAndCounty().get(stateShortCode + "|" + countyName));
        this.setZip(zip);
    }

    public String toString() {
        String line1 = this.getStreetAddressLine1();
        String line2 = this.getCity() + " " + this.getCounty() + " " + this.getState() + " " + this.getZip();
        if(this.getStreetAddressLine2() != null && this.getStreetAddressLine2() != "") {
            line2 = this.getStreetAddressLine2() + "\r\n" + line2;
        }
        return line1 + "\r\n" + line2;
    }

    public String toCsv() {
        return Base.PrintStringNull(this.getStreetAddressLine1()) + "," +
                Base.PrintStringNull(this.getStreetAddressLine2()) + "," +
                Base.PrintStringNull(this.getCity()) + "," +
                Base.PrintObjectNull(this.getState() != null ? this.getState().getCode() : this.getState()) + "," +
                Base.PrintObjectNull(this.getZip()) + "," +
                Base.PrintObjectNull(this.getCounty() != null ? this.getCounty().getCode() : this.getCounty());
    }

    public String getStreetAddressLine1() {
        return streetAddressLine1;
    }

    public void setStreetAddressLine1(String streetAddressLine1) {
        this.streetAddressLine1 = streetAddressLine1;
    }

    public String getStreetAddressLine2() {
        return streetAddressLine2;
    }

    public void setStreetAddressLine2(String streetAddressLine2) {
        this.streetAddressLine2 = streetAddressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public LocaleParser getLocales() {
        return locales;
    }

    public void setLocales(LocaleParser locales) {
        this.locales = locales;
    }
}
