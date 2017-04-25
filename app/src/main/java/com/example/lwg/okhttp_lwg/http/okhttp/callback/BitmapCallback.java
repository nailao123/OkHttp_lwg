package com.example.lwg.okhttp_lwg.http.okhttp.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Response;

/**
 * 图片抽象类
 * Created by lwg on 2017/4/25.
 */

public  abstract  class BitmapCallback   extends   Callback<Bitmap>{

    @Override
    public Bitmap parseNetworkResponse(Response response , int id) throws Exception
    {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }

}
