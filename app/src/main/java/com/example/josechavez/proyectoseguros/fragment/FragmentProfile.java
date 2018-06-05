package com.example.josechavez.proyectoseguros.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josechavez.proyectoseguros.MainActivity;
import com.example.josechavez.proyectoseguros.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment {


    public FragmentProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inicializas el Intent

        Intent intent = new Intent(getActivity().getApplication(), MainActivity.class);
        startActivity(intent);
        return inflater.inflate(R.layout.fragment_fragment_profile , container, false);
    }


}
