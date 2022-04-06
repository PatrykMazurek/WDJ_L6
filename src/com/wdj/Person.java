package com.wdj;

public abstract class Person {

    public int id;
    protected static int nextId = 1;
    private String name;
    private String lastName;
    private int age;

    public Person(){
        id = getNextId();
        name ="";
        lastName = "";
        age = 0;
    }

    public Person(String n, String l, int a){
        id = getNextId();
        name = n;
        lastName = l;
        age = a;
    }

    private int getNextId(){ return nextId++;}

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

    public abstract void toShow();

    public abstract Object convert(Object obj);

    @Override
    public String toString() {
        return "name='" + name +", lastName='" + lastName + '\'' +
                ", age=" + age;
    }


}
