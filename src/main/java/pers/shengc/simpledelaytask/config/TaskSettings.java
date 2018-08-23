package pers.shengc.simpledelaytask.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 一些可以修改的配置信息
 *
 * @author sc
 * @create 2018-08-22-14:34
 **/
@Component
public class TaskSettings {
    /**
     * 是否自动自动定时器
     */
    private static boolean autoStart;


    private static Long startTime;

    public static boolean isAutoStart() {
        return autoStart;
    }

    public static void setAutoStart(boolean autoStart) {
        TaskSettings.autoStart = autoStart;
    }

    public static Long getStartTime() {
        return startTime;
    }

    public static void setStartTime(Long startTime) {
        TaskSettings.startTime = startTime;
    }
}
