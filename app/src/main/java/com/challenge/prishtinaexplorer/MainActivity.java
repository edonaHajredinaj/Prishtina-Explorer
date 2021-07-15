package com.challenge.prishtinaexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TTS textToSpeech;
    TextView reviewDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeech = new TTS(this);
        reviewDesc = findViewById(R.id.reviewDesc);
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        textToSpeech.speak("Explore Prishtina's history with Google Maps");
        startActivity(intent);
    }

    public void review(View view) {
        Intent intent = new Intent(this, Reviews.class);
        textToSpeech.speak(reviewDesc.getText().toString());
        startActivity(intent);
    }

    public void goToNewborn(View view) {
        Intent intent = new Intent(this, Newborn.class);
        textToSpeech.speak("Visit Newborn");
        startActivity(intent);
    }

    public void goToCathedral(View view) {
        Intent intent = new Intent(this, Cathedral.class);
        textToSpeech.speak("Visit Mother Teresa Cathedral");
        startActivity(intent);
    }

    public void goToGermia(View view) {
        Intent intent = new Intent(this, Germia.class);
        textToSpeech.speak("Visit Germia Park");
        startActivity(intent);
    }

    public void goToLibrary(View view) {
        Intent intent = new Intent(this, Library.class);
        textToSpeech.speak("Visit The National Library of Kosovo \"Pjetër Bogdani\"");
        startActivity(intent);
    }

}