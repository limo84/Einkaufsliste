package coffee.einkaufsliste;

/**
 * Created by Tribe on 01.08.2017.
 * Klasse für die Einträge
 */

public class ListElement {
    private String Artikel;
    private int Anzahl;

    public ListElement(int Anzahl, String Artikel){
        this.Anzahl = Anzahl;
        this.Artikel = Artikel;
    }

    public String GetArtikel() {
        return Artikel;
    }

    public int GetAnzahl(){
        return Anzahl;
    }
}
