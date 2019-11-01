package com.jesse.bigzhalloween;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ExtraChallengeActivity extends AppCompatActivity {
    int animationTime;

    CardView all1;
    CardView all1Puzzle;
    CardView all2;
    CardView all2Puzzle;

    int currentProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_challenge);
        animationTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        ((TextView) findViewById(R.id.all0_txt)).setText(Html.fromHtml(getString(R.string.txt_all0)));
        ((TextView) findViewById(R.id.all0_txt_hidden)).setText(Html.fromHtml(getString(R.string.txt_hidden_all0)));

        all1 = findViewById(R.id.all1);
        all2 = findViewById(R.id.all2);
        currentProgress = 1;
    }
    public void startScanning(View view)
    {
        Intent intent = new Intent(ExtraChallengeActivity.this, ScannerActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                Bundle resultBundle = data.getExtras();
                int resultInt = resultBundle.getInt("result");
                switch (resultInt) {
                    case 71:
                        showAll1();
                        currentProgress++;
                        break;
                    case 72:
                        if (currentProgress > 1)
                            showAll2();
                        break;
                    case 61:
                        SharedPreferences sharedPreferences = this.getSharedPreferences("progress", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("route", 0);
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        editor.commit();
                        break;
                    default:
                        Toast.makeText(this, "Cannot recognize this QR code. ", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }

    public void showAll1()
    {
        all1.setVisibility(View.VISIBLE);
        all1.setAlpha(0f);
        all1.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void showAll1Puzzle()
    {
        all1Puzzle = findViewById(R.id.all1_puzzle);
        all1Puzzle.setVisibility(View.VISIBLE);
        all1Puzzle.setAlpha(0f);
        all1Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void all1Verify(View view)
    {
        EditText all1Input = findViewById(R.id.all1_input);
        if (all1Input.getText().toString().equalsIgnoreCase("tulansunasaptaenneikhalasinclair"))
        {
            TextView all1Hidden = findViewById(R.id.all1_hidden_txt);
            final LinearLayout all1Password = findViewById(R.id.all1_password);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(all1Input.getWindowToken(), 0);

            all1Hidden.setVisibility(View.VISIBLE);
            all1Password.animate().alpha(0f).setDuration(animationTime).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    all1Password.setVisibility(View.GONE);
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
//                    showAll1Puzzle();
//                }
//            }, 1000);
        }
        else
        {
            Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT).show();
            all1Input.setText("");
        }
    }

    public void showAll2()
    {
        all2.setVisibility(View.VISIBLE);
        all2.setAlpha(0f);
        all2.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void showAll2Puzzle()
    {
        all2Puzzle = findViewById(R.id.all2_puzzle);
        all2Puzzle.setVisibility(View.VISIBLE);
        all2Puzzle.setAlpha(0f);
        all2Puzzle.animate().alpha(1f).setDuration(animationTime).setListener(null);
    }

    public void all2Verify(View view)
    {
        EditText all2Input = findViewById(R.id.all2_input);
        if (all2Input.getText().toString().equalsIgnoreCase("descend"))
        {
            TextView all2Hidden = findViewById(R.id.all2_hidden_txt);
            final LinearLayout all2Password = findViewById(R.id.all2_password);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(all2Input.getWindowToken(), 0);

            all2Hidden.setVisibility(View.VISIBLE);
            all2Password.animate().alpha(0f).setDuration(animationTime).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    all2Password.setVisibility(View.GONE);
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
//                    showAll2Puzzle();
//                }
//            }, 1000);
        }
        else
        {
            Toast.makeText(this, "Wrong password! ", Toast.LENGTH_SHORT).show();
            all2Input.setText("");
        }
    }
}
