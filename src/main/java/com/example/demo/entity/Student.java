package com.example.demo.entity;

import java.util.Date;

public class Student extends User {
    private int studentId;
    private String major;
    private String classId;
    private String name;
    private int sex;//0 male

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", major='" + major + '\'' +
                ", classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
