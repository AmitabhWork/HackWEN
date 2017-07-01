package wen.hackthon.com.wen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

public class Create extends AppCompatActivity {

    EditText eventname, date, startitme, endtime, address;
    AppCompatButton createevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        eventname = (EditText) findViewById(R.id.editText);
        date = (EditText) findViewById(R.id.editText5);
        startitme = (EditText) findViewById(R.id.editText6);
        endtime = (EditText) findViewById(R.id.editText7);
        address = (EditText) findViewById(R.id.editText8);
        createevent = (AppCompatButton) findViewById(R.id.createvenet);
        createevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
