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
        public int id;
        public String item;
        public Node next;

        public Node(String item) {
            this.id = 0;
            this.item = item;
        }

        public void add(String item) {
            if(this.next == null) {
                this.next = new Node(item);
                this.next.id = this.id + 1;
            }
            else {
                this.next.add(item);
            }
        }

        public String printList() {
            if(this.next != null) {
                return Integer.toString(this.next.id) + this.next.printList();
            }

            return "";
        }

        public void printList2(Context context) {
            if(this.next != null) {
                linearLayoutEntry = new LinearLayout(context);

                TextView tf_id = new TextView(context);
                tf_id.setTextSize(30);
                tf_id.setText(Integer.toString(this.next.id));
                //tf_id.setBackgroundColor(Color.RED);

                TextView tf_item = new TextView(context);
                tf_item.setTextSize(30);
                tf_item.setText(this.next.item);

                linearLayoutUpperPart.addView(linearLayoutEntry);
                linearLayoutEntry.addView(tf_id);
                linearLayoutEntry.addView(tf_item);

                this.next.printList2(context);
            }
        }

        public void refreshId() {
            if (this.next != null) {
                this.next.id = this.id + 1;
                this.next.refreshId();
            }
        }

        public void delete(int id) {
            if (this.next == null) {
                return;
            }
            else {
                if(this.next.id == id) {
                    this.next = this.next.next;
                }
                else {
                    this.next.delete(id);
                }
            }
        }
    }

    Node node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutUpperPart = (LinearLayout) findViewById(R.id.itemListLayout);
        node = new Node("");
        //for (int i=1; i<6; i++)
        //    node.add("Pflaume");
        //node.delete(3);
    }

    public void onClickBtn(View v) {

        numberOfItems = (EditText) findViewById(R.id.editTextItemNumber);
        editText = (EditText) findViewById(R.id.editText);

        node.add(editText.getText().toString());
        linearLayoutEntry = new LinearLayout(this);

        TextView fred = new TextView(this);
        fred.setTextSize(30);
        fred.setText(editText.getText().toString());

        linearLayoutUpperPart.addView(linearLayoutEntry);
        linearLayoutEntry.addView(fred);

        /*linearLayoutEntry = new LinearLayout(this);

        node.add();
        TextView fred = new TextView(this);
        fred.setTextSize(30);
        fred.setText(node.printList());
        fred.setBackgroundColor(Color.RED);

        linearLayoutUpperPart.addView(linearLayoutEntry);
        linearLayoutEntry.addView(fred);

        // create new Entry
        //Entry entry = new Entry(Integer.parseInt(numberOfItems.getText().toString()),
         //       editText.getText().toString());

        // Get params:
        /*LinearLayout.LayoutParams loparams = (LinearLayout.LayoutParams) v.getLayoutParams();
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
        linearLayoutEntry.addView(frud);*/
    }

    public void fct_refreshList(View v) {
        linearLayoutUpperPart.removeAllViews();
        node.refreshId();
        node.printList2(this);
    }
}

