package com.lee.filter;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author : Liw
 * @description :
 * @date : 2018/7/16 14:44
 */
@Order(1)
@WebFilter(filterName = "corFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "cors.allowed.origins", value = "*"),
        @WebInitParam(name = "cors.allowed.methods", value = "GET,POST"),
        @WebInitParam(name = "cors.allowed.headers", value = "Content-Type,Authorization,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers"),
        @WebInitParam(name = "cors.exposed.header", value = "Access-Control-Allow-Credentials,Access-Control-Allow-Origin,Access-Control-Expose-Headers,Content-Type,Content-Disposition"),
        @WebInitParam(name = "cors.support.credentials", value = "true"),
        @WebInitParam(name = "cors.preflight.maxage", value = "10")
})
public class CorFilter extends CorsFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(servletRequest, servletResponse, filterChain);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
