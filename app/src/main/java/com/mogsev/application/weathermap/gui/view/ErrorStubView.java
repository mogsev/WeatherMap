package com.mogsev.application.weathermap.gui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.mogsev.application.weathermap.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by Eugene Sikaylo on 3/7/2018.
 * email: mogsev@gmail.com
 */

public class ErrorStubView extends DataEmptyStubView {

    // Property of type error
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TYPE_ERROR_DATA, TYPE_ERROR_APP})
    public @interface TypeError {
    }

    public static final int TYPE_ERROR_DATA = 1;
    public static final int TYPE_ERROR_APP = 2;

    public ErrorStubView(Context context) {
        this(context, null);
    }

    public ErrorStubView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ErrorStubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ErrorStubView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setTypeError(@TypeError int typeError) {
        switch (typeError) {
            case TYPE_ERROR_DATA:
                setDataError(true);
                break;
            case TYPE_ERROR_APP:
                setAppError(true);
                break;
            default:
                mBinding.imageView.setImageResource(R.drawable.ic_cloud_off_outline_24dp);
                mBinding.textViewDescription.setText(R.string.warning_unknown_error);
                break;
        }
    }

    public void setAppError(boolean isAppError) {
        if (isAppError) {
            mBinding.imageView.setImageResource(R.drawable.ic_cloud_off_outline_24dp);
            mBinding.textViewDescription.setText(R.string.warning_service_is_unavailable);
        }
    }

    public void setDataError(boolean isDataError) {
        if (isDataError) {
            mBinding.imageView.setImageResource(R.drawable.ic_database_24dp);
            mBinding.textViewDescription.setText(mDescription);
        }

    }

}
