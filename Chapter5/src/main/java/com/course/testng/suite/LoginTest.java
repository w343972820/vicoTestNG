package com.course.testng.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void loginTaobao(){
        System.out.println("淘宝登录成功....");
    }
    @BeforeMethod
    public void beforeTestMothod(){
        System.out.println("SuiteConfig->BeforeMethod");
    }
    @AfterMethod
    public void afterTestMothod(){
        System.out.println("SuiteConfig->BeforeMethod");
    }


}
