package com.example.digitalnum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class License extends Activity {
    Button but;
    EditText e1,e2,e3,e4,e5,e6,e7;
    DBlicense Dblicense=new DBlicense(License.this);
    RadioButton r1,r2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.license);
        e1=(EditText)findViewById(R.id.edi21);
        e2=(EditText)findViewById(R.id.edi22);
        e3=(EditText)findViewById(R.id.edi23);
        e4=(EditText)findViewById(R.id.edi24);
        e5=(EditText)findViewById(R.id.edi25);
        e6=(EditText)findViewById(R.id.edi26);
        e7=(EditText)findViewById(R.id.edi27);
        but=(Button)findViewById(R.id.licenseadd);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cid=e1.getText().toString();
                String name=e2.getText().toString();
                String licensenum=e3.getText().toString();
                String valid=e4.getText().toString();
                String addr=e5.getText().toString();
                String pincode=e6.getText().toString();
                String phn=e7.getText().toString();




                Dblicense.insertAdharDetails(cid,name,licensenum,valid,addr,pincode,phn);
                Intent intent = new Intent(License.this,Selectcard.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "License Details Inserted Successfully",Toast.LENGTH_SHORT).show();



            }
        });


    }
}