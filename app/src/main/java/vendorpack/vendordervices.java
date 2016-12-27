package vendorpack;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import com.example.khushalithakkar.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class vendordervices extends Fragment {


    public vendordervices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_vendordervices,null);
        //Spinner spinner = (Spinner)view.findViewById(R.id.spinner);

        String[] SPINNERLIST = {"Catering", "Choreography", "Photography", "Decoration"};


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, SPINNERLIST);

        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                view.findViewById(R.id.spinner);
        materialDesignSpinner.setAdapter(dataAdapter);


        return view;
    }


}
