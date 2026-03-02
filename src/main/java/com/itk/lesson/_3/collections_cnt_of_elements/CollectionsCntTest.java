package com.itk.lesson._3.collections_cnt_of_elements;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsCntTest {

    public static void main(String[] args) {
        new CollectionsCntTest().run();
    }

    public void run() {

        int[] arr = {1, 2, 2, 2, 3, 4, 5, 6, 6};

        System.out.println(getCountOfValues(arr));

    }

    Map<Integer, Long> getCountOfValues(int[] srcArr) {
        return Arrays.stream(srcArr).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

}
