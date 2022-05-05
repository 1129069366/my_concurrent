package com.ynu.concurrent.Unit5.unsafe;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-27 16:41
 **/
public class AccountUnsafe implements Account {

    private Integer balance;

    public AccountUnsafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBanlance() {
        return this.balance;
    }


    @Override
    public void withdraw(Integer amount) {
        balance = balance - amount;
    }
}
