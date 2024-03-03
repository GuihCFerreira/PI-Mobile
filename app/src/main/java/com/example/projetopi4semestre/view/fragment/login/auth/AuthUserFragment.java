package com.example.projetopi4semestre.view.fragment.login.auth;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentAuthUserBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AuthUserFragment extends Fragment {

    private AuthUserViewModel mViewModel;
    private FragmentAuthUserBinding binding;

    public static AuthUserFragment newInstance() {
        return new AuthUserFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAuthUserBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(AuthUserViewModel.class);
        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}