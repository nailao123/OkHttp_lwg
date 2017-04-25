package com.example.lwg.okhttp_lwg.http.okhttp.utils;

import android.util.Log;

/**
 * Created by lwg on 2017/4/25.
 */

public class L {
    private static boolean debug = false;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("OkHttp", msg);
        }
    }

}
