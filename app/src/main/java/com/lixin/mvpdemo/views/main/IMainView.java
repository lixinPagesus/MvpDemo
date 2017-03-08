package com.lixin.mvpdemo.views.main;



/**
 * 处理业务需要哪些方法
 */
public interface IMainView {


    void getDataFail(String msg);

    void showLoading();

    void hideLoading();
}
