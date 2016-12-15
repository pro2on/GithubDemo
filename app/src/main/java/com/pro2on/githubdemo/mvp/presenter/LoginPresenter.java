package com.pro2on.githubdemo.mvp.presenter;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.pro2on.githubdemo.R;
import com.pro2on.githubdemo.application.DemoApp;
import com.pro2on.githubdemo.mvp.model.User;
import com.pro2on.githubdemo.mvp.model.UserManager;
import com.pro2on.githubdemo.mvp.view.LoginView;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Date: 14.12.16
 * Time: 15:05
 * Created by pro2on in project GithubDemo
 */

@InjectViewState
public class LoginPresenter extends BasePresenter<LoginView> {


    @Inject
    UserManager userManager;


    public LoginPresenter() {
        DemoApp.getAppComponent().inject(this);
    }



    public void login(String login) {

        Integer loginError = null;

        getViewState().showFieldError(null);


        if (TextUtils.isEmpty(login)) {
            loginError = R.string.error_field_required;
        }

        if (loginError != null) {
            getViewState().showFieldError(loginError);
            return;
        }

        getViewState().showProgress();

        Disposable disposable = userManager.startSessionForUser(login)
                .subscribe(user -> {
                    getViewState().hideProgress();
                    getViewState().successLogin();
                }, throwable -> {
                    getViewState().hideProgress();
                    getViewState().showError(throwable.getMessage());
                });

        unsubscribeOnDestroy(disposable);

    }


    public void errorCancel() {
        getViewState().hideError();
    }

}
