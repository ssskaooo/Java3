package ru.biriukov.lesson5.stage;

import ru.biriukov.lesson5.Car;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
