package com.example.myapplication.Java8;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.Map;


/**
 * Stream API
 *

 forEach
 Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。


 map
 map 方法用于映射每个元素到对应的结果。


 filter
 filter 方法用于通过设置的条件过滤出元素。


 limit
 limit 方法用于获取指定数量的流。


 sorted
 sorted 方法用于对流进行排序。


 并行（parallel）程序
 parallelStream 是流并行处理程序的代替方法。


 Collectors
 Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
 */

public class Stream {

    public static void test(String args[]) {
        System.out.println("使用 Java 7: ");

        // 计算空字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);

        long count;

        // 删除空字符串
        List<String> filtered;

        // 删除空字符串，并使用逗号把它们合并起来
        String mergedString;

        // 获取列表元素平方数
        List<Integer> squaresList;


        System.out.println("使用 Java 8: ");
        System.out.println("列表: " + strings);

        count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);

        filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

        squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
        System.out.println("列表: " + integers);

        // 输出10个随机数
        Random random = new Random();

        random.ints().limit(10).sorted().forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        });

        random.ints().limit(10).sorted().forEach(s -> System.out.print(s));

        random.ints().limit(10).sorted().forEach(System.out::print);


        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("随机数: ");


        BiPredicate<String, String> biPre=String::equals;

    }

}
