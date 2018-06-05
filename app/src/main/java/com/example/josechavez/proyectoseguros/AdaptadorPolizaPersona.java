package com.example.josechavez.proyectoseguros;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Josechavez on 03/06/2018.
 */

public class AdaptadorPolizaPersona extends RecyclerView.Adapter<AdaptadorPolizaPersona.PolizaPersonaViewHolder> {
    private ArrayList<Poliza> polizas;
    private OnPolizaPersonaClickListener clickListener;

    public AdaptadorPolizaPersona(ArrayList<Poliza> polizas, AdaptadorPolizaPersona.OnPolizaPersonaClickListener clickListener) {
        this.polizas = polizas;
        this.clickListener = clickListener;
    }


    @Override
    public AdaptadorPolizaPersona.PolizaPersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_poliza, parent, false);
        return new AdaptadorPolizaPersona.PolizaPersonaViewHolder(v);
    }



    @Override
    public void onBindViewHolder(AdaptadorPolizaPersona.PolizaPersonaViewHolder holder, int position) {
        final Poliza p = polizas.get(position);
        holder.npoliza.setText(p.getNpoliza());
        holder.nplaca.setText(p.getNplaca());
        holder.fechai.setText(p.getFechainicio());
        holder.fechaf.setText(p.getFechafinal());
        holder.valor.setText(p.getValor_poliza());


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onPolizaPersonaClick(p);
            }
        });
    }
    @Override
    public int getItemCount() {
        return polizas.size();
    }

    public static class PolizaPersonaViewHolder extends RecyclerView.ViewHolder{
        private TextView npoliza;
        private TextView nplaca;
        private TextView fechai;
        private TextView fechaf;
        private TextView valor;
        private View v;

        public PolizaPersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            npoliza=v.findViewById(R.id.txtPoliza);
            nplaca=v.findViewById(R.id.txtPlaca);
            fechai=v.findViewById(R.id.txtFechai);
            fechaf=v.findViewById(R.id.txtFechaf);
            valor=v.findViewById(R.id.txtValor);




        }

    }
    public interface OnPolizaPersonaClickListener{
        void onPolizaPersonaClick(Poliza p);
    }


}