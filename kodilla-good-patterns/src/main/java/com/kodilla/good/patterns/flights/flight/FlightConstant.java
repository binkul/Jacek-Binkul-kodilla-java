package com.kodilla.good.patterns.flights.flight;

public class FlightConstant {
    static final String[] NONE = {};

    static final String[] BYDGOSZCZ = {
            "BZG001|BYDGOSZCZ|WARSZAWA",
            "BZG002|BYDGOSZCZ|POZNAN",
            "BZG003|BYDGOSZCZ|KRAKOW"
    };

    static final String[] WARSZAWA = {
            "WAW001|WARSZAWA|BYDGOSZCZ",
            "WAW002|WARSZAWA|POZNAN",
            "WAW003|WARSZAWA|KRAKOW",
            "WAW004|WARSZAWA|LODZ",
            "WAW005|WARSZAWA|BERLIN",
            "WAW006|WARSZAWA|GDANSK"
    };

    static final String[] GDANSK = {
            "GDN001|GDANSK|WARSZAWA",
            "GDN002|GDANSK|KRAKOW",
            "GDN003|GDANSK|LODZ"
    };

    static final String[] KRAKOW = {
            "KRK001|KRAKOW|WARSZAWA",
            "KRK002|KRAKOW|BYDGOSZCZ",
            "KRK003|KRAKOW|POZNAN",
            "KRK004|KRAKOW|GDANSK"
    };

    static final String[] LODZ = {
            "LCJ001|LODZ|WARSZAWA",
            "LCJ002|LODZ|BYDGOSZCZ",
            "LCJ003|LODZ|GDANSK"
    };

    static final String[] POZNAN = {
            "POZ001|POZNAN|WARSZAWA",
            "POZ002|POZNAN|BYDGOSZCZ",
            "POZ003|POZNAN|KRAKOW",
            "POZ004|POZNAN|BERLIN"
    };

}
