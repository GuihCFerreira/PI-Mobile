package com.example.projetopi4semestre.data.remote.resposnse;

import com.example.projetopi4semestre.MyApplication;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class CustomCallback<T> implements Callback<T> {

    private final UseCaseCallback<T> useCaseCallback;

    public CustomCallback(UseCaseCallback<T> useCaseCallback){
        this.useCaseCallback = useCaseCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.isSuccessful()){
            useCaseCallback.onSuccess(response.body());
        }else if(response.errorBody() != null){
            try {
                Converter<ResponseBody, CustomResponse> converter = MyApplication.getRetrofit().responseBodyConverter(CustomResponse.class, new Annotation[0]);
                CustomResponse responseApi = converter.convert(response.errorBody());
                useCaseCallback.onFailure(responseApi);
            } catch (IOException e) {
                e.printStackTrace();
                useCaseCallback.onFailure(new CustomResponse( e.getMessage()));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        useCaseCallback.onFailure(new CustomResponse(t.getMessage()));
    }
}
