package com.pro2on.githubdemo.di;

import com.pro2on.githubdemo.di.module.ApplicationModule;
import com.pro2on.githubdemo.di.module.UserModule;
import com.pro2on.githubdemo.mvp.presenter.SplashPresenter;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by pro2on on 23.11.16.
 */

@Singleton
@Component(modules = {ApplicationModule.class, UserModule.class})
public interface AppComponent {


    void inject(SplashPresenter splashPresenter);

}
