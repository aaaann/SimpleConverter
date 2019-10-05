package com.example.simpleconverter.dataprovider;

import com.example.simpleconverter.models.Conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversionsProvider {
    private List<Conversion> mConversions = Arrays.asList(
            new Conversion("Валюта"),
            new Conversion("Вес")
    );

    public List<Conversion> provideConversions() {return mConversions;};


}
