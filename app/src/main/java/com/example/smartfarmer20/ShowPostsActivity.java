package com.example.smartfarmer20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShowPostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_posts);

        //getSupportFragmentManager().beginTransaction().replace(R.id.CommunityLayout,new HomeFragment()).commit();
    }
}
