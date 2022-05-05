package com.ynu.concurrent.Unit5.AtomicReference;

import java.math.BigDecimal;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 10:19
 **/
public class TestDecimalAccount {
    public static void main(String[] args) {
        DecimalAccount.demo(new DecimalAccountUnsafe(new BigDecimal("10000")));
        DecimalAccount.demo(new DecimalAccountSafe1(new BigDecimal("10000")));
        DecimalAccount.demo(new DecimalAccountSafeCas(new BigDecimal("10000")));

    }
}
