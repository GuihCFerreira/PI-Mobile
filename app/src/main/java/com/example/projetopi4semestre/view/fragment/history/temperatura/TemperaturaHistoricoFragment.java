package com.example.projetopi4semestre.view.fragment.history.temperatura;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentTemperaturaHistoricoBinding;
import com.example.projetopi4semestre.view.adapter.historico.TemperaturaHistoricoAdapter;
import com.example.projetopi4semestre.view.adapter.historico.UmidadeHistoricoAdapter;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TemperaturaHistoricoFragment extends Fragment {

    private TemperaturaHistoricoViewModel mViewModel;
    private TemperaturaHistoricoAdapter temperaturaHistoricoAdapter = new TemperaturaHistoricoAdapter();
    private UmidadeHistoricoAdapter umidadeHistoricoAdapter = new UmidadeHistoricoAdapter();
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

        //mViewModel.getTemperaturaHistorico();

        observarEstadosPadrao();
        configurarRecyclerView();
        configurarSpinner();

        return binding.getRoot();
    }

    private void configurarSpinner(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireActivity(),R.layout.spinner_item,getResources().getStringArray( R.array.type_array));
        binding.spinnerTipoHistorico.setAdapter(arrayAdapter);
        binding.spinnerTipoHistorico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] tipoSelecionado = getResources().getStringArray( R.array.type_array);
                binding.textTipo.setText("De " + tipoSelecionado[position]);
                if(position ==0) mViewModel.getTemperaturaHistorico(); else mViewModel.getUmidadeHistorico();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void configurarRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewHistorico.setLayoutManager(layoutManager);
        binding.recyclerViewHistorico.setHasFixedSize(true);
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
                binding.recyclerViewHistorico.setAdapter(temperaturaHistoricoAdapter);
                configurarRecyclerView();
            }else{
                mViewModel.getTemperaturaHistorico();
            }
        });

        mViewModel.getViewState().getUmidadeHistorico().observe(getViewLifecycleOwner(), umidades -> {
            if(umidades != null){
                umidadeHistoricoAdapter.setUmidadeTemperatura(umidades);
                binding.recyclerViewHistorico.setAdapter(umidadeHistoricoAdapter);
                configurarRecyclerView();
            }else{
                mViewModel.getUmidadeHistorico();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding= null;
    }
}