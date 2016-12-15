package com.pro2on.githubdemo.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.pro2on.githubdemo.api.response.UserResponse;

import io.reactivex.functions.Function;

/**
 * Date: 14.12.16
 * Time: 15:16
 * Created by pro2on in project GithubDemo
 */

public class User implements Parcelable{



    public String login;
    public long id;
    public String url;
    public String email;


    public User() {
    }


    protected User(Parcel in) {
        login = in.readString();
        id = in.readLong();
        url = in.readString();
        email = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public static Function<UserResponse, User> UserResponseToUser() {
        return new Function<UserResponse, User>() {
            @Override
            public User apply(UserResponse userResponse) throws Exception {
                User user = new User();
                user.login = userResponse.login;
                user.id = userResponse.id;
                user.url = userResponse.url;
                user.email = userResponse.email;
                return user;
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeLong(id);
        parcel.writeString(url);
        parcel.writeString(email);
    }
}
