package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentBook studentBook = new StudentBook();
        studentBook.addSubject( "Digital platforms", 1,5);
        studentBook.addSubject( "Math", 1,5);
        studentBook.addSubject( "OOP", 2,5);
        studentBook.addSubject( "Development", 3,5);
        studentBook.setDiplomWork(5);
        //studentBook.getSubjects();
        //studentBook.getAverage();
        studentBook.isPossibleToGetRedDiploma.run();
    }
}