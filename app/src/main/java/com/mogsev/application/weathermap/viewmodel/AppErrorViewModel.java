package com.mogsev.application.weathermap.viewmodel;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;

/**
 * Created by Eugene Sikaylo on 3/7/2018.
 * email: mogsev@gmail.com
 */

public class AppErrorViewModel {

    protected final ObservableBoolean mAppError;

    protected OnAppErrorListener mAppErrorListener;

    public AppErrorViewModel() {
        // prepare app error
        mAppError = new ObservableBoolean(false);
        // add property
        mAppError.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (mAppErrorListener != null) {
                    mAppErrorListener.onAppError(mAppError.get());
                }
            }
        });
    }

    public ObservableBoolean getAppError() {
        return mAppError;
    }

    public void setOnAppErrorListener(OnAppErrorListener listener) {
        mAppErrorListener = listener;
    }

    public interface OnAppErrorListener {

        public void onAppError(boolean isAppError);

    }

}
