package com.example.demo.service;

import com.example.demo.dao.domain.ActivityDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.MessageDomain;
import com.example.demo.dao.domain.StudentDomain;

import java.util.List;

public interface StudentService {
    List<StudentDomain> showall();

    //显示个人信息
    List<StudentDomain> showuser(String stuId);

    //查询单个用户
    StudentDomain findByStudentId(String id);

    //登录
    StudentDomain login(String stuid,String password);

    //注册
    int studentsave(String School, String StuId, String StuName, String Tel, String Profession, String Password);

    //    修改个人信息
    int studentupdate(String school, String stuid, String stuname, String tel, String profession, String password);

    //    查找文本
    List<InforDomain> findInforByInforSchool(String author);

    //显示文本信息
    List<InforDomain> showinfor();

    //消息接收
    List<MessageDomain> smessage(String stuId);

    //消息已读
    int trueexist();

    //显示所有活动
    List<ActivityDomain> showactivity();

    //报名
    int takepart(String meetname,String stuId);

    //显示已报名活动
    List<ActivityDomain> takedpart(String stuId);
}

