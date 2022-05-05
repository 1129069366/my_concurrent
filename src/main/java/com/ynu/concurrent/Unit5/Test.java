package com.ynu.concurrent.Unit5;

import java.util.Arrays;
import java.util.List;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-27 16:13
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","c","python","c++","VB","C#");
        list.forEach(s -> System.out.println(s));

    }
}
