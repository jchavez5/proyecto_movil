package com.example.josechavez.proyectoseguros;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class   ListaPoliza extends AppCompatActivity implements AdaptadorPoliza.OnPolizaClickListener {
    private RecyclerView ListaPoliza;
    private ArrayList<Poliza> polizas;
    private Intent i;
    private LinearLayoutManager llm;
    private AdaptadorPoliza adapter;
    private static String db_poliza = "poliza";
    private DatabaseReference databaseReference;
    private int valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_poliza);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListaPoliza=findViewById(R.id.ListaPoliza);
        polizas=new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorPoliza(polizas,this);

        ListaPoliza.setLayoutManager(llm);
        ListaPoliza.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(db_poliza).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                polizas.clear();

                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Poliza p = snapshot.getValue(Poliza.class);
                        polizas.add(p);
                    }
                }


                adapter.notifyDataSetChanged();
                Datos.setPoliza(polizas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void crearpoliza(View v){
        i = new Intent(ListaPoliza.this,ListaUsuarios  .class);
        startActivity(i);


    }

    @Override
    public void onPolizaClick(Poliza p) {
        Intent i = new Intent(ListaPoliza.this,DetallePoliza.class);
        Bundle b = new Bundle();


        i.putExtra("datos",b);
        startActivity(i);

    }
}
