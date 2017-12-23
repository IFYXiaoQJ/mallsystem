package edu.mallsystem.filter;

import edu.mallsystem.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理登录拦截的过滤器
 * Created by Administrator on 2017/12/23.
 */
public class LoginFilter implements Filter {

    //允许不用过滤的路径
    private String allowString = "/index.jsp,/pages/user/login.jsp,/pages/user/registerUser.jsp,/pages/user/userAction_doLogin.action";
    private String requestPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //类型转换
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //获取访问路径
        requestPath = req.getServletPath();
        System.out.println(requestPath);
        //如果是不用过滤的路径
        if(allowString.indexOf(requestPath)!=-1){
            //放行
            filterChain.doFilter(request, response);
            return;
        }else{
            //获取HttpSession
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("loginUser");	//获取登录用户

            //判断用户是否登录
            if(user==null){
                PrintWriter out = response.getWriter();
                String url = req.getContextPath()+"/index.jsp";
                out.println("<script>alert('请先登录'); location.href='"+url+"';</script>");
                out.close();
            }
            //放行
            filterChain.doFilter(request, response);
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
