package com.lee.sell;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20001,254456,32313,6546454,5878,63213,75654,6548,6549,65410);
        IntSummaryStatistics number = list.stream().mapToInt(e -> e).summaryStatistics();
        System.out.println("sum==="+number.getSum());
        System.out.println("min==="+number.getMin());
        System.out.println("max==="+number.getMax());
        System.out.println("count==="+number.getCount());
        System.out.println("average==="+number.getAverage());

    }
}
