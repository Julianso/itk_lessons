package com.itk.lesson._7.streams_numbers_generation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberGenerationTest {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        Map<String, List<Order>> groupedProducts = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));

        System.out.println("\ngrouped orders\n");
        groupedProducts.forEach((product, orderList) ->
                System.out.println(product + ": " + orderList));


        Map<String, Double> totalPrice = groupedProducts.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .mapToDouble(Order::getCost)
                                .sum()
                ));

        System.out.println("\ntotal price by products\n");
        totalPrice.forEach((product, total) -> System.out.println(product + " - " + total));


        List<Map.Entry<String, Double>> sorted = totalPrice.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()).toList();

        System.out.println("\nsorted by total price\n");
        sorted.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));


        List<Map.Entry<String, Double>> topThreeByPrice = sorted.stream()
                .limit(3).toList();
        System.out.println("\ntop 3 products by price\n");
        topThreeByPrice.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}

