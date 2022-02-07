package com.example.digitalnum;



import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Register extends AppCompatActivity {
    EditText name,age,addres,mobile,city;
    Button saveBtn;
    DbHandler Dbuser=new DbHandler(this);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name = (EditText)findViewById(R.id.txtName);
        age = (EditText)findViewById(R.id.txtage);
        addres = (EditText)findViewById(R.id.txtaddr);
        mobile=(EditText)findViewById(R.id.txtmobile);
        city=(EditText)findViewById(R.id.txtcity);
        saveBtn = (Button)findViewById(R.id.btnSave);



        EditText Output_Generated_Number=

                (EditText) findViewById(R.id.card);
        final Random numRandom = new Random();
        Output_Generated_Number.setText(String.valueOf(numRandom.nextInt(1000000000)));


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString()+"\n";
                String userage = age.getText().toString();
                String useraddr = addres.getText().toString();
                String usercity = city.getText().toString();
                String usermobile=mobile.getText().toString();
                String Card_number=Output_Generated_Number.getText().toString();
                Dbuser.insertUserDetails(username,userage,useraddr,usercity,usermobile,Card_number);


                Cursor res=Dbuser.getData(usermobile);



                if (res.getCount() == 0)
                    Toast.makeText(getApplicationContext(), "No Registered Sucessfully", Toast.LENGTH_SHORT).show();
                else if (res.moveToFirst()) {

                    StringBuffer buffer = new StringBuffer();

                    buffer.append("Card NO :" + res.getString(5) + "\n\n");
                    buffer.append("Name :" + res.getString(0) + "\n\n");
                    buffer.append("Age :" + res.getString(1) + "\n\n");
                    buffer.append("Address :" + res.getString(2) + "\n\n");
                    buffer.append("City :" + res.getString(3) + "\n\n");
                    buffer.append("Mobile No :" + res.getString(4) + "\n\n");



                    AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                    builder.setCancelable(true);
                    builder.setTitle("\t\t\tYour Card Details");
                    builder.setMessage(buffer.toString());
                    builder.show();


                }
                name.setText("");
                age.setText("");
                addres.setText("");
                mobile.setText("");
                city.setText("");


            }
        });




    }
}