package com.example.khushalithakkar.androiddemo;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import customerpack.custfregreg;
import vendorpack.regvendor;
import vendorpack.vendordervices;

public class categorythree extends FragmentActivity {


    Button btnowner,btnvendor,btncustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorythree);

        btnowner=(Button)findViewById(R.id.imageButton2);
        btnvendor=(Button)findViewById(R.id.imageButton);
        btncustomer=(Button)findViewById(R.id.imageButton3);



        btnowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regfragowner rf= new regfragowner();
                FragmentTransaction ft= getFragmentManager().beginTransaction();
                ft.add(android.R.id.content,rf);
                ft.commit();


            }
        });

        btnvendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vendordervices rv= new vendordervices();
                FragmentTransaction ft= getFragmentManager().beginTransaction();
                ft.add(android.R.id.content,rv);
                ft.commit();

            }
        });

        btncustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                custfregreg cfr=new custfregreg ();
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.add(android.R.id.content,cfr);
                ft.commit();
            }
        });
    }
}
