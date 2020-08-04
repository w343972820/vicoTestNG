package com.course.testng.multiThread;

import org.testng.annotations.Test;

//注解式多线程
public class MultiThreadOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.println("Thread id: "+ Thread.currentThread().getId());
    }
}
