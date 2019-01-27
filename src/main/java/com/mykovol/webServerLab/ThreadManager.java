package com.mykovol.webServerLab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);


    public static void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static void execute(Runnable runnable) {
        executor.execute(runnable);
    }

}
