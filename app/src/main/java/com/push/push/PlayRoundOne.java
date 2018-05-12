package com.push.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PlayRoundOne extends AppCompatActivity {

    Boolean wildsAreGood, acesAreGood, tensToKingsAreGood, threesToNinesAreGood;
    Button wildsIncrement, wildsDecrement;
    EditText aces, tenToKing, threeToNine;
    TextView wilds;
    int numberOfWilds, numberOfAces, numberOfTensToKings, numberOfThreesToNines;
    int wildsTotal, acesTotal, tenToKingTotal, threeToNineTotal, totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_round_one);

        //Get ids
        wilds = findViewById(R.id.Wilds);
        aces = findViewById(R.id.Aces);
        tenToKing = findViewById(R.id.TenToKing);
        threeToNine = findViewById(R.id.ThreeToNine);
        wildsIncrement = findViewById(R.id.WildsIncrement);
        wildsDecrement = findViewById(R.id.WildsDecrement);
    }

    /**Called when the player clicks wilds increment button*/
    public void incrementWilds(View view) {
        int currentWildCount = Integer.parseInt(wilds.getText().toString());
        currentWildCount++;
        wilds.setText(Integer.toString(currentWildCount));
    }

    /**Called when the player clicks wilds decrement button*/
    public void decrementWilds(View view) {
        int currentWildCount = Integer.parseInt(wilds.getText().toString());
        currentWildCount--;
        wilds.setText(Integer.toString(currentWildCount));
    }

    /**Called when player submits score*/
    public void roundTwo(View view) {
        //Get number of each type of card
        if (!wilds.getText().toString().equals("") && !aces.getText().toString().equals("") &&
                !tenToKing.getText().toString().equals("") && !threeToNine.getText().toString().equals("")) {
            numberOfWilds = Integer.parseInt(wilds.getText().toString());
            numberOfAces = Integer.parseInt(aces.getText().toString());
            numberOfTensToKings = Integer.parseInt(tenToKing.getText().toString());
            numberOfThreesToNines = Integer.parseInt(threeToNine.getText().toString());

            checkCardNumbers();

            if (wildsAreGood && acesAreGood && tensToKingsAreGood && threesToNinesAreGood) {
                getTotalScore();
                //Start next Round
                Intent intent = new Intent(this, PlayRoundTwo.class);
                intent.putExtra("total", Integer.toString(totalScore));
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Must enter a valid number!", Toast.LENGTH_SHORT).show();
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
