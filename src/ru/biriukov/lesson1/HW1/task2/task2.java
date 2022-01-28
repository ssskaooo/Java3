package ru.biriukov.lesson1.HW1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task2 {

//    Написать метод, который преобразует массив в ArrayList;
    public static void main(String[] args) {
        String [] arr = {"v","i","t","a","l","i","k"};
        List<String> arrList = transformation(arr);
        System.out.println(arrList.getClass().getSimpleName() + " " + arrList);
    }

    public static <T> List<T> transformation (T[]array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
