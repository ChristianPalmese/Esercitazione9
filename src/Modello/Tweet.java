package Modello;

import java.util.ArrayList;

public class Tweet {

	private int codice;
    private String codiceFiscale;
    private int dataEmissione;
    private String citta;
    private ArrayList<String> tag;

    public Tweet(int codice, String codiceFiscale, int dataEmissione, String citta, ArrayList<String> tag) {
        this.codice = codice;
        this.codiceFiscale = codiceFiscale;
        this.dataEmissione = dataEmissione;
        this.citta = citta;
        this.tag = tag;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public int getDataEmissione() {
        return dataEmissione;
    }

    public String getCitta() {
        return citta;
    }

    public ArrayList<String> getTag() {
        return tag;
    }
	
}
