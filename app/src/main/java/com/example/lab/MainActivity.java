package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;
import org.w3c.dom.Text;

import java.util.prefs.Preferences;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById
    TextView textView;

    @ViewById
    TextView textView2;

    @ViewById
    TextView textView3;

    @ViewById
    EditText editText;

    @ViewById
    EditText editText2;

    @ViewById
    Button button;

    @ViewById
    Button button2;

    @ViewById
    CheckBox checkBox;

    @Bean
    UserManager realm;

   SharedPreferences prefs;

    @AfterViews
    public void init(){
        textView.setText("LOGIN");


    }

    @Click(R.id.checkBox)
    public void check()
    {
    }

    @Click(R.id.button)
    public void login()
    {
        String email = editText.getText().toString();
        String password = editText2.getText().toString();
        boolean a = checkBox.isChecked();
        boolean authenticate = false;


//        // initialize preferences
//        prefs = getSharedPreferences("myprefs", MODE_PRIVATE);
//
//        // initialize editor like buffer
//        SharedPreferences.Editor edit = prefs.edit();
//
//
//        // extract values
//        String uname = prefs.getString("username", null); // returns "abc", null if not existing
//        String upass = prefs.getString("password", null); // returns "abc", null if not existing

        User userLoggingIn = realm.checkUsers(email);

        if(userLoggingIn != null && userLoggingIn.getPassword().equals(password))
        {

            authenticate = true;

            finish();
            Welcome_.intent(this)
                    .username(userLoggingIn.getUsername())
                    .start();
        }

        else if(email.matches("") || password.matches(""))
        {
            Toast toast = Toast.makeText(this, "Please fill up all fields", Toast.LENGTH_SHORT);
            toast.show();
        }


//        else if (name.matches(uname) && password.matches(upass)){
//            Welcome_.intent(this).start();
//        }
        else{
            Toast toast = Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    @Click(R.id.button2)
    public void next()
    {
        UserList_.intent(this).start();
    }


}
