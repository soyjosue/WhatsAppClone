package com.inoadev.whatsappclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class AuthActivity extends AppCompatActivity {

    private CountryCodePicker countryCodePicker;
    private EditText phoneEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        getElements();

        setup();

    }

    private void setup() {

        countryCodePicker.registerCarrierNumberEditText(phoneEditText);

        nextButton.setOnClickListener(view -> {

            if(phoneEditText.getText().toString().isEmpty()) {
                emptyPhoneEtAlert();
            } else {
                verifyPhoneAlert();
            }

        });

    }

    private void verifyPhoneAlert() {

        new AlertDialog.Builder(this)
                .setMessage(Html.fromHtml("Ingresaste este número de teléfono: <br /><br /><b>" + countryCodePicker.getFormattedFullNumber() + "</b><br /><br />¿Es correcto o quieres editarlo?"))
                .setPositiveButton("Ok", (dialog, which) -> {
                    Intent intent = new Intent(AuthActivity.this, VerifyActivity.class);
                    intent.putExtra("phone", countryCodePicker.getFormattedFullNumber());
                    startActivity(intent);
                })
                .setNegativeButton("Editar", null)
                .show();

    }

    private void emptyPhoneEtAlert() {

        new AlertDialog.Builder(this)
                .setMessage("Por favor, ingresa tu número de teléfono.")
                .setPositiveButton("ok", null).show();

    }

    private void getElements() {

       countryCodePicker = (CountryCodePicker) findViewById(R.id.countryCodePicker);
       phoneEditText = (EditText) findViewById(R.id.phoneEditText);
       nextButton = (Button) findViewById(R.id.nextButton);

    }
}