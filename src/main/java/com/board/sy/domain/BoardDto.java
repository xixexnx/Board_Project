package com.board.sy.domain;

public class BoardDto {
    private String bno;
    private String title;
    private String reg_date;

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

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }
}
