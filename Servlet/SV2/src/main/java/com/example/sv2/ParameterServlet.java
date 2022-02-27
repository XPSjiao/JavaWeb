package com.example.sv2;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * @program: SV2
 * @description: test
 * @author: EthanJiao
 * @create: 2022-02-23
 **/
@WebServlet(
        name = "ParamterServlet",
        urlPatterns = {"/param"},
        loadOnStartup = 1,//默认是-1，意思是当有人访问Servlet的时候得有人映射到资源，然后才会初始化和执行；设置为一个正数，只要不是-1就会自动初始化
        initParams = {
                @WebInitParam(name = "site",value = "xiaoxiao"),
                @WebInitParam(name = "name",value = "xiaoyi")
        }
)
public class ParameterServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        String site = this.getInitParameter("site");
        System.out.println(site);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        String site = this.getInitParameter("site");
//        String name = this.getInitParameter("name");
//        PrintWriter out = res.getWriter();
//        out.println(site);
//        out.println(name);
//        out.flush();
//        out.close();
    }
}
