package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsClass1 {
    public void stu1(){
        System.out.println("GroupsClass1中的stu1111运行");
    }
    public void stu2(){
        System.out.println("GroupsClass1中的stu2222运行");
    }
}
