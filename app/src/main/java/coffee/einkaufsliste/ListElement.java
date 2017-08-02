package coffee.einkaufsliste;


import android.widget.Button;

/**
 * Created by Tribe on 01.08.2017.
 * Klasse für die Einträge
 */

public class ListElement {
    private String Artikel;
    private int Anzahl;
    private Button Remove;

    public ListElement(int Anzahl, String Artikel, Button Remove){
        this.Anzahl = Anzahl;
        this.Artikel = Artikel;
        this.Remove = Remove;

    }

    public String GetArtikel() {
        return Artikel;
    }

    public void SetArtikel (String Artikel) { this.Artikel = Artikel;}

    public int GetAnzahl(){
        return Anzahl;
    }

    public void SetAnzahl (int Anzahl) { this.Anzahl = Anzahl; }

    public Button GetButton() { return Remove; }

    public void SetButton (Button Remove) { this.Remove = Remove; }
}
