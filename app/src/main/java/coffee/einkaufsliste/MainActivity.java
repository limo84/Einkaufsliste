package coffee.einkaufsliste;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ListElement> ListenSpeicher;
    LinearLayout linearLayoutUpperPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListenSpeicher = new ArrayList<>(0);
        linearLayoutUpperPart = (LinearLayout) findViewById(R.id.itemListLayout);

        // Es muss den ListenSpeicher vorher geben

        //ListElement FirstEntry = new ListElement(3, "Bohnen");
        //ListElement SecondEntry = new ListElement(4, "Gurken");
        //ListElement ThirtEntry = new ListElement (7, "Bananen");

        //ListenSpeicher.add(FirstEntry);
        //ListenSpeicher.add(SecondEntry);
        //ListenSpeicher.add(ThirtEntry);

        //EingabeAnzeigen(null);
    }

    public void onClickBtn(View v) {

        EditText numberOfItem = (EditText) findViewById(R.id.editTextItemNumber);
        EditText nameOfItem = (EditText) findViewById(R.id.editText);

        if(!numberOfItem.getText().toString().isEmpty() && !nameOfItem.getText().toString().isEmpty()) {

            Button Remove = new Button(this);
            Remove.setTextSize(20);
            Remove.setText("R");

            ListElement neuesElement = new ListElement(Integer.parseInt(numberOfItem.getText().toString()), nameOfItem.getText().toString(), Remove);
            ListenSpeicher.add(neuesElement);

            // ListenSpeicher.indexOf(neuesElement);

        }

        //EingabeAnzeigen(v);

    }

    public void EingabeAnzeigen(View v) {

        linearLayoutUpperPart.removeAllViews();

        for (int i = 0; i<= (ListenSpeicher.size()-1); i++){

            LinearLayout linearLayoutEntry = new LinearLayout(this);

            TextView Zahl = new TextView(this);
            Zahl.setTextSize(30);
            Zahl.setText(String.valueOf(ListenSpeicher.get(i).GetAnzahl()));
            //Zahl.setText(String.valueOf(ListenSpeicher.size()));

            TextView Leerzeile = new TextView(this);
            Leerzeile.setTextSize(30);
            Leerzeile.setText(" ");

            TextView Artikel = new TextView(this);
            Artikel.setTextSize(30);
            Artikel.setText(ListenSpeicher.get(i).GetArtikel());

            linearLayoutEntry.addView(Zahl);
            linearLayoutEntry.addView(Leerzeile);
            linearLayoutEntry.addView(Artikel);
            linearLayoutEntry.addView(ListenSpeicher.get(i).GetButton());

            linearLayoutUpperPart.addView(linearLayoutEntry);
            //Test

        }

    }
}