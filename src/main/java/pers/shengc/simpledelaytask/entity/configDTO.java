package pers.shengc.simpledelaytask.entity;

/**
 * @author sc
 * @create 2018-08-22-17:10
 **/
public class configDTO {
    public static final Integer CIRCLE_SIZE=3600;

    /**
     * 定时任务的时间必须在当前系统时间 timeAfter 毫秒之后
     */
    public static Long TIME_AFTER = 60 * 1000L;
}
