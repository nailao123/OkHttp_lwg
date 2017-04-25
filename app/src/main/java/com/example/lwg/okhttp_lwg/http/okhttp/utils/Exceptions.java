package com.example.lwg.okhttp_lwg.http.okhttp.utils;

/**
 * Created by lwg on 2017/4/25.
 */

public class Exceptions {

    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }


}
