package com.alibaba.medical.interceptor;

import com.alibaba.medical.common.Const;
import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.pojo.Role;
import com.alibaba.medical.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @ClassName AuthorityInterceptor
 * @Description TODO
 * @Author panjing
 * @Date 19-7-13 上午12:29
 * @Version 1.0
 **/
@Slf4j
@Service
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");

        HttpSession session = request.getSession();
        //这里的Role是登陆时放入session的
        Role role = (Role) session.getAttribute(Const.CURRENT_ROLE);
        if (role == null) {
            //返回false，即不会调用controller的方法
            response.reset(); //这里要添加reset，否则会报异常getwritter() has already...
            request.setCharacterEncoding("UTF-8"); //这里要设置编码，否则会乱码
            response.setContentType("application/json;charset=utf-8"); //这里要设置返回值的类型，因为全部是json接口

            PrintWriter out = response.getWriter();
            out.println(JsonUtil.beanToString(ServerResponse.createByErrorMessage("用户未登录，请登陆后重试！")));
            out.flush();
            out.close();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}