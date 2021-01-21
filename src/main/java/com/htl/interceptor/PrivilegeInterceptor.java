package com.htl.interceptor;

import com.htl.domain.BookAdmin;
import com.htl.domain.Reader;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器 ---如果没有登录就跳转到登录界面
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //逻辑：判断用户是否登录。 本质：判断session中有没有reader、admin
        HttpSession session = request.getSession();
        Reader user = (Reader) session.getAttribute("reader");
        BookAdmin admin = (BookAdmin) session.getAttribute("admin");
        if (user == null && admin == null){
            //没有登录
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //放行 访问目标资源
        return true;
    }
}
