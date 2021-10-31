<%--
  Created by IntelliJ IDEA.
  User: 26471
  Date: 2021/10/28
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js" crossorigin="anonymous"></script>
    <title>UpDate</title>
</head>
<body>

<h1 style="text-align: center">修改部门信息</h1>
<div class="container col-6">
    <form action="${pageContext.request.contextPath}/UpDeServlet" method="post">
        <%--隐藏域--%>
        <input type="hidden" name="id" value="${de.id}">
        <div class="input-group mb-3">
            <label for="name" class="L1">部门名称：</label>
            <input type="text" class="form-control" id="name" name="name" value="${de.name}">
        </div>

        <div class="input-group mb-3">
            <label for="pnumber" class="L1">部门人数：</label>
            <input type="text" class="form-control" id="pnumber" name="pnumber" value="${de.pnumber}">
        </div>

        <div class="input-group mb-3">
            <label for="dmanager" class="L1">部门经理：</label>
            <input type="text" class="form-control" id="dmanager" name="dmanager" value="${de.dmanager}">
        </div>
        <div class="container d1">
            <div class="d2">
                <input type="submit" class="btn btn-info" value="提交"/>
            </div>
        </div>
    </form>

</div>

</body>
<style>
    .L1 {
        padding-right: 10px;
        text-align: center;
        line-height: 50px;
    }

    .d1 {
        display: table;
        width: 100%;
    }

    .d2 {
        display: table-cell;
        text-align: center;
        vertical-align: middle;
    }
</style>
</html>
