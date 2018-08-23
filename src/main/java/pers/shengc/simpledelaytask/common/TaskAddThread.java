package pers.shengc.simpledelaytask.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author sc
 * @create 2018-08-22-14:40
 **/
public class TaskAddThread implements Runnable {
    /** 待添加的任务 */
    private Integer index;
    /** 任务环 */
    private ConcurrentHashMap<Integer,Vector<AbstractTaskBase>> taskCircle;
    /** 待添加的任务 */
    private AbstractTaskBase task;
    /** 专门用来做锁的 */
    private static final Object LOCK = new Object();

    public TaskAddThread(Integer index, AbstractTaskBase task, ConcurrentHashMap<Integer,Vector<AbstractTaskBase>> taskCircle) {
        this.index = index;
        this.task = task;
        this.taskCircle = taskCircle;
    }

    @Override
    public void run() {
        synchronized (LOCK) {

            Vector<AbstractTaskBase> tasks = taskCircle.get(index);
            if (tasks == null){
                tasks = new Vector<>();
            }
            tasks.add(task);
            taskCircle.put(index,tasks);
            //TODO
            System.out.println("add success!");
        }
    }
}
