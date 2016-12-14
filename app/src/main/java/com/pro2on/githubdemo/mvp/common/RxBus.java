package com.pro2on.githubdemo.mvp.common;


import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


/**
 * Time: 15:53
 * Date: 23.11.16
 *
 * Created by pro2on in project GithubDemo
 */

public class RxBus {

    private final Relay<Object> _bus = PublishRelay.create().toSerialized();

    public void send(Object o) {
        _bus.accept(o);
    }

    public Observable<Object> asObservable() {
        return _bus;
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }

}
