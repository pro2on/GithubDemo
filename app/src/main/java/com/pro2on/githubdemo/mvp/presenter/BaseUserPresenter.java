package com.pro2on.githubdemo.mvp.presenter;

import com.pro2on.githubdemo.application.DemoApp;
import com.pro2on.githubdemo.di.UserComponent;
import com.pro2on.githubdemo.mvp.model.UserManager;
import com.pro2on.githubdemo.mvp.view.BaseUserView;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Date: 14.12.16
 * Time: 17:56
 * Created by pro2on in project GithubDemo
 */

public abstract class BaseUserPresenter<View extends BaseUserView> extends BasePresenter<View> {

    private boolean isUserSessionStarted;


    UserManager userManager;


    public BaseUserPresenter() {

        userManager = DemoApp.getAppComponent().getUserManager();

        isUserSessionStarted = userManager.isUserSessionIsStartedOrStartSessionIfPossible();
        if (isUserSessionStarted) {
            setupUserComponent(userManager.getUserComponent());
        } else {
            finish();
        }

        Timber.d("BaseUserPresenter constructor");
    }



    public abstract void finish();

    public abstract void setupUserComponent(UserComponent userComponent);

}
