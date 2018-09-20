package com.push.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    /**Called when the user taps the Play button */
    public void playGame(View view) {
        Intent intent = new Intent(this, Play.class);
        startActivity(intent);
    }

    /**Called when the user taps the How to play button */
    public void getGameRules(View view) {
        Intent intent = new Intent(this, RulesMainPage.class);
        startActivity(intent);
    }
}
