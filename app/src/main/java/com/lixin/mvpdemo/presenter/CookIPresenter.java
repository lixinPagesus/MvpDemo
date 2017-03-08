package com.lixin.mvpdemo.presenter;


import com.lixin.mvpdemo.bean.CookCategoryBean;
import com.lixin.mvpdemo.bean.CookListBean;
import com.lixin.mvpdemo.http.IApiCallback;
import com.lixin.mvpdemo.http.SubscriberCallBack;
import com.lixin.mvpdemo.mvp.BaseIPresenter;
import com.lixin.mvpdemo.views.cook.ICookView;

import java.util.Map;

/**
 * Created by lixin on 16/9/20.
 */

public class CookIPresenter extends BaseIPresenter<ICookView> {

    public CookIPresenter(ICookView cookView) {
        attachView(cookView);
    }

    public void getCookCategory(){

        mvpView.showLoading();
        addSubscription(IApiStores.loadCookCategory(sharesdkKey),
                new SubscriberCallBack<>(new IApiCallback<CookCategoryBean>() {
                    @Override
                    public void onSuccess(CookCategoryBean model) {
                        mvpView.getCookCategorySuccess(model);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }
                }));

    }


    public void getCookList(Map<String,String> params){

        mvpView.showLoading();
        addSubscription(IApiStores.loadCookList(params),
                new SubscriberCallBack<>(new IApiCallback<CookListBean>() {
                    @Override
                    public void onSuccess(CookListBean model) {
                        mvpView.getCookListSuccess(model);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }
                }));

    }


}
