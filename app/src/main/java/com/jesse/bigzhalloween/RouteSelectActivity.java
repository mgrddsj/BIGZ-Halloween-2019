package com.jesse.bigzhalloween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RouteSelectActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_select);
        sharedPreferences = this.getSharedPreferences("progress", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        redirectToRoute();

        /*
            Route:
            C = 1
            A = 2
            H = 3
            P = 4
            F = 5
         */
    }

    public void redirectToRoute()
    {
        Intent intent;
        switch (sharedPreferences.getInt("route", 0))
        {
            case 1:
                Toast.makeText(this, "App force closure/crash detected, \nresuming last game. ", Toast.LENGTH_LONG).show();
                intent = new Intent(this, RouteC.class);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(this, "App force closure/crash detected, \nresuming last game. ", Toast.LENGTH_LONG).show();
                intent = new Intent(this, RouteA.class);
                startActivity(intent);
                break;
            case 3:
                Toast.makeText(this, "App force closure/crash detected, \nresuming last game. ", Toast.LENGTH_LONG).show();
                intent = new Intent(this, RouteH.class);
                startActivity(intent);
                break;
            case 4:
                Toast.makeText(this, "App force closure/crash detected, \nresuming last game. ", Toast.LENGTH_LONG).show();
                intent = new Intent(this, RouteP.class);
                startActivity(intent);
                break;
            case 5:
                Toast.makeText(this, "App force closure/crash detected, \nresuming last game. ", Toast.LENGTH_LONG).show();
                intent = new Intent(this, RouteF.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void gotoRouteC(View view)
    {
        editor.putInt("route", 1);
        editor.commit();

        Intent intent = new Intent(this, RouteC.class);
        startActivity(intent);
    }

    public void gotoRouteA(View view)
    {
        editor.putInt("route", 2);
        editor.commit();

        Intent intent = new Intent(this, RouteA.class);
        startActivity(intent);
    }

    public void gotoRouteH(View view)
    {
        editor.putInt("route", 3);
        editor.commit();

        Intent intent = new Intent(this, RouteH.class);
        startActivity(intent);
    }

    public void gotoRouteP(View view)
    {
        editor.putInt("route", 4);
        editor.commit();

        Intent intent = new Intent(this, RouteP.class);
        startActivity(intent);
    }

    public void gotoRouteF(View view)
    {
        editor.putInt("route", 5);
        editor.commit();

        Intent intent = new Intent(this, RouteF.class);
        startActivity(intent);
    }
}
