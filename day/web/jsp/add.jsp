<%--
  Created by IntelliJ IDEA.
  User: 农艺
  Date: 2021/10/8
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h2>学生新增</h2>
<form action="/day/stu?method=add" method="post">
    <table align="center" border="1px" cellspacing="0px" width="700px">
        <tr>
            <td align="right">姓名：</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="right">年龄：</td>
            <td>
                <input type="text" name="age">
            </td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td align="right">爱好：</td>
            <td>
                <input type="checkbox" name="hobby" value="坑">坑
                <input type="checkbox" name="hobby" value="蒙">蒙
                <input type="checkbox" name="hobby" value="拐">拐
                <input type="checkbox" name="hobby" value="骗">骗
            </td>
        </tr>
        <tr>
            <td align="right">工作：</td>
            <td>
                <select name="work">
                    <option value="正在学习">正在学习</option>
                    <option value="正在学习">正在玩游戏</option>
                    <option value="正在学习">正在嫖</option>
                    <option value="正在学习">正在吃</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">个人描述：</td>
            <td>
                <textarea rows="5" cols="30" name="sdesc"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="新增">
            </td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
