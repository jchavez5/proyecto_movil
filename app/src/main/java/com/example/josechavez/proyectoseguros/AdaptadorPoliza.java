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

public class  AdaptadorPoliza extends RecyclerView.Adapter<AdaptadorPoliza.PolizaViewHolder> {
    private ArrayList<Poliza> polizas;
    private OnPolizaClickListener clickListener;
    public AdaptadorPoliza(ArrayList<Poliza> polizas, AdaptadorPoliza.OnPolizaClickListener clickListener) {
        this.polizas = polizas;
        this.clickListener = clickListener;
    }


    @Override
    public AdaptadorPoliza.PolizaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_poliza, parent, false);
        return new AdaptadorPoliza.PolizaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorPoliza.PolizaViewHolder holder, int position) {
        final Poliza p = polizas.get(position);
        holder.npoliza.setText(p.getNpoliza());
        holder.nplaca.setText(p.getNplaca());
        holder.fechai.setText(p.getFechainicio());
        holder.fechaf.setText(p.getFechafinal());
        holder.valor.setText(p.getValor_poliza());


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onPolizaClick(p);
            }
        });
    }
    @Override
    public int getItemCount() {
        return polizas.size();
    }

    public static class PolizaViewHolder extends RecyclerView.ViewHolder{
        private TextView npoliza;
        private TextView nplaca;
        private TextView fechai;
        private TextView fechaf;
        private TextView valor;
        private View v;

        public PolizaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            npoliza=v.findViewById(R.id.txtPoliza);
            nplaca=v.findViewById(R.id.txtPlaca);
            fechai=v.findViewById(R.id.txtFechai);
            fechaf=v.findViewById(R.id.txtFechaf);
            valor=v.findViewById(R.id.txtValor);



        }

    }
    public interface OnPolizaClickListener{
        void onPolizaClick(Poliza p);
    }
}
