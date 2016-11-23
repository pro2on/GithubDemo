package com.pro2on.githubdemo.mvp.presenter;


import com.arellomobile.mvp.MvpPresenter;
import com.pro2on.githubdemo.mvp.view.LoginView;

/**
 * Date: 23.11.16
 * Time: 16:37
 * Created by pro2on in project GithubDemo
 */


public class LoginPresenter extends MvpPresenter<LoginView> {


    @Override
    public void attachView(LoginView view) {
        super.attachView(view);


        // TODO : check user

    }
}
