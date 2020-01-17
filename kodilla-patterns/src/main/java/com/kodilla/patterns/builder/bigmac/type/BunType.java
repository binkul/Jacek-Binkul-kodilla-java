package com.kodilla.patterns.builder.bigmac.type;

public enum BunType {
    SESAME_BUN("Bun with sesame"),
    NORMAL_BUN("Standard bun");

    private final String name;

    BunType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}