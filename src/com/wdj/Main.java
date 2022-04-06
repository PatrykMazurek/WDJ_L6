package com.wdj;

import java.lang.reflect.Member;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int number = 10;

        // nie jset możiwe utworzenie klasy Person gyż klasa jest abstrakcyjna
//        Person p = new Person("Patryk", "Mazurek", 34);
        Employee e = new Employee(2000);
        e.setName("Patryk");
        e.setLastName("Mazurek");
        e.setAge(34);

        Person p2 = new Student( "Jan", "Kowalski", 23, "UP", 2);
        Person etemp =  p2;
        Manager m = (Manager) e;
        System.out.println(etemp.getClass());
        // sprawdzenie czy obiekt jest danej klasy
        if( etemp instanceof Student){
            System.out.println("Jest studentem ");
        }else{
            System.out.println("nie jest studentem ");
        }

        // Stworzenie tabeli obiektów typu Pesrson
        Person[] person = new Person[14];
        person[0] = new Student("Jan", "Kowalski", 22, "UP", 3);

        Object tempObj = p2;
        System.out.println(" obj class:" + tempObj.getClass());
        Student s3 = (Student)tempObj;
        System.out.println(" żutowanie na klsę Student ");
        System.out.println(s3.getClass());

        System.out.println(etemp.getName() + " nowy osoba");

        // wysołanie metod o dowolnej liczbue argumentów
        e.toShow("Dowolny tekst do metody to show");
        e.toShow("zadanie", "zadanie 1", "zadanie 3", "zadanie 2" );
        e.toShow("praca", "zadanie 1", "zadanie 2");

        Manager m1 = new Manager(4000.0, 10);
        m1.setName("Jan");
    }
}
