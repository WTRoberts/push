package com.push.push;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RulesMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_main_page);

        //Set font to chalkboard style
        setTextToChalk(R.id.round1);
        setTextToChalk(R.id.round2);
        setTextToChalk(R.id.round3);
        setTextToChalk(R.id.round4);
        setTextToChalk(R.id.round5);

    }

    /**Called when the user taps Round One button */
    public void roundOne(View view) {
        Intent intent = new Intent(this, RulesRoundOne.class);
        startActivity(intent);
    }

    /**Sets the text to chalk font*/
    public void setTextToChalk(int textView) {
        TextView tx = findViewById(textView);
        Typeface customFont = Typeface.createFromAsset(getAssets(), "Fonts/DJB Chalk It Up.ttf");
        tx.setTypeface(customFont);
    }
}
