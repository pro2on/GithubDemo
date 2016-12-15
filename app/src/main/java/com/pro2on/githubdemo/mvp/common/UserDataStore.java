package com.pro2on.githubdemo.mvp.common;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.pro2on.githubdemo.mvp.model.User;

/**
 * Date: 14.12.16
 * Time: 15:49
 * Created by pro2on in project GithubDemo
 */

public class UserDataStore {

    private static final String KEY_SERIALIZED_USER = "serialized_user";

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public UserDataStore(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public void createUser(User user) {
        String serializedUser = gson.toJson(user);
        sharedPreferences.edit().putString(KEY_SERIALIZED_USER, serializedUser).apply();
    }

    public void clearUser() {
        sharedPreferences.edit().remove(KEY_SERIALIZED_USER).apply();
    }

    public User getUser() {
        String serializedUser = sharedPreferences.getString(KEY_SERIALIZED_USER, null);
        if (!TextUtils.isEmpty(serializedUser)) {
            return gson.fromJson(serializedUser, User.class);
        }

        return null;
    }

}
