package com.example.raplaapp;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button submitURLButton;
    EditText insertURLText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitURLButton = findViewById(R.id.submitURL);
        insertURLText = findViewById(R.id.inputRaplaLink);
        submitURLButton.setOnClickListener(view -> {
            String url = insertURLText.getText().toString();
            if (!url.startsWith("https://")) {
                url = "https://" + url;
            }
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        });
    }
}