package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.spec.ECField;
import java.util.List;

public class ExemploAdapter extends RecyclerView.Adapter<ExemploAdapter.MyViewHolder> {

    private List<Exemplo> listExemplo;

    public ExemploAdapter(List<Exemplo> lista ) {
        this.listExemplo = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_exemplo_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Exemplo exemplo = listExemplo.get(position);
        holder.exemplo.setText( exemplo.getNomeExeplo() );


    }

    @Override
    public int getItemCount() {
        return this.listExemplo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView exemplo;

        public MyViewHolder(View itemView) {
            super(itemView);

            exemplo = itemView.findViewById(R.id.textView);

        }
    }

}
