<%--
  Created by IntelliJ IDEA.
  User: 农艺
  Date: 2021/10/8
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="/day/js/jquery-1.12.4.js"></script>
    <title>Title</title>
</head>
<style>
    #d1{
        width: 90px;
        border: 1px;
        line-height: 30px;
        border-radius: 40%;
        background: aquamarine;
        position:relative;
        left: 360px;
    }
</style>
<body>
<center>
<p>
    <form action="/day/stu?method=findPages" method="post">
        姓名：<input type="text" name="name" value="${param.name}">
        性别：<select name="sex">
    <option value="-1" <c:if test="${param.sex=='-1'}">selected</c:if>>--请选择--</option>
    <option value="男" <c:if test="${param.sex=='男'}">selected</c:if>>男</option>
    <option value="女" <c:if test="${param.sex=='女'}">selected</c:if>>女</option>
              </select>
        <input type="submit" value="查询">
    </form>
</p>
</center>
<div id="d1" onclick="delAll()">批量删除</div>
        <table width="1200px" cellspacing="0px" border="1px" align="center">
            <tr>
               <td>全选
                   <input type="checkbox" name="all" onclick="fun(checked)">
               </td>
               <td>学生编号</td>
               <td>学生姓名</td>
               <td>学生年龄</td>
               <td>学生性别</td>
               <td>学生爱好</td>
               <td>学生工作</td>
               <td>学生描述</td>
               <td>操作</td>
            </tr>
            <c:if test="${pb.list!=null}">
                <c:forEach items="${pb.list}" var="stu">
                    <tr>
                        <td>
                            <input type="checkbox" name="checkbox" value="${stu.id}">
                        </td>
                        <td>${stu.id}</td>
                        <td>${stu.name}</td>
                        <td>${stu.age}</td>
                        <td>${stu.sex}</td>
                        <td>${stu.hobby}</td>
                        <td>${stu.work}</td>
                        <td>${stu.sdesc}</td>
                        <td><a href="/day/stu?method=findStu&id=${stu.id}">修改</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
<center>
    <p>
        <a href="/day/stu?method=findPages&currentPage=1&pageSize=3&name=${param.name}&sex=${param.sex}">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <c:if test="${pb.currentPage==1}">
            <a href="#">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </c:if>
        <c:if test="${pb.currentPage!=1}">
            <a href="/day/stu?method=findPages&currentPage=${pb.currentPage-1}&pageSize=3&name=${param.name}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </c:if>
        <c:if test="${pb.currentPage!=totalPage}">
            <a href="/day/stu?method=findPages&currentPage=${pb.currentPage+1}&pageSize=3&name=${param.name}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </c:if>
        <c:if test="${pb.currentPage==totalPage}">
            <a href="#">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </c:if>
        <a href="/day/stu?method=findPages&currentPage=${pb.totalPage}&pageSize=3&name=${param.name}&sex=${param.sex}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        共${pb.totalPage}页当前${pb.currentPage}页&nbsp;&nbsp;&nbsp;&nbsp; 总共${pb.totalCount}条记录每页显示${pb.pageSize}条
    </p>
</center>
</body>
<script>
    function fun(flag) {
        $("input[name='checkbox']").prop("checked",flag)
    }
    function delAll() {
        var inputs= $("input[name='checkbox']:checked")
        var ids=""
        $.each(inputs,function (index,input) {
           if (index==inputs.length-1){
               ids+=input.value
           }else{
               ids+=input.value+","
           }
        })
        location.href="/day/stu?method=del&ids="+ids
    }
</script>
</html>
