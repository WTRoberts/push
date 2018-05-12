package com.push.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PlayRoundTwo extends AppCompatActivity {

    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_round_two);

        Intent intent = getIntent();
        score = findViewById(R.id.Score2);
        String extra = intent.getStringExtra("total");
        score.setText(extra);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Cannot go back!", Toast.LENGTH_SHORT).show();
    }
}