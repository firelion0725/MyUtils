package com.leo.utils.thread;

/**
 * @author leo, ZhangWei
 * @date 2018/7/3
 */
public abstract class PriorityRunnable implements Runnable {
    private final Priority priority;

    public PriorityRunnable(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}
