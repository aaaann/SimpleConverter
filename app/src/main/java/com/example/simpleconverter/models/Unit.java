package com.example.simpleconverter.models;

public enum Unit {

    RUB("Рубль", 0.014), USD("Доллар", 0.761789), GBP("Фунт", 1.454334),EUR("Евро", 1),CHF("Швейцарский франк",0.646747),
    SEK("Шведская Крона", 0.110558), DKK("Датская Крона", 0.134371), NOK("Норвежская Крона", 0.121708),SGD("Сингапурский доллар", 0.468867), INR("Рупия", 0.017494), AED("Дирхам", 0.207577),
    KRW("Вона", 0.000758), THB("Бат", 0.019682),ILS("Шекель", 0.175688),JPY("Иена", 0.007261), UAH("Гривна", 0.037),
    KILOGRAM("Килограмм", 1000), GRAM("Грамм", 1), MILLIGRAM("", 0.001), TON("Тонна", 1000000),
    GRAN("Гран", 0.0648), OUNCE("Унция", 28.350296), LB("Фунт", 453.599082);

    private final String mName;
    private final double mProportion;

    public String getName() {
        return mName;
    }

    public double getProportion() {
        return mProportion;
    }


    Unit(String name, double proportion) {
        mName = name;
        mProportion = proportion;
    }
}
