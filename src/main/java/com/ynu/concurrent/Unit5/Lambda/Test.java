package com.ynu.concurrent.Unit5.Lambda;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-04-02 16:20
 **/
public class Test {
    public static void main(String[] args) {

        System.out.println(invokeCalc(1, 3, (a, b) -> a + b));
        System.out.println(invokeCalc(1, 3, (a, b) -> a / b));
        System.out.println(invokeCalc(1, 3, (a, b) -> a * b));
        System.out.println(invokeCalc(1, 3, (a, b) -> a - b));
        invokeCalc(1, 2, (int a,int b)-> {return a>b?a:b;});

    }


    public static int invokeCalc(int a,int b,Calculator calculator){
        return calculator.add(a,b);
    }

}


