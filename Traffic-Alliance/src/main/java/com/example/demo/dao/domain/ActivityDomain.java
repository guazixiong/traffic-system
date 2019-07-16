package com.example.demo.dao.domain;

import java.util.Date;

public class ActivityDomain {
    private int id;  //序号       数据库创建自动递增
    private String activitytype; //活动类别
    private Date activitytime; //活动时间
    private String acticityspace; //活动地点
    private int meetnumber; //活动人数
    private String meetname; //活动名称
    private String connent; //活动内容
    private String peoplename="空";  //参与者

    public String getPeoplename() {
        return peoplename;
    }

    public void setPeoplename(String peoplename) {
        this.peoplename = peoplename;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetname() {
        return meetname;
    }

    public void setMeetname(String meetname) {
        this.meetname = meetname;
    }

    public int getMeetnumber() {
        return meetnumber;
    }

    public void setMeetnumber(int meetnumber) {
        this.meetnumber = meetnumber;
    }

    public String getConnent() {
        return connent;
    }

    public void setConnent(String connent) {
        this.connent = connent;
    }

    public String getActicityspace() {
        return acticityspace;
    }

    public void setActicityspace(String acticityspace) {
        this.acticityspace = acticityspace;
    }

    public Date getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(Date activitytime) {
        this.activitytime = activitytime;
    }

    public String getActivitytype() {
        return activitytype;
    }

    public void setActivitytype(String activitytype) {
        this.activitytype = activitytype;
    }

    @Override
    public String toString() {
        return "ActivityDomain{" +
                "id=" + id +
                ", activitytype='" + activitytype + '\'' +
                ", activitytime=" + activitytime +
                ", acticityspace='" + acticityspace + '\'' +
                ", meetnumber=" + meetnumber +
                ", meetname='" + meetname + '\'' +
                ", connent='" + connent + '\'' +
                ", peoplename='" + peoplename + '\'' +
                '}';
    }
}
