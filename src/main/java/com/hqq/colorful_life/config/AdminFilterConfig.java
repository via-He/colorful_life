package com.hqq.colorful_life.config;

import com.hqq.colorful_life.filter.AdminFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author Qingqing.He
 * @date 2021/1/4 13:39
 * 描述：通过FilterRegistrationBean实例自定义admin过滤器
 */
@Configuration
public class AdminFilterConfig {
    @Bean
    public AdminFilter adminFilter(){
        return new AdminFilter();
    }

    @Bean(name="adminFilterConf")
    public FilterRegistrationBean adminFilterConfig(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean =
            new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(adminFilter());
        filterFilterRegistrationBean.addUrlPatterns("/user/admin/*");
        filterFilterRegistrationBean.addUrlPatterns("/notice/admin/*");
        filterFilterRegistrationBean.addUrlPatterns("/admin/*");
        filterFilterRegistrationBean.addUrlPatterns("/reco/admin/*");
        filterFilterRegistrationBean.setName("adminFilterConf");
        return filterFilterRegistrationBean;
    }
}
