package ru.gb.hw02.animal;

import ru.gb.hw02.interfaces.Runner;
import ru.gb.hw02.interfaces.Sound;

public class Cat extends Animal implements Runner {

    private boolean hasScratchingPost;
    public Cat(String name, int age, boolean hasScratchingPost) {
        super(name, age);
        this.hasScratchingPost = hasScratchingPost;
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says meow-meow", getName());
    }

    @Override
    public void run() {
        System.out.println("Can run");
    }
}
