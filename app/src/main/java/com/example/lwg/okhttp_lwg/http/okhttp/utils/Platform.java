package com.example.lwg.okhttp_lwg.http.okhttp.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by lwg on 2017/4/25.
 *  *  Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * * HTTP：/ / www.apache。org /许可证/ license-2.0
 *
 *除非适用法律或书面同意，软件
 *在许可证下分发的“按需”分配，
 *无任何保证或条件，明示或默示。
 *查看特定语言的权限和权限
 ＊牌照下的限制。
 */

public class Platform {
    private static final Platform PLATFORM = findPlatform();

    public static Platform get()
    {
        L.e(PLATFORM.getClass().toString());
        return PLATFORM;
    }

    private static Platform findPlatform()
    {
        try
        {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0)
            {
                return new Android();
            }
        } catch (ClassNotFoundException ignored)
        {
        }
        return new Platform();
    }

    public Executor defaultCallbackExecutor()
    {
        return Executors.newCachedThreadPool();
    }

    public void execute(Runnable runnable)
    {
        defaultCallbackExecutor().execute(runnable);
    }


    static class Android extends Platform
    {
        @Override
        public Executor defaultCallbackExecutor()
        {
            return new MainThreadExecutor();
        }

        static class MainThreadExecutor implements Executor
        {
            private final Handler handler = new Handler(Looper.getMainLooper());

            @Override
            public void execute(Runnable r)
            {
                handler.post(r);
            }
        }
    }
}
