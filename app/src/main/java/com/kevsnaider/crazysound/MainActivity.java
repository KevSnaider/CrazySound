package com.kevsnaider.crazysound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btn_laugh, btn_applause, btn_boo, btn_joke, btn_money, btn_wrong;
    AdView adView;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_laugh = findViewById(R.id.btn_laugh);
        btn_laugh.setOnClickListener(this);
        btn_applause = findViewById(R.id.btn_applause);
        btn_applause.setOnClickListener(this);
        btn_boo = findViewById(R.id.btn_boo);
        btn_boo.setOnClickListener(this);
        btn_joke = findViewById(R.id.btn_joke);
        btn_joke.setOnClickListener(this);
        btn_money = findViewById(R.id.btn_money);
        btn_money.setOnClickListener(this);
        btn_wrong = findViewById(R.id.btn_wrong);
        btn_wrong.setOnClickListener(this);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == findViewById(R.id.btn_laugh)) {
            releaseMediaPlayer();
            mMediaPlayer = MediaPlayer.create(this, R.raw.laugh);
        } else if (v == findViewById(R.id.btn_applause)) {
            releaseMediaPlayer();
            mMediaPlayer = MediaPlayer.create(this, R.raw.applause);
        } else if (v == findViewById(R.id.btn_boo)) {
            releaseMediaPlayer();
            mMediaPlayer = MediaPlayer.create(this, R.raw.boo);
        } else if (v == findViewById(R.id.btn_joke)) {
            releaseMediaPlayer();
            mMediaPlayer = MediaPlayer.create(this, R.raw.joke);
        } else if (v == findViewById(R.id.btn_money)) {
            releaseMediaPlayer();
            mMediaPlayer = MediaPlayer.create(this, R.raw.money);
        } else {
            releaseMediaPlayer();
            mMediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        }

        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
