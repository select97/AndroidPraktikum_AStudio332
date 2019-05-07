package com.example.androidpraktikum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.androidpraktikum.R;

public class Fragment2 extends Fragment {
    CheckBox checkBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_f2, container, false);
        checkBox = view.findViewById(R.id.checkbox);
        return view;
    }
}