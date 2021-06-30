package com.inoadev.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setup();

    }

    private void setup() {
        // Getting the elements of the WelcomeActivity's layout.
        acceptButton = (Button) findViewById(R.id.acceptButton);

        acceptButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
        });
    }
}