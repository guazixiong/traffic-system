package com.example.demo.dao;

import com.example.demo.dao.domain.ActivityDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.MessageDomain;
import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {

    //    查询出当前存在的所有用户信息
    List<StudentDomain> showall();

    //    通过学生id进行查询，用于实现用户登录与注册
    StudentDomain findByStudentId(String id);

    //    实现用户注册存储功能
    void studentsave(@Param("school") String school, @Param("stuId") String stuId,
                     @Param("stuName") String stuName, @Param("tel") String tel,
                     @Param("profession") String profession, @Param("password") String password);

    //显示个人信息
    List<StudentDomain> showuser(@Param("stuId")String stuId);;

    //    修改个人信息
    void studentupdate(StudentDomain studentDomain);

    //    查找文本
    List<InforDomain> findInforByInforSchool(String author);

    //显示所有的文本信息
    List<InforDomain> showinfor();

    //显示发送的信息
    List<MessageDomain> smessage(@Param("message")String message);

    //消息已读
    void trueexist(@Param("ifexist")int ifexist);

    //显示活动信息
    List<ActivityDomain> showactivity();

    List<ActivityDomain> showactivityname();

    //查找活动
    ActivityDomain findactivity(@Param("meetname") String meetname);

    //报名
    void takepart(@Param("meetname")String meetname,@Param("peoplename")String peoplename);
}
