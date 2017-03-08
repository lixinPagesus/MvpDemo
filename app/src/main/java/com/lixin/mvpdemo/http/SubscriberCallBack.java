package com.lixin.mvpdemo.http;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by lixin on 16/8/16.
 */
public class SubscriberCallBack<T> extends Subscriber<T> {
    private IApiCallback<T> IApiCallback;

    public SubscriberCallBack(IApiCallback<T> IApiCallback) {
        this.IApiCallback = IApiCallback;
    }

    @Override
    public void onCompleted() {
        IApiCallback.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不给力";
            }
            IApiCallback.onFailure(code, msg);
        } else {
            IApiCallback.onFailure(0, e.getMessage());
        }
        IApiCallback.onCompleted();
    }

    @Override
    public void onNext(T t) {
        IApiCallback.onSuccess(t);
    }
}
