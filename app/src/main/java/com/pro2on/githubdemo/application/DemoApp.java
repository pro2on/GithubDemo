package com.pro2on.githubdemo.application;

import android.app.Application;

import com.arellomobile.mvp.MvpFacade;
import com.pro2on.githubdemo.BuildConfig;
import com.pro2on.githubdemo.application.timber.CrashReportingTree;
import com.pro2on.githubdemo.di.AppComponent;
import com.pro2on.githubdemo.di.DaggerAppComponent;
import com.pro2on.githubdemo.di.module.ApplicationModule;
import com.pro2on.githubdemo.di.module.UserModule;

import timber.log.Timber;

/**
 * Created by pro2on on 23.11.16.
 */

public class DemoApp extends Application {



    private static AppComponent sAppComponent;




    @Override
    public void onCreate() {
        super.onCreate();



        // Plant Timber Tree
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }



        // init storage for moxy presenters
        MvpFacade.init();


        // resolve dagger 2 dependencies
        resolveDependencies();

    }



    public static AppComponent getAppComponent() {
        return sAppComponent;
    }




    private void resolveDependencies() {

        sAppComponent =
                DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .userModule(new UserModule())
                .build();

    }

}
