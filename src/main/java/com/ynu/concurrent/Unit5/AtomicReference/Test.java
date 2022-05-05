package com.ynu.concurrent.Unit5.AtomicReference;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-28 16:16
 **/
public class Test {

    public static void main(String[] args) {

        User user1  = new User("杨炳辉",23);
        User user2  = new User("路梦娟",24);
        User user3  = new User("李思璋",24);


        AtomicReference<User> reference = new AtomicReference<>();
        reference.set(user1);
        System.out.println(reference.get());   // 输出user1

        reference.compareAndSet(user1,user2);
        System.out.println(reference.get());   // 输出user2

        reference.compareAndSet(user1,user3);
        System.out.println(reference.get());   // 不会输出user3,而是user2


    }
}
