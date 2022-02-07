package com.example.digitalnum;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class View_card extends Activity {
    EditText ed1;
    Button bt1;
    DbHandler Dbuser=new DbHandler(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_card);
        ed1=(EditText)findViewById(R.id.view1);
        bt1=(Button)findViewById(R.id.detail);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usermobile=ed1.getText().toString();
                Cursor res=Dbuser.getData(usermobile);

                if (res.getCount() == 0)
                    Toast.makeText(getApplicationContext(), "No card details Exists", Toast.LENGTH_SHORT).show();
                else if (res.moveToFirst()) {

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("Card NO :" + res.getString(5) + "\n\n");
                    buffer.append("Name :" + res.getString(0) + "\n\n");
                    buffer.append("Age :" + res.getString(1) + "\n\n");
                    buffer.append("Adress :" + res.getString(2) + "\n\n");
                    buffer.append("City :" + res.getString(3) + "\n\n");
                    buffer.append("Mobile No :" + res.getString(4) + "\n\n");



                    AlertDialog.Builder builder = new AlertDialog.Builder(View_card.this);
                    builder.setCancelable(true);
                    builder.setTitle("\t\t\tYour Card Details");
                    builder.setMessage(buffer.toString());
                    builder.show();


                }
                ed1.setText("");


            }

        });


    }
}
