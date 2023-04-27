package com.example.app_crud.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_crud.R;
import com.example.app_crud.entidades.Agenda;

import java.util.ArrayList;

public class ListaAgendaAdapter extends RecyclerView.Adapter<ListaAgendaAdapter.AgendaViewHolder> {

    ArrayList<Agenda> listaAgenda;

    public ListaAgendaAdapter(ArrayList<Agenda> listaAgenda){
        this.listaAgenda = listaAgenda;
    }


    @NonNull
    @Override
    public ListaAgendaAdapter.AgendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_agenda, null, false);

        return new AgendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAgendaAdapter.AgendaViewHolder holder, int position) {
        holder.viewNombre.setText(listaAgenda.get(position).getNombres());
        holder.viewTelefono.setText(listaAgenda.get(position).getTelefono());
        holder.viewCorreo.setText(listaAgenda.get(position).getCorreo_electronico());
        holder.viewMotivo.setText(listaAgenda.get(position).getMotivo());
        holder.viewFecha.setText(listaAgenda.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
       return listaAgenda.size();
    }

    public class AgendaViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewTelefono, viewCorreo, viewMotivo, viewFecha;
        public AgendaViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);
            viewMotivo = itemView.findViewById(R.id.viewMotivo);
            viewFecha = itemView.findViewById(R.id.viewFecha);

        }
    }
}
