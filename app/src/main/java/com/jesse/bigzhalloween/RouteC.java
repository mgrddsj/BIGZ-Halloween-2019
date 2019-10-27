package com.jesse.bigzhalloween;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class RouteC extends AppCompatActivity {
    int animationTime;

    FloatingActionButton fab;
    CardView c0;
    CardView c1;
    CardView c2;
    CardView c2Puzzle;
    CardView c3;
    CardView c4;
    CardView c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_c);
        scanSetup();

        animationTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        c0 = findViewById(R.id.c0);
        c0.setAlpha(0f);
        c0.animate().alpha(1f).setDuration(animationTime).setListener(null);

        // Launch c1
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                c1 = findViewById(R.id.c1);
//                showC1();
//            }
//        }, 10000);

        // launch c2
//        c2 = findViewById(R.id.c2);
//        showC2();

        // launch c3
//        c3 = findViewById(R.id.c3);
//        showC3();

        // launch c4
//        c4 = findViewById(R.id.c4);
//        showC4();

        // launch c5
//        c5 = findViewById(R.id.c5);
//        showC5();
    }

    @Override
    public void onBackPressed()
    {

    }

    public void scanSetup()
    {
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScanning();
            }
        });
    }

    public void startScanning()
    {
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);
    }

    public void showC1()
    {
        c1.setVisibility(View.VISIBLE);
        c1.setAlpha(0f);
        c1.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void showC2()
    {
        c2.setVisibility(View.VISIBLE);
        c2.setAlpha(0f);
        c2.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void showC3()
    {
        c3.setVisibility(View.VISIBLE);
        c3.setAlpha(0f);
        c3.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void showC4()
    {
        c4.setVisibility(View.VISIBLE);
        c4.setAlpha(0f);
        c4.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void showC5()
    {
        c5.setVisibility(View.VISIBLE);
        c5.setAlpha(0f);
        c5.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void c1Verify(View view)
    {
        EditText c1Input = findViewById(R.id.c1_input);
        if (c1Input.getText().toString().equals("FINAL"))
        {
            TextView c1Hidden = findViewById(R.id.c1_hidden_txt);
            final LinearLayout c1Password = findViewById(R.id.c1_password);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c1Input.getWindowToken(), 0);

            c1Hidden.setVisibility(View.VISIBLE);
            c1Password.animate().alpha(0f).setDuration(animationTime).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    c1Password.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
        else
        {
            Toast toast = Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT);
            TextView textView = toast.getView().findViewById(android.R.id.message);
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(Color.parseColor("#07000000"));
            toast.show();

            c1Input.setText("");
        }
    }

    public void c2Verify(View view)
    {
        EditText c2Input = findViewById(R.id.c2_input);
        if (c2Input.getText().toString().equals("VESSEL"))
        {
            TextView c2Hidden = findViewById(R.id.c2_hidden_txt);
            final LinearLayout c2Password = findViewById(R.id.c2_password);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c2Input.getWindowToken(), 0);

            c2Hidden.setVisibility(View.VISIBLE);
            c2Password.animate().alpha(0f).setDuration(animationTime).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    c2Password.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });

//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    showC2Puzzle();
//                }
//            }, 1000);
        }
        else
        {
            Toast toast = Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT);
            TextView textView = toast.getView().findViewById(android.R.id.message);
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(Color.parseColor("#07000000"));
            toast.show();

            c2Input.setText("");
        }
    }

    public void showC2Puzzle()
    {
        c2Puzzle = findViewById(R.id.c2_puzzle);
        c2Puzzle.setVisibility(View.VISIBLE);
        c2Puzzle.setAlpha(0f);
        c2Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void c3Verify(View view)
    {
        EditText c3Input = findViewById(R.id.c3_input);
        if (c3Input.getText().toString().equals("SENSORY"))
        {
            TextView c3Hidden = findViewById(R.id.c3_hidden_txt);
            final LinearLayout c3Password = findViewById(R.id.c3_password);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c3Input.getWindowToken(), 0);

            c3Hidden.setVisibility(View.VISIBLE);
            c3Password.animate().alpha(0f).setDuration(animationTime).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    c3Password.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
        else
        {
            Toast toast = Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT);
            TextView textView = toast.getView().findViewById(android.R.id.message);
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(Color.parseColor("#07000000"));
            toast.show();

            c3Input.setText("");
        }
    }

    public void c4Verify(View view)
    {
        EditText c4Input = findViewById(R.id.c4_input);
        if (c4Input.getText().toString().equals("PINGPONG"))
        {
            TextView c4Hidden = findViewById(R.id.c4_hidden_txt);
            final LinearLayout c4Password = findViewById(R.id.c4_password);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c4Input.getWindowToken(), 0);

            c4Hidden.setVisibility(View.VISIBLE);
            c4Password.animate().alpha(0f).setDuration(animationTime).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    c4Password.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
        else
        {
            Toast toast = Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT);
            TextView textView = toast.getView().findViewById(android.R.id.message);
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(Color.parseColor("#07000000"));
            toast.show();

            c4Input.setText("");
        }
    }

    public void c5Verify(View view)
    {
        EditText c5Input = findViewById(R.id.c5_input);
        if (c5Input.getText().toString().equals("Ahki Horatio"))
        {
            TextView c5Hidden = findViewById(R.id.c5_hidden_txt);
            final LinearLayout c5Password = findViewById(R.id.c5_password);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c5Input.getWindowToken(), 0);

            c5Hidden.setVisibility(View.VISIBLE);
            c5Password.animate().alpha(0f).setDuration(animationTime).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    c5Password.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
        else
        {
            Toast toast = Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT);
            TextView textView = toast.getView().findViewById(android.R.id.message);
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(Color.parseColor("#07000000"));
            toast.show();

            c5Input.setText("");
        }
    }
}
