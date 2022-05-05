package com.ynu.concurrent.Unit5.AtomicReference;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 10:30
 **/
public class DecimalAccountSafeCas implements DecimalAccount {

    private AtomicReference<BigDecimal> balance;

    public DecimalAccountSafeCas(BigDecimal balance) {
        this.balance = new AtomicReference<>(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true){
            BigDecimal prev = balance.get();
            BigDecimal next = prev.subtract(amount);
            if (balance.compareAndSet(prev,next)){
                break;
            }
        }
    }
}
