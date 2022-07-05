package com.board.sy.domain;

public class MemberDto {
    private String mid;
    private String pwd;
    private String mname;
    private String email;
    private String birth_yy;
    private String birth_mm;
    private String birth_dd;
    private String mauth;
    private String reg_date;

    public MemberDto(){}

    public MemberDto(String mid, String pwd, String mname, String email, String birth_yy, String birth_mm, String birth_dd, String mauth, String reg_date) {
        this.mid = mid;
        this.pwd = pwd;
        this.mname = mname;
        this.email = email;
        this.birth_yy = birth_yy;
        this.birth_mm = birth_mm;
        this.birth_dd = birth_dd;
        this.mauth = mauth;
        this.reg_date = reg_date;
    }
    public MemberDto(String mid, String pwd, String mname, String email, String birth_yy, String birth_mm, String birth_dd) {
        this.mid = mid;
        this.pwd = pwd;
        this.mname = mname;
        this.email = email;
        this.birth_yy = birth_yy;
        this.birth_mm = birth_mm;
        this.birth_dd = birth_dd;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth_yy() {
        return birth_yy;
    }

    public void setBirth_yy(String birth_yy) {
        this.birth_yy = birth_yy;
    }

    public String getBirth_mm() {
        return birth_mm;
    }

    public void setBirth_mm(String birth_mm) {
        this.birth_mm = birth_mm;
    }

    public String getBirth_dd() {
        return birth_dd;
    }

    public void setBirth_dd(String birth_dd) {
        this.birth_dd = birth_dd;
    }

    public String getMauth() {
        return mauth;
    }

    public void setMauth(String mauth) {
        this.mauth = mauth;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }
}
