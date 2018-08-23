package pers.shengc.simpledelaytask.common;

import lombok.Data;

import java.io.Serializable;


/**
 * @author sc
 * @create 2018-08-22-10:26
 **/
@Data
public abstract class AbstractTaskBase implements Serializable {

    /**
     * 任务唯一标识
     */
    private String taskId;


    /**
     * 执行任务的方法
     */
    public abstract void taskExecutor();

}
