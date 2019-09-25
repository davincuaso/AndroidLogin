package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_welcome)
public class Welcome extends AppCompatActivity {

    @Extra
    String username;

    @ViewById
    TextView textView5;

    @ViewById
    Button button5;

    SharedPreferences prefs;


    @AfterViews
    public void init()
    {
//        prefs = getSharedPreferences("myprefs", MODE_PRIVATE);
//
//        // initialize editor like buffer
//        SharedPreferences.Editor edit = prefs.edit();
//
//        String name = prefs.getString("username", null); // returns "abc", null if not existing

        textView5.setText("Welcome " + username);
    }

    @Click(R.id.button5)
    public void back(){
        MainActivity_.intent(this).start();
    }

}
