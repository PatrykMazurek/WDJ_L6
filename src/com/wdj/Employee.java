package com.wdj;

public class Employee extends Person{

    private double salary;

    public Employee(double s){
        salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void toShow(String s, String... zadnia ){
        System.out.println(s);
        for (String temp : zadnia){
            System.out.println(temp);
        }
    }

    // rozszerzenie metody zadeklarowanej w klasie Person
    @Override
    public void toShow() {
        System.out.println("Pracownik z wynagrodzeniem " + salary);
    }

    // rozszerzenie metody zadeklarowanej w klasie Person
    @Override
    public Employee convert(Object obj) {
        if(obj instanceof Employee){
            return (Employee) obj;
        }else if (obj instanceof Student){
            Employee e = new Employee( 0);
            e.setName( ( (Student) obj).getName());
            e.setLastName( ( (Student) obj).getLastName());
            e.setAge( ( (Student) obj).getAge());
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() +", " +  "salary=" + salary;
    }


}
