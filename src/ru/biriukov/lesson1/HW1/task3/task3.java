package ru.biriukov.lesson1.HW1.task3;

public class task3 {

    //    Большая задача:
//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)

//b. Класс Box в который можно складывать фрукты, коробки условно сортируются
// по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

//c. Для хранения фруктов внутри коробки можете использовать ArrayList;

//d. Сделать метод getWeight() который высчитывает вес коробки, зная количество
// фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);

//e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
// которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
// (коробки с яблоками мы можем сравнивать с коробками с апельсинами);

//f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
// (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно
// в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;

//g. Не забываем про метод добавления фрукта в коробку.
public static void main(String[] args) {

    Box<Apple> appleBox = new Box<>();
    Box<Apple> appleBox2 = new Box<>();

    Box<Orange> orangeBox = new Box<>();

    System.out.println("AppleBox weight " + appleBox.getWeight());
    appleBox.add(new Apple());
    System.out.println("AppleBox weight " + appleBox.getWeight());
    System.out.println("AppleBox2 weight " + appleBox2.getWeight());

    appleBox.moveAllTo(appleBox2);
    System.out.println("AppleBox weight " + appleBox.getWeight());
    System.out.println("AppleBox2 weight " + appleBox2.getWeight());

    System.out.println("Compare oranges and apples : " + appleBox.compareTo(orangeBox));
    System.out.println("Compare oranges and apples2 : " + appleBox2.compareTo(orangeBox));

    Box<Fruit> testBox = new Box<>();
    testBox.add(new Fruit() {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public double getWeight() {
            return 5.0;
        }
    });
    appleBox.compareTo(testBox);
    }

}
