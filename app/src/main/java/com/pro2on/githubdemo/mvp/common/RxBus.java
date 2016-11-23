package com.pro2on.githubdemo.mvp.common;


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

    private final Subject<Object> _bus = PublishSubject.create();

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> asObservable() {
        return _bus;
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }

}
