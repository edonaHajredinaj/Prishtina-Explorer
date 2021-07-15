package com.challenge.prishtinaexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Cathedral extends AppCompatActivity {

    TTS textToSpeech;
    TextView cathedral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cathedral);
        cathedral = findViewById(R.id.cathedralTextView);
    }

    public void readText(View view) {
        textToSpeech.speak(cathedral.getText().toString());
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}