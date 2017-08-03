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
    LinearLayout linearLayoutUpperPart = (LinearLayout) findViewById(R.id.itemListLayout);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListenSpeicher = new ArrayList<>(0);


        // Es muss den ListenSpeicher vorher geben

        //ListElement FirstEntry = new ListElement(3, "Bohnen");
        //ListElement SecondEntry = new ListElement(4, "Gurken");
        //ListElement ThirtEntry = new ListElement (7, "Bananen");

        //ListenSpeicher.add(FirstEntry);
        //ListenSpeicher.add(SecondEntry);
        //ListenSpeicher.add(ThirtEntry);

    }

    public void onClickBtn(View v) {

        EditText numberOfItem = (EditText) findViewById(R.id.editTextItemNumber);
        EditText nameOfItem = (EditText) findViewById(R.id.editText);

        if(!numberOfItem.getText().toString().isEmpty() && !nameOfItem.getText().toString().isEmpty()) {

        }
    }

    public void EingabeAnzeigen(View v) {

        }
    }
}