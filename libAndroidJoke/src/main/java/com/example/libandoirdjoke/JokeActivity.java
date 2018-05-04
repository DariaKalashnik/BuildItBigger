package com.example.libandoirdjoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity{

    public static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView mJokeText = findViewById(R.id.joke_text);
        String joke = getIntent().getStringExtra(JOKE_KEY);
        mJokeText.setText(joke);
    }

}


