package com.example.projetopi4semestre.view.fragment.history.temperatura;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentTemperaturaHistoricoBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TemperaturaHistoricoFragment extends Fragment {

    private TemperaturaHistoricoViewModel mViewModel;
    private FragmentTemperaturaHistoricoBinding binding;

    public static TemperaturaHistoricoFragment newInstance() {
        return new TemperaturaHistoricoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentTemperaturaHistoricoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding= null;
    }
}