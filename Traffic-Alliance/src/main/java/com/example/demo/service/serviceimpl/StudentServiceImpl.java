package com.example.demo.service.serviceimpl;

import com.example.demo.dao.StudentDao;
import com.example.demo.dao.domain.*;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    ReturnDomain returnDomain = new ReturnDomain();

    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentService studentService;

    public List<StudentDomain> showall() {
        return studentDao.showall();
    }

    @Override
    public List<StudentDomain> showuser(String stuId) {
        return studentDao.showuser(stuId);
    }

    @Override
    public StudentDomain findByStudentId(String studentid) {
        return studentDao.findByStudentId(studentid);
    }

    @Override
    public StudentDomain login(String stuid, String password) {
        StudentDomain student = new StudentDomain();
        student = studentService.findByStudentId(stuid);
        return student;
    }

    //注册
    @Override
    public int studentsave(String school, String stuId, String stuName, String tel, String profession, String password) {
        StudentDomain studentDomain1;
        studentDomain1 = studentService.findByStudentId(stuId);
        if (stuId != null & stuName != null & tel != null & profession != null & password != null) {
            if (studentDomain1 == null) {
                studentDao.studentsave(school, stuId, stuName, tel, profession, password);
                return returnDomain.getR1();
            } else
                return returnDomain.getR2();
        } else
            return returnDomain.getR0();
    }

    @Override
    public int studentupdate(String School, String StuId, String StuName, String Tel, String Profession, String Password) {
        if (School == null || StuId == null || StuName == null ||
                Tel == null || Profession == null)
            return returnDomain.getR0();
        else {
            StudentDomain studentDomain1;
            studentDomain1 = studentService.findByStudentId(StuId);
            studentDomain1.setSchool(School);
            studentDomain1.setProfession(Profession);
            studentDomain1.setStuName(StuName);
            studentDomain1.setPassword(Password);
            studentDomain1.setTel(Tel);
            studentDao.studentupdate(studentDomain1);
            return returnDomain.getR1();
        }
    }

    @Override
    public List<InforDomain> findInforByInforSchool(String author) {
        return studentDao.findInforByInforSchool(author);
    }

    @Override
    public List<InforDomain> showinfor() {
        return studentDao.showinfor();
    }

    @Override
    public List<MessageDomain> smessage(String stuId) {
        StudentDomain studentDomain = studentDao.findByStudentId(stuId);
        String message = studentDomain.getStuName();
        return studentDao.smessage(message);
    }

    @Override
    public int trueexist() {
        int a = 1;
        studentDao.trueexist(a);
        return returnDomain.getR1();
    }

    @Override
    public List<ActivityDomain> showactivity() {
        return studentDao.showactivity();
    }

    @Override
    public int takepart(String meetname, String stuId) {
        if (meetname == null)
            return returnDomain.getR0();
        else {
            StudentDomain studentDomain = studentDao.findByStudentId(stuId);
            String name1 = studentDomain.getStuName();
            ActivityDomain activityDomain = studentDao.findactivity(meetname);
            String name2 = activityDomain.getPeoplename();
            String name3 = ",";
            String name = name1 + name3 + name2 + name3;
            studentDao.takepart(meetname, name);
            return returnDomain.getR1();
        }
    }

    @Override
    public List<ActivityDomain> takedpart(String stuId) {
        StudentDomain studentDomain = findByStudentId(stuId);
        String name = studentDomain.getStuName();            //用户姓名
        //System.out.println(name);
        List<ActivityDomain> list = studentDao.showactivityname();   //拿到所有活动数据
        //System.out.println(list.get(0).toString());
        List<ActivityDomain> list1=new ArrayList<ActivityDomain>();
        for (ActivityDomain activityDomain :list) {
//            ActivityDomain activityDomain=list.get(i);
            //System.out.println(activityDomain.getMeetname());
            String[] p1 = activityDomain.getPeoplename().split(",");   //字符串分离,找到所有的参与者
            for (int j = 0; j < p1.length; j++) {
                //System.out.println(p1[j]);
                String name3=p1[j];
                if (name.equals(name3)) {
                    list1.add(activityDomain);
                    break;
                }
            }
        }
        //System.out.println(list1.get(0).toString());
        //System.out.println(list1.size());
/*        String[] p2 = new String[50];
        int x = 0;
        Object[] objects1 = list.toArray();
        for (int i = 0; i < objects1.length; i++) {
            ActivityDomain activityDomain = (ActivityDomain) objects1[i];
            String name1 = activityDomain.getMeetname();
            String name2 = activityDomain.getPeoplename();       //获取单个对象的值
            String[] p1 = name2.split(",");   //字符串分离,找到所有的参与者
            //System.out.println(p1);
            //匹配参与者,找到参加的活动
            for (int j = 0; j < p1.length; j++) {
                String name3=p1[j];
                if (name.equals(name3)) {
                    p2[x]=name1;
                    x++;
                    break;
                }
            }
        }*/
/*        for (int a = 1; a<= list1.size(); a++)
            System.out.println(list1.get(a));
        //将对象放入List集合输出
        List<ActivityDomain> list2 = new ArrayList<ActivityDomain>();
        for (int k = 1; k <=list1.size(); k++) {
            ActivityDomain activityDomain2 = studentDao.findactivity(list1.get(k));
            list2.add(activityDomain2);
        }*/
        return list1;
    }
}
