package com.example.lwg.okhttp_lwg.http.okhttp.builder;

import java.util.Map;

/**
 * 实现两个接口
 * Created by lwg on 2017/4/25.
 */

public interface HasParamsable  {
    OkHttpRequestBuilder params(Map<String, String> params);
    OkHttpRequestBuilder addParams(String key, String val);
}


