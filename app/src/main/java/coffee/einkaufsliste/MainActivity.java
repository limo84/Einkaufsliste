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

    public class Node {
        public int wert;
        public Node next;

        public Node(int wert) {
            this.wert = wert;
        }

        public void add(int wert) {
            if(this.next == null) {
                this.next = new Node(wert);
            }
            else {
                this.next.add(wert);
            }
        }

        public String printList() {
            if(this.next != null) {
                return Integer.toString(this.next.wert) + this.next.printList();
            }

            return "";
        }

        public void delete(int wert) {
            if (this.next == null) {
                return;
            }
            else {
                if(this.next.wert == wert) {
                    this.next = this.next.next;
                }
                else {
                    this.next.delete(wert);
                }
            }
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


        // create new Entry
        //Entry entry = new Entry(Integer.parseInt(numberOfItems.getText().toString()),
         //       editText.getText().toString());

        // Get params:
        LinearLayout.LayoutParams loparams = (LinearLayout.LayoutParams) v.getLayoutParams();
        loparams.width = 0;
        loparams.weight = 3;
        linearLayoutEntry = new LinearLayout(this);


        TextView fred = new TextView(this);
        fred.setLayoutParams(loparams);
        fred.setTextSize(30);
        //fred.setText(Integer.toString(entry.getNumber()));
        fred.setBackgroundColor(Color.RED);

        loparams.weight = 7;
        TextView frud = new TextView(this);
        frud.setLayoutParams(loparams);
        frud.setTextSize(30);
        frud.setText(editText.getText());
        frud.setBackgroundColor(Color.BLUE);


        linearLayoutUpperPart.addView(linearLayoutEntry);
        linearLayoutEntry.addView(fred);
        linearLayoutEntry.addView(frud);
    }
}

