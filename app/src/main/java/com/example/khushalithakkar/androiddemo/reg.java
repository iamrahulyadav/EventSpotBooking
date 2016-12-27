package com.example.khushalithakkar.androiddemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import android.content.Context;
import android.widget.EditText;

import static android.R.attr.checked;


public class reg extends AppCompatActivity {

    Button btnSignUp, btnClear;

    CharSequence[] values = {"Male", "Female"};
    EditText mobileno,emailid, name, gender,password,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //coordinatorLayout = (CoordinatorLayout) findViewById(R.id
        // .coordinatorLayout);
        name=(EditText)findViewById(R.id.txtname);
        emailid=(EditText)findViewById(R.id.txtemailid);
        password=(EditText)findViewById(R.id.txtpass);
        mobileno=(EditText)findViewById(R.id.txtmobile);
        add=(EditText)findViewById(R.id.txtaddress);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString();
                String mobilenum = mobileno.getText().toString();
                String name2 = emailid.getText().toString();
                if (name2.trim().equals(""))
                    name.setError("Please enter your name");
                else if (email.trim().equals(""))
                    emailid.setError("Please enter email Address");
                else if (!email.contains("@") || !email.contains("."))
                    emailid.setError("Please enter a valid email Address");
                else if (mobilenum.trim().length() < 10)
                    mobileno.setError("Not a valid mobile no");

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailid.setText("");
                mobileno.setText("");
                name.setText("");
                name.setError(null);
                emailid.setError(null);
                mobileno.setError(null);
            }
        });

        gender = (EditText) findViewById(R.id.txtgender);

        gender.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                builder.setSingleChoiceItems(values,-1, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gender.setText(values[which]);
                    }
                });
                AlertDialog alertdg=builder.create();
                alertdg.show();

            }
        });




    }
}

