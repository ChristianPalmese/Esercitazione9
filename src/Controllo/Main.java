package Controllo;

import java.util.ArrayList;
import java.util.List;

import Modello.Sistema;
import Modello.Tweet;
import Modello.Utente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        Utente utente1 = new Utente("CF1", "Rende");
        Utente utente2 = new Utente("CF2", "Cosenza");
        Utente utente3 = new Utente("CF3", "Rende");

        sistema.aggiungiUtente(utente1);
        sistema.aggiungiUtente(utente2);
        sistema.aggiungiUtente(utente3);

        Tweet tweet1 = new Tweet(1, "CF1", 1, "Rende", new ArrayList<>(List.of("#capodanno", "#2020")));
        Tweet tweet2 = new Tweet(2, "CF1", 1, "Cosenza", new ArrayList<>(List.of("#capodanno", "#concerto")));
        Tweet tweet3 = new Tweet(3, "CF2", 2, "Rende", new ArrayList<>(List.of("#governo")));
        Tweet tweet4 = new Tweet(4, "CF3", 1, "Rende", new ArrayList<>(List.of("#capodanno")));
        Tweet tweet5 = new Tweet(5, "CF3", 1, "Rende", new ArrayList<>(List.of("#governo")));

        sistema.aggiungiTweet(tweet1);
        sistema.aggiungiTweet(tweet2);
        sistema.aggiungiTweet(tweet3);
        sistema.aggiungiTweet(tweet4);
        sistema.aggiungiTweet(tweet5);

        ArrayList<String> utentiCittaDiversa = sistema.cittaDiversa();
        System.out.println("Utenti con tweet da città diversa: " + utentiCittaDiversa);

        

        String tagPiùUsato = sistema.tagOfTheDay(1);
        System.out.println("Tag più usato nella data 1: " + tagPiùUsato);
        sistema.listaUtenti();
    }
}
