package com.example.projetopi4semestre.view.fragment.history.temperatura;

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
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentTemperaturaHistoricoBinding;
import com.example.projetopi4semestre.view.adapter.historico.TemperaturaHistoricoAdapter;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TemperaturaHistoricoFragment extends Fragment {

    private TemperaturaHistoricoViewModel mViewModel;
    private TemperaturaHistoricoAdapter temperaturaHistoricoAdapter = new TemperaturaHistoricoAdapter();
    private FragmentTemperaturaHistoricoBinding binding;

    public static TemperaturaHistoricoFragment newInstance() {
        return new TemperaturaHistoricoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentTemperaturaHistoricoBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(TemperaturaHistoricoViewModel.class);
        binding.buttonGoDashboard.setOnClickListener(v -> Toast.makeText(requireActivity(), "TESTE LOGIN", Toast.LENGTH_SHORT).show());

        mViewModel.getTemperaturaHistorico();

        observarEstadosPadrao();
        configurarRecyclerView();
        configurarSpinner();

        return binding.getRoot();
    }

    private void configurarSpinner(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireActivity(),R.layout.spinner_item,getResources().getStringArray( R.array.type_array));
        binding.spinnerTipoHistorico.setAdapter(arrayAdapter);
    }

    private void configurarRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewHistorico.setLayoutManager(layoutManager);
        binding.recyclerViewHistorico.setHasFixedSize(true);
        binding.recyclerViewHistorico.setAdapter(temperaturaHistoricoAdapter);
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

        mViewModel.getViewState().getTemperaturaHistorico().observe(getViewLifecycleOwner(),temperaturas -> {
            if(temperaturas != null){
                temperaturaHistoricoAdapter.setHistoricoTemperatura(temperaturas);
                configurarRecyclerView();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding= null;
    }
}