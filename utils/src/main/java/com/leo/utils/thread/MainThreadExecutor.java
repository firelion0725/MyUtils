package com.leo.utils.thread;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 * @author leo, ZhangWei
 * @date 2018/7/3
 */
public class MainThreadExecutor implements Executor {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
