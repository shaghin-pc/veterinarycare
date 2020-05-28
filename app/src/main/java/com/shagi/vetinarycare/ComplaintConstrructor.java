package com.shagi.vetinarycare;

public class ComplaintConstrructor {
    String Complaint,Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String complaint) {
        Complaint = complaint;
    }

    public ComplaintConstrructor() {
    }

    public ComplaintConstrructor(String complaint) {
        Complaint = complaint;
    }
}
