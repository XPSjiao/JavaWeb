package com.soft2176.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/2/21 19:30
 */
@WebServlet(urlPatterns = {"/res"})
public class ServletDemo extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "JavaWeb初体验";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        switch (type) {
            case "html":
                getHtml(response);
                break;
            case "json":
                getJson(response);
                break;
            case "img":
                getImg(request, response);
                break;
        }
    }

    private void getHtml(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        out.println("<html lang=\"+en+\"><body>");
        out.println("<h1>"+ message + "</h1>");
        out.println("<img src = 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fp7.itc.cn%2Fq_70%2Fimages03%2F20211027%2Fa642479148c5474196d0d3181f03e5d5.jpeg&refer=http%3A%2F%2Fp7.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1648036721&t=8ff40787b7e8f1fae25b09d0f34fc6e3'>");
        out.println("<body></html>");
        out.flush();
        out.close();
    }

    private void getJson(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out1 = response.getWriter();
        String json = "{\n" +
                "  \"date\": \"2021-05-09\",\n" +
                "  \"week\": \"星期日\",\n" +
                "  \"statusDesc\": \"周末\",\n" +
                "  \"status\": null,\n" +
                "  \"animal\": \"牛\",\n" +
                "  \"avoid\": \"订婚.上梁.纳采.盖屋.开仓\",\n" +
                "  \"cnDay\": \"日\",\n" +
                "  \"day\": \"9\",\n" +
                "  \"desc\": \"母亲节\",\n" +
                "  \"gzDate\": \"丁巳\",\n" +
                "  \"gzMonth\": \"癸巳\",\n" +
                "  \"gzYear\": \"辛丑\",\n" +
                "  \"isBigMonth\": \"1\",\n" +
                "  \"lDate\": \"廿八\",\n" +
                "  \"lMonth\": \"三\",\n" +
                "  \"lunarDate\": \"28\",\n" +
                "  \"lunarMonth\": \"3\",\n" +
                "  \"lunarYear\": \"2021\",\n" +
                "  \"month\": \"5\",\n" +
                "  \"suit\": \"搬家.装修.开业.结婚.入宅.领证.开工.动土.安床.出行.安葬.开张.作灶.旅游.求嗣.赴任.修造.祈福.祭祀.解除.开市.牧养.纳财.纳畜.开光.嫁娶.移徙.经络.立券.求医.竖柱.栽种.斋醮.求财\",\n" +
                "  \"term\": \"\",\n" +
                "  \"value\": \"母亲节\",\n" +
                "  \"year\": \"2021\"\n" +
                "}";
        out1.println(json);
        out1.flush();
        out1.close();
    }

    private void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        String path = request.getServletContext().getRealPath("");
        File file = new File(path+"/img/1.jpg");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        in.close();
        out.close();

    }
}

