package com.pro2on.githubdemo.di;

import com.pro2on.githubdemo.di.module.UserModule;
import com.pro2on.githubdemo.di.scopes.UserScope;
import com.pro2on.githubdemo.mvp.presenter.UserPresenter;

import dagger.Subcomponent;

/**
 * Date: 14.12.16
 * Time: 18:02
 * Created by pro2on in project GithubDemo
 */
@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {


    @Subcomponent.Builder
    interface Builder {
        Builder sessionModule(UserModule userModule);

        UserComponent build();
    }




    UserPresenter inject(UserPresenter userPresenter);


}
