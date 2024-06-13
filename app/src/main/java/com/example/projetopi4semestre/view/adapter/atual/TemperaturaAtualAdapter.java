package com.example.projetopi4semestre.view.adapter.atual;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.AdapterTemperaturaBinding;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.model.Umidade;

import java.util.ArrayList;
import java.util.List;

public class TemperaturaAtualAdapter extends RecyclerView.Adapter<TemperaturaAtualAdapter.MyViewHolder> {

    private List<Temperatura> temperaturaList = new ArrayList<>();
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AdapterTemperaturaBinding binding = AdapterTemperaturaBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Temperatura temperatura = temperaturaList.get(position);
        holder.binding.tvTemperatura.setText(temperatura.getTemperatura());
        String valorTemp = temperatura.getTemperatura().replaceAll("[^\\d.]", "");
        if(Float.valueOf(valorTemp) < 17.0){
            holder.binding.tvClima.setText("Clima Frio");
            holder.binding.imageViewClima.setImageResource(R.drawable.adapter_temp_frio);
        }else{
            holder.binding.tvClima.setText("Clima Quente");
            holder.binding.imageViewClima.setImageResource(R.drawable.adapter_temp_quente);
        }
        holder.binding.llVerHistorico.setOnClickListener(v -> onClick.onClick(v, temperatura));
    }

    public void setTemperaturaList(List<Temperatura> temperaturaList){
        this.temperaturaList.addAll(temperaturaList);
    }

    public interface OnClick{
        void onClick(View view, Temperatura temperatura);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        AdapterTemperaturaBinding binding;
        public MyViewHolder(@NonNull AdapterTemperaturaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
