package com.example.moneyshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class AddMoneyActivity extends AppCompatActivity implements
    View.OnClickListener {

    Button addMoney;
    EditText enteredAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

        addMoney = findViewById(R.id.add_money_final);
        addMoney.setOnClickListener(this);

        enteredAmount = findViewById(R.id.add_money_entered_amount);

    }

    @Override
    public void onClick(View view) {
        // get money value and do post
        Integer add_amount = Integer.parseInt(enteredAmount.getText().toString());
        Toast.makeText(this, "Adding money to wallet" + add_amount, Toast.LENGTH_LONG).show();

        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

}
