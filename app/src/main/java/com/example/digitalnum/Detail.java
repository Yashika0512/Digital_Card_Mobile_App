package com.example.digitalnum;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Detail extends Activity {
    EditText et1;
    Button bt1;
    DBadhar Dbhelper=new DBadhar(this);
    DBpan Dbpan=new DBpan(this);
    DBlicense Dblicense=new DBlicense(this);
    String id;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        et1=(EditText)findViewById(R.id.e1);
        bt1=(Button)findViewById(R.id.view);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = et1.getText().toString();
                Cursor res = Dbhelper.getData(id);
                Cursor res1 = Dbpan.getData(id);
                Cursor res2 = Dblicense.getData(id);

                if (res.getCount() == 0)
                    Toast.makeText(getApplicationContext(), "No Aadhar Card Details Entered", Toast.LENGTH_SHORT).show();
                else if (res.moveToFirst()) {

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("Card NO :" + res.getString(0) + "\n\n");
                    buffer.append("Name :" + res.getString(1) + "\n\n");
                    buffer.append("Adhar No :" + res.getString(2) + "\n\n");
                    buffer.append("Gender :" + res.getString(3) + "\n\n");
                    buffer.append("Address :" + res.getString(4) + "\n\n");
                    buffer.append("pin Code :" + res.getString(5) + "\n\n");
                    buffer.append("phone Number :" + res.getString(6) + "\n\n");


                    AlertDialog.Builder builder = new AlertDialog.Builder(Detail.this);
                    builder.setCancelable(true);
                    builder.setTitle("Your Aadhar Details");
                    builder.setMessage(buffer.toString());
                    builder.show();

                }


                if (res1.getCount() == 0)
                    Toast.makeText(getApplicationContext(), "No PanCard number Details Enterted", Toast.LENGTH_SHORT).show();
                else if (res1.moveToFirst()) {

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("Card NO :" + res1.getString(0) + "\n\n");
                    buffer.append("Name :" + res1.getString(1) + "\n\n");
                    buffer.append("Pan No :" + res1.getString(2) + "\n\n");

                    buffer.append("Address :" + res1.getString(3) + "\n\n");
                    buffer.append("pin Code :" + res1.getString(4) + "\n\n");
                    buffer.append("phone Number :" + res1.getString(5) + "\n\n");


                    AlertDialog.Builder builder = new AlertDialog.Builder(Detail.this);
                    builder.setCancelable(true);
                    builder.setTitle("Your Pancard Details");
                    builder.setMessage(buffer.toString());
                    builder.show();

                }
                if (res2.getCount() == 0)
                    Toast.makeText(getApplicationContext(), "No License Details Entered", Toast.LENGTH_SHORT).show();
                else if (res2.moveToFirst()) {

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("Card NO :" + res2.getString(0) + "\n\n");
                    buffer.append("Name :" + res2.getString(1) + "\n\n");
                    buffer.append("License No :" + res2.getString(2) + "\n\n");
                    buffer.append("Valid Upto :" + res2.getString(3) + "\n\n");
                    buffer.append("Address :" + res2.getString(4) + "\n\n");
                    buffer.append("pin Code :" + res2.getString(5) + "\n\n");
                    buffer.append("phone Number :" + res2.getString(6) + "\n\n");


                    AlertDialog.Builder builder = new AlertDialog.Builder(Detail.this);
                    builder.setCancelable(true);
                    builder.setTitle("Your License Details");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
                et1.setText("");
            }






    });

}
}