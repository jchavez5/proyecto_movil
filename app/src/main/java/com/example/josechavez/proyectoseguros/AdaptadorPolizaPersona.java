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
                inflate(R.layout.item_polizaxpersona, parent, false);
        return new AdaptadorPolizaPersona.PolizaPersonaViewHolder(v);
    }



    @Override
    public void onBindViewHolder(AdaptadorPolizaPersona.PolizaPersonaViewHolder holder, int position) {
        final Poliza p = polizas.get(position);
        holder.npoliza.setText(p.getNplaca());
        holder.nplaca.setText(p.getNplaca());


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
        private View v;

        public PolizaPersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            npoliza=v.findViewById(R.id.lblNpolizaPersona);
            nplaca=v.findViewById(R.id.lblNpolizaPersona);



        }

    }
    public interface OnPolizaPersonaClickListener{
        void onPolizaPersonaClick(Poliza p);
    }


}
