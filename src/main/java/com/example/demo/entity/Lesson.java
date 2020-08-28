package com.example.demo.entity;

public class Lesson {
    private int lessonId;
    private String name;
    private int teacherId;
    private String credit;

    public Lesson(int lessonId, String name, int teacherId, String credit) {
        this.lessonId = lessonId;
        this.name = name;
        this.teacherId = teacherId;
        this.credit = credit;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", name='" + name + '\'' +
                ", teacherId=" + teacherId +
                ", credit='" + credit + '\'' +
                '}';
    }
}
