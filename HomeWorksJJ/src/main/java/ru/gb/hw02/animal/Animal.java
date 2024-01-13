package ru.gb.hw02.animal;

import ru.gb.hw02.interfaces.Sound;

public abstract class Animal implements Sound {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
