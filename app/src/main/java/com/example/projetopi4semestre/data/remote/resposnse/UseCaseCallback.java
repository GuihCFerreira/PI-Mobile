package com.example.projetopi4semestre.data.remote.resposnse;

public interface UseCaseCallback<T> {

    void onSuccess(T response);
    void onFailure (CustomResponse customResponse);
}
