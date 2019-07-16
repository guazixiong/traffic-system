package com.example.demo.dao.domain;

import java.util.Date;

public class MessageDomain {
    private String messagecontent;   //内容
    private String messagename;   //消息接收端
    private Date sendtime;  //发送时间
    private String sendname;  //发送人
    private int ifexist;   //是否已读
    private int idm;    //自动递增

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }



    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public String getMessagename() {
        return messagename;
    }

    public void setMessagename(String messagename) {
        this.messagename = messagename;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public int getIfexist() {
        return ifexist;
    }

    public void setIfexist(int ifexist) {
        this.ifexist = ifexist;
    }


}
