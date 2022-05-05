package com.ynu.concurrent.Unit4;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-19 12:26
 **/
public class Test {

    public static void main(String[] args) {


    }

    public static void sleep(Integer i){
        while (true){
            if(i>0){
                System.out.print(i);
                inc(i);
                sleep(i);
            }
            break;
        }
    }

    public static void inc(int i){
        i--;
    }

}
