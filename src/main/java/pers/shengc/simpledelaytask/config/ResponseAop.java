package pers.shengc.simpledelaytask.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static pers.shengc.simpledelaytask.util.FormatUtils.formatResp;

/**
 * 全局异常处理类
 *
 * @author sc
 * @create 2018-08-23-15:03
 **/
@Aspect
public class ResponseAop {
    @Pointcut("execution(* pers.shengc.simpledelaytask.controller.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String message = "ok";
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            result = formatResp(throwable);
        }finally {
            return result;
        }

        //TODO 没有日志系统哦
    }

}
