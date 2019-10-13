package com.example.simpleconverter.models;

import com.example.simpleconverter.R;

public enum Unit {

    RUB(R.string.Rub, 0.014), USD(R.string.USD, 0.761789), GBP(R.string.GBP, 1.454334),EUR(R.string.EUR, 1),CHF(R.string.CHF,0.646747),
    SEK(R.string.SEK, 0.110558), DKK(R.string.DKK, 0.134371), NOK(R.string.NOK, 0.121708),SGD(R.string.SGD, 0.468867), INR(R.string.INR, 0.017494), AED(R.string.AED, 0.207577),
    KRW(R.string.KRW, 0.000758), THB(R.string.THB, 0.019682),ILS(R.string.ILS, 0.175688),JPY(R.string.JPY, 0.007261), UAH(R.string.UAH, 0.037),

    KILOGRAM(R.string.KILOGRAM, 1000), GRAM(R.string.GRAM, 1), MILLIGRAM(R.string.MILLIGRAM, 0.001), TON(R.string.TON, 1000000),
    GRAN(R.string.GRAN, 0.0648), OUNCE(R.string.OUNCE, 28.350296), LB(R.string.LB, 453.599082),

    MM(R.string.MM, 0.1), CM(R.string.CM, 1), M(R.string.M, 100), KM(R.string.KM, 100000), INCH(R.string.INCH, 2.540005), FT(R.string.FT, 30.480371), YD(R.string.YD, 91.441112), MILE(R.string.MILE, 160926.93917),

    CBCM(R.string.CBCM, 1), CBM(R.string.CBM, 1000000), LITER(R.string.LITER, 1000), CBINCH(R.string.CBUNCH, 16.38619), CBFT(R.string.CBFT, 28315.37665), CBYD(R.string.CBYD, 764409.111757), GALLON(R.string.GALLON, 4546.095132),

    SQCM(R.string.SQCM, 1), SQM(R.string.SQM, 10000), ARE(R.string.ARE, 1000000), SQINCH(R.string.SQINCH, 6.451613), SQFT(R.string.SQFT, 929.022668), SQYD(R.string.SQYD, 8361.204013), ACRE(R.string.ACRE, 40469445.568596), HA(R.string.HA, 100000000), SQMILE(R.string.SQMILE, 25899891738.4525);


    private final int mName;
    private final double mProportion;

    public int getName() {
        return mName;
    }

    public double getProportion() {
        return mProportion;
    }


    Unit(int name, double proportion) {
        mName = name;
        mProportion = proportion;
    }
}
