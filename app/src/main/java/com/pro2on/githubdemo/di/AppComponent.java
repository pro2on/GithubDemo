package com.pro2on.githubdemo.di;

import com.pro2on.githubdemo.di.module.ApiModule;
import com.pro2on.githubdemo.di.module.ApplicationModule;
import com.pro2on.githubdemo.di.module.UserModule;
import com.pro2on.githubdemo.mvp.model.UserManager;
import com.pro2on.githubdemo.mvp.presenter.BasePresenter;
import com.pro2on.githubdemo.mvp.presenter.BaseUserPresenter;
import com.pro2on.githubdemo.mvp.presenter.LoginPresenter;
import com.pro2on.githubdemo.mvp.presenter.SplashPresenter;
import com.pro2on.githubdemo.mvp.view.BaseUserView;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by pro2on on 23.11.16.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface AppComponent {



    UserComponent.Builder userComponentBuilder();


    UserManager getUserManager();

    void inject(SplashPresenter splashPresenter);
    void inject(LoginPresenter loginPresenter);

}
