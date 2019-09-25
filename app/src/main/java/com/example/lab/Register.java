package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_register)
public class Register extends AppCompatActivity {

    @ViewById
    EditText editText3;

    @ViewById
    EditText editText4;

    @ViewById
    EditText editText5;

    @AfterViews
    public void next(){

    }

    @Bean
    UserManager realm;

//    SharedPreferences prefs;


    @Click(R.id.button3)
    public void register(){
        String name = editText3.getText().toString();
        String email = editText4.getText().toString();
        String password = editText5.getText().toString();

//        prefs = getSharedPreferences("myprefs", MODE_PRIVATE);
//
//        // initialize editor like buffer
//        SharedPreferences.Editor edit = prefs.edit();
//
//        edit.putString("username", name);
//        edit.apply();
//        edit.putString("emailadd", email);
//        edit.apply();
//        edit.putString("password", password);
//        edit.apply();

        if(name.matches("") || email.matches("") || password.matches(""))
        {
            Toast toast = Toast.makeText(this, "Please fill up all fields", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            realm.save(name, email, password);
        }

        MainActivity_.intent(this).start();

    }

    @Click(R.id.button4)
    public void back(){


//        for (User x: userlist)
//        {
//            System.out.println(x.toString());
//        }

       MainActivity_.intent(this).start();
    }

}
