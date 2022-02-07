package com.example.digitalnum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Homepage extends Activity {
    ImageView bt1,bt2,bt3,bt4;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        bt1=(ImageView) findViewById(R.id.frst);
        bt2=(ImageView) findViewById(R.id.secn);
        bt3=(ImageView) findViewById(R.id.third);
        bt4=(ImageView) findViewById(R.id.fourth);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Register.class);
                startActivity(i);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getApplicationContext(),View_card.class);
                startActivity(i3);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),Selectcard.class);
                startActivity(i1);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),Detail.class);
                startActivity(i2);
            }
        });
    }
}
