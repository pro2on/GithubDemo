package com.pro2on.githubdemo.di.module;

import android.content.SharedPreferences;

import com.pro2on.githubdemo.mvp.common.TokenDataStore;

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


    @Provides
    @Singleton
    TokenDataStore provideTokenDataStore(SharedPreferences sharedPreferences) {
        return new TokenDataStore(sharedPreferences);
    }

}
