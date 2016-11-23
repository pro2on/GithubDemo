package com.pro2on.githubdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.pro2on.githubdemo.mvp.presenter.SplashPresenter;
import com.pro2on.githubdemo.mvp.view.SplashView;

import timber.log.Timber;


/**
 * Date: 23.11.16
 * Time: 16:19
 *
 * Created by pro2on in project GithubDemo
 */

public class SplashActivity extends MvpAppCompatActivity implements SplashView {


    @InjectPresenter
    SplashPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // By default view attaches to presenter in onStart() method,
        // but we attach it manually for earlier check authorization state.
        getMvpDelegate().onAttach();


        presenter.checkIsUserAuthorized();
    }

    @Override
    public void setAuthorized(boolean isAuthorized) {
        Timber.d("user is authorized: %s", isAuthorized);
        startActivityForResult(new Intent(this, isAuthorized ? MainActivity.class : SignInActivity.class) , 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }

}
