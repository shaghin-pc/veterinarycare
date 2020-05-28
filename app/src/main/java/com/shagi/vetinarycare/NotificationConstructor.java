package com.shagi.vetinarycare;

public class NotificationConstructor {

    String itemname,bankname,branch,ifsc,accountno,annualincome,mainjob,scst,bpl,women,handcap,girl,before;

    public NotificationConstructor() {
    }

    public NotificationConstructor(String itemname, String bankname, String branch, String ifsc, String accountno, String annualincome, String mainjob, String scst, String bpl, String women, String handcap, String girl, String before) {
        this.itemname = itemname;
        this.bankname = bankname;
        this.branch = branch;
        this.ifsc = ifsc;
        this.accountno = accountno;
        this.annualincome = annualincome;
        this.mainjob = mainjob;
        this.scst = scst;
        this.bpl = bpl;
        this.women = women;
        this.handcap = handcap;
        this.girl = girl;
        this.before = before;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getAnnualincome() {
        return annualincome;
    }

    public void setAnnualincome(String annualincome) {
        this.annualincome = annualincome;
    }

    public String getMainjob() {
        return mainjob;
    }

    public void setMainjob(String mainjob) {
        this.mainjob = mainjob;
    }

    public String getScst() {
        return scst;
    }

    public void setScst(String scst) {
        this.scst = scst;
    }

    public String getBpl() {
        return bpl;
    }

    public void setBpl(String bpl) {
        this.bpl = bpl;
    }

    public String getWomen() {
        return women;
    }

    public void setWomen(String women) {
        this.women = women;
    }

    public String getHandcap() {
        return handcap;
    }

    public void setHandcap(String handcap) {
        this.handcap = handcap;
    }

    public String getGirl() {
        return girl;
    }

    public void setGirl(String girl) {
        this.girl = girl;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }
}
