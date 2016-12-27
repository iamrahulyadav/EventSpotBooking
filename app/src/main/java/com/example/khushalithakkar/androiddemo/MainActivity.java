package com.example.khushalithakkar.androiddemo;

import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button btnSignUp, btnClear;
    AutoCompleteTextView txtmobileno, txtemailid, txtname,txtaddress,txtpass,txtgender,txtdob;
   // private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //coordinatorLayout = (CoordinatorLayout) findViewById(R.id
               // .coordinatorLayout);

        //Format code here
        //Format again - Test Branch


        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtemailid.getText().toString();
                String mobileno = txtmobileno.getText().toString();
                String name = txtemailid.getText().toString();
                if (name.trim().equals(""))
                    txtname.setError("Please enter your name");
                else if (email.trim().equals(""))
                    txtemailid.setError("Please enter email Address");
                else if (!email.contains("@") || !email.contains("."))
                    txtemailid.setError("Please enter a valid email Address");
                else if (mobileno.trim().length() < 10)
                    txtmobileno.setError("Not a valid mobile no"); // I'm finding solution to validate mobile no


            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtemailid.setText("");
                txtmobileno.setText("");
                txtname.setText("");
                txtname.setError(null);
                txtemailid.setError(null);
                txtmobileno.setError(null);
            }
        });
    }


}
