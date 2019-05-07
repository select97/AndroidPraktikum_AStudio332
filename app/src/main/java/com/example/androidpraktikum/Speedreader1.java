package com.example.androidpraktikum;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidpraktikum.Logger.newLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Speedreader1 extends AppCompatActivity{
    newLogger logger;
    String gesamtText;
    String[] tokens;
    int wortZaehler = 0;
    TextView wortTextView;
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speedreader1);
        logger = new newLogger(this.getClass().getSimpleName(),
                (TextView) findViewById(R.id.myLogView), "");
        logger.log("onCreate");

        gesamtText = readGesamtText("lyricsZuhause.txt");
        tokens = gesamtText.split(" |\n");

        myTextView = findViewById(R.id.myTextView);

        wortTextView = findViewById(R.id.wortTextView);
        Button getTextBut = findViewById(R.id.getTextButton);
        Button clearBut = findViewById(R.id.clearButton);
        Button getWordBut = findViewById(R.id.getWortButton);


        getTextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.log("loadButton clicked");
                myTextView.setText(gesamtText);
            }
        });

        clearBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.log("clearButton clicked");
                myTextView.setText("");
                wortTextView.setText("");

            }
        });

        getWordBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logger.log("getWortButton clicked");
                wortTextView.setText(tokens[wortZaehler]);
                wortZaehler++;
            }
        });
    }

    private String readGesamtText(String assetName){
        try{
            logger.log("auslesen()");
            String str = "";
            AssetManager manager = getAssets();
            StringBuffer buf = new StringBuffer();
            InputStream is = manager.open(assetName);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));

            while ((str = bf.readLine()) != null) {
                buf.append(str + "\n");
            }
            is.close();
            return buf.toString();
        }
        catch(FileNotFoundException e){
            logger.log(e.getMessage());
            return e.getMessage();
        }
        catch(IOException e){
            logger.log("Kann" + assetName + "nicht öffnen!");
            return e.getMessage();
        }
    }
}
