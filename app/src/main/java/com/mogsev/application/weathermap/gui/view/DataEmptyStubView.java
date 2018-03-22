package com.mogsev.application.weathermap.gui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.mogsev.application.weathermap.databinding.ViewDataEmptyStubBinding;


/**
 * Created by Eugene Sikaylo on 3/7/2018.
 * email: mogsev@gmail.com
 */

public class DataEmptyStubView extends LinearLayout implements StubView {

    protected ViewDataEmptyStubBinding mBinding;
    protected CharSequence mDescription;

    public DataEmptyStubView(Context context) {
        this(context, null);
    }

    public DataEmptyStubView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DataEmptyStubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DataEmptyStubView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    /**
     * Initialize
     */
    private void init(@Nullable AttributeSet attrs) {
        // inflate view
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        mBinding = ViewDataEmptyStubBinding.inflate(layoutInflater, this, true);

        setOrientation(VERTICAL);

        // parse attributes
        int[] setAttrs = {android.R.attr.text};
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, setAttrs, 0, 0);
        try {
            String description = typedArray.getString(0);
            setDescription(description);
        } finally {
            typedArray.recycle();
        }

        // preview mode on Android Studio
        if (isInEditMode()) {
            return;
        }

        // hide view
        setVisibility(View.GONE);
    }

    @Override
    public void setDescription(CharSequence description) {
        mDescription = description;
        mBinding.textViewDescription.setText(description);
    }

    @Override
    public void setDescription(@StringRes int description) {
        mDescription = getContext().getString(description);
        mBinding.textViewDescription.setText(description);
    }

}
