package com.example.moneyshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class BorrowRequestInputActivity extends AppCompatActivity implements
        View.OnClickListener{
    EditText borrowRequestInputAmount;
    EditText borrowRequestInputRoI;
    Button borrowRequestInputSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borrow_request_input_layout);

        borrowRequestInputAmount = findViewById(R.id.borrow_request_input_amount);
        borrowRequestInputRoI = findViewById(R.id.borrow_request_input_roi);

        borrowRequestInputSubmit = findViewById(R.id.borrow_request_input_submit);
        borrowRequestInputSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        // rest call to get the lend adds
        // populate recycler view here
        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainIntent);
    }
}
