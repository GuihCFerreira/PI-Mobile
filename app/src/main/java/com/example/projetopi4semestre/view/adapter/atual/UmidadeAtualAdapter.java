package com.example.projetopi4semestre.view.adapter.atual;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.AdapterUmidadeBinding;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.model.Umidade;

import java.util.ArrayList;
import java.util.List;

public class UmidadeAtualAdapter extends RecyclerView.Adapter<UmidadeAtualAdapter.MyViewHolder> {

    private List<Umidade> umidadeList = new ArrayList<>();
    private OnClick onClickListener;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AdapterUmidadeBinding binding = AdapterUmidadeBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void setOnClick(OnClick onClick) {
        this.onClickListener = onClick;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Umidade umidade = umidadeList.get(position);
        holder.binding.tvUmidade.setText(umidade.getUmidade());
        String valorUmd = umidade.getUmidade().replaceAll("[^\\d.]", "");
        Float umd = Float.valueOf(valorUmd);
        if (umd < 40.0){
            holder.binding.imageViewClima.setImageResource(R.drawable.adapter_umd_sol);
            holder.binding.tvTempo.setText("Tempo seco.");
        } else if (75.0 > umd && umd > 40.0) {
            holder.binding.imageViewClima.setImageResource(R.drawable.adapter_umd_nuvem);
            holder.binding.tvTempo.setText("Tempo úmido.");
        }else{
            holder.binding.imageViewClima.setImageResource(R.drawable.adapter_umd_raio);
            holder.binding.tvTempo.setText("Tempo úmida.");
        }
        holder.binding.llVerHistorico.setOnClickListener(v -> onClickListener.onClick(v, umidade));
    }

    public void setUmidadeList(List<Umidade> umidadeList){
        this.umidadeList.addAll(umidadeList);
    }


    public interface OnClick{
        void onClick(View view, Umidade umidade);
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private AdapterUmidadeBinding binding;
        public MyViewHolder(@NonNull AdapterUmidadeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
