package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * @program: servlet
 * @description: 1、HTML 2、JSON 3、图片
 * @author: EthanJiao
 * @create: 2022-02-21
 **/
@WebServlet(urlPatterns = {"/res"})
public class ServletDemo extends HttpServlet {
    private String message;

    @Override
    public void init()  {
        message = "JavaWeb-Servlet";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        switch (type){
            case"html":
                getHtml(response);
                break;
            case "json":
                getJson(response);
                break;
            case"img":
                getImg(request,response);
                break;

        }
    }
    private void getHtml(HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"+en\"><body>");
        out.println("<h1>"+message+"</h1>");
        out.println("<p><a href=https://www.baidu.com/>链接到百度</p>");
        out.println("<img src = 'http://img.daimg.com/uploads/allimg/140505/1-140505004P3.jpg'>");
        out.println("<body></html>");
        out.flush();
        out.close();
    }

    private void getJson(HttpServletResponse response)throws IOException{
        response.setContentType("application/json");
        PrintWriter out1 = response.getWriter();
        String json= "{\n" +
                "\"date\": \"2022-2-21\",\n" +
                "  \"week\": \"星期一\",\n" +
                "  \"wether\": \"阴\"\n"+
                "}";
        out1.println(json);
        out1.flush();
        out1.close();
    }

    private void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        String path = request.getServletContext().getRealPath("");
        File file = new File(path+"/img/img1.jpg");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read())!=-1){
            out.write(read);
        }
        out.flush();
        in.close();
        out.close();
    }
}
