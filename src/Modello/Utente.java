package Modello;

public class Utente {
    private String codiceFiscale;
    private String cittaResidenza;

    public Utente(String codiceFiscale, String cittaResidenza) {
        this.codiceFiscale = codiceFiscale;
        this.cittaResidenza = cittaResidenza;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getCittaResidenza() {
        return cittaResidenza;
    }
}