package com.sxg;


import com.sxg.filter.SecondFilter;
import com.sxg.listener.SecondListener;
import com.sxg.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * springboot 整合servlet方式二
 */
@SpringBootApplication
public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }

    /**
     * 注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean =new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }

    /**
     * 注册filter
     * @return
     */
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
//        bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        bean.addUrlPatterns("/second");
        return bean;
    }

    /**
     * 注册listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean(new SecondListener());
        return bean;
    }
}
