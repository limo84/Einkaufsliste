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

    class Entry {

        public String number;
        public String item;

        public Entry(String number, String item) {
            this.number = number;
            this.item = item;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutUpperPart = (LinearLayout) findViewById(R.id.itemListLayout);
    }

    public void onClickBtn(View v) {

        numberOfItems = (EditText) findViewById(R.id.editTextItemNumber);
        editText = (EditText) findViewById(R.id.editText);
        linearLayoutEntry = new LinearLayout(this);

        //String string = "";
        //string = string + numberOfItems.getText() + editText.getText();


        TextView fred = new TextView(this);
        //fred.setHeight(100);
        //fred.setWidth(0);
        //fred.setGravity(3);
        fred.setTextSize(30);
        fred.setText(numberOfItems.getText());
        fred.setBackgroundColor(Color.RED);

        TextView frud = new TextView(this);
        //frud.setWidth(0);
        //frud.setGravity(7);
        frud.setTextSize(30);
        frud.setText(editText.getText());
        frud.setBackgroundColor(Color.BLUE);
        //fred.setLayoutParams(new LinearLayout.LayoutParams
        //        (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        //fred.setBackgroundColor(Color.RED);
        //fred.setBackgroundResource();
        //fred.setImageDrawable(getResources().getDrawable(R.drawable.circle_image_selected));
        //android:background="@android:drawable/editbox_dropdown_light_frame"

        //fred.setText(string);

        linearLayoutUpperPart.addView(linearLayoutEntry);
        linearLayoutEntry.addView(fred);
        linearLayoutEntry.addView(frud);

    }
}

