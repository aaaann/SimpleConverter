package com.example.simpleconverter.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Conversion implements Serializable {
    public String getmName() {
        return mName;
    }

    private final String mName;


    public Conversion(@NonNull String mName) {
        this.mName = mName;
    }
}
