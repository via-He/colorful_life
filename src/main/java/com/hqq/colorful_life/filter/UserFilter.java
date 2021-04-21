package com.hqq.colorful_life.filter;

import com.hqq.colorful_life.common.Constant;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Qingqing.He
 * @date 2021/1/4 11:02
 * 描述：用户校验过滤器
 */
@Slf4j
public class UserFilter implements Filter {

    @Resource
    UserService userService;

    public static User currentUser;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse,
                         FilterChain filterChain) throws
                                                                                                                  IOException,
                                                                                                                  ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "Origin");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, GET");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials","true");
        HttpSession session = request.getSession();

        currentUser = (User) session.getAttribute(Constant.USER);
        log.info("已拿到当前用户currentUser:{}"+currentUser);
        if (currentUser == null){
            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            out.write("{\n" +" \"status\": 10007,\n" + "    \"msg\": \"NEED_LOGIN\",\n" + "    \"data\": null\n" + "}");
            out.flush();
            out.close();
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
