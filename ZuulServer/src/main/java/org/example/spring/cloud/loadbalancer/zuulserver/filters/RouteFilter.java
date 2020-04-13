package org.example.spring.cloud.loadbalancer.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;

import javax.servlet.http.HttpServletRequest;

public class RouteFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(PreFilter.class);

    @Autowired
    private ProxyRequestHelper helper;

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String uri = this.helper.buildZuulRequestURI(request);

        log.info("ROUTE-FILTER: The ui: " + uri);

        return null;
    }
}
