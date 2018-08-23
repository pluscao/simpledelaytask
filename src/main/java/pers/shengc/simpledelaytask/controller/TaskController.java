package pers.shengc.simpledelaytask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.shengc.simpledelaytask.biz.TaskService;
import pers.shengc.simpledelaytask.config.TaskSettings;

import java.text.ParseException;

import static pers.shengc.simpledelaytask.util.FormatUtils.dateToMillis;

/**
 * @author sc
 * @create 2018-08-22-16:16
 **/
@RestController()
public class TaskController {
    private TaskService taskService;
    private TaskSettings taskSettings;

    @Autowired
    public TaskController(TaskService taskService, TaskSettings taskSettings) {
        this.taskService = taskService;
        this.taskSettings = taskSettings;
    }

    @PostMapping("/add")
    public void addTask(String time) throws Exception {
        Long millisTime = null;
        //TODO 采用全局处理异常

        millisTime = dateToMillis(time);

        taskService.addTask(millisTime);
    }


}
