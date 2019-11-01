package com.jesse.bigzhalloween;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Congrats extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.all_0_txt);
                textView.setText(Html.fromHtml(getString(R.string.txt_all0)));
                textView.setVisibility(View.VISIBLE);
                textView.setAlpha(0f);
                textView.animate().alpha(1f).setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime)).setListener(null);

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Button button = findViewById(R.id.all_0_ok);
                        button.setVisibility(View.VISIBLE);
                        button.setAlpha(0f);
                        button.animate().alpha(1f).setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime)).setListener(null);
                    }
                }, 3000);
            }
        }, 3000);
    }

    public void gotoExtraChallenge(View view)
    {
        Intent intent = new Intent(this, ExtraChallengeActivity.class);
        startActivity(intent);
    }

}
