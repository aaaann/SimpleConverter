package com.example.simpleconverter.models;

import java.util.Arrays;
import java.util.List;

import static com.example.simpleconverter.models.Unit.AED;
import static com.example.simpleconverter.models.Unit.CHF;
import static com.example.simpleconverter.models.Unit.DKK;
import static com.example.simpleconverter.models.Unit.EUR;
import static com.example.simpleconverter.models.Unit.GBP;
import static com.example.simpleconverter.models.Unit.GRAM;
import static com.example.simpleconverter.models.Unit.GRAN;
import static com.example.simpleconverter.models.Unit.ILS;
import static com.example.simpleconverter.models.Unit.INR;
import static com.example.simpleconverter.models.Unit.JPY;
import static com.example.simpleconverter.models.Unit.KILOGRAM;
import static com.example.simpleconverter.models.Unit.KRW;
import static com.example.simpleconverter.models.Unit.LB;
import static com.example.simpleconverter.models.Unit.MILLIGRAM;
import static com.example.simpleconverter.models.Unit.NOK;
import static com.example.simpleconverter.models.Unit.OUNCE;
import static com.example.simpleconverter.models.Unit.RUB;
import static com.example.simpleconverter.models.Unit.SEK;
import static com.example.simpleconverter.models.Unit.SGD;
import static com.example.simpleconverter.models.Unit.THB;
import static com.example.simpleconverter.models.Unit.TON;
import static com.example.simpleconverter.models.Unit.UAH;
import static com.example.simpleconverter.models.Unit.USD;

public enum Conversion {
    CURRENCY("Валюта", Arrays.asList(RUB, USD, GBP, EUR, CHF, SEK, DKK, NOK, SGD, INR,AED, KRW, THB, ILS, JPY, UAH)),
    WEIGHT("Вес", Arrays.asList(KILOGRAM, GRAM, MILLIGRAM, TON, GRAN, OUNCE, LB));


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
