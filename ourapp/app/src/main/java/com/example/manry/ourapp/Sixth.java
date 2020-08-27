package com.example.manry.ourapp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Sixth extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6;
    EditText e1,e2;
    TextView t1;
    TextToSpeech t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button13);
        b3 = (Button) findViewById(R.id.button14);
        b4 = (Button) findViewById(R.id.button15);
        b5 = (Button) findViewById(R.id.button19);
        b6 = (Button) findViewById(R.id.button20);
        e1 = (EditText) findViewById(R.id.editText8);
        e2 = (EditText) findViewById(R.id.editText9);
        t1 = (TextView) findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1, s2;
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();

                Float f1, f2, f3;
                f1 = Float.parseFloat(s1);
                f2 = Float.parseFloat(s2);
                f3 = f1 - f2;
                String s3 = Float.toString(f3);
                t1.setText(s3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1, s2;
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();

                Float f1, f2, f3;
                f1 = Float.parseFloat(s1);
                f2 = Float.parseFloat(s2);
                f3 = f1 + f2;
                String s3 = Float.toString(f3);
                t1.setText(s3);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1, s2;
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();

                Float f1, f2, f3;
                f1 = Float.parseFloat(s1);
                f2 = Float.parseFloat(s2);
                f3 = f1 * f2;
                String s3 = Float.toString(f3);
                t1.setText(s3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1, s2;
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();

                Float f1, f2, f3;
                f1 = Float.parseFloat(s1);
                f2 = Float.parseFloat(s2);
                f3 = f1 / f2;
                String s3 = Float.toString(f3);
                t1.setText(s3);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(Sixth.this, Third.class);
                startActivity(x);
                finish();
            }
        });
        t2 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t2.setLanguage(Locale.ENGLISH);
                t2.setSpeechRate(1.0f);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s8 = t1.getText().toString();
                t2.speak(s8, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

    }
    }

