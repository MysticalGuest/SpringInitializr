package com.initializr.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 监听启动和销毁
public class CustomListener implements ServletContextListener {

    private static final Logger LOG = LoggerFactory.getLogger(CustomListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("contextInitialized...web应用启动...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("contextInitialized...当前web项目销毁...");
    }
}
