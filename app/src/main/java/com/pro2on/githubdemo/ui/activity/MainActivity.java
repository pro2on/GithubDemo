package com.pro2on.githubdemo.ui.activity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.pro2on.githubdemo.mvp.presenter.UserPresenter;
import com.pro2on.githubdemo.mvp.view.UserView;

import timber.log.Timber;

/**
 * Date: 23.11.16
 * Time: 16:28
 * Created by pro2on in project GithubDemo
 */

public class MainActivity extends MvpAppCompatActivity implements UserView {


    private static final int LAYOUT = 1;


    @InjectPresenter
    UserPresenter userPresenter;

    @Override
    public void showUserName(String username) {
        Timber.d("user name: %s", username);
        getSupportActionBar().setTitle(username);
    }


    @Override
    public void onUserFinish() {
        Timber.d("need to logout");
    }

}
