package com.challenge.prishtinaexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Germia extends AppCompatActivity {

    TTS textToSpeech;
    TextView germia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_germia);
        textToSpeech = new TTS(this);
        germia = findViewById(R.id.germiaTextView);
    }

    public void liveChat(View view) {
        textToSpeech.speak(germia.getText().toString());
        Intent intent = new Intent(this, Reviews.class);
        startActivity(intent);
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}