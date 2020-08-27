package com.example.manry.ourapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Seventhf extends AppCompatActivity {
    TextView t1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventhf);
        t1=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.button18);
        t1.setText("your score is"+Seventh.score);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Seventhf.this,Seventh.class);
                startActivity(i);
                finish();
            }
        });
    }
}
