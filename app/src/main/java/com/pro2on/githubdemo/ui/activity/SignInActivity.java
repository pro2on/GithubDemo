package com.pro2on.githubdemo.ui.activity;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.pro2on.githubdemo.R;

/**
 * Date: 23.11.16
 * Time: 16:36
 *
 * Created by pro2on in project GithubDemo
 */

public class SignInActivity extends MvpAppCompatActivity {


    private static final int LAYOUT = R.layout.activity_sign_in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(LAYOUT);
    }
}
