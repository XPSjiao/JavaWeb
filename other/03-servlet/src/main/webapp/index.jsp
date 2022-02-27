<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JavaWeb初体验</title>
    <style>
        ul li a{
            padding:0;
            border: antiquewhite;
            border-radius: 3px;
            background-color: cadetblue;
            height: 30px;
            width: 50px;
            font-size: 25px;
            margin:0;
            list-style:none
        }
    </style>

</head>
<body>
<h1><%= "JavaWeb初体验~" %>
</h1>
<br/>

<ul>
    <li>
        <a href="res?type=html">返回Html</a>
    </li>
    &nbsp;
    &nbsp;
    <li>
        <a href="res?type=json">返回JSON数据</a>
    </li>
    &nbsp;
    &nbsp;
    <li>
        <a href="res?type=img">返回图片</a>
    </li>
</ul>






</body>
</html>