package com.example.smartfarmer20;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlantsFragment extends Fragment {


    public PlantsFragment() {
        // Required empty public constructor
    }

    private View view;
    private TextView mangoText, roseText, jasminText, jackText, lemonText;
    private Button mangoButton, roseButton, jasminButton, jackButton, lemonButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_plants, container, false);

        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//
//        roseButton = view.findViewById(R.id.rose_button);
//        jasminButton = view.findViewById(R.id.jasmin_button);
//        jackButton = view.findViewById(R.id.jack_button);
//        lemonButton = view.findViewById(R.id.lemon_button);
//        mangoButton = view.findViewById(R.id.mango_button);
//
//        roseText = view.findViewById(R.id.rose_text);
//        jasminText = view.findViewById(R.id.jasmin_text);
//        jackText = view.findViewById(R.id.jack_text);
//        lemonText = view.findViewById(R.id.lemon_text);
//        mangoText = view.findViewById(R.id.mango_text);
//
//
//        roseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//
//
//
//    private Integer getNumber (String s) {
//        String t;
//        t = "" + s.charAt(0);
//        return Integer.parseInt(t);
//    }
}