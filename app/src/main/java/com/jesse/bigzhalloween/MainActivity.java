package com.jesse.bigzhalloween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences sharedPreferences = this.getSharedPreferences("progress", Context.MODE_PRIVATE);
    }

    public void start(View view)
    {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
}
