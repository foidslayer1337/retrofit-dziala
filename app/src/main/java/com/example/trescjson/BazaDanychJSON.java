package com.example.trescjson;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BazaDanychJSON {
    @SerializedName("pytania")
    private List<Aktywnosc> pytania;

    public List<Aktywnosc> getPytania() {
        return pytania;
    }
}
