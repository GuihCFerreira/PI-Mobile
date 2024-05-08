
package com.example.projetopi4semestre.view.fragment.login.login;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.databinding.FragmentLoginBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        configurarEventosPadrao();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void configurarEventosPadrao(){

        binding.buttonSignin.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(LoginFragmentDirections.actionLoginFragment2ToAuthUserFragment2())
        );

        binding.buttonCreateUser.setOnClickListener(v ->
            Navigation.findNavController(v).navigate(LoginFragmentDirections.actionLoginFragment2ToCreateUserFragment2())
        );
    }
}