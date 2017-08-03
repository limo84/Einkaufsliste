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

    LinearLayout Anzeige;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anzeige = (LinearLayout) findViewById(R.id.itemListLayout);

    }

    public void onClickBtn(View v) {

        EditText numberOfItem = (EditText) findViewById(R.id.editTextItemNumber);
        EditText nameOfItem = (EditText) findViewById(R.id.editText);

        if(!numberOfItem.getText().toString().isEmpty() && !nameOfItem.getText().toString().isEmpty()) {

            TextView ErsterUntereintrag = new TextView(this);
            TextView ZweiterUntereintrag = new TextView(this);

            LinearLayout Eintrag = new LinearLayout(this);
            Eintrag.addView(ErsterUntereintrag);
            Eintrag.addView(ZweiterUntereintrag);

            Anzeige.addView(Eintrag, i);

            i++;

        }
    }

    public void Test(View v) {

    }
}