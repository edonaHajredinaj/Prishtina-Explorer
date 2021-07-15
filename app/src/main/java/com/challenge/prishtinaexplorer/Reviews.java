package com.challenge.prishtinaexplorer;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Reviews extends AppCompatActivity {
    private final int VOICE_REC_CODE = 213;
    FirebaseDatabase database;
    DatabaseReference reference;
    EditText reviewEditText, user;
    TextView reviewTextView;
    TTS textToSpeech;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_REC_CODE && resultCode == RESULT_OK) {
            ArrayList<String> recognized = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            showMessage("Recognized", recognized.toString());
            reviewTextView.setText(recognized.toString());
        }
    }

    private void showMessage(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .show();
    }

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

    public void hear(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Please speak your review!");
        startActivityForResult(intent, VOICE_REC_CODE);
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