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

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutUpperPart;
    LinearLayout linearLayoutEntry;

    EditText numberOfItems;
    EditText editText;


    public class Node {
        public int id;
        public String item;
        public CheckBox checkBox;
        public Node next;

        public Node(String item) {
            this.id = 0;
            this.item = item;
        }

        public void add(String item, Context context) {
            if(this.next == null) {
                this.next = new Node(item);
                this.next.id = this.id + 1;
                this.checkBox = new CheckBox(context);
            }
            else {
                this.next.add(item, context);
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


                TextView tf_item = new TextView(context);
                tf_item.setTextSize(30);
                tf_item.setText(this.next.item);

                linearLayoutUpperPart.addView(linearLayoutEntry);
                linearLayoutEntry.addView(tf_id);
                linearLayoutEntry.addView(tf_item);
                //linearLayoutEntry.addView(this.checkBox);

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
    }

    public void onClickBtn(View v) {

        numberOfItems = (EditText) findViewById(R.id.editTextItemNumber);
        editText = (EditText) findViewById(R.id.editText);

        node.add(editText.getText().toString(), this);
        linearLayoutEntry = new LinearLayout(this);

        TextView fred = new TextView(this);
        fred.setTextSize(30);
        fred.setText(editText.getText().toString());

        CheckBox check = new CheckBox(this);

        linearLayoutUpperPart.addView(linearLayoutEntry);
        linearLayoutEntry.addView(fred);
        linearLayoutEntry.addView(check);

    }

    public void fct_refreshList(View v) {
        linearLayoutUpperPart.removeAllViews();
        node.delete(3);
        node.refreshId();
        node.printList2(this);
    }
}

