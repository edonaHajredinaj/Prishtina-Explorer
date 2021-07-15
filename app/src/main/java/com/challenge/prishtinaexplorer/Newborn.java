package com.challenge.prishtinaexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Newborn extends AppCompatActivity {

    TTS textToSpeech;
    TextView newborn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newborn);
        textToSpeech = new TTS(this);
        newborn = findViewById(R.id.cathedralTextView);
    }

    public void readText(View view) {
        textToSpeech.speak(newborn.getText().toString());
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        textToSpeech.speak("Explore Prishtina's history with Google Maps");
        startActivity(intent);
    }
}