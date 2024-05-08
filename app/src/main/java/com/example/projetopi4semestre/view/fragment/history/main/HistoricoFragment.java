package com.example.projetopi4semestre.view.fragment.history.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.constants.TiposDados;
import com.example.projetopi4semestre.databinding.FragmentHistoricoBinding;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HistoricoFragment extends Fragment {

    private HistoricoViewModel mViewModel;
    private FragmentHistoricoBinding binding;

    public static HistoricoFragment newInstance() {
        return new HistoricoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentHistoricoBinding.inflate(inflater, container, false);
        mViewModel= new ViewModelProvider(this).get(HistoricoViewModel.class);
        configurarEventosPadrao();

        configurarSpinner();


        return inflater.inflate(R.layout.fragment_historico, container, false);
    }

    private void configurarSpinner(){

        List<String> tipoList = new ArrayList<>();
        tipoList.add(TiposDados.UMIDADE.toString());
        tipoList.add(TiposDados.TEMPERATURA.toString());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireActivity(), R.layout.spinner_item, tipoList);
        binding.spinnerTipo.setAdapter(arrayAdapter);

        binding.spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipoSelecionado = tipoList.get(position);
                binding.textTipo.setText("De " + tipoSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Faz alguma coisa se nada for selecionado
            }
        });

    }

    private void itemSelecionado(){
    }

    private void configurarEventosPadrao(){
        binding.imageView10.setOnClickListener(v ->Log.d("TAG","CLICADO AQUI") );
        Log.d("TAG"," AQUI");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}