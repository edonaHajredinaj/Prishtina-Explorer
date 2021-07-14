package com.challenge.prishtinaexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void review(View view) {
        Intent intent = new Intent(this, Reviews.class);
        startActivity(intent);
    }

    public void goToNewborn(View view) {
        Intent intent = new Intent(this, Newborn.class);
        startActivity(intent);
    }

    public void goToCathedral(View view) {
        Intent intent = new Intent(this, Cathedral.class);
        startActivity(intent);
    }

    public void goToGermia(View view) {
        Intent intent = new Intent(this, Germia.class);
        startActivity(intent);
    }

    public void goToLibrary(View view) {
        Intent intent = new Intent(this, Library.class);
        startActivity(intent);
    }

}