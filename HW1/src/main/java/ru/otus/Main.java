package ru.otus;

import com.google.common.collect.Lists;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 4};
        List<Integer> list = Lists.asList(1, arr);
        System.out.println(list);
    }
}
