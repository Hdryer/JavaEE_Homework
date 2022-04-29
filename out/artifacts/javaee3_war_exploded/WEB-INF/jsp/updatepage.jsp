<%--
  Created by IntelliJ IDEA.
  User: bindada
  Date: 2022/4/17
  Time: 15:43
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
            <form method="post" action="/updatecourse" enctype="multipart/form-data">
                <label>课程号</label><br>
                <input type="text" name="id" value="${onecourse.getId()}" readonly="readonly" required><br>
                <label>课程名</label><br>
                <input type="text"  name="name" value="${onecourse.getName()}" required><br>
                <label>课时</label><br>
                <input type="text" name="hours" value="${onecourse.getHours()}" required><br>
                <label>开课学院</label><br>
                <input type="text" name="sid" value="${onecourse.getSid()}" required><br>
                <div>
                    <input type="submit" value="Update" style="padding: 10px;font-size: 15px;margin-left: 30%;">
                    <button style="margin-left: 100px;padding: 10px;font-size: 15px;">Cancel</button>
                </div>
            </form>
    </div>
</body>
</html>
