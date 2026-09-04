package ru.otus.animals.birds;

import ru.otus.animals.Animal;

public class Duck extends Animal implements Flying {

    @Override
    public void fly() {
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }
}
