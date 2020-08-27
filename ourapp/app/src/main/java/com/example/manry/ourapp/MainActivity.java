package com.example.manry.ourapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manry.ourapp.R;
import com.example.manry.ourapp.Second;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "fill all", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    SQLiteDatabase db=openOrCreateDatabase("netcamp",MODE_PRIVATE,null);
                    db.execSQL("create table if not exists diya (name varchar,password varchar,email varchar)");
                    String s3="select * from diya where name='"+s1+"' and password='"+s2+"'";
                    Cursor cursor=db.rawQuery(s3,null);
                    if(cursor.getCount()>0) {
                        Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(MainActivity.this, Third.class);
                        startActivity(j);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "sorry", Toast.LENGTH_SHORT).show();
                        Intent k=new Intent(MainActivity.this,Second.class);
                        startActivity(k);
                        finish();
                    }
                }
            }
        });
    }
}
