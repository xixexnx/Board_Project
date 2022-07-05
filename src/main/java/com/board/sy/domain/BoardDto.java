package com.board.sy.domain;

import java.util.Date;

public class BoardDto {
    private String bno;
    private String title;
    private Date reg_date;

    public BoardDto() {}

    public BoardDto(String bno, String title) {
        this.bno = bno;
        this.title = title;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
}
