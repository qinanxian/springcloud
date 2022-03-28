package com.lih.userserver.config;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpRetryException;

/**
 * 2022-03-28
 * 作者: lih
 * 登录过滤器实现
 */
//@Component
@WebFilter(urlPatterns = "/api/*")
public class LoginFilter implements Filter {
    protected static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        //1.获取资源请求路径
        String requestURI = req.getRequestURI();

        Object user = req.getSession().getAttribute("user");
        if(user != null){
            //登录了。放行
            filterChain.doFilter(req, res);
        }else{
            //没有登录
            logger.error("非法访问[" + req.getRequestURI() + "]");
            res.setStatus(401);
        }
    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器");
    }
}
