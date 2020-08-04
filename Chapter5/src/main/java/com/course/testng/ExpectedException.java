package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 什么时候会用到异常测试
     * 我们期望结果为某一个异常的时候
     * 比如:我们传入了某些不合法的参数,程序抛出了异常
     * 也就是说我们预期结果就是这个异常
     */
//  这是一个测试强震果会失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一失败的异常测试 ……");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是成功的异常测试");
        throw new RuntimeException();
    }
}
