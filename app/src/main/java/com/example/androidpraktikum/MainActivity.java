package com.example.androidpraktikum;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private String projekte[] = new String[]{
            DemoFragment.class.getSimpleName(),
            Speedreader1.class.getSimpleName()
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, projekte));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String auswahl = projekte[position];

        try{
            Class<?> c = Class.forName("com.example.androidpraktikum." + auswahl);
            Intent intent = new Intent(this, c);
            startActivity(intent);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
