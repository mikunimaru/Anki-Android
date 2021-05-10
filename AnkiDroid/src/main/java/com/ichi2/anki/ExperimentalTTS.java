package com.ichi2.anki;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class ExperimentalTTS implements TextToSpeech.OnInitListener {

  private TextToSpeech mTts;
  private boolean mTtsOk;

 //The constructor will create a TextToSpeech instance.
  ExperimentalTTS(Context context) {
      mTts = new TextToSpeech(context, this);
      mTts.setLanguage(Locale.US);
  }

  @Override
 //OnInitListener method to receive the TTS engine status
  public void onInit(int status) {
      if (status == TextToSpeech.SUCCESS) {
          mTtsOk = true;
      }
      else {
          mTtsOk = false;
      }
  }

 //A method to speak something
  @SuppressWarnings("deprecation")//Support older API levels too.
  public void speak(String text, Boolean override) {
      if (mTtsOk) {
          if (override) {
              mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
          }
          else {
              mTts.speak(text, TextToSpeech.QUEUE_ADD, null);
          }
      }
  }
}