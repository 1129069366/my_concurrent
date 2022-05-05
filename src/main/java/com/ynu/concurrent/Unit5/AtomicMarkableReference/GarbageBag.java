package com.ynu.concurrent.Unit5.AtomicMarkableReference;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 12:52
 **/
public class GarbageBag {

    String desc;


    public GarbageBag(String desc) {
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public String toString() {
        return super.toString() + " " + desc;
    }
}
