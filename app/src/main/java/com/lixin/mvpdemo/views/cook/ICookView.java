package com.lixin.mvpdemo.views.cook;


import com.lixin.mvpdemo.bean.CookCategoryBean;
import com.lixin.mvpdemo.bean.CookListBean;

/**
 * 处理业务需要哪些方法
 */
public interface ICookView {

    void getCookCategorySuccess(CookCategoryBean model);

    void getCookListSuccess(CookListBean model);

    void getDataFail(String msg);

    void showLoading();

    void hideLoading();
}
