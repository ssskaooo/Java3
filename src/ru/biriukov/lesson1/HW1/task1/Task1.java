package ru.biriukov.lesson1.HW1.task1;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
//    1.Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
        String [] arr = {"1", "2", "3", "4"};
//        Integer [] arr = {1, 2, 6 ,9, 7};
        System.out.println(Arrays.toString(arr));
        indexChange(arr, 2, 3);
        System.out.println(Arrays.toString(arr));

    }

    public static <T> void indexChange(T[]array, int indexOne, int indexTwo){
        T temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;

    }







}
