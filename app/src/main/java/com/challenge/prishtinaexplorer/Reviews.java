package com.challenge.prishtinaexplorer;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Reviews extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    EditText reviewEditText, user;
    TextView reviewTextView;
    TTS textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("reviews");
        reviewEditText = findViewById(R.id.reviewEditText);
        user = findViewById(R.id.username);
        reviewTextView = findViewById(R.id.reviewTextView);
        textToSpeech = new TTS(this);
    }

    public void post(View view) {
        if (!reviewEditText.getText().toString().matches("")) {
            reference.setValue(user.getText().toString() + ": " + reviewEditText.getText().toString());
            Toast.makeText(this, "You are posting a review", Toast.LENGTH_SHORT).show();

        }
    }

    public void read(View view) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                textToSpeech.speak(reviewTextView.getText().toString() + "\n\n" + snapshot.getValue().toString());
                reviewTextView.setText(reviewTextView.getText().toString() + "\n\n" + snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}