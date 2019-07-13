package com.example.demo.dao.domain;

public class AdminDomain{
    private String SchoolName;     //学校名称
    private String Tel;         //负责人电话
    private String adminname;   //负责人
    private String Schoolid;   //登录id
    private String Password;   //密码

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getSchoolid() {
        return Schoolid;
    }

    public void setSchoolid(String schoolid) {
        Schoolid = schoolid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
