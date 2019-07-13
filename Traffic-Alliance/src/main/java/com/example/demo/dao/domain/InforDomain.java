package com.example.demo.dao.domain;


import java.util.Date;

public class InforDomain {
    private String Title;            //标题
    private Date InforTime;          //时间
    private String Conent;              //内容
    private String Author;           //作者

    public String getConent() {
        return Conent;
    }

    public void setConent(String conent) {
        Conent = conent;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getInforTime() {
        return InforTime;
    }

    public void setInforTime(Date inforTime) {
        InforTime = inforTime;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }


}
