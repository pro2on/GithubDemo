package com.pro2on.githubdemo.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.pro2on.githubdemo.api.GithubApi;
import com.pro2on.githubdemo.application.DemoApp;
import com.pro2on.githubdemo.di.UserComponent;
import com.pro2on.githubdemo.mvp.common.RxBus;
import com.pro2on.githubdemo.mvp.common.TokenDataStore;
import com.pro2on.githubdemo.mvp.common.UserDataStore;
import com.pro2on.githubdemo.mvp.model.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pro2on on 23.11.16.
 */

@Module
public class ApplicationModule {


    private DemoApp application;


    public ApplicationModule(DemoApp application) {
        this.application = application;
    }


    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }



    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }



    @Provides
    Gson provideGson() {
        return new Gson();
    }


    @Provides
    @Singleton
    RxBus provideRxBus() {
        return new RxBus();
    }

    @Provides
    @Singleton
    TokenDataStore provideTokenDataStore(SharedPreferences sharedPreferences) {
        return new TokenDataStore(sharedPreferences);
    }



    @Provides
    @Singleton
    UserDataStore provideUserDataStore(SharedPreferences sharedPreferences, Gson gson) {
        return new UserDataStore(sharedPreferences, gson);
    }



    @Provides
    @Singleton
    UserManager provideUserManager(UserDataStore userDataStore, GithubApi githubApi, UserComponent.Builder userComponentBuilder) {
        return new UserManager(githubApi, userDataStore, userComponentBuilder);
    }
}
