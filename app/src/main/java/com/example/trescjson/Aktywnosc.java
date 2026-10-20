package com.example.trescjson;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Aktywnosc {

    private String tytul;
    private String tresc;
    private Date data;

    public String getTytul() {
        return tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        return "tytul: " + tytul +
                "\ntresc: " + tresc +
                "\ndata: " + format.format(data);
    }
}
