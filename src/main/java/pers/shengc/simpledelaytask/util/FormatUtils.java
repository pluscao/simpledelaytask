package pers.shengc.simpledelaytask.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 一些需要的转换函数
 * @author sc
 * @create 2018-08-23-9:27
 **/
public class FormatUtils {

    /**
     * 时间转毫秒数
     * @param date
     * @return
     * @throws ParseException
     */
    public static Long dateToMillis(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(date).getTime();
    }

    public static String formatResp(Throwable ex){
        return ex.getMessage();
    }
}
