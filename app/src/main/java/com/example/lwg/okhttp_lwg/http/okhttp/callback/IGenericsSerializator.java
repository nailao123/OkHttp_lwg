package com.example.lwg.okhttp_lwg.http.okhttp.callback;

/**
 * Created by lwg on 2017/4/25.
 */

public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}

