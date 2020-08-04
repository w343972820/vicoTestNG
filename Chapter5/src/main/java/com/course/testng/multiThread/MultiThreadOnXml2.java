package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml2 {
    @Test
    public void test1(){
        System.out.println("xm2 -> test1 Thread id: "+ Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.println("xm2 -> test2 Thread id: "+ Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.println("xm2 -> test3 Thread id: "+ Thread.currentThread().getId());
    }
}
