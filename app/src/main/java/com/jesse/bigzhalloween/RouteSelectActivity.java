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

    public void gotoRouteA(View view)
    {
        Intent intent = new Intent(this, RouteA.class);
        startActivity(intent);
    }

    public void gotoRouteH(View view)
    {
        Intent intent = new Intent(this, RouteH.class);
        startActivity(intent);
    }

    public void gotoRouteP(View view)
    {
        Intent intent = new Intent(this, RouteP.class);
        startActivity(intent);
    }

    public void gotoRouteF(View view)
    {
        Intent intent = new Intent(this, RouteF.class);
        startActivity(intent);
    }
}
