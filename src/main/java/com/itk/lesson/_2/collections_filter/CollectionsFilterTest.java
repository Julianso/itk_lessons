package com.itk.lesson._2.collections_filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsFilterTest {

    public static void main(String[] args) {
        new CollectionsFilterTest().run();
    }

    public void run() {

        List<Integer> list = Arrays.asList(0, 1, 2);

        System.out.println(list);

        System.out.println(filter(list, new FilterIncrement()));

    }

    List<Integer> filter(List<Integer> srcList, Filter<Integer> filter) {

        List<Integer> filteredList = new ArrayList<>();

        for(Integer v : srcList) {
            filteredList.add(filter.apply(v));
        }

        return filteredList;

    }

}
