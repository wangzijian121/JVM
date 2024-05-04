package 多线程.java并发编程.java共享模型_工具.线程池.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用Executors创建【固定】大小的线程池
 *
 * @author zijian Wang
 */

public class NewFixedThreadPoolTest {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);

    public static void main(String[] args) {
        //不建议使用Executors 创建线程池❌
        ExecutorService executorService = Executors.newFixedThreadPool(10, (runnable) -> {
            Thread thread = new Thread(runnable);
            // 设置线程的一些属性，比如名称、优先级等等
            thread.setName("固定长度的线程池 - " + poolNumber.getAndIncrement());
            return thread;
        });
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.shutdown();
    }
}

