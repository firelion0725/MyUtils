package com.leo.utils;

import android.os.Process;
import android.support.annotation.NonNull;
import android.util.Log;

import com.leo.utils.thread.DefaultExecutorSupplier;
import com.leo.utils.thread.DefaultPriorityExecutorSupplier;
import com.leo.utils.thread.PriorityRunnable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author leo, ZhangWei
 * @date 2018/4/17
 * @function
 */
public class ThreadUtils {

    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    /**
     * 提供自定义线程池的方法
     *
     * @param threadFactory            线程工厂
     * @param rejectedExecutionHandler 处理器
     * @return {@link ExecutorService}
     */
    public static ExecutorService createThreadPool(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        return new ThreadPoolExecutor(NUMBER_OF_CORES,
                NUMBER_OF_CORES * 2, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, taskQueue,
                threadFactory, rejectedExecutionHandler);
    }

    /**
     * 提供默认线程池
     * 线程工厂默认为 new Thread(Runnable r)
     *
     * @return {@link ExecutorService}
     */
    public static ExecutorService createDefaultThreadPool() {
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        return new ThreadPoolExecutor(NUMBER_OF_CORES,
                NUMBER_OF_CORES * 2, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, taskQueue,
                new BackgroundThreadFactory());
    }


    private static class BackgroundThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(@NonNull Runnable r) {
            return new Thread(r);
        }
    }

    /**
     * 内部封装线程池 线程调用线程模式为 Process.THREAD_PRIORITY_DEFAULT
     * 具体见{@link Process},{@link DefaultExecutorSupplier}
     *
     * @param runnable 具体线程
     */
    public static void doSomeBackgroundWork(Runnable runnable) {
        DefaultExecutorSupplier.getInstance().forBackgroundTasks().execute(runnable);
    }

    /**
     * 内部封装线程池 线程调用 Process.THREAD_PRIORITY_BACKGROUND
     * 具体见{@link Process },{@link DefaultExecutorSupplier}
     *
     * @param runnable 具体线程
     */
    public static void doSomeLightWeightBackgroundWork(Runnable runnable) {
        DefaultExecutorSupplier.getInstance().forLightWeightBackgroundTasks().execute(runnable);
    }

    /**
     * 内部封装线程池 主线程为handler.post 实现
     * {@link DefaultExecutorSupplier}
     *
     * @param runnable runnable 具体线程
     */
    public static void doSomeMainThreadWork(Runnable runnable) {
        DefaultExecutorSupplier.getInstance().forMainThreadTasks().execute(runnable);
    }

    /**
     * 内部封装带权重的线程池 线程调用 Process.THREAD_PRIORITY_BACKGROUND
     * {@link DefaultPriorityExecutorSupplier}
     *
     * @param runnable runnable 具体线程{@link PriorityRunnable} 为一个带权重的线程
     */
    public static void doSomeTaskAtHighPriority(PriorityRunnable runnable) {
        DefaultPriorityExecutorSupplier.getInstance().forBackgroundTasks().submit(runnable);
    }

}
