<%--
  Created by IntelliJ IDEA.
  User: bindada
  Date: 2022/4/17
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        label{
            font-size: 20px;
        }
        input[type=text]{
            width: 90%;
            padding: 10px;
            border-radius: 5px;
            font-size: 20px;
            margin: 20px;
        }
    </style>
</head>
<body>
<div style="margin: auto;width: 50%; border-radius: 5px;border: 1px solid black;height: 600px" >
    <form method="post" action="/addcourse" enctype="multipart/form-data">
        <input type="text" name="id" value="99" required style="display: none">
        <label>课程名</label><br>
        <input type="text"  name="name"  required><br>
        <label>课时</label><br>
        <input type="text" name="hours"  required><br>
        <label>开课学院</label><br>
        <input type="text" name="sid"  required><br>
        <label>课程封面</label><br>
        <input type="file" name="myFile" style="text-align: center;font-size: 16px;margin: 20px">
        <p></p>
        <div>
            <input type="submit" value="Addcourse" style="padding: 10px;font-size: 15px;margin-left: 30%;">
        </div>
    </form>
</div>
</body>
</html>
