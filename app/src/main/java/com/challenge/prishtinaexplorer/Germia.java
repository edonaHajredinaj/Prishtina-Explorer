package com.challenge.prishtinaexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Germia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_germia);
    }

    public void liveChat(View view) {
        Intent intent = new Intent(this, Reviews.class);
        startActivity(intent);
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}