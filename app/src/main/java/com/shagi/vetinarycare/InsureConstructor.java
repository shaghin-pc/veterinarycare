package com.shagi.vetinarycare;

public class InsureConstructor {

    String EarTag_no,Species,PetSex,Color,Identification_Mark,Milk_Per_Day,Age,Height,No_of_Calves,Last_Calving_Date,Pregnency;

    public InsureConstructor() {
    }

    public InsureConstructor(String earTag_no, String species, String petSex, String color, String identification_Mark, String milk_Per_Day, String age, String height, String no_of_Calves, String last_Calving_Date, String pregnency) {
        EarTag_no = earTag_no;
        Species = species;
        PetSex = petSex;
        Color = color;
        Identification_Mark = identification_Mark;
        Milk_Per_Day = milk_Per_Day;
        Age = age;
        Height = height;
        No_of_Calves = no_of_Calves;
        Last_Calving_Date = last_Calving_Date;
        Pregnency = pregnency;
    }

    public String getEarTag_no() {
        return EarTag_no;
    }

    public void setEarTag_no(String earTag_no) {
        EarTag_no = earTag_no;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getPetSex() {
        return PetSex;
    }

    public void setPetSex(String petSex) {
        PetSex = petSex;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getIdentification_Mark() {
        return Identification_Mark;
    }

    public void setIdentification_Mark(String identification_Mark) {
        Identification_Mark = identification_Mark;
    }

    public String getMilk_Per_Day() {
        return Milk_Per_Day;
    }

    public void setMilk_Per_Day(String milk_Per_Day) {
        Milk_Per_Day = milk_Per_Day;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getNo_of_Calves() {
        return No_of_Calves;
    }

    public void setNo_of_Calves(String no_of_Calves) {
        No_of_Calves = no_of_Calves;
    }

    public String getLast_Calving_Date() {
        return Last_Calving_Date;
    }

    public void setLast_Calving_Date(String last_Calving_Date) {
        Last_Calving_Date = last_Calving_Date;
    }

    public String getPregnency() {
        return Pregnency;
    }

    public void setPregnency(String pregnency) {
        Pregnency = pregnency;
    }
}
