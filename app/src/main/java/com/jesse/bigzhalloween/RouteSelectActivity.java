package com.jesse.bigzhalloween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RouteSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_select);
    }

    public void gotoRouteC(View view)
    {
        Intent intent = new Intent(this, RouteC.class);
        startActivity(intent);
    }
}
