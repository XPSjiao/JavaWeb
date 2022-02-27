<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ServletDemo</title>
<style>
    html{
        background-color: cornsilk;
    }
    ul li{
        float: left;
        list-style: none;

    }
    ul li a{
        display: block;
        padding: 20px 50px;
        height: 70px;
        background-color: aqua;
        color: orange;
        box-sizing: border-box;
        margin-right: 20px;
        font-size: 25px;
        transition: transform 0.25s linear 0s;
        text-decoration: none;
        margin-top: 30px;


    }
    ul li a:hover{
        background-color: darkcyan;
        transform: scale(1.3) ;
    }
</style>
</head>
<body>
<h1><%= "ServletDemo" %>
</h1>
<br/>

<ul>
    <li>
        <a href="res?type=html">返回html</a>
    </li>
    <li>
        <a href="res?type=json">返回JSON</a>
    </li>
    <li>
        <a href="res?type=img">返回图片</a>
    </li>
</ul>
</body>
</html>