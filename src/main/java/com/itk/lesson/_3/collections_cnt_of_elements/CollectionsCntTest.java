package com.itk.lesson._3.collections_cnt_of_elements;

import java.util.*;

public class CollectionsCntTest {

    public static void main(String[] args) {
        new CollectionsCntTest().run();
    }

    public void run() {

        int[] arr = {1, 2, 2, 2, 3, 4, 5, 6, 6};

        System.out.println(getCountOfValues(arr));

    }

    Map<Integer, Integer> getCountOfValues(int[] srcArr) {

        Map<Integer, Integer> result = new HashMap<>();

        if(srcArr == null) {
            return result;
        }


        for(int i : srcArr) {

            int occurs = 0;

            for(int j : srcArr) {
                if(i == j) {
                    occurs++;
                }
            }

            result.put(i, occurs);
        }

        return result;

    }

}
