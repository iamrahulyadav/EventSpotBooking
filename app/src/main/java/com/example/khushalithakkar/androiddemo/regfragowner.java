package com.example.khushalithakkar.androiddemo;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import customerpack.DatePickerFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class regfragowner extends Fragment implements View.OnClickListener {

    Button btnSignUp, btnClear,btndate2;

    FragmentManager fm;
    AlertDialog.Builder builder;

    CharSequence[] values = {"Male", "Female"};
    EditText mobileno,emailid, name, gender,password,add,dob;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_regfragowner,null);

        builder = new AlertDialog.Builder(getActivity());
        FragmentActivity activity = (FragmentActivity) view.getContext();


        name=(EditText)view.findViewById(R.id.txtname);
        emailid=(EditText)view.findViewById(R.id.txtemailid);
        password=(EditText)view.findViewById(R.id.txtpass);
        mobileno=(EditText)view.findViewById(R.id.txtmobile);
        add=(EditText)view.findViewById(R.id.txtaddress);
        dob=(EditText)view.findViewById(R.id.txtdob);

        btnSignUp = (Button)view.findViewById(R.id.btnSignUp);
        btnClear = (Button)view.findViewById(R.id.btnClear);

        fm = activity.getSupportFragmentManager();

        btndate2 = (Button) view.findViewById(R.id.button7);
        btndate2.setOnClickListener(this);

        gender = (EditText) view.findViewById(R.id.txtgender);
        gender.setOnClickListener(this);


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

        return view;
    }

    public void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();

        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH)+1);
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);

        date.setCallBack(ondate);
        date.show(fm, "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            dob.setText(String.valueOf(i) + "-" + String.valueOf(i1+1) + "-" + String.valueOf(i2));

        }
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button7:
                showDatePicker();

            case R.id.txtgender:
                builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gender.setText(values[which]);
                    }
                });
                AlertDialog alertdg = builder.create();
                alertdg.show();
                //alertdg.cancel();
        }


    }



}
