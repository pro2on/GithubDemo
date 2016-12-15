package com.pro2on.githubdemo.di.module;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.pro2on.githubdemo.api.GithubApi;
import com.pro2on.githubdemo.di.scopes.UserScope;
import com.pro2on.githubdemo.mvp.common.TokenDataStore;
import com.pro2on.githubdemo.mvp.common.UserDataStore;
import com.pro2on.githubdemo.mvp.model.RepositoriesManager;
import com.pro2on.githubdemo.mvp.model.User;
import com.pro2on.githubdemo.mvp.model.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Date: 23.11.16
 * Time: 20:02
 * Created by pro2on in project GithubDemo
 */

@Module
public class UserModule {

    private User user;


    public UserModule(User user) {
        this.user = user;
    }


    @Provides
    @UserScope
    User provideUser() {
        return user;
    }



    @Provides
    @UserScope
    RepositoriesManager provideRepositoriesManager(User user, GithubApi githubApi) {
        return new RepositoriesManager(user, githubApi);
    }
}
