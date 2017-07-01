package wen.hackthon.com.wen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

import static android.R.attr.phoneNumber;

public class VerifyActivity extends AppCompatActivity {

    EditText mobilenum, otpnum;
    AppCompatButton verifybut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        mobilenum = (EditText) findViewById(R.id.phonenumber);
        otpnum = (EditText) findViewById(R.id.otptext);
    }
}
