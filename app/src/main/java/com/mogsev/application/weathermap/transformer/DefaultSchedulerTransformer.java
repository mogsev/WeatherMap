package com.mogsev.application.weathermap.transformer;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Eugene Sikaylo on 11/10/2017.
 * email: mogsev@gmail.com
 */

public class DefaultSchedulerTransformer<T> implements ObservableTransformer<T, T> {

    public DefaultSchedulerTransformer() {
        // empty
    }

    @Override
    public Observable<T> apply(Observable<T> upstream) {
        return upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
