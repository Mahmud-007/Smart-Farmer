package com.example.smartfarmer20;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class VlogFragment extends Fragment implements View.OnClickListener {

    //private LinearLayout ssp,chem_org,dis_nut,tech_beauty;

    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;

   public VlogFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_vlog, container, false);

        cardView1 = view.findViewById(R.id.soil_seed_plant);
        cardView1.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if(id == R.id.soil_seed_plant){
            Intent intent=new Intent(getActivity(), SeedsSoilPlantsActivity.class);
            startActivity(intent);
        }
    }
}
