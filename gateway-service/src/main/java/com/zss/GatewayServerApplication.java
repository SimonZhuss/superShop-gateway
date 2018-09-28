package com.zss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zss.gateway.config.PostFilter;
import com.zss.gateway.config.PreFilter;
import com.zss.gateway.config.RouteFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class,args);
	}
	
	// 配置过滤器,可以配置多个过滤器
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
}
