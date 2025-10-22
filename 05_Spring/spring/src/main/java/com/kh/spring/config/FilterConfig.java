package com.kh.spring.config;

import com.kh.spring.filter.RequesetTimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//필터 등록 및 설정을 위한 Configuration 클래스
@Configuration
public class FilterConfig {

        /*
            기본적으로 필터는 @Component 어노테이션으로  Bean에 등록해도 되지만
            좀더 디테일한 설정을 할 때는 FilterRegistrationBean이라는 객체를 사용,
         */
    @Bean
    public FilterRegistrationBean<RequesetTimeFilter> filterFilterRegistrationBean(RequesetTimeFilter filter) {
        FilterRegistrationBean<RequesetTimeFilter> registration = new FilterRegistrationBean<>();

        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setOrder(1); //필터 우선 순위 숫자가 낮을수록 먼저 실행
        registration.setName("requestTimeFilter");


        return registration;
    }

}
