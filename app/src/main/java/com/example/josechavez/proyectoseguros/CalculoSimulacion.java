package com.example.josechavez.proyectoseguros;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class CalculoSimulacion extends Activity {
    private RadioGroup opcion1, opcion2;
    private EditText cantidad, precio;
    private Button consultar;
    private Spinner spinner;

    private int valor;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_simulacion);
        opcion1 = findViewById(R.id.Radio1);
        opcion2 = findViewById(R.id.Radio2);
        cantidad = findViewById(R.id.txtcantidad);
        precio = findViewById(R.id.txtprecio);
        consultar = findViewById(R.id.button);
        spinner = findViewById(R.id.spinnerGamma);
        recursos = this.getResources();
    }

    public void mostrar (View v){
        if (validar()) {
            total();
            int n = Integer.parseInt(cantidad.getText().toString());
            valor *= n;

            precio.setText(valor + "");
        }
        Toast.makeText(CalculoSimulacion.this,"Recuerde: Este es el valor de la Póliza Consultada: "+(valor), Toast.LENGTH_SHORT).show();
        limpiar();
    }

    public boolean validar () {
        if (cantidad.getText().toString().equals("")) {
            cantidad.requestFocus();
            cantidad.setError(recursos.getString(R.string.error_vacio));
            return false;
        } else if (Integer.parseInt(cantidad.getText().toString()) <= 0) {
            cantidad.requestFocus();
            cantidad.setError(recursos.getString(R.string.error_mayorcero));
            return false;

        }
        return true;
    }
    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        cantidad.setText("");

    }

    public void total () {
        if (opcion1.getCheckedRadioButtonId() == R.id.Radiob1) {
            gamma(1);
        } else {
            gamma(2);
        }
    }

    public void gamma ( int n){
        switch (n) {
            case 1:
                if (opcion2.getCheckedRadioButtonId() == R.id.Radiob3) {
                    int i = spinner.getSelectedItemPosition();
                    valor = metodo.gamma1(i);
                } else {
                    int i = spinner.getSelectedItemPosition();
                    valor = metodo.gamma2(i);
                }
                break;
            case 2:
                if (opcion2.getCheckedRadioButtonId() == R.id.Radiob3) {
                    int i = spinner.getSelectedItemPosition();
                    valor = metodo.gamma3(i);
                } else {
                    int i = spinner.getSelectedItemPosition();
                    valor = metodo.gamma4(i);
                }
                break;
        }
    }
    public void onBackPressed() {
        finish();
        Intent i = new Intent(CalculoSimulacion.this,principal.class);
        startActivity(i);
    }


}


