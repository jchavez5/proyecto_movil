package com.example.josechavez.proyectoseguros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lvPrincipal;
    private String [] opc_Principal;
    private Intent in_principal;
    private ListViewAdapter adapter;

    int[] imagenes = {
            R.drawable.imagen1,
            R.drawable.imagen2,
            R.drawable.imagen3,
            R.drawable.imagen4

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPrincipal = findViewById(R.id.lvPrincipal);

        final ListView lista = findViewById(R.id.lvPrincipal);
        String crearE = getResources().getString(R.string.usuarios);
        String crearE2 = getResources().getString(R.string.lista_usuario);
        String crearE3 = getResources().getString(R.string.consultar);
        String crearE4 = getResources().getString(R.string.consultar_poliza);

        String[] titulos = new String[]{crearE,crearE2,crearE3,crearE4    };

        adapter = new ListViewAdapter(this,titulos, imagenes);
        lista.setAdapter(adapter);




        //opc_Principal = getResources().getStringArray(R.array.op_lista_principal);
        //ArrayAdapter<String> adpPrincipal = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc_Principal);
        //lvPrincipal.setAdapter(adpPrincipal);
        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in_principal= new Intent(MainActivity.this,CrearPersona.class);
                        startActivity(in_principal);
                        break;
                    case 1:
                        in_principal= new Intent(MainActivity.this,ListaUsuarios.class);
                        startActivity(in_principal);
                        break;

                    case 2:
                        in_principal= new Intent(MainActivity.this,ConsultarPolizas.class);
                        startActivity(in_principal);
                        break;
                    case 3:
                        in_principal= new Intent(MainActivity.this,ListaPoliza.class);
                        startActivity(in_principal);
                        break;




                }
            }
        });
    }
}
