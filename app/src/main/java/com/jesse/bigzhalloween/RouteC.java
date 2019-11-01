package com.jesse.bigzhalloween;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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

    int currentProgress;

    MediaPlayer audioText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_c);

        animationTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        c0 = findViewById(R.id.c0);
        c0.setAlpha(0f);
        c0.animate().alpha(1f).setDuration(animationTime).setListener(null);
        ((TextView) findViewById(R.id.c0_txt)).setText(Html.fromHtml(getString(R.string.txt_c0)));

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        currentProgress = 1;

        // Audio text
        audioText = MediaPlayer.create(this, R.raw.sum);
        audioText.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                ((ImageView) findViewById(R.id.c2_audio_button)).setImageResource(R.drawable.ic_play);
            }
        });
        final SeekBar seekBar = findViewById(R.id.c2_audio_seekbar);
        final Handler handler = new Handler();
        seekBar.setMax(audioText.getDuration());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(audioText.getCurrentPosition());
                handler.postDelayed(this, 100);
            }
        };
        runnable.run();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b)
                {
                    audioText.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onBackPressed()
    {
        // Do nothing when back is pressed.
        Toast.makeText(this, "Don't lose your determination! \nYou can't change the character once selected. ", Toast.LENGTH_SHORT).show();
    }

    public void startScanning(View view)
    {
        Intent intent = new Intent(RouteC.this, ScannerActivity.class);
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
                    case 11:
                        if (currentProgress>=1)
                        {
                            showC1();
                            currentProgress++;
                        }
                        else
                        {
                            Toast.makeText(this, "You are not there yet. \nTry another QR code. ", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 12:
                        if (currentProgress>=2)
                        {
                            showC2();
                            currentProgress++;
                        }
                        else
                        {
                            Toast.makeText(this, "You are not there yet. \nTry another QR code. ", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 13:
                        if (currentProgress>=3)
                        {
                            showC3();
                            currentProgress++;
                        }
                        else
                        {
                            Toast.makeText(this, "You are not there yet. \nTry another QR code. ", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 14:
                        if (currentProgress>=4)
                        {
                            showC4();
                            currentProgress++;
                        }
                        else
                        {
                            Toast.makeText(this, "You are not there yet. \nTry another QR code. ", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 15:
                        if (currentProgress>=5)
                        {
                            showC5();
                            currentProgress++;
                        }
                        else
                        {
                            Toast.makeText(this, "You are not there yet. \nTry another QR code. ", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 16:
                        if (currentProgress>=6)
                        {
                            showCSuspect();
                            currentProgress++;
                        }
                        else
                        {
                            Toast.makeText(this, "You are not there yet. \nTry another QR code. ", Toast.LENGTH_SHORT).show();
                        }
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

    public void start(View view)
    {
        Intent intent = new Intent(this, HelpInGame.class);
        startActivity(intent);
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
        if (c1Input.getText().toString().equalsIgnoreCase("syferliste"))
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
        if (c2Input.getText().toString().equalsIgnoreCase("final"))
        {
            TextView c2Hidden = findViewById(R.id.c2_hidden_txt);
            final LinearLayout c2Password = findViewById(R.id.c2_password);
            LinearLayout c2Audio = findViewById(R.id.c2_audio);

            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c2Input.getWindowToken(), 0);

            c2Hidden.setVisibility(View.VISIBLE);
            c2Audio.setVisibility(View.VISIBLE);
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
        if (c3Input.getText().toString().equalsIgnoreCase("vessel"))
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
        if (c4Input.getText().toString().equalsIgnoreCase("sensory"))
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
        if (c5Input.getText().toString().equalsIgnoreCase("pingpong"))
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
            case R.id.c_suspect_4:
                startActivity(new Intent(this, Congrats.class));
                break;
            default:
                Toast.makeText(this, "Wrong answer, try again! ", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void playButton(View view)
    {
        ImageView imageView = (ImageView) view;
        if (!audioText.isPlaying())
        {
            imageView.setImageResource(R.drawable.ic_pause);
            audioText.start();
        }
        else
        {
            imageView.setImageResource(R.drawable.ic_play);
            audioText.pause();
        }
    }
}
