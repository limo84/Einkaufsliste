package coffee.einkaufsliste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View v) {

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText numberOfItems = (EditText) findViewById(R.id.editTextItemNumber);
        final TextView textView = (TextView) findViewById(R.id.textView2);

        String string = textView.getText().toString();

        String number = "";
        switch(numberOfItems.length()) {
            case 0: number = "  "; break;
            case 1: number = " " + numberOfItems.getText(); break;
            case 2: number = ""  + numberOfItems.getText(); break;
            default: number = "  "; break;
        }
        string = string + numberOfItems.getText() + "\t" + editText.getText().toString() + "\n";

        //Toast.makeText(this, editText.getText(), Toast.LENGTH_LONG).show();
        textView.setText(string);
    }
}

