package com.example.sendsmsmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2;
EditText sendernumber,sendmessage;
TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendernumber = findViewById(R.id.sendnumberz);
        sendmessage = findViewById(R.id.sendmessage);

        btn1 = findViewById(R.id.sendbtn);
        btn2 = findViewById(R.id.viewbtn);

        textView1 = findViewById(R.id.txtcount);


        sendmessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int messagelenght = sendmessage.getText().length();
                textView1.setText("Letter Count is "+messagelenght);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   Toast.makeText(MainActivity.this, "Clicked..!", Toast.LENGTH_SHORT).show();
                String messagenumber =sendernumber.getText().toString();
                String messagedetailz = sendmessage.getText().toString();

                int messagetxtcount= messagenumber.length();
                int messagelength =messagedetailz.length();


                if(messagedetailz.equals("") || messagenumber.equals("")){

                    Toast.makeText(MainActivity.this, "Please Fill All Feilds To Continue..!", Toast.LENGTH_SHORT).show();

                }else if(!(messagetxtcount == 10)){

                    Toast.makeText(MainActivity.this, "Insert a valid Number..!", Toast.LENGTH_SHORT).show();



                }else if(messagelength >65){
                    Toast.makeText(MainActivity.this, "You Have Exceed the text count.!", Toast.LENGTH_SHORT).show();
                }else{
                    DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                    SQLiteDatabase sqLiteDatabase = helper.getReadableDatabase();

                    helper.insertdata(messagenumber,messagedetailz,sqLiteDatabase);

                    Toast.makeText(MainActivity.this, "Data Saved..!", Toast.LENGTH_SHORT).show();
                    Intent ii = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(ii);

                }


            }
        });
        
    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent ii = new Intent(MainActivity.this,Viewmessages.class);
            startActivity(ii);

        }
    });
        
        

        

    }

    @Override
    public void onBackPressed() {

    }
}
