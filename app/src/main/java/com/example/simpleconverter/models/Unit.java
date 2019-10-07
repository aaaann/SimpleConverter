package com.example.simpleconverter.models;

public enum Unit {

    RUB("Рубль", 1), DOLLAR("Доллар", 1), POUND("Фунт", 1),
    KILOGRAM("Килограмм", 1), GRAM("Грамм", 1);

    private final String mName;
    private final int mProportion;

    public String getName() {
        return mName;
    }

    public int getProportion() {
        return mProportion;
    }

    Unit(String name, int proportion) {
        mName = name;
        mProportion = proportion;
    }
}
