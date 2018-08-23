package pers.shengc.simpledelaytask.entity;

import lombok.Data;
import pers.shengc.simpledelaytask.common.AbstractTaskBase;

import java.util.Date;

/**
 * 延迟通知任务
 * @author sc
 * @create 2018-08-22-15:34
 **/
@Data
public class DelayAlertTask extends AbstractTaskBase {
    /**
     * 任务将在第几轮被执行，当 taskCount=0时，表示立即执行
     */
    private Integer taskCount;

    public DelayAlertTask(Integer taskCount) {
        this.taskCount = taskCount;
    }

        @Override
    public void taskExecutor() {
        //TODO http
        System.out.println(new Date());
        System.out.println("your setting is alert now");
    }
}
