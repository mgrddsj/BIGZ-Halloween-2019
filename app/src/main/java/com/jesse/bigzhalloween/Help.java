package com.jesse.bigzhalloween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ((TextView) findViewById(R.id.to_players_txt)).setText(Html.fromHtml(getString(R.string.txt_help)));
    }

    public void ok(View view)
    {
        Intent intent = new Intent(this, RouteSelectActivity.class);
        startActivity(intent);
    }
}
