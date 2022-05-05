package com.ynu.concurrent.Unit5.safe2;

import com.ynu.concurrent.Unit5.unsafe.AccountUnsafe;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-27 16:43
 **/
public class TestSafe {
    public static void main(String[] args) {
        Account.demo(new AccountSafe(10000));
    }
}
