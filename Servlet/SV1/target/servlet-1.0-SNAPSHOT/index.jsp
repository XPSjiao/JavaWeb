<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JavaWeb-Servlet</title>
    <style>
        ul li a{
            padding: 0;
            height: 50px;
            width: 100%;
            background-color: aqua;
            font-size: 40px;
            margin: 0;
        }

    </style>
</head>
<body>
<h1><%= "JavaWeb-Servlet" %>
</h1>
<br/>
<ul>
    <li>
        <a href="res?type=html">返回Html</a>
    </li>
    <li>
        <a href="res?type=json">返回JSON数据</a>
    </li>
    <li>
        <a href="res?type=img">返回图片</a>
    </li>
</ul>
</body>
</html>