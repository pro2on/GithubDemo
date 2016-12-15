package com.pro2on.githubdemo.mvp.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import org.reactivestreams.Subscription;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Date: 14.12.16
 * Time: 15:01
 * Created by pro2on in project GithubDemo
 */

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {


    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void unsubscribeOnDestroy(@NonNull Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

}
