package com.lixin.mvpdemo.mvp;

import android.os.Bundle;

import com.lixin.mvpdemo.views.BaseActivity;


public abstract class MvpActivity<P extends BaseIPresenter> extends BaseActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
