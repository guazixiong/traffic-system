package com.example.demo.service.serviceimpl;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.domain.*;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    ReturnDomain returnDomain = new ReturnDomain();
    @Autowired
    AdminDao adminDao;
    @Autowired
    AdminService adminService;

    //删除学校下的某一用户
    @Override
    public int deletstudent(String stuName, String School) {
        if (stuName == null || School == null)
            return returnDomain.getR0();
        else {
            StudentDomain studentDomain = new StudentDomain();
            studentDomain = adminService.findByAdminId2(stuName, School);
            if (studentDomain == null)
                return returnDomain.getR2();
            else {
                adminDao.deletstudent(stuName, School);
                return returnDomain.getR1();
            }
        }

    }

    @Override
    public List<AdminDomain> showadmin(String Schoolid) {
        return adminDao.showadmin(Schoolid);
    }

    //修改个人数据
    @Override
    public int alteradmin(String tel, String adminname, String schoolid, String password1, String password2) {
        if (adminname == null || tel == null || schoolid == null ||
                password1 == null || password2 == null || password1.equals(password2))
            return returnDomain.getR0();
        else {
            AdminDomain adminDomain = new AdminDomain();
            adminDomain = adminDao.findByAdminId(schoolid);
            if (adminDomain == null)
                return returnDomain.getR2();
            else {
                adminDomain.setTel(tel);
                adminDomain.setAdminname(adminname);
                adminDomain.setPassword(password2);
                adminDao.alteradmin(adminDomain);
                return returnDomain.getR1();
            }
        }
    }

    //查找学校下的所有用户
    @Override
    public List<StudentDomain> findstudent(String school) {
        return adminDao.findstudent(school);
    }

    @Override
    public int deleteinfor(String title) {
        InforDomain inforDomain = adminDao.findByInforTitle(title);
        if (inforDomain == null) {
            return returnDomain.getR1();
        } else {
            adminDao.deleteinfor(title);
            return returnDomain.getR1();
        }
    }

    //发布信息
    @Override
    public int uploadinfo(String title, String conent, Date inforTime, String author) {
        if (title != null & conent != null & inforTime != null && author != null) {
            InforDomain inforDomain = adminDao.findByInforTitle(title);
            if (inforDomain == null) {              //未找到
                adminDao.uploadinfo(title, conent, inforTime, author);
                return returnDomain.getR1();
            } else     //对象存在
                return returnDomain.getR2();
        } else   //输入格式问题
            return returnDomain.getR0();
    }

    @Override
    public List<InforDomain> findInforByInforSchool(String author) {
        return adminDao.findInforByInforSchool(author);
    }

    //登录
    @Override
    public AdminDomain login(String stuId, String password) {
        AdminDomain adminDomain;
        adminDomain = adminService.findByAdminId(stuId);
        return adminDomain;
    }

    @Override
    public AdminDomain findByAdminId(String schoolid) {
        return adminDao.findByAdminId(schoolid);
    }

    @Override
    public StudentDomain findByAdminId2(String stuname, String school) {
        return adminDao.findByAdminId2(stuname, school);
    }

    //修改文件信息
    @Override
    public int updateinfor(String title, String conent, Date infortime) {
        if (title == null || infortime == null || conent == null)    //对象为空
            return returnDomain.getR0();
        else {
            InforDomain inforDomain = adminDao.findByInforTitle(title);
            if (inforDomain == null)   //找不到对象
                return returnDomain.getR2();
            else {  //找到并更改
                inforDomain.setConent(conent);
                inforDomain.setInforTime(infortime);
                adminDao.updateInfor(inforDomain);
                return returnDomain.getR1();
            }
        }
    }

    @Override
    public List<StudentDomain> onlyfind(String stuname) {
        return adminDao.onlyfind(stuname);
    }

    @Override
    public int sendmessage(String messagename, Date sendtime, String sendname, String messagecontent) {
        if (messagename == null || sendtime == null || sendname == null || messagecontent == null)
            return returnDomain.getR0();
        else {
            adminDao.sendmessage(messagename,sendtime,sendname,messagecontent);
            return returnDomain.getR1();
        }
    }

    @Override
    public int uploadactivity(String activitytype, Date activitytime, String acticityspace, int meetnumber, String meetname, String connent) {
        if (activitytype == null || activitytime == null || acticityspace == null || meetnumber == 0
                || meetname == null || connent == null)
            return returnDomain.getR0();
        else {
            ActivityDomain activityDomain = adminDao.findactivity(meetname);
            if (activityDomain != null)
                return returnDomain.getR2();
            else {
                adminDao.uploadactivity(activitytype, activitytime, acticityspace, meetnumber,meetname, connent);
                return returnDomain.getR1();
            }
        }
    }

    @Override
    public int updateactivity(String activitytype, Date activitytime, String acticityspace, int meetnumber, String meetname, String connent, String peoplename) {
        if (activitytype == null || activitytime == null || acticityspace == null || meetnumber == 0
                || meetname == null || connent == null||peoplename==null)
            return returnDomain.getR0();
        else {
            ActivityDomain activityDomain = adminDao.findactivity(meetname);
            if (activityDomain == null)
                return returnDomain.getR2();
            else {
                int p=activityDomain.getId();
                adminDao.updateactivity(p,activitytype, activitytime, acticityspace, meetnumber,meetname,connent,peoplename);
                return returnDomain.getR1();
            }
        }
    }
}
