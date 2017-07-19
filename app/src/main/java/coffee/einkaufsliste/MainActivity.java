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

    public class ListEntry
    {
        private Short number;
        private String item;

        private ListEntry next;

        public ListEntry(Short number, String item)
        {
            this.number = number;
            this.item = item;
        }

        public String getItem()
        {
            return item;
        }

        public Short getNumber()
        {
            return number;
        }

        public ListEntry getNext()
        {
            return next;
        }

        public void setNext(ListEntry next)
        {
            this.next = next;
        }
    }

    public class ListOfEntrys
    {
        // First Entry in the ListOfEntrys
        private ListEntry start;

        // Length of the hole ListOfEntrys
        private int length;

        public void add (Short number, String item)
        {
            ListEntry pos = new ListEntry(number, item);
            pos.setNext(start);
            start = pos;
            length++;
        }

        public int getLength()
        {
            return length;
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


        TextView fred = new TextView(this);
        fred.setTextSize(30);
        fred.setText(numberOfItems.getText());
        fred.setBackgroundColor(Color.RED);

        TextView frud = new TextView(this);
        frud.setTextSize(30);
        frud.setText(editText.getText());
        frud.setBackgroundColor(Color.BLUE);


        linearLayoutUpperPart.addView(linearLayoutEntry);
        linearLayoutEntry.addView(fred);
        linearLayoutEntry.addView(frud);
    }
}

