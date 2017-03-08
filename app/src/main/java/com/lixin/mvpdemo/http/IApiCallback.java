package com.lixin.mvpdemo.http;

/**
 * Created by lixin on 16/8/16.
 */
public interface IApiCallback<T> {

    void onSuccess(T model);

    void onFailure(int code, String msg);

    void onCompleted();

}
