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
import java.util.Iterator;

public class ListaPolizaXPersona extends AppCompatActivity implements AdaptadorPolizaPersona.OnPolizaPersonaClickListener {
    private RecyclerView ListaPolizaPersona;
    private ArrayList<Poliza> polizas;
    private Intent i;
    private LinearLayoutManager llm;
    private AdaptadorPolizaPersona adapter;
    private static String db_poliza = "poliza";
    private DatabaseReference databaseReference;
    private Bundle bundle;
    private String id_persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_poliza_xpersona);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListaPolizaPersona=findViewById(R.id.ListaPolizaXpersona);
        polizas=new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorPolizaPersona(polizas,this);

        i=getIntent();
        bundle=i.getBundleExtra("datos");
        id_persona=bundle.getString("id");


        ListaPolizaPersona.setLayoutManager(llm);
        ListaPolizaPersona.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(db_poliza).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                polizas.clear();
                Iterable<DataSnapshot> snapshotIterable=dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator=snapshotIterable.iterator();
                while (iterator.hasNext()){
                    DataSnapshot snapshot=iterator.next();
                    Poliza p = snapshot.getValue(Poliza.class);
                        if (p.getId_usuario().equals(id_persona)){
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
    public void crearPolizap(View v){
        i = new Intent(ListaPolizaXPersona.this,ListaUsuarios  .class);
        startActivity(i);


    }


    @Override
    public void onPolizaPersonaClick(Poliza p) {

    }
}
