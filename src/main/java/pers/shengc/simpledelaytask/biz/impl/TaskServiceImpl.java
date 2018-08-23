package pers.shengc.simpledelaytask.biz.impl;

import org.springframework.stereotype.Service;
import pers.shengc.simpledelaytask.biz.TaskService;
import pers.shengc.simpledelaytask.common.AbstractTaskBase;
import pers.shengc.simpledelaytask.common.MyTimeCount;
import pers.shengc.simpledelaytask.common.TaskFactory;
import pers.shengc.simpledelaytask.entity.DelayAlertTask;

import java.util.Timer;

import static pers.shengc.simpledelaytask.config.TaskSettings.*;
import static pers.shengc.simpledelaytask.entity.configDTO.CIRCLE_SIZE;
import static pers.shengc.simpledelaytask.entity.configDTO.TIME_AFTER;


/**
 * @author sc
 * @create 2018-08-22-17:02
 **/
@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public void addTask(Long time) throws Exception {
        // 计算当前时间与定时时间的差值md
        Long difference = time - System.currentTimeMillis();

        //定时时间要大于当前系统时间 timeAfter 毫秒才可以设置成功
        if (difference <= TIME_AFTER) {
            throw new Exception("需要一个未来的时间");
        }

        // 验证通过，启动任务定时器
        startTask();

        // 计算所在区域
        int index = (int) ((time - getStartTime()) / 1000 % CIRCLE_SIZE);
        // 计算所在轮次
        int count = (int) ((time - getStartTime()) / 1000 / CIRCLE_SIZE);

        AbstractTaskBase task = new DelayAlertTask(count);

        TaskFactory.getTaskCircleInstance().addTask(index, task);


    }

    @Override
    public void countStart() {
        Timer timer = new Timer();
        timer.schedule(new MyTimeCount(), 0, 1000);
//        ScheduledExecutorService schedule = ExecutorService.
    }

    @Override
    public void  startTask() {
        if (isAutoStart()){
            return ;
        }
        countStart();
        setAutoStart(true);
        //差不多两秒的误差。。。
        setStartTime(System.currentTimeMillis() + 2);
        return ;
    }

}
