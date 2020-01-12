package com.lcke.demo.utils.config;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 拦截器
 *
 * @Author niujinpeng
 * @Date 2019/1/6 16:54
 */
@Slf4j
public class LogHandlerInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 请求方法执行之前
     * 返回true则通过
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        StringBuffer requestURL = request.getRequestURL();
        logger.info("preHandle请求URL：" + requestURL.toString());
        return true;
    }

    /**
     * 返回modelAndView之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("postHandle返回modelAndView之前");
    }

    /**
     * 执行Handler完成执行此方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("afterCompletion执行完请求方法完全返回之后");
    }
}