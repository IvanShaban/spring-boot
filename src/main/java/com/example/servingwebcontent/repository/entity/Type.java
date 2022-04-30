package com.example.servingwebcontent.repository.entity;

public enum Type {
    PHONE("Телефон"),
    LAPTOP("Ноутбук"),
    MONITOR("Монитор");

    private final String translation;

    Type(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
