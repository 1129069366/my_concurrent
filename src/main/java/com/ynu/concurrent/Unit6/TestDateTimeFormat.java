package com.ynu.concurrent.Unit6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-04-19 22:06
 **/
@Slf4j(topic = "c.TestSimpleDateFormat")
public class TestDateTimeFormat {

    public static void main(String[] args) throws ParseException {

        DateTimeFormatter stf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                TemporalAccessor parse = stf.parse("2022-04-20");
                System.out.println(parse);
            }).start();

        }

    }
}
