package com.example.projetopi4semestre.view.adapter.historico;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetopi4semestre.databinding.AdapterHistoricoBinding;
import com.example.projetopi4semestre.domain.model.Umidade;

import java.util.ArrayList;
import java.util.List;

public class UmidadeHistoricoAdapter extends RecyclerView.Adapter<UmidadeHistoricoAdapter.MyViewHolder> {

    private List<Umidade> umidadeList = new ArrayList<>();

    @NonNull
    @Override
    public UmidadeHistoricoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AdapterHistoricoBinding binding = AdapterHistoricoBinding.inflate(inflater, parent, false);
        return new UmidadeHistoricoAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UmidadeHistoricoAdapter.MyViewHolder holder, int position) {
        Umidade temp = umidadeList.get(position);
        holder.binding.tvHistData.setText(temp.getData());
        holder.binding.tvHistData.setText(temp.getHora());
        holder.binding.tVHistValor.setText(temp.getUmidade());
        holder.binding.tVHistMedida.setText(temp.getUnidadeMedida());
    }

    @Override
    public int getItemCount() {
        return umidadeList.size();
    }

    public void setUmidadeTemperatura(List<Umidade> umidadeList){
        this.umidadeList.addAll(umidadeList);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private AdapterHistoricoBinding binding;
        public MyViewHolder(@NonNull AdapterHistoricoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
