package coffee.einkaufsliste;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutUpperPart;
    LinearLayout linearLayoutEntry;

    EditText numberOfItems;
    EditText editText;

    ListOfEntrys test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutUpperPart = (LinearLayout) findViewById(R.id.itemListLayout);
        test =  new ListOfEntrys (123, "Bananen");
    }

    public void onClickBtn(View v) {

        numberOfItems = (EditText) findViewById(R.id.editTextItemNumber);
        editText = (EditText) findViewById(R.id.editText);
        linearLayoutEntry = new LinearLayout(this);

        test.add(1,"string");
        test.add(3,"Pflaumen");

        TextView fred = new TextView(this);
        fred.setTextSize(30);
        fred.setText(numberOfItems.getText());
        fred.setBackgroundColor(Color.RED);

        TextView frud = new TextView(this);
        frud.setTextSize(30);
        frud.setText(test.NameById(6));
        //frud.setText(editText.getText());
        frud.setBackgroundColor(Color.BLUE);




        linearLayoutUpperPart.addView(linearLayoutEntry);
        linearLayoutEntry.addView(fred);
        linearLayoutEntry.addView(frud);


    }
}

