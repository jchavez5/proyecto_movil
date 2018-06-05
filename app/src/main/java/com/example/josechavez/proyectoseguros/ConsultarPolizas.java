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

public class  ConsultarPolizas extends AppCompatActivity implements AdaptadorConsulta.OnConsultaClickListener{
    private RecyclerView ListaPersona;
    private ArrayList<Persona> personas;
    private Intent i;
    private LinearLayoutManager llm;
    private AdaptadorConsulta adapter;
    private static String db = "persona";
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_polizas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListaPersona=findViewById(R.id.listaPersona);
        personas=new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorConsulta(personas,this);

        ListaPersona.setLayoutManager(llm);
        ListaPersona.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                personas.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Persona p = snapshot.getValue(Persona.class);
                        personas.add(p);

                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setPersonas(personas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
    public void crearPersonaP(View v){
        i = new Intent(ConsultarPolizas.this,CrearPersona  .class);
        startActivity(i);


    }
    @Override
    public void onConsultaClick(Persona p) {
        Intent i = new Intent(ConsultarPolizas.this,ListaPolizaXPersona.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());



        i.putExtra("datos",b);
        startActivity(i);


    }
}