package org.example;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StudentBook {
    public Set<Subject> subjects;
    private Integer diplomWork;
    private boolean isHighSalary;
    public StudentBook() {
        this.subjects = new HashSet<Subject>();
        this.diplomWork = 0;
    }
    public void setDiplomWork(Integer diplomWork) {
        if (diplomWork < 3 || diplomWork > 5) {
            throw new IllegalArgumentException();
        }
        this.diplomWork = diplomWork;
    }
    public void addSubject(String name, Integer semesterNumber, Integer mark){
        Subject newSubject = new Subject(name, semesterNumber, mark);
        this.subjects.add(newSubject);
    }
    public void getSubjects() {
        for (Subject item : this.subjects)
        {
            System.out.println(" Дисциплина: " + item.getName() + " семестр: " + item.getSemesterNumber() + " оценка: " + item.getMark());
        }
    }
    public void getAverage() {
        float count = 0;
        float sum = 0;
        for (Subject item : this.subjects)
        {
            sum+=item.getMark();
            count++;
        }
        System.out.println("Средняя оценка за всё время: " + sum/count);
    }

    public void isPossibleToGetHisgSalary(int semesterNumber) {
        boolean isPossible = true;
        for (Subject item : this.subjects)
        {
            if((item.getSemesterNumber() == semesterNumber) && (item.getMark() != 5)){
                isPossible = false;
            }
        }
        if(isPossible){
            System.out.println("У вас есть шанс на полученне повышенной стипендии");
        }else{
            System.out.println("Возможности получить повышенную стипендию уже нет");
        }
    }
    public Runnable isPossibleToGetRedDiploma = () -> {
        float count = 0;
        float countFive = 0;
        for (Subject item : this.subjects) {
            count++;
            if (item.getMark() == 5) {
                countFive++;
            }
            if ((item.getMark() == 3) || (this.diplomWork != 5)) {
                System.out.println("У вас нет шанса получить красный диплом");
                return;
            }
        }
        if (countFive / count < 0.75) {
            System.out.println("У вас нет шанса получить красный диплом");
            return;
        }
        System.out.println("У вас есть шанс получить красный диплом");
    };

}
