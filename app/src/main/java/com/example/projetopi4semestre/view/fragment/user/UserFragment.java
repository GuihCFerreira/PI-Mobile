package com.example.projetopi4semestre.view.fragment.user;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.constants.Strings;
import com.example.projetopi4semestre.databinding.FragmentUserBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserFragment extends Fragment {

    private UserViewModel mViewModel;
    private FragmentUserBinding binding;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        configurarUI();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void configurarUI(){

        SharedPreferences preferences = getActivity().getSharedPreferences(Strings.KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String nomeUsuario = preferences.getString(Strings.KEY_USER_NAME,"Nome Usuário");
        String emailUsuario = preferences.getString(Strings.KEY_USER_EMAIL,"Email Usuário");

        String[] partesNome = nomeUsuario.split(" ");
        String nomeImagem = partesNome[0].substring(0,1) + partesNome[partesNome.length -1].substring(0,1);

        binding.tvInicialUser.setText(nomeImagem);
        binding.tvEmail.setText(emailUsuario);
        binding.tvNome.setText(nomeUsuario);

    }
}