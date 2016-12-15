package com.pro2on.githubdemo.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.pro2on.githubdemo.R;
import com.pro2on.githubdemo.mvp.presenter.LoginPresenter;
import com.pro2on.githubdemo.mvp.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Date: 23.11.16
 * Time: 16:36
 * <p>
 * Created by pro2on in project GithubDemo
 */

public class LoginActivity extends MvpAppCompatActivity implements LoginView, DialogInterface.OnCancelListener {


    private static final int LAYOUT = R.layout.activity_login;


    @InjectPresenter
    LoginPresenter presenter;
    @BindView(R.id.etUsername)
    EditText loginEditView;
    @BindView(R.id.btnStartSession)
    Button loginButton;
    @BindView(R.id.pbLoading)
    ProgressBar progressView;

    private AlertDialog errorDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(LAYOUT);
        ButterKnife.bind(this);

        errorDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setOnCancelListener(this)
                .create();
    }


    @Override
    public void showProgress() {
        toggleProgressVisibility(true);
    }

    @Override
    public void hideProgress() {
        toggleProgressVisibility(false);
    }

    @Override
    public void showError(String message) {
        errorDialog.setMessage(message);
        errorDialog.show();
    }

    @Override
    public void hideError() {
        errorDialog.cancel();
    }

    @Override
    public void showFieldError(Integer loginError) {
        if (loginError != null) {
            loginEditView.setError(getString(loginError));
        }
    }

    @Override
    public void successLogin() {
        final Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }

    private void toggleProgressVisibility(final boolean show) {
        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        loginButton.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        presenter.errorCancel();
    }


    @Override
    protected void onDestroy() {
        if (errorDialog != null) {
            errorDialog.setOnCancelListener(null);
            errorDialog.dismiss();
        }

        super.onDestroy();
    }


    @OnClick(R.id.btnStartSession)
    public void attemptLogin() {
        presenter.login(loginEditView.getText().toString());
    }

}
