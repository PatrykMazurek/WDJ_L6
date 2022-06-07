package com.wdj;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class BoardGame {

    public String name;
    public int year;
    public double rating;
    public BigDecimal price;
    public int minPlayers;
    public int maxPlayers;

    public BoardGame(){}

    public BoardGame(String name, int year, double rating, BigDecimal price, int minPlayers, int maxPlayers) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.price = price;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    public List<BoardGame> initListGame(){
        return Arrays.asList(
                new BoardGame("Terraforming Mars", 2016, 8.38, new BigDecimal("123.49"), 1, 5),
                new BoardGame("Codenames", 2015, 7.82, new BigDecimal("64.95"), 2, 8),
                new BoardGame("Puerto Rico", 2011, 8.07, new BigDecimal("149.99"), 2, 5),
                new BoardGame("Terra Mystica", 2012,8.26, new BigDecimal("252.99"), 2, 5),
                new BoardGame("Scythe", 2016, 8.3, new BigDecimal("314.95"), 1, 5),
                new BoardGame("Power Grid", 2004, 7.92, new BigDecimal("145"), 2, 6),
                new BoardGame("7 Wonders Duel", 2015,8.15, new BigDecimal("109.95"), 2, 2),
                new BoardGame("Dominion: Intrigue", 2009,7.77, new BigDecimal("159.95"), 2, 4),
                new BoardGame("Patchwork", 2014,7.77, new BigDecimal("75"), 2, 2),
                new BoardGame("The Castles of Burgundy", 2011,8.12, new BigDecimal("129.95"), 2, 4),
                new BoardGame("Brass: Birmingham", 2018,8.7, new BigDecimal("133.38"), 2, 4),
                new BoardGame("Pandemic Legacy: Season 1", 2016,8.3, new BigDecimal("66.35"), 2,4),
                new BoardGame("Gloomhaven", 2017,8.7, new BigDecimal("349.44"), 1,4),
                new BoardGame("Gaia Project", 2017,8.5, new BigDecimal("72.09"), 1,4),
                new BoardGame("Star Wars: Rebellion", 2016,8.4, new BigDecimal("114.13"), 2,2),
                new BoardGame("Spirit Island", 2017,8.4, new BigDecimal("122.17"), 1,4),
                new BoardGame("War of the Ring: Second Edition", 2011,8.5, new BigDecimal("200.10"),2,4),
                new BoardGame("Through the Ages: A New Story of Civilization", 2015,8.4, new BigDecimal("70.43"),2,4),
                new BoardGame("Great Western Trail", 2016, 8.3, new BigDecimal("75.23"),2,4),
                new BoardGame("Dune: Imperium", 2020, 8.3, new BigDecimal("58.96"), 1,4),
                new BoardGame("Ark Nova", 2021, 8.7, new BigDecimal("63.09"), 1,4),
                new BoardGame("Concordia", 2013, 8.1, new BigDecimal("49.21"), 2,5),
                new BoardGame("Wingspan", 2019, 8.1, new BigDecimal("55.00"),1,5),
                new BoardGame("Everdell", 2018, 8.1, new BigDecimal("81.95"),1,4),
                new BoardGame("Clank!: Legacy – Acquisitions Incorporated", 2019, 8.7, new BigDecimal("27.99"), 2,4),
                new BoardGame("Root", 2018, 8.1, new BigDecimal("40.74"),2,4),
                new BoardGame("Inis", 2016, 7.8, new BigDecimal("149.99"), 2,4),
                new BoardGame("Decrypto", 2018, 7.8, new BigDecimal("24.84"), 3,8),
                new BoardGame("The Isle of Cats", 2019, 7.9, new BigDecimal("62.72"), 1,4),
                new BoardGame("Trickerion: Legends of Illusion", 2015,8.0, new BigDecimal("67.91"), 2,4 ),
                new BoardGame("Pandemic: Iberia", 2016, 7.9, new BigDecimal("94.99"),2,5),
                new BoardGame("Yokohama", 2016, 7.8, new BigDecimal("63.09"), 2,4),
                new BoardGame("Res Arcana", 2019, 7.7, new BigDecimal("48.22"), 2,4),
                new BoardGame("Alchemists", 2014, 7.7, new BigDecimal("63.39"), 2,4),
                new BoardGame("Targi", 2012, 7.6, new BigDecimal("22.36"), 2, 2),
                new BoardGame("Star Wars: X-Wing Miniatures Game", 2012, 7.7, new BigDecimal("28.99"), 2,2),
                new BoardGame("Ticket to Ride: Europe", 2005, 7.5, new BigDecimal("41.26"),2,5),
                new BoardGame("The Lord of the Rings: The Card Game", 2011, 7.7, new BigDecimal("39.99"), 1,2),
                new BoardGame("Concordia Venus", 2018, 8.3, new BigDecimal("49.29"), 2,6),
                new BoardGame("Marco Polo II: In the Service of the Khan", 2009, 8.0, new BigDecimal("64.06"), 2,4),
                new BoardGame("Praga Caput Regni", 2020, 8.0, new BigDecimal("55.55"),1,4)
        );
    }

    public double getRating(){
        return this.rating;
    }

    public int getYear() { return year;}

    public String bestGame(List<BoardGame> boardGames){
        double highestRanking = 0;
        BoardGame bestGame = null;
        for (BoardGame game : boardGames) {
            if (game.name.contains("a")) {
                if (game.rating > highestRanking) {
                    highestRanking = game.rating;
                    bestGame = game;
                }
            }
        }
//        System.out.println(bestGame.name);
        return "Najlepsz gra: " + bestGame.toString();
    }

    public String bestGameStream(List<BoardGame> boardGames, String sign){
        BoardGame tempGame = boardGames.stream()
                .filter(g -> g.name.contains(sign))
                .max(Comparator.comparing(BoardGame::getRating))
                .orElseThrow();

        return "Najlepsz gra: " + tempGame.toString();
    }
    // zwracanie mapy pogrupowanej po elemencie raiting, do działania grupowania wymagany
    // stworzenie odpowiedniej metody zwracającej wymaganą wartość
    public Map<Double, List<BoardGame>> toMapRaiting (List<BoardGame> boardGames){
        Map<Double, List<BoardGame>> tempMap = boardGames
                .stream()
                .collect(Collectors.groupingBy(BoardGame::getRating));
        return tempMap;
    }

    // zwrócenie mapy pogrupowanej po roku wydania gry
    public Map<Integer, List<BoardGame>> toMapYear (List<BoardGame> boardGames){
        Map<Integer, List<BoardGame>> tempMap = boardGames
                .stream()
                .collect(Collectors.groupingBy(BoardGame::getYear));
        return tempMap;
    }

    @Override
    public String toString() {
        return name + " (" + year + "), ocena=" + rating + ", cena=" + price +
                ", gracze=" + minPlayers + " - " +maxPlayers ;
    }
}
