package com.example.demo;

import com.example.demo.service.AdminService;
import com.example.demo.service.serviceimpl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    StudentServiceImpl studentService;
    //@Autowired
    AdminService adminService;

    /*
        private String School;
    private String StuId;
    private String StuName;
    private String Tel;
    private String Profession;
    private String Password;
     */



}
