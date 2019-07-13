package com.example.demo.dao.domain;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnDomain {
    private int r0=0;    //失败
    private int r1=1;    //通过
    private int r2=-1;    //已存在


    public int getR0() {
        return r0;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public void setR0(int r0) {
        this.r0 = r0;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }


}
