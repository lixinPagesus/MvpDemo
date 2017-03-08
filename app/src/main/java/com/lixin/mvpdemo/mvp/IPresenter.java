package com.lixin.mvpdemo.mvp;

public interface IPresenter<V> {

    void attachView(V view);

    void detachView();

}
