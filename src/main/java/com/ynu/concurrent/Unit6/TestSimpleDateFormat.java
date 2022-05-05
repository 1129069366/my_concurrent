package com.ynu.concurrent.Unit6;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-04-19 22:06
 **/
@Slf4j(topic = "c.TestSimpleDateFormat")
public class TestSimpleDateFormat {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Object lock = new Object();


        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                synchronized (lock) {
                    try {
                        System.out.println(sdf.parse("1998-9-15"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }




    }
}
