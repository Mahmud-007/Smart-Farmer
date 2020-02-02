package com.example.smartfarmer20;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment implements View.OnClickListener{

    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;

    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blog2, container, false);
        cardView1 = view.findViewById(R.id.soil_seed_plantBLOG);
        cardView1.setOnClickListener(this);
        return inflater.inflate(R.layout.fragment_blog2, container, false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.soil_seed_plantBLOG){
            Intent intent=new Intent(getActivity(), SSPblogActivity.class);
            startActivity(intent);
        }
    }
}
