package org.example.spring.cloud.loadbalancer.zuulserver;

import org.example.spring.cloud.loadbalancer.zuulserver.filters.PostFilter;
import org.example.spring.cloud.loadbalancer.zuulserver.filters.PreFilter;
import org.example.spring.cloud.loadbalancer.zuulserver.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public RouteFilter routeFilter(){
        return new RouteFilter();
    }
}
