package com.example.josechavez.proyectoseguros.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josechavez.proyectoseguros.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCalculo extends Fragment {


    public FragmentCalculo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_calculo, container, false);
    }

}
