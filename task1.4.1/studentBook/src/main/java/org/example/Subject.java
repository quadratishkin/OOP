package org.example;

public class Subject {
    private String name;
    private Integer mark;
    private Integer semesterNumber;
    public void setMark(Integer mark) {

        this.mark = mark;
    }
    public void setSemesterNumber(Integer semesterNumber) {

        this.semesterNumber = semesterNumber;
    }
    public String getName() {

        return name;
    }

    public Integer getMark() {

        return mark;
    }
    public Integer getSemesterNumber() {

        return semesterNumber;
    }
    public Subject(String name, Integer semesterNumber, Integer mark) {
        this.name = name;
        this.semesterNumber = semesterNumber;
        this.mark = mark;
    }

}
