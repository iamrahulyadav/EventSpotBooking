package vendorpack;


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

import com.example.khushalithakkar.androiddemo.R;

import java.util.Calendar;

import customerpack.DatePickerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class regvendor extends Fragment implements View.OnClickListener {


    public regvendor() {
        // Required empty public constructor
    }

    Button btnSignUp2, btnClear2,btndate1;
    FragmentManager fm;
    AlertDialog.Builder builder;

    CharSequence[] values2 = {"Male", "Female"};
    EditText mobileno2, emailid2, name2, gender2, password2, add2, website2, dob2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_regvendor, null);
        builder = new AlertDialog.Builder(getActivity());
        FragmentActivity activity = (FragmentActivity) view.getContext();


        name2 = (EditText) view.findViewById(R.id.txname);
        emailid2 = (EditText) view.findViewById(R.id.txemailid);
        password2 = (EditText) view.findViewById(R.id.txpass);
        mobileno2 = (EditText) view.findViewById(R.id.txmobile);
        add2 = (EditText) view.findViewById(R.id.txaddress);
        dob2=(EditText)view.findViewById(R.id.txdob);

        btnSignUp2 = (Button) view.findViewById(R.id.btSignUp);
        btnClear2 = (Button) view.findViewById(R.id.btClear);
        fm = activity.getSupportFragmentManager();

        gender2 = (EditText) view.findViewById(R.id.txgender);
        gender2.setOnClickListener(this);

        btndate1=(Button)view.findViewById(R.id.button9);
        btndate1.setOnClickListener(this);


        btnSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid2.getText().toString();
                String mobilenum = mobileno2.getText().toString();
                String name3 = emailid2.getText().toString();
                if (name3.trim().equals(""))
                    name2.setError("Please enter your name");
                else if (email.trim().equals(""))
                    emailid2.setError("Please enter email Address");
                else if (!email.contains("@") || !email.contains("."))
                    emailid2.setError("Please enter a valid email Address");
                else if (mobilenum.trim().length() < 10)
                    mobileno2.setError("Not a valid mobile no");
            }
        });

        btnClear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailid2.setText("");
                mobileno2.setText("");
                name2.setText("");
                name2.setError(null);
                emailid2.setError(null);
                mobileno2.setError(null);
            }
        });

        return view;
    }

    public void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();

        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH) + 1);
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);

        date.setCallBack(ondate);
        date.show(fm, "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            dob2.setText(String.valueOf(i) + "-" + String.valueOf(i1 + 1) + "-" + String.valueOf(i2));

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button9:
                showDatePicker();

            case R.id.txgender:
                builder.setSingleChoiceItems(values2, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gender2.setText(values2[which]);
                    }
                });
                AlertDialog alertdg = builder.create();
                alertdg.show();
                //alertdg.cancel();


        }


    }
}
