package com.pro2on.githubdemo.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Date: 14.12.16
 * Time: 14:57
 * Created by pro2on in project GithubDemo
 */

public interface LoginView extends MvpView {

    static final String TAG_PROGRESS = "progress";
    static final String TAG_ERROR = "error";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROGRESS)
    void showProgress();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROGRESS)
    void hideProgress();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_ERROR)
    void showError(String message);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_ERROR)
    void hideError();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_ERROR)
    void showFieldError(Integer loginError);


    @StateStrategyType(SkipStrategy.class)
    void successLogin();


}
