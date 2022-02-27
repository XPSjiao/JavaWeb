package com.example.sv2;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * @program: SV2
 * @description: 返回一些东西
 * @author: EthanJiao
 * @create: 2022-02-22
 **/

//@WebServlet(urlPatterns = {"/res"}) //用来获取资源，在index.jsp中的
public class ServletDemo1 extends HttpServlet { //继承HttpServlet类
    private String message;

    @Override
    public void init() throws ServletException { //实例构造器
        System.out.println("init...");
        message = "欢迎来到我的Servlet页面";
    }

    //doGet方法
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type"); //通过reguest请求对象获取参数，这边type就是前面超链接后面的type
        System.out.println(type);//type取出来就是一个字符串，即前面jsp文件中给type赋值的3个
        switch (type){  //switch分支来对type进行区分来调用不同的资源
            case "html":
                getHtml(response);//获取html
                break;
            case "json":
                getJson(response);
                break;
            case "img"://图片需要request来获取整个应用的上下文，相当获取这个Web目录的路径
                getImg(request,response);
                break;
        }
    }

    private void getHtml(HttpServletResponse response) throws IOException{
        //需要向客户端返回数据，所以需要用到response对象，从上面switch语句中传下来的
        //设置一个contentType，拼接了一个html片段，加了个消息和图片就好了
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"+en+\"><body>");
        out.println("<h1>"+message+"</h1>");
        out.println("<img src ='http://img95.699pic.com/photo/40167/5661.jpg_wh860.jpg' alt='同心抗疫'>");
//        out.println("<img src ='http://img95.699pic.com/photo/40167/5661.jpg_wh860.jpg' alt='同心抗疫'>");
        out.flush();//清空缓冲区的数据流
        out.close();//关闭
    }

//    获取json
    private void getJson(HttpServletResponse response) throws IOException{
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json= "{\"name\":\"笑笑\",\"age\":18,\n" +
                "\"name\":\"小一\",\"age\": 18}";
        out.println(json);
        out.flush();
        out.close();
    }


    //获取图片
    private void getImg(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.setContentType("image/jpg");
        String path = request.getServletContext().getRealPath("");
        System.out.println(path);
        File file = new File(path + "/img/img1.jpg");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read())!= -1){
            out.write(read);
        }
        out.flush();
        in.close();
        out.close();
    }
}
