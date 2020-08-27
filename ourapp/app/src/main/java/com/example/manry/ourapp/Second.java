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

public class Second extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1=(Button)findViewById(R.id.b);
        b2=(Button)findViewById(R.id.button3);

        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText5);
        e4=(EditText)findViewById(R.id.editText6);
        e5=(EditText)findViewById(R.id.editText7);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(Second.this, "Fill all", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    SQLiteDatabase db=openOrCreateDatabase("netcamp",MODE_PRIVATE,null);//no other app should use this database
                    db.execSQL("create table if not exists diya (name varchar,password varchar,email varchar)");
                    String s4="select * from diya where name='"+s1+"' and email='"+s3+"'";//to store a value in android you can use cursor class
                    Cursor cursor=db.rawQuery(s4,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Second.this, "user exists", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(Second.this,MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                    else {
                        db.execSQL("insert into diya values('" + s1 + "','" + s2 + "','" + s3 + "')");
                        Toast.makeText(Second.this, "database updated", Toast.LENGTH_SHORT).show();
                        Intent k = new Intent(Second.this, MainActivity.class);
                        startActivity(k);
                        finish();
                    }
                }
            }
        });
    }
}

