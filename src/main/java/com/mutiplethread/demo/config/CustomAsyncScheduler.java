package com.mutiplethread.demo.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CustomAsyncScheduler
 * @Description: TODO 异步线程调度管理器
 * @Author lxc
 * @Date 2020/4/2 16:08
 * @Version V1.0
 **/
public class CustomAsyncScheduler {
    private volatile static CustomAsyncScheduler instance;
    private static ThreadPoolExecutor chnlBackendQueryPool;

    private CustomAsyncScheduler() {
    }

    @SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
    public static CustomAsyncScheduler getInstance() {
        if (instance == null) {
            synchronized (CustomAsyncScheduler.class) {
                if (instance == null) {
                    instance = new CustomAsyncScheduler();
                    BlockingQueue queue = new LinkedBlockingQueue();
                    chnlBackendQueryPool = new ThreadPoolExecutor(50, 100, 30, TimeUnit.SECONDS, queue);
                    chnlBackendQueryPool.allowCoreThreadTimeOut(true);
                    setChnlBackendQueryPool(chnlBackendQueryPool);
                }
            }
        }
        return instance;
    }

    public ThreadPoolExecutor getChnlBackendQueryPool() {
        return chnlBackendQueryPool;
    }

    public static void setChnlBackendQueryPool(ThreadPoolExecutor chnlBackendQueryPool) {
        CustomAsyncScheduler.chnlBackendQueryPool = chnlBackendQueryPool;
    }

    public static void setInstance(CustomAsyncScheduler instance) {
        CustomAsyncScheduler.instance = instance;
    }
}
