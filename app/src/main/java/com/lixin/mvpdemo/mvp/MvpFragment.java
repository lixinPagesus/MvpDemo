package com.lixin.mvpdemo.mvp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lixin.mvpdemo.views.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class MvpFragment<P extends BaseIPresenter> extends BaseFragment {
    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();
    }

    protected abstract P createPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
