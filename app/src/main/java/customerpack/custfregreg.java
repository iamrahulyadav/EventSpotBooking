package customerpack;

import android.os.Debug;
import android.support.v4.app.FragmentActivity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

//import android.app.DialogFragment;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

import android.widget.DatePicker;
import android.app.Dialog;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;


import android.app.DatePickerDialog.OnDateSetListener;

import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

import android.os.Bundle;


import java.sql.Time;
import java.util.Calendar;
import com.example.khushalithakkar.androiddemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class custfregreg extends Fragment implements OnClickListener {


    Button btnSignUp12, btnClear1, btncal;
    private DatePickerDialog datePickerDialog;
    Button btndate;
    FragmentManager fm;
    AlertDialog.Builder builder;

    CharSequence[] values1 = {"Male", "Female"};
    EditText mobileno1, emailid1, name1, gender1, password1, add1, dob1;


    public custfregreg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custfregreg, null);
        builder = new AlertDialog.Builder(getActivity());
        FragmentActivity activity = (FragmentActivity) view.getContext();


        name1 = (EditText) view.findViewById(R.id.tname);
        emailid1 = (EditText) view.findViewById(R.id.temailid);
        password1 = (EditText) view.findViewById(R.id.tpass);
        mobileno1 = (EditText) view.findViewById(R.id.tmobile);
        add1 = (EditText) view.findViewById(R.id.taddress);
        dob1 = (EditText) view.findViewById(R.id.tdob);
        btnSignUp12 = (Button) view.findViewById(R.id.bSignUp);
        btnClear1 = (Button) view.findViewById(R.id.bClear);

        fm = activity.getSupportFragmentManager();

        btndate = (Button) view.findViewById(R.id.button8);
        btndate.setOnClickListener(this);

        gender1 = (EditText) view.findViewById(R.id.tgender);
        gender1.setOnClickListener(this);



        btnSignUp12.setOnClickListener(new View.OnClickListener()

                                       {
                                           @Override
                                           public void onClick(View v) {
                                               String email = emailid1.getText().toString();
                                               String mobilenum = mobileno1.getText().toString();
                                               String name2 = emailid1.getText().toString();
                                               if (name2.trim().equals(""))
                                                   name1.setError("Please enter your name");
                                               else if (email.trim().equals(""))
                                                   emailid1.setError("Please enter email Address");
                                               else if (!email.contains("@") || !email.contains("."))
                                                   emailid1.setError("Please enter a valid email Address");
                                               else if (mobilenum.trim().length() < 10)
                                                   mobileno1.setError("Not a valid mobile no");
                                           }
                                       }

        );

        btnClear1.setOnClickListener(new View.OnClickListener()

                                     {
                                         @Override
                                         public void onClick(View v) {
                                             emailid1.setText("");
                                             mobileno1.setText("");
                                             name1.setText("");
                                             name1.setError(null);
                                             emailid1.setError(null);
                                             mobileno1.setError(null);
                                         }
                                     }

        );

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

    OnDateSetListener ondate = new OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            dob1.setText(String.valueOf(i) + "-" + String.valueOf(i1+1) + "-" + String.valueOf(i2));

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button8:
                showDatePicker();

            case R.id.tgender:
                builder.setSingleChoiceItems(values1, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gender1.setText(values1[which]);
                    }
                });
                AlertDialog alertdg = builder.create();
                alertdg.show();
                //alertdg.cancel();



        }






        }

    }





