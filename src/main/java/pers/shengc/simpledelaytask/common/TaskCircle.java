package pers.shengc.simpledelaytask.common;

import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import pers.shengc.simpledelaytask.config.TaskSettings;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 任务环
 * @author sc
 * @create 2018-08-22-16:23
 **/
public class TaskCircle {
    private static ConcurrentHashMap<Integer,Vector<AbstractTaskBase>> taskCircle = new ConcurrentHashMap<>();
    /**
     * 线程池
     */
    private ExecutorService threadPool;
    /**
     * 线程池大小
     */
    private int threadPoolSize;


    public TaskCircle(Integer threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
        this.threadPool = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void addTask(Integer index , AbstractTaskBase task){
        threadPool.execute(new TaskAddThread(index ,task ,taskCircle));
    }
    public void taskExecut(AbstractTaskBase task){
        threadPool.submit(new TaskDoingThread(task));
    }

    public static ConcurrentHashMap<Integer, Vector<AbstractTaskBase>> getTaskCircle() {
        return taskCircle;
    }
}
