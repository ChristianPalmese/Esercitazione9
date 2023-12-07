package Modello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sistema {
    private ArrayList<Tweet> tweets;
    private ArrayList<Utente> utenti;

    public Sistema() {
        this.tweets = new ArrayList<>();
        this.utenti = new ArrayList<>();
    }

    public void aggiungiTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }

    public ArrayList<String> cittaDiversa(){
    	ArrayList<String> cittaDiversa= new ArrayList<>();
    	HashMap<Utente,List<Tweet>> utenteETweet= new HashMap<>();
    	
    	for(Utente utente : utenti) {
    		List<Tweet> tweetUtente= new ArrayList<>();
    		
    		for(Tweet tweet : tweets) {
    			if(tweet.getCodiceFiscale().equalsIgnoreCase(utente.getCodiceFiscale())) {
    				tweetUtente.add(tweet);
    			}
    			
    		}
    		utenteETweet.put(utente, tweetUtente);
    	}
    	
    	for (Map.Entry<Utente, List<Tweet>> entry : utenteETweet.entrySet()) {
    	    Utente utente = entry.getKey();
    	    List<Tweet> listaTweet = entry.getValue();
    	    boolean controllo = true;

    	    for (Tweet tweet : listaTweet) {
    	        if(utente.getCittaResidenza().equalsIgnoreCase(tweet.getCitta())) {
    	        	controllo=false;
    	        }
    	    }
    	    if(controllo==true) {
    	    	cittaDiversa.add(utente.getCodiceFiscale());
    	    }
    	}
    	
    	return cittaDiversa;
    }
    
    
    public static String[] convertiListaStringhe(ArrayList<String> arrayList) {
        // Creazione di un nuovo array di stringhe della stessa dimensione della lista
        String[] arrayStringhe = new String[arrayList.size()];

        // Conversione degli elementi uno per uno
        for (int i = 0; i < arrayList.size(); i++) {
            arrayStringhe[i] = String.valueOf(arrayList.get(i));
        }

        return arrayStringhe;
    }

    public void listaUtenti() {
    	Map<String, List<String[]>> tagsUtenteProva = new HashMap<>();
    	
    	Map<Integer,String> listaTagNumerato= new HashMap<>();

        for (Utente utente : utenti) {
            ArrayList<String[]> tagsUtente = new ArrayList<>();
            // Troviamo tutti i tag distinti dell'utente
            for (Tweet tweet : tweets) {
                if (tweet.getCodiceFiscale().equals(utente.getCodiceFiscale())) {
                    String[] array = convertiListaStringhe(tweet.getTag());
                    tagsUtente.add(array);
                    tagsUtenteProva.put(utente.getCodiceFiscale(), tagsUtente);
                }
            }
        }
        
        for (Map.Entry<String, List<String[]>> entry : tagsUtenteProva.entrySet()) {
        	List<String[]> valore = tagsUtenteProva.get(entry.getKey());
        	System.out.println(checkDistinctStrings(valore));
        }
        
        /*List<String[]> listaProva = tagsUtenteProva.get("CF3");
        for(String[] arr : listaProva) {
        	for (int i = 0; i < arr.length; i++) {
                System.out.println("Indice " + i + ": " + arr[i]);
            }
        }*/
       
    }
    
    public static boolean checkDistinctStrings(List<String[]> arrays) {
    	if(arrays.size() > 1) {
    		for (int i = 0; i < arrays.size(); i++) {
                Set<String> set = new HashSet<>();
                for (int j = 0; j < arrays.size(); j++) {
                    if (i != j) {
                        for (String str : arrays.get(j)) {
                            set.add(str);
                        }
                    }
                }
                for (String str : arrays.get(i)) {
                    if (set.contains(str)) {
                        return false; // Se trova una stringa uguale, restituisce false
                    }
                }
            }
            return true; // Se tutte le stringhe sono diverse, restituisce true
    	}else {
    		return false;
    	}
    }

    
    public String tagOfTheDay(int data) {
        Map<String, Integer> tagCounter = new HashMap<>();

        for (Tweet tweet : tweets) {
            if (tweet.getDataEmissione() == data) {
                for (String tag : tweet.getTag()) {
                    tagCounter.put(tag, tagCounter.getOrDefault(tag, 0) + 1);
                }
            }
        }

        String tagPiùUsato = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : tagCounter.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                tagPiùUsato = entry.getKey();
            }
        }

        return tagPiùUsato;
    }

    

    
    
    
    
    
}