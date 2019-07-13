package com.example.demo.service;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;

import java.util.Date;
import java.util.List;

public interface AdminService {
    /*
    对旗下用户的删改查,发布信息,查找信息,修改个人发布信息
     */
    //删除学校下的某一用户
    int deletstudent(String stuName, String School);

    //显示个人信息
    List<AdminDomain> showadmin(String Schoolid);

    //修改个人数据(根据学校查询并更改信息)
    int alteradmin(String tel, String adminname, String schoolid, String password1, String password2);

    //查找学校下的所有用户
    List<StudentDomain> findstudent(String school);

    //删除已发布的文件
    int deleteinfor(String title);

    //发布信息
    int uploadinfo(String title, String conent, Date inforTime, String author);

    //查找学校所有发布的文件
    List<InforDomain> findInforByInforSchool(String author);

    //实现登录和返回登录信息
    AdminDomain login(String stuId, String password);

    //查找单个用户利用id进行登录
    AdminDomain findByAdminId(String schoolid);

    //查找单个用户通过姓名和学校进行删除
    StudentDomain findByAdminId2(String stuname, String school);

    //修改学校发布信息
    int updateinfor(String title, String conent, Date infortime);

    //查找单个学生用户
    List<StudentDomain> onlyfind(String stuname);

    //发送消息
    int sendmessage(String messagename, Date sendtime,String sendname, String messagecontent);

    //创建活动
    int uploadactivity(String activitytype,Date activitytime,String acticityspace,
                       int meetnumber,String meetname,String connent);

    //更新活动
    int updateactivity(String activitytype,Date activitytime,String acticityspace,
                       int meetnumber,String meetname,String connent,String peoplename);
}
