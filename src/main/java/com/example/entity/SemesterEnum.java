package com.example.entity;

public enum SemesterEnum {

    SEMESTER_1("Kỳ 1"),
    SEMESTER_2("Kỳ 2");

    private String name;

    SemesterEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
