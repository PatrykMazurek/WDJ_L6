package com.wdj;

public class Employee extends Person{

    private int salary;

    public Employee(int s){
        salary = s;
//        super.id = 0;
    }

    public void toShow(String s, String... zadnia ){
        System.out.println(s);
        for (String temp : zadnia){
            System.out.println(temp);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() +", " +  "salary=" + salary;
    }


}
