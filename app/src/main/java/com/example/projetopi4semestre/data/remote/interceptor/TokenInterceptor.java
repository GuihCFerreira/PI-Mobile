package com.example.projetopi4semestre.data.remote.interceptor;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.projetopi4semestre.MyApplication;
import com.example.projetopi4semestre.constants.Strings;
import com.example.projetopi4semestre.domain.usecase.Usuario.RenewTokenUseCase;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    @Inject
    public TokenInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {


        Response response = chain.proceed(requestToken(chain.request()));

        if(response.code() == 401) renewToken();

        return response;
    }

    private void renewToken(){

    }

    private Request requestToken(Request originalRequest){
        Request request;

        SharedPreferences preferences = MyApplication.getAppContext().getSharedPreferences(Strings.KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String token = preferences.getString(Strings.KEY_USER_TOKEN, "");

        if(token.isEmpty()) {
            request = originalRequest;
        } else {
            request = originalRequest.newBuilder()
                    .header("Authorization", "Bearer " + token)
                    .build();
        }

        return request;
    }
}
