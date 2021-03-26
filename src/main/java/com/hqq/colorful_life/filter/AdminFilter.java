package com.hqq.colorful_life.filter;

import com.hqq.colorful_life.common.Constant;
import com.hqq.colorful_life.model.domain.SysUser;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.service.UserService;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Qingqing.He
 * @date 2021/1/4 11:02
 * 描述：管理员校验过滤器
 */
public class AdminFilter implements Filter {


    public static SysUser currentSysUser;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
                                                                                                                  IOException,
                                                                                                                  ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(Constant.MALL_USER);
        currentSysUser = (SysUser) attribute;
        if (attribute == null) {
            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            out.write(
                "{\n" + " \"status\": 10007,\n" + "    \"msg\": \"NEED_LOGIN\",\n" + "    \"data\": null\n" + "}");
            out.flush();
            out.close();
            return;
        }


        if (attribute instanceof User) {
            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            out.write("{\n" + "    \"status\": 10009,\n" + "    \"msg\": \"NEED_ADMIN\",\n" + "    " +
                          "\"data\": null\n" + "}");
            out.flush();
            out.close();
            return;
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
