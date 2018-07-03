package com.leo.utils.thread;

import android.os.Process;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author leo, ZhangWei
 * @date 2018/7/3
 */
public class DefaultPriorityExecutorSupplier {

    /**
     * Number of cores to decide the number of threads
     */
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    /**
     * an instance of DefaultExecutorSupplier
     */
    private static DefaultPriorityExecutorSupplier sInstance;

    private final PriorityThreadPoolExecutor mForBackgroundTasks;

    private DefaultPriorityExecutorSupplier() {

        ThreadFactory mForLightWeightThreadFactory = new
                PriorityThreadFactory(Process.THREAD_PRIORITY_BACKGROUND);

        mForBackgroundTasks = new PriorityThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                mForLightWeightThreadFactory
        );
    }

    /**
     * returns the instance of DefaultExecutorSupplier
     */
    public static DefaultPriorityExecutorSupplier getInstance() {

        if (sInstance == null) {
            synchronized (DefaultPriorityExecutorSupplier.class) {
                sInstance = new DefaultPriorityExecutorSupplier();
            }
        }
        return sInstance;
    }

    /**
     * returns the thread pool executor for background task
     */
    public ThreadPoolExecutor forBackgroundTasks() {
        return mForBackgroundTasks;
    }
}
