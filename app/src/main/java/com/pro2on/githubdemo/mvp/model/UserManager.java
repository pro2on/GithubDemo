package com.pro2on.githubdemo.mvp.model;

import com.pro2on.githubdemo.api.GithubApi;
import com.pro2on.githubdemo.di.UserComponent;
import com.pro2on.githubdemo.di.module.UserModule;
import com.pro2on.githubdemo.mvp.common.UserDataStore;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Date: 23.11.16
 * Time: 17:24
 * Created by pro2on in project GithubDemo
 */

public class UserManager {

    private GithubApi githubApi;
    private UserDataStore userDataStore;

    private UserComponent.Builder userComponentBuilder;
    private UserComponent userComponent;


    public UserManager(GithubApi githubApi, UserDataStore userDataStore,
                       UserComponent.Builder userComponentBuilder) {
        this.githubApi = githubApi;
        this.userDataStore = userDataStore;
        this.userComponentBuilder = userComponentBuilder;
    }


    public Observable<User> startSessionForUser(String username) {
        return githubApi.getUser(username)
                .map(User.UserResponseToUser())
                .doOnNext(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        userDataStore.createUser(user);
                        startUserSession();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    private boolean startUserSession() {
        User user = userDataStore.getUser();
        if (user != null) {
            Timber.i("Session started, user: %s", user);
            userComponent = userComponentBuilder.sessionModule(new UserModule(user)).build();
            return true;
        }
        return false;
    }


    private void closeUserSession() {
        Timber.i("Close session for user: %s", userDataStore.getUser());
        userDataStore.clearUser();
        userComponent = null;
    }



    public boolean isUserSessionIsStartedOrStartSessionIfPossible() {
        return userComponent != null || startUserSession();
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }


}
