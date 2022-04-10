package com.example.moneyshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {
    private Button saveProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        saveProfileButton = (Button) findViewById(R.id.button_save_profile);
        saveProfileButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}
