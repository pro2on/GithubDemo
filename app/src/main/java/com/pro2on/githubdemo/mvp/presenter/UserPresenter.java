package com.pro2on.githubdemo.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.pro2on.githubdemo.di.UserComponent;
import com.pro2on.githubdemo.mvp.model.User;
import com.pro2on.githubdemo.mvp.view.UserView;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Date: 14.12.16
 * Time: 18:16
 * Created by pro2on in project GithubDemo
 */
@InjectViewState
public class UserPresenter extends BaseUserPresenter<UserView> {

    @Inject
    User user;


    @Override
    public void finish() {
        getViewState().onUserFinish();
    }

    @Override
    public void setupUserComponent(UserComponent userComponent) {
        userComponent.inject(this);
    }


    public UserPresenter() {
        getViewState().showUserName(user.login);
        Timber.d("UserPresenter constructor");
    }


}
