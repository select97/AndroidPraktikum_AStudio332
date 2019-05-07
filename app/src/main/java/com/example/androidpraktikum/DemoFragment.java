package com.example.androidpraktikum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;


public class DemoFragment extends AppCompatActivity {
    private Fragment1 f1;
    private Fragment2 f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demofragments);

        f1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.F_1_ID);

        f2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.F_2_ID);

        f1.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                f2.checkBox.setChecked(isChecked);
            }
        });

        f2.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                f1.toggleButton.setChecked(isChecked);
            }
        });
    }
}
