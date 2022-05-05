package com.ynu.concurrent.Unit5.AtomicReference;

import java.math.BigDecimal;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 10:15
 **/
public class DecimalAccountSafe1 implements DecimalAccount {


    private BigDecimal balance;

    public DecimalAccountSafe1(BigDecimal bigDecimal) {
        this.balance = bigDecimal;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public synchronized void withdraw(BigDecimal amount) {
        this.balance = balance.subtract(amount);
    }
}
