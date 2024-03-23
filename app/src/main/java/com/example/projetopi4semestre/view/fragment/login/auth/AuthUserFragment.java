package com.example.projetopi4semestre.view.fragment.login.auth;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.constants.Strings;
import com.example.projetopi4semestre.databinding.FragmentAuthUserBinding;
import com.example.projetopi4semestre.domain.model.Usuario;
import com.example.projetopi4semestre.view.activity.MainActivity;

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

        configurarEstadosPadrao();
        observarEstadosPadrao();

        return binding.getRoot();
    }

    private void observarEstadosPadrao(){

        mViewModel.getViewState().getMensagem().observe(getViewLifecycleOwner(), msg ->{
            if(msg != null){
                Toast.makeText(requireActivity(), msg, Toast.LENGTH_LONG).show();
            }
        });

        mViewModel.getViewState().getCarregando().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean){
                binding.progressBar.setVisibility(View.VISIBLE);
            }else{
                binding.progressBar.setVisibility(View.GONE);
            }
        });

        mViewModel.getViewState().getUsuario().observe(getViewLifecycleOwner(), usuario -> {
            if(usuario !=null ){

                salvarSharedPreferences(usuario);

                try {

                    Intent intent = new Intent(requireActivity() , MainActivity.class);
                    startActivity(intent);

                }catch (Error error){

                    Log.e("TAG ON LOGIN USER", error.toString() );
                    mViewModel.getViewState().getMensagem().setValue(error.getMessage());

                }
            }
        });

    }

    private void configurarEstadosPadrao(){
        binding.buttonLogin.setOnClickListener(v -> {
            verificarCamposVazios();
            mViewModel.logarUsuario(
                    binding.editEmailLogin.getText().toString(),
                    binding.editSenhaLogin.getText().toString()
            );
        });
    }

    private void verificarCamposVazios(){
        if (
                binding.editEmailLogin.getText().toString().equals("") &&
                binding.editSenhaLogin.getText().toString().equals("")
        ){
            Toast.makeText(requireActivity(), "Preencha todos os campos!", Toast.LENGTH_LONG).show();
        }
    }

    private void salvarSharedPreferences(Usuario usuario){

        SharedPreferences preferences = requireActivity().getSharedPreferences(Strings.KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();

        editor.putString(Strings.KEY_USER_NAME, usuario.getNome());
        editor.putString(Strings.KEY_USER_EMAIL, usuario.getEmail());
        editor.putString(Strings.KEY_USER_TOKEN, usuario.getToken());

        editor.apply();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}