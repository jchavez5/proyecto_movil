package com.example.josechavez.proyectoseguros;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.josechavez.proyectoseguros.fragment.FragmentCalculo;
import com.example.josechavez.proyectoseguros.fragment.FragmentHome;
import com.example.josechavez.proyectoseguros.fragment.FragmentProfile;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class principal extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        BottomBar bottomBar =  findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_home);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId==R.id.tab_home){
                    FragmentHome homeFragment=new FragmentHome();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                            .addToBackStack(null).commit();
                }
                if (tabId==R.id.tab_calculo){
                    FragmentCalculo calculo=new FragmentCalculo();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,calculo)
                            .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                            .addToBackStack(null).commit();
                    Log.i("entro","entro");}

                if (tabId==R.id.tab_proflile){

                        FragmentProfile profileFragment=new FragmentProfile();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                                .addToBackStack(null).commit();
                                      }
            }
        });

    }
    public void onBackPressed() {
        finish();
    }
}

