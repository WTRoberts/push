package com.push.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Play extends AppCompatActivity {

    Boolean wildsAreGood, acesAreGood, tensToKingsAreGood, threesToNinesAreGood;
    Button wildsIncrement, wildsDecrement, acesIncrement, acesDecrement, tenToKingIncrement, getTenToKingDecrement, threeToNineIncrement, threeToNineDecrement;
    TextView wilds, aces, tenToKing, threeToNine, score, round;
    int numberOfWilds, numberOfAces, numberOfTensToKings, numberOfThreesToNines;
    int wildsTotal, acesTotal, tenToKingTotal, threeToNineTotal, totalScore, currentRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Get ids
        round = findViewById(R.id.firstRound);
        score = findViewById(R.id.Score);
        wilds = findViewById(R.id.Wilds);
        aces = findViewById(R.id.Aces);
        tenToKing = findViewById(R.id.TenToKing);
        threeToNine = findViewById(R.id.ThreeToNine);
        wildsIncrement = findViewById(R.id.WildsIncrement);
        wildsDecrement = findViewById(R.id.WildsDecrement);
        acesIncrement = findViewById(R.id.AcesIncrement);
        acesDecrement = findViewById(R.id.AcesDecrement);
        tenToKingIncrement = findViewById(R.id.TenToKingIncrement);
        getTenToKingDecrement = findViewById(R.id.TenToKingDecrement);
        threeToNineIncrement = findViewById(R.id.ThreeToNineIncrement);
        threeToNineDecrement = findViewById(R.id.ThreeToNineDecrement);

        //Initializing the round number for first round
        currentRound = 1;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Cannot go back!", Toast.LENGTH_SHORT).show();
    }

    /**Called when the player clicks wilds increment button*/
    public void incrementWilds(View view) {
        int currentWildCount = Integer.parseInt(wilds.getText().toString());
        currentWildCount++;
        wilds.setText(Integer.toString(currentWildCount));
    }

    /**Called when the player clicks aces increment button*/
    public void incrementAces(View view) {
        int currentAceCount = Integer.parseInt(aces.getText().toString());
        currentAceCount++;
        aces.setText(Integer.toString(currentAceCount));
    }

    /**Called when the player clicks tens through kings increment button*/
    public void incrementTensToKings(View view) {
        int currentTenToKingCount = Integer.parseInt(tenToKing.getText().toString());
        currentTenToKingCount++;
        tenToKing.setText(Integer.toString(currentTenToKingCount));
    }

    /**Called when the player clicks threes through nines increment button*/
    public void incrementThreesToNines(View view) {
        int currentThreeToNineCount = Integer.parseInt(threeToNine.getText().toString());
        currentThreeToNineCount++;
        threeToNine.setText(Integer.toString(currentThreeToNineCount));
    }

    /**Called when the player clicks wilds decrement button*/
    public void decrementWilds(View view) {
        int currentWildCount = Integer.parseInt(wilds.getText().toString());
        currentWildCount--;
        wilds.setText(Integer.toString(currentWildCount));
    }

    /**Called when the player clicks aces decrement button*/
    public void decrementAces(View view) {
        int currentAceCount = Integer.parseInt(aces.getText().toString());
        currentAceCount--;
        aces.setText(Integer.toString(currentAceCount));
    }

    /**Called when the player clicks tens through kings decrement button*/
    public void decrementTensToKings(View view) {
        int currentTenToKingCount = Integer.parseInt(tenToKing.getText().toString());
        currentTenToKingCount--;
        tenToKing.setText(Integer.toString(currentTenToKingCount));
    }

    /**Called when the player clicks threes through nines decrement button*/
    public void decrementThreesToNines(View view) {
        int currentThreeToNineCount = Integer.parseInt(threeToNine.getText().toString());
        currentThreeToNineCount--;
        threeToNine.setText(Integer.toString(currentThreeToNineCount));
    }

    /**Called when player submits score*/
    public void nextRound(View view) {
        numberOfWilds = Integer.parseInt(wilds.getText().toString());
        numberOfAces = Integer.parseInt(aces.getText().toString());
        numberOfTensToKings = Integer.parseInt(tenToKing.getText().toString());
        numberOfThreesToNines = Integer.parseInt(threeToNine.getText().toString());

        checkCardNumbers();

        if (wildsAreGood && acesAreGood && tensToKingsAreGood && threesToNinesAreGood) {
            getTotalScore();
            //Reset card counts and increment round
            wilds.setText(Integer.toString(0));
            aces.setText(Integer.toString(0));
            tenToKing.setText(Integer.toString(0));
            threeToNine.setText(Integer.toString(0));
            currentRound++;
            //Start next Round
            String string = Integer.toString(totalScore);
            score.setText("Score " + string);
            round.setText("Round " + currentRound);
        }
    }

    /**Gets the total score for the round*/
    public void getTotalScore() {
        //Get totals
        wildsTotal = numberOfWilds * 50;
        acesTotal = numberOfAces * 25;
        tenToKingTotal = numberOfTensToKings * 10;
        threeToNineTotal = numberOfThreesToNines * 5;

        //Get total score
        totalScore = wildsTotal + acesTotal + tenToKingTotal + threeToNineTotal;
    }

    /**Makes sure that the card count is possible*/
    public void checkCardNumbers() {
        if (numberOfWilds < 0 || numberOfWilds > 24) {
            Toast.makeText(this, "Invalid number of wilds!", Toast.LENGTH_SHORT).show();
            wildsAreGood = false;
        } else {
            wildsAreGood = true;
        }
        if (numberOfAces < 0 || numberOfAces > 16) {
            Toast.makeText(this, "Invalid number of aces!", Toast.LENGTH_SHORT).show();
            acesAreGood = false;
        } else {
            acesAreGood = true;
        }
        if (numberOfTensToKings < 0 || numberOfTensToKings > 64) {
            Toast.makeText(this, "Invalid number of tens or face cards!", Toast.LENGTH_LONG).show();
            tensToKingsAreGood = false;
        } else {
            tensToKingsAreGood = true;
        }
        if (numberOfThreesToNines < 0 || numberOfThreesToNines > 112) {
            Toast.makeText(this, "Invalid number of threes through nines!", Toast.LENGTH_LONG).show();
            threesToNinesAreGood = false;
        } else {
            threesToNinesAreGood = true;
        }
    }
}
