package com.example.smartfarmer20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.VideoView;

public class OptionsActivity extends AppCompatActivity {

    private LinearLayout store,learn,community;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().setTitle("Smart Farmer");


        store=findViewById(R.id.storeID);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OptionsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        learn=findViewById(R.id.learnID);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OptionsActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });
        community=findViewById(R.id.communityID);
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OptionsActivity.this, CommunityActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.profile_navigation,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.profile){
            Intent intent =new Intent(this,ProfileActivity.class);
            startActivity(intent);

        }
        if (item.getItemId()==R.id.community){
            Intent intent= new Intent(this,CommunityActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.store){
            Intent intent= new Intent(this,MenuActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.learn){
            Intent intent= new Intent(this,LearnActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.about){
            Intent intent= new Intent(this,AboutUsActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
