package com.wdj;

import java.util.Random;

public class Student extends Person {

    private String universityName;
    private int year;

    public Student(String n, String l, int a,  String u, int y){
        super(n, l, a);
        universityName = u;
        year = y;
    }

    public boolean goToExam(){
        Random random = new Random();
        if (random.nextBoolean()){
            System.out.println("Egzamin zaliczony");
            return true;
        }else{
            System.out.println("Egzamin nie zaliczony");
            return false;
        }
    }

    @Override
    public String toString() {
        return "universityName='" + universityName + ", year=" + year;
    }
}
