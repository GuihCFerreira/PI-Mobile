package com.example.projetopi4semestre.data.remote.resposnse;

import retrofit2.Call;
import retrofit2.Callback;
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
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        useCaseCallback.onFailure(new CustomResponse(t.getMessage()));
    }
}
