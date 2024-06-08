package com.example.projetopi4semestre.view.adapter.historico;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetopi4semestre.databinding.AdapterHistoricoBinding;
import com.example.projetopi4semestre.domain.model.Temperatura;

import java.util.ArrayList;
import java.util.List;

public class TemperaturaHistoricoAdapter extends RecyclerView.Adapter<TemperaturaHistoricoAdapter.MyViewHolder> {

    private List<Temperatura> temperaturaList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AdapterHistoricoBinding binding = AdapterHistoricoBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Temperatura temp = temperaturaList.get(position);
        holder.binding.tvHistData.setText(temp.getData());
        holder.binding.tvHistHora.setText(temp.getHora());
        holder.binding.tVHistValor.setText(temp.getTemperatura());
        holder.binding.tVHistMedida.setText("º"+temp.getUnidadeMedida());
    }

    @Override
    public int getItemCount() {
        return temperaturaList.size() ;
    }

    public void setHistoricoTemperatura(List<Temperatura> temperaturaList){
        this.temperaturaList.addAll(temperaturaList);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private AdapterHistoricoBinding binding;
        public MyViewHolder(@NonNull AdapterHistoricoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
