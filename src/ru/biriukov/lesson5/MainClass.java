package ru.biriukov.lesson5;

import ru.biriukov.lesson5.stage.Road;
import ru.biriukov.lesson5.stage.Tunnel;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {

    public static final int CARS_COUNT = 4;
    private static ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
    public static final AtomicInteger finishCount = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1,
                ()-> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdl, finishCount);
        }

        for (int i = 0; i < cars.length; i++) {
            executorService.execute(cars[i]);
        }

        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            ex.printStackTrace();
        }

        try {
            cdl.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            executorService.shutdown();
        }
    }

}
