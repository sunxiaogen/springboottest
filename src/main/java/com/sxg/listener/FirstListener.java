package com.sxg.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * springboot 整合listener
 *
 * <listener>
 *     <listener-class>com.sxg.listener.FirstListener</listener-class>
 * </listener>
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Listener...init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
