package com.shagi.vetinarycare;

public class PetConstructor {

    String Type,Age,Color,Sex,IdentifyMark,mail;

    public PetConstructor(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public PetConstructor() {
    }

    public PetConstructor(String type, String age, String color, String sex, String identifyMark) {
        Type = type;
        Age = age;
        Color = color;
        Sex = sex;
        IdentifyMark = identifyMark;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getIdentifyMark() {
        return IdentifyMark;
    }

    public void setIdentifyMark(String identifyMark) {
        IdentifyMark = identifyMark;
    }
}
