package com.ynu.concurrent.Unit5.unsafe;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-27 16:43
 **/
public class TestUnsafe {
    public static void main(String[] args) {

        Account.demo(new AccountUnsafe(10000));

    }
}
