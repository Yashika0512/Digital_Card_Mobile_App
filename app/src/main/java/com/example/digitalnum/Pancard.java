package com.example.digitalnum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class Pancard extends Activity {
    Button but;
    EditText e1,e2,e3,e5,e6,e7;
    DBpan Dbpan=new DBpan(Pancard.this);
    RadioButton r1,r2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pancard);
        e1=(EditText)findViewById(R.id.edi11);
        e2=(EditText)findViewById(R.id.edi12);
        e3=(EditText)findViewById(R.id.edi13);

        e5=(EditText)findViewById(R.id.edi15);
        e6=(EditText)findViewById(R.id.edi16);
        e7=(EditText)findViewById(R.id.edi17);
        but=(Button)findViewById(R.id.panadd);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cid=e1.getText().toString();
                String name=e2.getText().toString();
                String pannum=e3.getText().toString();

                String addr=e5.getText().toString();
                String pincode=e6.getText().toString();
                String phn=e7.getText().toString();




                Dbpan.insertPanDetails(cid,name,pannum,addr,pincode,phn);
                Intent intent = new Intent(Pancard.this,Selectcard.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Pancard Details Inserted Successfully",Toast.LENGTH_SHORT).show();



            }
        });


    }
}
