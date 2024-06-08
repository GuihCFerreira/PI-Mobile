package com.example.projetopi4semestre.view.fragment.dashboard;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.constants.Strings;
import com.example.projetopi4semestre.databinding.FragmentDashboardBinding;

import java.util.Calendar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;
    private FragmentDashboardBinding  binding;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater,container, false);
        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        iniciarEstadosPadrao();
        observarEstadosPadrao();

        mViewModel.getDashboard("03/03/2024","20/04/2024");

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        binding.buttonDashboard.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(Strings.LINK_DASHBOARD));
            startActivity(intent);
        });
    }

    private void iniciarEstadosPadrao(){

        binding.edittextDataInicial.setOnClickListener(v -> {
            setDate(requireActivity(), binding.edittextDataInicial, false);
        });

        binding.edittextDataFinal.setOnClickListener(v -> {
            setDate(requireActivity(), binding.edittextDataFinal, false);
        });

        binding.buttonFiltroLimpar.setOnClickListener(v -> {
            binding.edittextDataFinal.setText("");
            binding.edittextDataInicial.setText("");
            mViewModel.getDashboard("03/03/2024","20/04/2024");
        });

        binding.buttonFiltroBuscar.setOnClickListener(v -> {

            String dataInicial = binding.edittextDataInicial.getText().toString().equals("") ? "03/03/2024" : binding.edittextDataInicial.getText().toString();
            String dataFinal = binding.edittextDataFinal.getText().toString().equals("") ? "20/04/2024" : binding.edittextDataFinal.getText().toString();

            mViewModel.getDashboard(dataInicial, dataFinal);
        });

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

        mViewModel.getViewState().getDashboard().observe(getViewLifecycleOwner(), dashboard -> {
            if(dashboard != null) {
                binding.tvMediaTemp.setText(dashboard.getTemperatura().getMedia());
                binding.tvMedianaTemp.setText(dashboard.getTemperatura().getMediana());
                binding.tvModaTemp.setText(dashboard.getTemperatura().getModa());
                binding.tvAssimTemp.setText(dashboard.getTemperatura().getAssimetria());
                binding.tvDesvPadraoTemp.setText(dashboard.getTemperatura().getDesvioPadrao());
                binding.tvPrevFuturaTemp.setText(dashboard.getTemperatura().getPrevisaoFutura());

                binding.tvMediaUmd.setText(dashboard.getUmidade().getMedia());
                binding.tvMedianaUmd.setText(dashboard.getUmidade().getMediana());
                binding.tvModaUmd.setText(dashboard.getUmidade().getModa());
                binding.tvAssimUmd.setText(dashboard.getUmidade().getAssimetria());
                binding.tvDesvPadraoUmd.setText(dashboard.getUmidade().getDesvioPadrao());
                binding.tvPrevFuturaUmd.setText(dashboard.getUmidade().getPrevisaoFutura());
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private static void setDate(Context ctx, EditText edt, Boolean fab) {

        Calendar c = Calendar.getInstance();

        Integer mYear = c.get(Calendar.YEAR);
        Integer mMonth = c.get(Calendar.MONTH);
        Integer mDay = c.get(Calendar.DAY_OF_MONTH);
        final EditText edit = edt;

        DatePickerDialog dpd = new DatePickerDialog(ctx, (view, year, monthOfYear, dayOfMonth) ->
                edit.setText(zero(String.valueOf(dayOfMonth),2) + "/"
                + zero(String.valueOf((monthOfYear + 1)),2) + "/"
                + zero(String.valueOf(year),4)), mYear, mMonth, mDay);

        if (fab){
            dpd.getDatePicker().setMaxDate(System.currentTimeMillis());
            dpd.show();
        }else {
            dpd.show();
        }
    }

    public static String zero(String orig, Integer qtZeros) {
        int qi = orig.length();
        for (int i = qi; i < qtZeros; i++) {
            orig = '0' + orig.trim();
        }
        return orig;
    }
}