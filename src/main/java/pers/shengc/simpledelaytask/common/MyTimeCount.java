package pers.shengc.simpledelaytask.common;

import pers.shengc.simpledelaytask.entity.DelayAlertTask;

import java.util.Iterator;
import java.util.TimerTask;

import static pers.shengc.simpledelaytask.entity.configDTO.CIRCLE_SIZE;

/**
 * @author sc
 * @create 2018-08-23-10:03
 **/
public class MyTimeCount extends TimerTask {
    private Integer index = 0;


    @Override
    public void run() {
        if (index < CIRCLE_SIZE){
            index ++;
        }else {
            index = 1;
        }
        System.out.println("index:"+ index + TaskCircle.getTaskCircle());
        if (TaskCircle.getTaskCircle().get(index) == null){
            return;
        }

        Iterator it = TaskCircle.getTaskCircle().get(index).iterator();
        while (it.hasNext()) {
            DelayAlertTask task = (DelayAlertTask)it.next();
            if (task.getTaskCount() == 0){
                TaskFactory.getTaskCircleInstance().taskExecut(task);
                it.remove();
            }else{
                task.setTaskCount(task.getTaskCount() -1);
            }
        }

    }
}
