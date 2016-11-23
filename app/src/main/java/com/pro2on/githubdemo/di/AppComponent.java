package com.pro2on.githubdemo.di;

import com.pro2on.githubdemo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by pro2on on 23.11.16.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {
}
