package com.example.projetopi4semestre.data.remote.interceptor;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.projetopi4semestre.MyApplication;
import com.example.projetopi4semestre.constants.Strings;

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

        Request originalRequest = chain.request();

        SharedPreferences preferences = MyApplication.getAppContext().getSharedPreferences(Strings.KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String token = preferences.getString(Strings.KEY_USER_TOKEN, "");

        // Verifica se o token está disponível e adiciona-o ao header se necessário
        Request request;
        if(token.isEmpty()) {
            request = originalRequest;
        } else {
            request = originalRequest.newBuilder()
                    .header("Authorization", token)
                    .build();
        }

        return chain.proceed(request);
    }
}
