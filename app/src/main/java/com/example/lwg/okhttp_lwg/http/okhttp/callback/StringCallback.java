package com.example.lwg.okhttp_lwg.http.okhttp.callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by lwg on 2017/4/25.
 */

public class StringCallback  extends Callback<String> {
    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException
    {
        return response.body().string();
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(String response, int id) {

    }
}
