package com.example.myapplication.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口
 * predicate 接受一个输入参数，返回一个布尔值结果。
 */

public class Functional {

    public static void test(String args[]){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


        System.out.println("输出所有数据:");
        eval(list, n->true);


        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );


        System.out.println("输出大于 3 的所有数字:");
        eval(list, n-> n > 3 );
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
