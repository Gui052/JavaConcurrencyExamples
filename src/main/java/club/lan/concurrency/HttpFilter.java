package club.lan.concurrency;

import club.lan.concurrency.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  14:01
 */
@Slf4j
public class HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //request.getSession().getAttribute("user"); //登录的时候取出
        log.info("do filter,{},{}", Thread.currentThread().getId(), request.getServletPath());

        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
