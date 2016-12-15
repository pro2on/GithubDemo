package com.pro2on.githubdemo.mvp.presenter;


import android.text.TextUtils;

import com.arellomobile.mvp.MvpPresenter;
import com.pro2on.githubdemo.application.DemoApp;
import com.pro2on.githubdemo.mvp.common.TokenDataStore;
import com.pro2on.githubdemo.mvp.model.UserManager;
import com.pro2on.githubdemo.mvp.view.SplashView;



import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Date: 23.11.16
 * Time: 19:56
 * Created by pro2on in project GithubDemo
 */

public class SplashPresenter extends MvpPresenter<SplashView> {


    @Inject
    UserManager userManager;


    public SplashPresenter() {
        DemoApp.getAppComponent().inject(this);
    }



    public void checkIsUserAuthorized() {

        for (SplashView splashView : getAttachedViews()) {
            splashView.setAuthorized(userManager.isUserSessionIsStartedOrStartSessionIfPossible());
        }

    }





}
