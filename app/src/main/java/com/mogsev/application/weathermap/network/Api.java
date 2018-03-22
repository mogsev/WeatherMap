package com.mogsev.application.weathermap.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mogsev.application.weathermap.BuildConfig;
import com.mogsev.application.weathermap.WeatherMap;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eugene Sikaylo on 3/13/2018.
 * email: mogsev@gmail.com
 */

public class Api {

    public static final String API_BASE_URL = "http://samples.openweathermap.org/";

    private Retrofit.Builder mRetrofitBuilder;
    private OkHttpClient.Builder mHttpClientBuilder;
    private ApiService mApiService;

    public static Api from(@NonNull Context context) {
        return ((WeatherMap) context.getApplicationContext()).getApi();
    }

    public Api() {
        mHttpClientBuilder = new OkHttpClient.Builder();
        // follow redirect
        mHttpClientBuilder.followRedirects(true)
                .followSslRedirects(true);
        // Create Http logging interceptor
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            mHttpClientBuilder.addInterceptor(logging);
        }

        // create instance retrofit builder
        mRetrofitBuilder = new Retrofit.Builder();
        mRetrofitBuilder.baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        mRetrofitBuilder.client(mHttpClientBuilder.build());

        Retrofit retrofit = mRetrofitBuilder.build();
        // create Api service
        mApiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return mApiService;
    }

}
