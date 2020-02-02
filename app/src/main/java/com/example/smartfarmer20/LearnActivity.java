package com.example.smartfarmer20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LearnActivity extends AppCompatActivity {

    private BottomNavigationView mbottomNavigationView;
    private FrameLayout mframeLayout;
    private Fragment blogFragment,vlogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        //setFragment(vlogFragment);

        final BlogFragment blogFragment = new BlogFragment();
        final VlogFragment vlogFragment = new VlogFragment();

        mframeLayout=findViewById(R.id.main_frame);
        mbottomNavigationView=findViewById(R.id.navigation);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.vlogid:
                        //mbottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(vlogFragment);
                        return true;
                    case R.id.blogid:
                        //mbottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(blogFragment);
                        return true;
                    default:
                        setFragment(vlogFragment);
                        return true;

                }
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

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }

}
