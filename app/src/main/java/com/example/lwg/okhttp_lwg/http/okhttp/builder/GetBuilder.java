package com.example.lwg.okhttp_lwg.http.okhttp.builder;

import android.net.Uri;
import android.util.Log;

import com.example.lwg.okhttp_lwg.http.okhttp.request.RequestCall;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lwg on 2017/4/25.
 */

public class GetBuilder  extends  OkHttpRequestBuilder <GetBuilder> implements HasParamsable {
    private static final String TAG = "GetBuilder";
    //该方法是继承抽象类实现的方法
    @Override
    public RequestCall build() {
        if(params != null){
            url = appendParams(url, params);  //调用方法进行网址的拼接
        }
        return null;
    }

    protected String appendParams(String url, Map<String, String> params) {
        //http://www.apihome.cn/api/android/Uri.Builder.html参考url使用网址
        if (url == null || params == null || params.isEmpty())
        {
            return url;
        }
        Uri.Builder builder= Uri.parse(url).buildUpon();
        Log.i(TAG, "appendParams 打印出Uri.parse(url).buildUpon()对象: "+builder);
        Set<String> keys = params.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            builder.appendQueryParameter(key, params.get(key)); //  对密钥和值进行编码，然后将参数附加到查询字符串。
        }
        Log.i(TAG, "appendParams:对密钥和值进行编码，然后将参数附加到查询字符串。 "+builder.build().toString());
        return builder.build().toString();
    }


    // 重写HasParamsable 接口的实现方法
    @Override
    public GetBuilder params(Map<String, String> params)
    {
        this.params = params;
        return this;
    }
    // 重写HasParamsable 接口的实现方法
    @Override
    public GetBuilder addParams(String key, String val)
    {
        if (this.params == null)
        {
            params = new LinkedHashMap<>();
        }
        params.put(key, val);
        return this;
    }





}
