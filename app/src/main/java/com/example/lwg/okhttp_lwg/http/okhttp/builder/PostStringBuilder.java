package com.example.lwg.okhttp_lwg.http.okhttp.builder;

import com.example.lwg.okhttp_lwg.http.okhttp.request.PostStringRequest;
import com.example.lwg.okhttp_lwg.http.okhttp.request.RequestCall;

import okhttp3.MediaType;

/**
 * Created by lwg on 2017/4/25.
 */

public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder> {
    private String content;
    private MediaType mediaType;
    //有参构造
    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }
    //有参构造
    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }
    //重写父类方法
    @Override
    public RequestCall build() {
        return new PostStringRequest(url, tag, params, headers, content, mediaType,id).build();
    }
}
