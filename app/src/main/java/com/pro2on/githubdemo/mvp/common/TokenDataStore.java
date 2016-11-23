package com.pro2on.githubdemo.mvp.common;

import android.content.SharedPreferences;

/**
 * Date: 23.11.16
 * Time: 19:48
 * Created by pro2on in project GithubDemo
 */

public class TokenDataStore {


    private static final String TOKEN = "token";


    private SharedPreferences sharedPreferences;


    public TokenDataStore(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }



    public void setToken(String token) {
        sharedPreferences.edit().putString(TOKEN, token).apply();
    }


    public String getToken() {
        return sharedPreferences.getString(TOKEN, "");
    }


    public void clearToken() {
        sharedPreferences.edit().remove(TOKEN).apply();
    }

}
