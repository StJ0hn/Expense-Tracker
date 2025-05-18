package com.tracker.model;

import java.time.LocalDate;

public class Expense {

    private String category;
    private String name;
    private float value;
    private int id;
    private LocalDate date;
    private static int idCounter = 1;

    public Expense(
        String category,
        String name,
        float value,
        int id,
        LocalDate date
    ) {
        this.setCategory(category);
        this.setName(name);
        this.setValue(value);
        this.setDate(date);
        this.id = id;
        updateIdCounter(id);
    }

    public Expense(String category, String name, float value, LocalDate date) {
        this.setCategory(category);
        this.setName(name);
        this.setValue(value);
        this.setDate(date);
        this.id = idCounter++;
    }

    public static void updateIdCounter(int lastUsedId) {
        if (lastUsedId >= idCounter) {
            idCounter = lastUsedId + 1;
        }
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException(
                "Category can't be empty or null."
            );
        }
        this.category = category;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                "Expense's name can't be empty."
            );
        }
        this.name = name;
    }

    public void setValue(float value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value can't be negative.");
        }
        this.value = value;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date can't be empty or null.");
        }
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
            "Expense {id = %d, Name = %s, Category = %s, Amount = R$ %.2f, Date = %s}",
            getId(),
            getName(),
            getCategory(),
            getValue(),
            getDate()
        );
    }
}
