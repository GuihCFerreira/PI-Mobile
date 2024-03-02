package com.example.projetopi4semestre.view.fragment.history.umidade;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentUmidadeHistoricoBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UmidadeHistoricoFragment extends Fragment {

    private UmidadeHistoricoViewModel mViewModel;
    private FragmentUmidadeHistoricoBinding binding;

    public static UmidadeHistoricoFragment newInstance() {
        return new UmidadeHistoricoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentUmidadeHistoricoBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(UmidadeHistoricoViewModel.class);

        return binding.getRoot();
    }

}