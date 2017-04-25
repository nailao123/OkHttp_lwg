package com.example.lwg.okhttp_lwg.http.okhttp.builder;

import com.example.lwg.okhttp_lwg.http.okhttp.OkHttpUtils;
import com.example.lwg.okhttp_lwg.http.okhttp.request.OtherRequest;
import com.example.lwg.okhttp_lwg.http.okhttp.request.RequestCall;

/**
 * Created by lwg on 2017/4/25.
 */

public class HeadBuilder extends  GetBuilder{
    //重写父类 的方法
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }

}
