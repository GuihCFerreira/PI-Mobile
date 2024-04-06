package com.example.projetopi4semestre.view.fragment.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentHomeBinding;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.model.Umidade;
import com.example.projetopi4semestre.view.adapter.atual.TemperaturaAtualAdapter;
import com.example.projetopi4semestre.view.adapter.atual.UmidadeAtualAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private FragmentHomeBinding binding;

    private TemperaturaAtualAdapter temperaturaAtualAdapter = new TemperaturaAtualAdapter();
    private UmidadeAtualAdapter umidadeAtualAdapter = new UmidadeAtualAdapter();

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentHomeBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        mViewModel.getValoresAtuais();
        observarEstadosPadrao();
        return binding.getRoot();
    }

    private void observarEstadosPadrao(){

        mViewModel.getViewState().getCarregando().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean){
                binding.progressBar2.setVisibility(View.VISIBLE);
            }else{
                binding.progressBar2.setVisibility(View.GONE);
            }
        });

        mViewModel.getViewState().getMensagem().observe(getViewLifecycleOwner(), msg -> {
            if(msg != null )
                Toast.makeText(requireActivity(), msg, Toast.LENGTH_LONG).show();
        });

        binding.imageViewRefresh.setOnClickListener(v -> mViewModel.getValoresAtuais());

        mViewModel.getViewState().getUmidade().observe(getViewLifecycleOwner(),this::configurarRecyclerViewUmidade);

        mViewModel.getViewState().getTemperatura().observe(getViewLifecycleOwner(), this::configurarRecyclerViewTemperatura);

    }

    private void configurarRecyclerViewUmidade(Umidade umidade){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        binding.rvUmidade.setLayoutManager(layoutManager);
        binding.rvUmidade.hasFixedSize();

        List<Umidade> umidadeList = new ArrayList<>();
        umidadeList.add(umidade);

        umidadeAtualAdapter.setUmidadeList(umidadeList);
        binding.rvUmidade.setAdapter(umidadeAtualAdapter);
    }

    private void configurarRecyclerViewTemperatura(Temperatura temperatura){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        binding.rvTemperatura.setLayoutManager(layoutManager);
        binding.rvTemperatura.hasFixedSize();

        List<Temperatura> temperaturaList = new ArrayList<>();
        temperaturaList.add(temperatura);

        temperaturaAtualAdapter.setTemperaturaList(temperaturaList);
        binding.rvTemperatura.setAdapter(temperaturaAtualAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}