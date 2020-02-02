package com.example.smartfarmer20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SeedsSoilPlantsActivity extends AppCompatActivity {

    LinearLayout PaddyHarvestProcess,RiceCultivationTech,MatNursury,vegeSoil,SoilPlott,seedHome,SaveSeeds;
    private String []urls=new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeds_soil_plants);

        PaddyHarvestProcess=findViewById(R.id.PaddyHarvestProcess);
        PaddyHarvestProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urls[0]="https://www.youtube.com/watch?v=SJgDswVRuXA";
                Intent intent=new Intent(SeedsSoilPlantsActivity.this, WebViewActivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
            }
        });

        RiceCultivationTech=findViewById(R.id.RicecultivatioTechnology);
        RiceCultivationTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urls[1]="https://www.youtube.com/watch?v=ueM8w9JGxEE";
                Intent intent=new Intent(SeedsSoilPlantsActivity.this, WebViewActivity.class);
                intent.putExtra("links",urls[1]);
                startActivity(intent);
            }
        });
        MatNursury=findViewById(R.id.modifiedMatnurseryrice);
        MatNursury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urls[2]="https://www.youtube.com/watch?v=CLS2WvMoDLc";
                Intent intent=new Intent(SeedsSoilPlantsActivity.this, WebViewActivity.class);
                intent.putExtra("links",urls[2]);
                startActivity(intent);
            }
        });
        vegeSoil=findViewById(R.id.vegeSoil);
        vegeSoil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urls[3]="https://www.youtube.com/watch?v=vQrKKmYUh6E";
                Intent intent=new Intent(SeedsSoilPlantsActivity.this, WebViewActivity.class);
                intent.putExtra("links",urls[3]);
                startActivity(intent);
            }
        });
        SoilPlott=findViewById(R.id.SoilPlott);
        SoilPlott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urls[4]="https://www.youtube.com/watch?v=mLe0yN18P_M";
                Intent intent=new Intent(SeedsSoilPlantsActivity.this, WebViewActivity.class);
                intent.putExtra("links",urls[4]);
                startActivity(intent);
            }
        });
        seedHome=findViewById(R.id.SeedsForHome);
        seedHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urls[5]="https://www.youtube.com/watch?v=OjgBAIlzjJY";
                Intent intent=new Intent(SeedsSoilPlantsActivity.this, WebViewActivity.class);
                intent.putExtra("links",urls[5]);
                startActivity(intent);
            }
        });
    }
}
