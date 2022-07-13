package com.example.moneyshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LendRequestActivity extends AppCompatActivity implements
        View.OnClickListener
{
    Button lendRequestSubmit;
    EditText lendRequestAmount;
    EditText lendRequestRoI;
    EditText lendRequestCreditScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_request);

        lendRequestAmount = findViewById(R.id.lend_activity_entered_amount);
        lendRequestRoI = findViewById(R.id.lend_activity_preferred_roi);
        lendRequestCreditScore = findViewById(R.id.lend_activity_preferred_credit_score);

        lendRequestSubmit = findViewById(R.id.submit_lend_request);
        lendRequestSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Integer amount = Integer.parseInt(lendRequestAmount.getText().toString());
        Integer roi = Integer.parseInt(lendRequestRoI.getText().toString());
        Integer creditscore = Integer.parseInt(lendRequestCreditScore.getText().toString());

        Toast.makeText(this, "Submitting lend request for amount" + amount + " Roi " + roi + " creditscore " + creditscore, Toast.LENGTH_LONG).show();


        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}
