package com.example.raplaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<Integer, Vorlesung> Vorlesungen = new HashMap<>()
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void parseIncommingStringInList(String inCommingString){
            
    }
}