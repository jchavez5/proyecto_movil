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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPrincipal = findViewById(R.id.lvPrincipal);
        opc_Principal = getResources().getStringArray(R.array.op_lista_principal);
        ArrayAdapter<String> adpPrincipal = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc_Principal);
        lvPrincipal.setAdapter(adpPrincipal);
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

                }
            }
        });
    }
}
