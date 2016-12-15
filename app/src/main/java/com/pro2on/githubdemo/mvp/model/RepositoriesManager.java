package com.pro2on.githubdemo.mvp.model;

import com.pro2on.githubdemo.api.GithubApi;
import com.pro2on.githubdemo.api.response.RepositoryResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Date: 14.12.16
 * Time: 18:20
 * Created by pro2on in project GithubDemo
 */

public class RepositoriesManager {

    private User user;
    private GithubApi githubApi;

    public RepositoriesManager(User user, GithubApi githubApi) {
        this.user = user;
        this.githubApi = githubApi;
    }


    public Observable<List<String>> getUserRepositories() {
        return githubApi.getUsersRepositories(user.login)
                .map(new Function<List<RepositoryResponse>, List<String>>() {
                    @Override
                    public List<String> apply(List<RepositoryResponse> repositoryResponses) throws Exception {
                        List<String> repositories = new ArrayList<String>();
                        for (RepositoryResponse repositoryResponse : repositoryResponses) {
                            repositories.add(repositoryResponse.name);
                        }
                        return repositories;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
