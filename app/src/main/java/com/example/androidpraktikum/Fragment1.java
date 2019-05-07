package com.example.androidpraktikum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.example.androidpraktikum.R;

public class Fragment1 extends Fragment {
    ToggleButton toggleButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_f1, container, false);
        toggleButton = view.findViewById(R.id.togglebutton);
        return view;
    }
}
