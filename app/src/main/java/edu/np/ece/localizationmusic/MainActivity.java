package edu.np.ece.localizationmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    BackgroundSound mBackgroundSound;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = findViewById(R.id.tvMessage);
        mBackgroundSound = new BackgroundSound();

        String language = Locale.getDefault().getDisplayLanguage();
        Log.i("Main", language);
        tvMessage.setText(language);
    }

    public void onResume() {
        super.onResume();
        mBackgroundSound.execute();
    }

    public void onPause() {
        super.onPause();
        mBackgroundSound.cancel(true);
    }

    class BackgroundSound extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.background);
            player.setLooping(true); // Set looping
            player.setVolume(1.0f, 1.0f);
            player.start();

            return null;
        }

    }
}

