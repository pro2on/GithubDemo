package com.pro2on.githubdemo.ui.activity;

import android.content.Intent;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.pro2on.githubdemo.mvp.view.LoginView;

/**
 * Date: 23.11.16
 * Time: 16:28
 * Created by pro2on in project GithubDemo
 */

public class MainActivity extends MvpAppCompatActivity implements LoginView {



    private static final int LAYOUT = 1;









    @Override
    public void leaveUserSpace() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }


}
