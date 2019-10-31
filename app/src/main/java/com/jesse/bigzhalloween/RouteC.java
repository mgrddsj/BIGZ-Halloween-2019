package com.jesse.bigzhalloween;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class RouteC extends AppCompatActivity {
    int animationTime;

    FloatingActionButton fab;
    CardView c0;
    CardView c1;
    CardView c1Puzzle;
    CardView c2;
    CardView c2Puzzle;
    CardView c3;
    CardView c3Puzzle;
    CardView c4;
    CardView c4Puzzle;
    CardView c5;
    CardView c5Puzzle;
    CardView cSuspect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_c);
        fabSetup();

        animationTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        c0 = findViewById(R.id.c0);
        c0.setAlpha(0f);
        c0.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c0_txt)).setText(Html.fromHtml(getString(R.string.txt_c0)));

        // Launch c1
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
                c1 = findViewById(R.id.c1);
                showC1();
//            }
//        }, 10000);

        // launch c2
        c2 = findViewById(R.id.c2);
        showC2();

        // launch c3
        c3 = findViewById(R.id.c3);
        showC3();

        // launch c4
        c4 = findViewById(R.id.c4);
        showC4();

        // launch c5
        c5 = findViewById(R.id.c5);
        showC5();

        // launch suspect selection
        showCSuspect();
    }

    @Override
    public void onBackPressed()
    {
        // Do nothing when back is pressed.
    }

    public void fabSetup()
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
        startActivityForResult(intent, 233);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 233)
        {
            if (resultCode == RESULT_OK);
            {
                Bundle scanResult = Objects.requireNonNull(data).getExtras();
                int scanResultInt = (Integer)scanResult.get("result");
                switch (scanResultInt)
                {
                    case 11:
                        showC1();
                    case 12:
                        showC2();
                    case 13:
                        showC3();
                    case 14:
                        showC4();
                    case 15:
                        showC5();
                    case 16:
                        showCSuspect();
                    default:
                        Toast.makeText(this, "The QR Code you scanned cannot be recognized. ", Toast.LENGTH_SHORT);
                }
            }
        }
    }

    public void showC1()
    {
        c1.setVisibility(View.VISIBLE);
        c1.setAlpha(0f);
        c1.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c1_hidden_txt)).setText(Html.fromHtml(getString(R.string.txt_hidden_c1)));
    }

    public void showC1Puzzle()
    {
        c1Puzzle = findViewById(R.id.c1_puzzle);
        c1Puzzle.setVisibility(View.VISIBLE);
        c1Puzzle.setAlpha(0f);
        c1Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c1_puzzle_txt)).setText(Html.fromHtml(getString(R.string.txt_c1_puzzle)));
    }

    public void showC2()
    {
        c2.setVisibility(View.VISIBLE);
        c2.setAlpha(0f);
        c2.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c2_hidden_txt)).setText(Html.fromHtml(getString(R.string.txt_hidden_c2)));
    }

    public void showC2Puzzle()
    {
        c2Puzzle = findViewById(R.id.c2_puzzle);
        c2Puzzle.setVisibility(View.VISIBLE);
        c2Puzzle.setAlpha(0f);
        c2Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c2_puzzle_txt)).setText(Html.fromHtml(getString(R.string.txt_c2_puzzle)));
    }

    public void showC3()
    {
        c3.setVisibility(View.VISIBLE);
        c3.setAlpha(0f);
        c3.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c3_hidden_txt)).setText(Html.fromHtml(getString(R.string.txt_hidden_c3)));
    }

    public void showC3Puzzle()
    {
        c3Puzzle = findViewById(R.id.c3_puzzle);
        c3Puzzle.setVisibility(View.VISIBLE);
        c3Puzzle.setAlpha(0f);
        c3Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c3_puzzle_txt)).setText(Html.fromHtml(getString(R.string.txt_c3_puzzle)));
    }

    public void showC4()
    {
        c4.setVisibility(View.VISIBLE);
        c4.setAlpha(0f);
        c4.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c4_hidden_txt)).setText(Html.fromHtml(getString(R.string.txt_hidden_c4)));
    }

    public void showC4Puzzle()
    {
        c4Puzzle = findViewById(R.id.c4_puzzle);
        c4Puzzle.setVisibility(View.VISIBLE);
        c4Puzzle.setAlpha(0f);
        c4Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c4_puzzle_txt)).setText(Html.fromHtml(getString(R.string.txt_c4_puzzle)));
    }

    public void showC5()
    {
        c5.setVisibility(View.VISIBLE);
        c5.setAlpha(0f);
        c5.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c5_hidden_txt)).setText(Html.fromHtml(getString(R.string.txt_hidden_c5)));
    }

    public void showC5Puzzle()
    {
        c5Puzzle = findViewById(R.id.c5_puzzle);
        c5Puzzle.setVisibility(View.VISIBLE);
        c5Puzzle.setAlpha(0f);
        c5Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c5_puzzle_txt)).setText(Html.fromHtml(getString(R.string.txt_c5_puzzle)));
    }

    public void showCSuspect()
    {
        cSuspect = findViewById(R.id.c_suspect_selection);
        cSuspect.setVisibility(View.VISIBLE);
        cSuspect.setAlpha(0f);
        cSuspect.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void c1Verify(View view)
    {
        EditText c1Input = findViewById(R.id.c1_input);
        if (c1Input.getText().toString().equals("syferliste"))
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

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showC1Puzzle();
                }
            }, 1000);
        }
        else
        {
            Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT).show();
            c1Input.setText("");
        }
    }

    public void c2Verify(View view)
    {
        EditText c2Input = findViewById(R.id.c2_input);
        if (c2Input.getText().toString().equals("final"))
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

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showC2Puzzle();
                }
            }, 1000);
        }
        else
        {
            Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT).show();
            c2Input.setText("");
        }
    }

    public void c3Verify(View view)
    {
        EditText c3Input = findViewById(R.id.c3_input);
        if (c3Input.getText().toString().equals("vessel"))
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
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showC3Puzzle();
                }
            }, 1000);
        }
        else
        {
            Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT).show();
            c3Input.setText("");
        }
    }

    public void c4Verify(View view)
    {
        EditText c4Input = findViewById(R.id.c4_input);
        if (c4Input.getText().toString().equals("sensory"))
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
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showC4Puzzle();
                }
            }, 1000);
        }
        else
        {
            Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT).show();
            c4Input.setText("");
        }
    }

    public void c5Verify(View view)
    {
        EditText c5Input = findViewById(R.id.c5_input);
        if (c5Input.getText().toString().equals("pingpong"))
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
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showC5Puzzle();
                }
            }, 1000);
        }
        else
        {
            Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT).show();
            c5Input.setText("");
        }
    }

    public void checkSuspect(View view)
    {
        RadioGroup radioGroup = findViewById(R.id.c_suspect_radio_group);
        int checkButton = radioGroup.getCheckedRadioButtonId();
        switch (checkButton)
        {
            case R.id.c_suspect_1:
                break;
            case R.id.c_suspect_2:
                break;
            case R.id.c_suspect_3:
                break;
            case R.id.c_suspect_4:
                break;
            case R.id.c_suspect_5:
                break;
            default:
                break;
        }
    }
}
