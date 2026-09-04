package ru.otus.animals;

import java.awt.*;

public abstract class Animal {

    private String name;
    private int age;
    private double weight;
    private Color color;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут %s, мне %d %s, я вешу - %.2f кг, мой цвет - %s"
                .formatted(name, age, getPluralAge(), weight, getColorValue());
    }

    private String getColorValue() {
        if (color == null) {
            return "неизвестный";
        }
        return color.getValue();
    }

    private String getPluralAge() {
        int remainder10 = age % 10;
        int remainder100 = age % 100;
        if (remainder10 == 1 && remainder100 != 11) {
            return "год";
        }
        if (remainder10 >= 2 && remainder10 <= 4 && remainder100 != 12 && remainder100 != 13 && remainder100 != 14) {
            return "года";
        }
        return "лет";
    }
    }
