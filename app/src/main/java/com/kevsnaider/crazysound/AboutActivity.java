package com.kevsnaider.crazysound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    TextView tv_aboutUs, tv_iconsFonts, tv_laughFont, tv_applauseFont, tv_booFont, tv_jokeFont, tv_moneyFont, tv_wrongFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv_aboutUs = findViewById(R.id.tv_about_us);
        tv_aboutUs.setMovementMethod(LinkMovementMethod.getInstance());
        tv_iconsFonts = findViewById(R.id.tv_icons_fonts);
        tv_iconsFonts.setMovementMethod(LinkMovementMethod.getInstance());
        tv_laughFont = findViewById(R.id.tv_laugh_fonts);
        tv_laughFont.setMovementMethod(LinkMovementMethod.getInstance());
        tv_applauseFont = findViewById(R.id.tv_applause_fonts);
        tv_applauseFont.setMovementMethod(LinkMovementMethod.getInstance());
        tv_booFont = findViewById(R.id.tv_boo_fonts);
        tv_booFont.setMovementMethod(LinkMovementMethod.getInstance());
        tv_jokeFont = findViewById(R.id.tv_joke_fonts);
        tv_jokeFont.setMovementMethod(LinkMovementMethod.getInstance());
        tv_moneyFont = findViewById(R.id.tv_money_fonts);
        tv_moneyFont.setMovementMethod(LinkMovementMethod.getInstance());
        tv_wrongFont = findViewById(R.id.tv_wrong_fonts);
        tv_wrongFont.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
