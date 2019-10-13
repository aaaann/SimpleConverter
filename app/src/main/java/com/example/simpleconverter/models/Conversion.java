package com.example.simpleconverter.models;

import com.example.simpleconverter.R;

import java.util.Arrays;
import java.util.List;

import static com.example.simpleconverter.models.Unit.ACRE;
import static com.example.simpleconverter.models.Unit.AED;
import static com.example.simpleconverter.models.Unit.ARE;
import static com.example.simpleconverter.models.Unit.CBCM;
import static com.example.simpleconverter.models.Unit.CBFT;
import static com.example.simpleconverter.models.Unit.CBINCH;
import static com.example.simpleconverter.models.Unit.CBM;
import static com.example.simpleconverter.models.Unit.CBYD;
import static com.example.simpleconverter.models.Unit.CHF;
import static com.example.simpleconverter.models.Unit.CM;
import static com.example.simpleconverter.models.Unit.DKK;
import static com.example.simpleconverter.models.Unit.EUR;
import static com.example.simpleconverter.models.Unit.FT;
import static com.example.simpleconverter.models.Unit.GALLON;
import static com.example.simpleconverter.models.Unit.GBP;
import static com.example.simpleconverter.models.Unit.GRAM;
import static com.example.simpleconverter.models.Unit.GRAN;
import static com.example.simpleconverter.models.Unit.HA;
import static com.example.simpleconverter.models.Unit.ILS;
import static com.example.simpleconverter.models.Unit.INCH;
import static com.example.simpleconverter.models.Unit.INR;
import static com.example.simpleconverter.models.Unit.JPY;
import static com.example.simpleconverter.models.Unit.KILOGRAM;
import static com.example.simpleconverter.models.Unit.KM;
import static com.example.simpleconverter.models.Unit.KRW;
import static com.example.simpleconverter.models.Unit.LB;
import static com.example.simpleconverter.models.Unit.LITER;
import static com.example.simpleconverter.models.Unit.M;
import static com.example.simpleconverter.models.Unit.MILE;
import static com.example.simpleconverter.models.Unit.MILLIGRAM;
import static com.example.simpleconverter.models.Unit.MM;
import static com.example.simpleconverter.models.Unit.NOK;
import static com.example.simpleconverter.models.Unit.OUNCE;
import static com.example.simpleconverter.models.Unit.RUB;
import static com.example.simpleconverter.models.Unit.SEK;
import static com.example.simpleconverter.models.Unit.SGD;
import static com.example.simpleconverter.models.Unit.SQCM;
import static com.example.simpleconverter.models.Unit.SQFT;
import static com.example.simpleconverter.models.Unit.SQINCH;
import static com.example.simpleconverter.models.Unit.SQM;
import static com.example.simpleconverter.models.Unit.SQMILE;
import static com.example.simpleconverter.models.Unit.SQYD;
import static com.example.simpleconverter.models.Unit.THB;
import static com.example.simpleconverter.models.Unit.TON;
import static com.example.simpleconverter.models.Unit.UAH;
import static com.example.simpleconverter.models.Unit.USD;
import static com.example.simpleconverter.models.Unit.YD;

public enum Conversion {
    CURRENCY(R.string.Currency, Arrays.asList(RUB, USD, GBP, EUR, CHF, SEK, DKK, NOK, SGD, INR,AED, KRW, THB, ILS, JPY, UAH)),
    WEIGHT(R.string.Weight, Arrays.asList(KILOGRAM, GRAM, MILLIGRAM, TON, GRAN, OUNCE, LB)),
    LENGTH(R.string.Length,Arrays.asList(MM, CM, M, KM, INCH, FT, YD, MILE)),
    VOLUME(R.string.Volume, Arrays.asList(CBCM, CBM, LITER, CBINCH, CBFT, CBYD, GALLON)),
    AREA(R.string.Area, Arrays.asList(SQCM, SQM, ARE, SQINCH, SQFT, SQYD, ACRE, HA, SQMILE));


    private final int mLabel;
    private final List<Unit> mUnits;

    Conversion(int label, List<Unit> units) {
        mLabel = label;
        mUnits = units;
    }

    public int getLabel() {
        return mLabel;
    }

    public List<Unit> getUnits() {
        return mUnits;
    }
}
