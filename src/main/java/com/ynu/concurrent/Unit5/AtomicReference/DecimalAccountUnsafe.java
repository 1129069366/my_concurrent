package com.ynu.concurrent.Unit5.AtomicReference;

import java.math.BigDecimal;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 10:15
 **/
public class DecimalAccountUnsafe implements DecimalAccount {


    private BigDecimal balance;

    public DecimalAccountUnsafe(BigDecimal bigDecimal) {
        this.balance = bigDecimal;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        this.balance = balance.subtract(amount);
    }
}
