package com.example.digitalnum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Adhar extends Activity {
    Button but;
    EditText e1,e2,e3,e4,e5,e6,e7;
    DBadhar Dbhelper=new DBadhar(Adhar.this);
RadioButton r1,r2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhar);
        e1=(EditText)findViewById(R.id.edi1);
        e2=(EditText)findViewById(R.id.edi2);
        e3=(EditText)findViewById(R.id.edi3);
e4=(EditText)findViewById(R.id.edi4);
        e5=(EditText)findViewById(R.id.edi5);
        e6=(EditText)findViewById(R.id.edi6);
        e7=(EditText)findViewById(R.id.edi7);
        but=(Button)findViewById(R.id.adharadd);



        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cid=e1.getText().toString();
                String name=e2.getText().toString();
                String adharnum=e3.getText().toString();
                String gender=e4.getText().toString();
                String addr=e5.getText().toString();
                String pincode=e6.getText().toString();
                String phn=e7.getText().toString();




                Dbhelper.insertAdharDetails(cid,name,adharnum,gender,addr,pincode,phn);
               Intent intent = new Intent(Adhar.this,Selectcard.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Aadhar details inserted Successfully",Toast.LENGTH_SHORT).show();



            }
        });


    }
}