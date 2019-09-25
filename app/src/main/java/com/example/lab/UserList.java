package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_user_list)
public class UserList extends AppCompatActivity {

    @ViewById
    RecyclerView recyclerView;

    @Bean
    UserManager realm;

    @ViewById
    Button button6;




    @Click(R.id.button6)
    public void next()
    {
        Register_.intent(this).start();
    }




    @AfterViews
    public void init(){
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
     mLayoutManager.setOrientation(RecyclerView.VERTICAL);
    recyclerView.setLayoutManager(mLayoutManager);

        RealmResults<User> displayusers = realm.findAll();

       // set adapter
       UserAdapter ua = new UserAdapter(this,displayusers);
        recyclerView.setAdapter(ua);
    }

    public void delete(User object)
    {
        realm.delete(object);
    }

}
