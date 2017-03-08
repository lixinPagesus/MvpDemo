package com.lixin.mvpdemo.mvp;


import com.lixin.mvpdemo.http.IApiStores;
import com.lixin.mvpdemo.http.AppClient;
import com.lixin.mvpdemo.utils.ConstantMvp;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by lixin on 16/8/12.
 */
public class BaseIPresenter<V> implements IPresenter<V> {

    public V mvpView;
    public IApiStores IApiStores = AppClient.retrofit().create(IApiStores.class);
    private CompositeSubscription mCompositeSubscription;
    public String sharesdkKey = ConstantMvp.APPKEY;

    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }



    @Override
    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }


    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));

    }
}
