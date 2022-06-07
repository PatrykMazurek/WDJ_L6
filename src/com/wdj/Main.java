package com.wdj;

import java.lang.reflect.Member;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int number = 10;

        // nie jset możiwe utworzenie klasy Person gyż klasa jest abstrakcyjna

//        new MainWindow();
//        new ListWindow();

        List<String> tempList = new ArrayList<>();
        tempList.add("Pomidor");
        tempList.add("Pomarańcza");
        tempList.add("Kiwi");
        tempList.add("Kalafior");
        tempList.add("Cytryna");

        Stream<String> stream = tempList.stream();
        List<String> fruits = stream.filter(f -> f.length() > 4).collect(Collectors.toList());
//        fruits.stream().map(String::toUpperCase).forEach(System.out::println);
//        List<Integer> intFruits = fruits.stream()
//                .map(f -> f.length()).collect(Collectors.toList());
//
//        intFruits.stream().forEach(System.out::println);
//
//        fruits.stream().forEach(System.out::println);

        BoardGame boardGame = new BoardGame();
        List<BoardGame> boardGames = boardGame.initListGame();

        long countGame = boardGames.stream().filter(g -> g.minPlayers > 1).count();
        System.out.println("liczba gier " + countGame);

        System.out.println(boardGame.bestGameStream(boardGames, "a"));

        Map<Integer, List<BoardGame>> gameMap = boardGame.toMapYear(boardGames);

        for (Map.Entry<Integer, List<BoardGame>> rating : gameMap.entrySet()){
            System.out.println( rating.getKey() + " : " + rating.getValue() );
        }


//        Person p = new Person("Patryk", "Mazurek", 34);
//        Employee e = new Employee(2000);
//        e.setName("Patryk");
//        e.setLastName("Mazurek");
//        e.setAge(34);
//
//        Person p2 = new Student( "Jan", "Kowalski", 23, "UP", 2);
//        Person etemp =  p2;
//        Manager m = (Manager) e;
//        System.out.println(etemp.getClass());
//        // sprawdzenie czy obiekt jest danej klasy
//        if( etemp instanceof Student){
//            System.out.println("Jest studentem ");
//        }else{
//            System.out.println("nie jest studentem ");
//        }
//
//        // Stworzenie tabeli obiektów typu Pesrson
//        Person[] person = new Person[14];
//        person[0] = new Student("Jan", "Kowalski", 22, "UP", 3);
//
//        Object tempObj = p2;
//        System.out.println(" obj class:" + tempObj.getClass());
//        Student s3 = (Student)tempObj;
//        System.out.println(" żutowanie na klsę Student ");
//        System.out.println(s3.getClass());
//
//        System.out.println(etemp.getName() + " nowy osoba");
//
//        // wysołanie metod o dowolnej liczbue argumentów
//        e.toShow("Dowolny tekst do metody to show");
//        e.toShow("zadanie", "zadanie 1", "zadanie 3", "zadanie 2" );
//        e.toShow("praca", "zadanie 1", "zadanie 2");
//
//        Manager m1 = new Manager(4000.0, 10);
//        m1.setName("Jan");
    }
}
