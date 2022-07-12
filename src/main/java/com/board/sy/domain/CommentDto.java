package com.board.sy.domain;

import java.util.Date;

public class CommentDto {
    private String cno;
    private String pno;
    private String pcno;
    private String comment;
    private String commenter;
    private Date reg_date;
    private String up_date;

    public CommentDto(){}
    public CommentDto(String pno, String pcno, String comment, String commenter){
//        this.cno = cno;
        this.pno = pno;
        this.pcno = pcno;
        this.comment = comment;
        this.commenter = commenter;
    }
    public CommentDto(String cno, String pno, String pcno, String comment, String commenter) {
        this.cno = cno;
        this.pno = pno;
        this.pcno = pcno;
        this.comment = comment;
        this.commenter = commenter;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPcno() {
        return pcno;
    }

    public void setPcno(String pcno) {
        this.pcno = pcno;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date;
    }

}
