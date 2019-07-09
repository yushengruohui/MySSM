package com.yusheng.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
方法耗时拦截器
 */
public class MethodTimeCountInterceptor implements HandlerInterceptor {
    //记录日志
    private static final Logger logger = Logger.getLogger(MethodTimeCountInterceptor.class);

    // 前置处理，请求到达之前处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        //记录请求
        logger.info("请求： " + request.getRequestURI() + "已到达");

        //一定要返回true，这样程序才会继续执行
        return true;
    }


    // 后置处理，请求到达之后，视图未生成的时候处理
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");

        long spendTime = endTime - startTime;

        if (spendTime < 1000) {
            logger.error("方法耗时:" + spendTime + "，速度正常 ");
        } else {
            logger.warn("方法耗时:" + spendTime + "，耗时严重，请及时修改");
        }
    }

    //完成后处理，请求到达后，视图生成完成后处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
