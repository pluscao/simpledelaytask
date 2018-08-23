package pers.shengc.simpledelaytask.biz;

import org.springframework.stereotype.Service;
import pers.shengc.simpledelaytask.common.AbstractTaskBase;

/**
 * @author sc
 * @create 2018/8/22
 * @desc
 **/

public interface TaskService {
    /**
     * 添加任务到队列
     * @param time
     */
    void addTask(Long time) throws Exception;

    /**
     * 开启定时器
     */
    void countStart();

    /**
     * 线程启动
     * @return
     */
     void startTask();
}
