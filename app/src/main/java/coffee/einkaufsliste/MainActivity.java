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
        private int number;
        private String item;
        private int id;

        private ListEntry next;

        public ListEntry(int number, String item, int id)
        {
            this.number = number;
            this.item = item;
            this.id = id;
        }

        public String getItem()
        {
            return item;
        }

        public int getNumber()
        {
            return number;
        }

        public int getId()
        {
            return id;
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
        private ListEntry end;

        public ListOfEntrys(int number, String item)
        {
            start = new ListEntry(number, item, 1);
            end = start;
        }

        public void Add(int number, String item)
        {
            int endId = end.getId()+1;
            end.setNext(new ListEntry(number, item, endId));
            end = end.getNext();
        }

        public String NameById (int id)
        {
            ListEntry currentPosition = start;
            while(currentPosition.getId() != id)
            {
                if(currentPosition.getNext() != null)
                {
                    currentPosition = currentPosition.getNext();
                }else return "Kein Eintrag gefunden";
            }return currentPosition.getItem();
        }
    }

    ListOfEntrys test = new ListOfEntrys (123, "Bananen");


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

