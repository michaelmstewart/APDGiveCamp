package org.apd.model.domain;

import java.text.SimpleDateFormat;

public abstract class Base {
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/YYYY 0:00:00");

    public static String PrintStringNull(String s) {
        return (s == null ? "" : ("\"" + s + "\""));
    }

    public static String PrintObjectNull(Object o) {
        return (o == null ? "" : o.toString());
    }

    public String toCsv() {
        return "";
    }
}
