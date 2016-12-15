package com.pro2on.githubdemo.api;

import com.pro2on.githubdemo.api.response.RepositoryResponse;
import com.pro2on.githubdemo.api.response.UserResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Date: 14.12.16
 * Time: 14:48
 * Created by pro2on in project GithubDemo
 */

public interface GithubApi {



    @GET("/users/{username}")
    Observable<UserResponse> getUser(@Path("username") String username
    );



    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );



}
