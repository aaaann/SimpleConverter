package com.example.simpleconverter.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static com.example.simpleconverter.models.Unit.DOLLAR;
import static com.example.simpleconverter.models.Unit.GRAM;
import static com.example.simpleconverter.models.Unit.KILOGRAM;
import static com.example.simpleconverter.models.Unit.POUND;
import static com.example.simpleconverter.models.Unit.RUB;

public enum Conversion {
    CURRENCY("Валюта", Arrays.asList(RUB, DOLLAR, POUND)),
    WEIGHT("Вес", Arrays.asList(KILOGRAM, GRAM));


    private final String mLabel;
    private final List<Unit> mUnits;

    Conversion(String label, List<Unit> units) {
        mLabel = label;
        mUnits = units;
    }

    public String getLabel() {
        return mLabel;
    }

    public List<Unit> getUnits() {
        return mUnits;
    }
}
