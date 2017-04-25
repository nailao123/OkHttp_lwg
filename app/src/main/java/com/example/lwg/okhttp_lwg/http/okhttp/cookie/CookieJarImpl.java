package com.example.lwg.okhttp_lwg.http.okhttp.cookie;

import com.example.lwg.okhttp_lwg.http.okhttp.cookie.store.CookieStore;
import com.example.lwg.okhttp_lwg.http.okhttp.utils.Exceptions;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by lwg on 2017/4/25.
 */

public class CookieJarImpl  implements CookieJar {

    private CookieStore  cookieStore;
    //有参构造
    public CookieJarImpl(CookieStore cookieStore)
    {
        if (cookieStore == null)Exceptions.illegalArgument("cookieStore can not be null.");
        this.cookieStore = cookieStore;
    }

    @Override
    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies)
    {
        cookieStore.add(url, cookies);
    }

    @Override
    public synchronized List<Cookie> loadForRequest(HttpUrl url)
    {
        return cookieStore.get(url);
    }

    public CookieStore getCookieStore()
    {
        return cookieStore;
    }
}
