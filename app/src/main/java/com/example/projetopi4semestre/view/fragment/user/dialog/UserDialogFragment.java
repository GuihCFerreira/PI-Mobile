package com.example.projetopi4semestre.view.fragment.user.dialog;

import androidx.fragment.app.DialogFragment;
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
import android.widget.Toast;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.constants.Strings;
import com.example.projetopi4semestre.databinding.FragmentUserDialogBinding;
import com.example.projetopi4semestre.domain.model.Usuario;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserDialogFragment extends DialogFragment {

    private UserDialogViewModel mViewModel;
    private FragmentUserDialogBinding binding;
    private SharedPreferences preferences;
    public String TAG = "TAG_USER_DIALOG_FRAGMENT";
    public static UserDialogFragment newInstance() {
        return new UserDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentUserDialogBinding.inflate(inflater, container, false);

        mViewModel = new ViewModelProvider(this).get(UserDialogViewModel.class);

        preferences = requireActivity().getSharedPreferences(Strings.KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE);

        eventosPadrao();

        return binding.getRoot();
    }

    private void eventosPadrao(){

        binding.buttonAlterarSenha.setOnClickListener(v ->{
            if(!validarCampos())
                mViewModel.resetarSenha(
                        preferences.getString(Strings.KEY_USER_EMAIL, ""),
                        binding.editSenhaAtualReset.getText().toString(),
                        binding.editSenhNovaReset.getText().toString()
                );
        });

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

        mViewModel.getViewState().getUsuario().observe(getViewLifecycleOwner(), usuario -> {
            if(usuario != null){
                salvarSharedPreferences(usuario);
                Toast.makeText(requireActivity(), "Senha alterada com sucesso.", Toast.LENGTH_LONG).show();
                dismiss();
            }
        });

    }

    private boolean validarCampos (){

        boolean ret = false;
        if(binding.editSenhaAtualReset.getText().toString().equals("") ||
           binding.editSenhNovaReset.getText().toString().equals("") ||
           binding.editConfirmSenhaNovaReset.getText().toString().equals("")){
            Toast.makeText(requireActivity(), "Preencha todos os campos.", Toast.LENGTH_LONG).show();
            ret = true;
        }

        if(!binding.editSenhNovaReset.getText().toString().equals(binding.editConfirmSenhaNovaReset.getText().toString())){
            Toast.makeText(requireActivity(), "As senhas não se conferem.", Toast.LENGTH_LONG).show();
            ret = true;
        }

        return ret;
    }

    private void salvarSharedPreferences(Usuario usuario){

        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();

        editor.putString(Strings.KEY_USER_NAME, usuario.getNome());
        editor.putString(Strings.KEY_USER_EMAIL, usuario.getEmail());
        editor.putString(Strings.KEY_USER_TOKEN, usuario.getToken());

        editor.apply();
    }


}