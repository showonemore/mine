<%--
  Created by IntelliJ IDEA.
  User: 农艺
  Date: 2021/10/8
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h2>学生修改</h2>
<form action="/day/stu?method=updateStu" method="post">
    <input type="hidden" name="id" value="${stu.id}">
    <table align="center" border="1px" cellspacing="0px" width="700px">
        <tr>
            <td align="right">姓名：</td>
            <td>
                <input type="text" name="name" value="${stu.name}">
            </td>
        </tr>
        <tr>
            <td align="right">年龄：</td>
            <td>
                <input type="text" name="age" value="${stu.age}">
            </td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td>
                <input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男'}">checked</c:if>>男
                <input type="radio" name="sex" value="女" <c:if test="${stu.sex=='女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td align="right">爱好：</td>
            <td>
                <input type="checkbox" name="hobby" value="坑" <c:if test="${fn:contains(stu.hobby,'坑')}">checked</c:if>>坑
                <input type="checkbox" name="hobby" value="蒙" <c:if test="${fn:contains(stu.hobby,'蒙')}">checked</c:if>>蒙
                <input type="checkbox" name="hobby" value="拐" <c:if test="${fn:contains(stu.hobby,'拐')}">checked</c:if>>拐
                <input type="checkbox" name="hobby" value="骗" <c:if test="${fn:contains(stu.hobby,'骗')}">checked</c:if>>骗
            </td>
        </tr>
        <tr>
            <td align="right">工作：</td>
            <td>
                <select name="work">
                    <option value="正在学习" <c:if test="${stu.work=='正在学习'}">selected</c:if>>正在学习</option>
                    <option value="正在学习" <c:if test="${stu.work=='正在玩游戏'}">selected</c:if>>正在玩游戏</option>
                    <option value="正在学习" <c:if test="${stu.work=='正在嫖'}">selected</c:if>>正在嫖</option>
                    <option value="正在学习" <c:if test="${stu.work=='正在吃'}">selected</c:if>>正在吃</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">个人描述：</td>
            <td>
                <textarea rows="5" cols="30" name="sdesc">${stu.sdesc}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
