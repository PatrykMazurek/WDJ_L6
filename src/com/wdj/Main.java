package com.wdj;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int number = 10;

        Person p = new Person("Patryk", "Mazurek", 34);
        Employee e = new Employee(2000);

        Person p2 = new Student( "Jan", "Kowalski", 23, "UP", 2);
        System.out.println("Person");
        System.out.println(p2.toString());
        System.out.println("Pracownik");

        e.setName("Patryk");
        e.setLastName("Mazurek");
        e.setAge(34);
        System.out.println(e.toString());

        e.toShow("Dowolny tekst do metody to show");
        p.toShow();

        e.toShow("zadanie", "zadanie 1", "zadanie 3", "zadanie 2" );
        e.toShow("praca", "zadanie 1", "zadanie 2");
        Manager m = new Manager(4000);
        m.setName("Jan");
    }
}
