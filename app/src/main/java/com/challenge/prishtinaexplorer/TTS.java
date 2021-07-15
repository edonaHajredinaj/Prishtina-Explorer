package com.challenge.prishtinaexplorer;

import android.content.Context;
import android.speech.tts.TextToSpeech;

public class TTS {

    private final TextToSpeech textToSpeech;
    private final TextToSpeech.OnInitListener initListener = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int i) {

        }
    };

    public TTS(Context context) {
        textToSpeech = new TextToSpeech(context, initListener);
    }

    public void speak(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null, null);
    }
}
