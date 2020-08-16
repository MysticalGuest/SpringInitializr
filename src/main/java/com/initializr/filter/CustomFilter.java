package com.initializr.filter;

import com.initializr.controller.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class CustomFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(CustomFilter.class);

    // filter初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // filter过滤值
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("My Filter process...");
        // 放行
        chain.doFilter(request, response);
    }

    // filter销毁
    @Override
    public void destroy() {

    }
}
