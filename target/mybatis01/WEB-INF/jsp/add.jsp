<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2020/11/17
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/ctx.jsp"%>
<html>
<head>
    <title>新增</title>
</head>
<body>
<form action="${ctx}/book/doadd" method="post">
    书本名：<input type="text" name="bookName"/><br/>
    价格：<input type="text" name="bookPrice"/><br/>
    简介：<input type="text" name="bookBrief"/><br/>
    <input type="submit"/>

</form>
</body>
</html>

