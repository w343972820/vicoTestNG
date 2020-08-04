package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("SuiteConfig->beforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("SuiteConfig->afterSuite测试套件");
    }
    @BeforeTest
    public void beforTest(){
        System.out.println("SuiteConfig->beforTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("SuiteConfig->afterTest");
    }


}
