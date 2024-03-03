package com.example.projetopi4semestre.view.fragment.history.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentHistoricoBinding;

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
        return inflater.inflate(R.layout.fragment_historico, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}