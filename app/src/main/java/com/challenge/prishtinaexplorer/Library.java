package com.challenge.prishtinaexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Library extends AppCompatActivity {

    TTS textToSpeech;
    TextView library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        textToSpeech = new TTS(this);
        library = findViewById(R.id.cathedralTextView);
    }

    public void readText(View view) {
        textToSpeech.speak(library.getText().toString());
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}