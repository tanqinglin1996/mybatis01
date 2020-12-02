<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2020/11/15
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../common/ctx.jsp"%>
<html>
<head>
    <title>Spring-mvc</title>
</head>
<body>
<h1>Hello world </h1>
<form action="${ctx}/book/list" method="=post">
    <input name="bookName"/><input type="submit"/>

</form><a href="${ctx}/book/toadd">新增</a>
<table border="1px" align="center" width="60%">
    <tr>
        <td>编号</td>
        <td>书本名</td>
        <td>书本价格</td>
        <td>书本简介</td>
    </tr>
    <c:forEach items="${books}" var="i">
        <tr>
            <td>${i.getBookId()}</td>
            <td>${i.getBookName()}</td>
            <td>${i.getBookPrice()}</td>
            <td>${i.getBookBrief()}</td>
            <td> <a href="${ctx}/book/toUpdate?bookId=${i.getBookId()}">修改</a>
                 <a href="javascript:mya(${i.getBookId()})">删除</a>
            </td>
        </tr>


    </c:forEach>

</table>

<script>
    function mya(bid){
        var a=confirm("确认删除？");
        if(a){
            location.href="/mybatis01/book/dodel?bookId="+bid;
        }
    }

</script>
</body>
</html>
