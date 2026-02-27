package com.itk.lesson._2.collections_filter;

public class FilterIncrement implements Filter<Integer> {

    @Override
    public Integer apply(Integer o) {
        return o + 1;
    }

}
