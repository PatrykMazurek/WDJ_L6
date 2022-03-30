package com.wdj;

public class Person {

    public int id;
    protected static int nextId;
    private String name;
    private String lastName;
    private int age;

    public Person(){
        name ="";
        lastName = "";
        age = 0;
    }

    public Person(String n, String l, int a){
        name = n;
        lastName = l;
        age = a;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void toShow(){
        System.out.println("wywołanie z klasy Person");
    }

    @Override
    public String toString() {
        return "name='" + name +", lastName='" + lastName + '\'' +
                ", age=" + age;
    }


}
