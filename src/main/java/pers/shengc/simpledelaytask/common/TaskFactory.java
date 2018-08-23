package pers.shengc.simpledelaytask.common;

import lombok.Data;

/**
 * @author sc
 * @create 2018-08-22-17:18
 **/
@Data
public class TaskFactory {
    private TaskCircle taskCircle;
    private static TaskFactory taskFactory;

    public TaskFactory(Integer threadPoolSize) {
        this.taskCircle = new TaskCircle(threadPoolSize);
    }

    public static synchronized TaskCircle getTaskCircleInstance(){
        if (taskFactory == null){
            //TODO 线程数
            return new TaskFactory(8).getTaskCircle();
        }
        return taskFactory.getTaskCircle();
    }
}
