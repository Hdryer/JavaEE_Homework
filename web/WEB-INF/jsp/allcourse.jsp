<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bindada
  Date: 2022/4/17
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <title>Title</title>
    <style>
        tr{
            width: 100%;
            text-align: center;
            padding: 20px;
            background-color: lightblue;
        }
        td{
            padding: 10px;
            width: 20%;
            border-top: black 1px solid;
        }
        td a{
            color: black;
        }
    </style>
</head>
<body>
    <div style="margin: auto; width: 50%">
        <div style="border: #fdfdfd 2px solid;width: 80px;margin-right: 95%;border-radius: 4px;height:40px;background-color: #bcdef5;">
            <label>
                <a href="/toadd" style="text-decoration: none;color: black;">新增课程</a>
            </label>
        </div>
        <table cellspacing="0px" style="margin: auto;width: 100%">
            <tbody>
            <tr >
                <td>     </td>
                <td>课程名</td>
                <td>课时数</td>
                <td>学院号</td>
                <td>操作</td>
            </tr>
            <c:forEach var="course" items="${requestScope.get('courses')}">
                <tr>
                    <td><img src="/showPic/${course.getUrl()}" style=""width: 100px;height: 100px></td>
                    <td>${course.getName()}</td>
                    <td>${course.getHours()}</td>
                    <td>${course.getSid()}</td>
                    <td><a href="/toupdate?id=${course.getId()}">修改</a> | <a href="/deletecourse?id=${course.getId()}">删除</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

<%--
    <div>
        <form action="/fileupload" method="post" enctype="multipart/form-data">
            <p><span><label>上传封面:</label></span>
            <input type="file" name="upload"></p>
            <input type="submit" value="上传">
        </form>
    </div>
--%>

</body>
</html>
