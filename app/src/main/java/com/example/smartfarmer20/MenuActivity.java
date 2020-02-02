package com.example.smartfarmer20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {

    private ViewPager mViewpager;
    private SectionPgerAdapter mSectoinPagerAdapter;
    private TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setTitle("Store");

        mViewpager=findViewById(R.id.main_tabs_pager);
        mTablayout=findViewById(R.id.main_tabs);

        mSectoinPagerAdapter=new SectionPgerAdapter(getSupportFragmentManager());
        mViewpager.setAdapter(mSectoinPagerAdapter);
        mTablayout.setupWithViewPager(mViewpager);
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
