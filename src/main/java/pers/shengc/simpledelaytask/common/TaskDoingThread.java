package pers.shengc.simpledelaytask.common;

/**
 * 任务执行线程
 * @author sc
 * @create 2018-08-23-11:05
 **/
public class TaskDoingThread implements Runnable {
    private AbstractTaskBase task;

    public TaskDoingThread(AbstractTaskBase task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.taskExecutor();
    }
}
