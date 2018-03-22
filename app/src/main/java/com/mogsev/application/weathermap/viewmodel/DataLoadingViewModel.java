package com.mogsev.application.weathermap.viewmodel;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;

/**
 * Created by Eugene Sikaylo on 3/7/2018.
 * email: mogsev@gmail.com
 */

public class DataLoadingViewModel extends AppErrorViewModel {

    protected final ObservableBoolean mError;
    protected final ObservableBoolean mDataEmpty;
    protected final ObservableBoolean mDataLoading;

    protected OnDataLoadingListener mDataLoadingListener;
    protected OnDataEmptyListener mDataEmptyListener;

    public DataLoadingViewModel() {
        super();
        mError = new ObservableBoolean(false);
        // add property to app error
        mAppError.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                mError.set(mDataEmpty.get() || mAppError.get());
            }
        });
        // prepare if data is empty
        mDataEmpty = new ObservableBoolean(false);
        mDataEmpty.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                mError.set(mDataEmpty.get() || mAppError.get());
            }
        });
        mDataEmpty.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (mDataEmptyListener != null)
                    mDataEmptyListener.onDataEmpty(mDataEmpty.get());
            }
        });
        // prepare if data loading
        mDataLoading = new ObservableBoolean(false);
        mDataLoading.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (mDataLoadingListener != null)
                    mDataLoadingListener.onLoading(mDataLoading.get());

            }
        });
        mDataLoading.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (mDataLoading.get()) {
                    mDataEmpty.set(false);
                    mAppError.set(false);
                }
            }
        });
    }

    public ObservableBoolean getError() {
        return mError;
    }

    public ObservableBoolean getDataEmpty() {
        return mDataEmpty;
    }

    public ObservableBoolean getDataLoading() {
        return mDataLoading;
    }

    public void setOnDataLoadingListener(OnDataLoadingListener listener) {
        mDataLoadingListener = listener;
    }

    public void setOnDataEmptyListener(OnDataEmptyListener listener) {
        mDataEmptyListener = listener;
    }

    public interface OnDataLoadingListener {

        public void onLoading(boolean isLoading);

    }

    public interface OnDataEmptyListener {

        public void onDataEmpty(boolean isDataEmpty);

    }

}
