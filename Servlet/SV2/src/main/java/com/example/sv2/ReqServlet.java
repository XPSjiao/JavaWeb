package com.example.sv2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/req")//直接用/req表示请求，一会儿在地址栏直接用localhost:8080/req就能访问到
public class ReqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Protocol:"+ request.getProtocol());
//        System.out.println("getContextPath:"+request.getContextPath());
//        System.out.println("getServletPath:"+request.getServletPath());
//        System.out.println("getQueryString:"+request.getQueryString());
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        System.out.println(name);
//        String info= "中国";
        //1.设置服务器端的编码，在response.getWriter()之前设置，默认是iso-8859-1
        request.setCharacterEncoding("UTF-8");//设置中文不乱码
        //2.通过设置响应头，通知浏览器服务器发送的数据格式
//        response.setHeader("Content-type","text/plain;charset=utf-8");
//        //3.作用等同于2,提倡用这个！！！！
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().println(name);
        response.getWriter().close();

    }
}
