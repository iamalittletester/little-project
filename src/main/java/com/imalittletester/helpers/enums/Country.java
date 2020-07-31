package com.imalittletester.helpers.enums;

import java.util.Arrays;
import java.util.List;

public enum Country {
    AT("Austria", Arrays.asList("Vienna", "Salzburg", "Innsbruck"), 43),
    EE("Estonia", Arrays.asList("Tallinn", "Haapsalu", "Tartu"), 372),
    ES("Spain", Arrays.asList("Malaga", "Madrid", "Valencia", "Corralejo"), 34);

    public final String label;
    public final List<String> cities;
    public int phoneNumberPrefix;

    Country(String label, List<String> cities, int phoneNumberPrefix) {
        this.label = label;
        this.cities = cities;
        this.phoneNumberPrefix = phoneNumberPrefix;
    }
}
