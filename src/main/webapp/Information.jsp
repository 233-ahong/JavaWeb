<%--
  Created by IntelliJ IDEA.
  User: 26471
  Date: 2021/10/27
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>部门信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/FindDeByPageServlet" method="post">
    <div class="container col-6" style="float: left">
        <span style="margin-left: 14%">
            <label for="id">部门名</label><input id="id" value="${condition.name[0]}" type="text" name="name">
            <label for="name">部门经理</label><input id="name" value="${condition.dmanager[0]}" type="text" name="dmanager">
            <input id="add" type="submit" value="查询">
        </span>
    </div>
</form>
<div class="container col-4" style="float: right;margin-left: 30px">
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加部门</a>
    <a class="btn btn-primary" id="delDe">删除选中</a>
    <a class="btn btn-primary" id="upDe">修改部门</a>
</div>
<div class="container" style="height: 50%">
    <form id="from" name="from" method="post">
        <table class="table table-hover container" >
            <thead>
            <tr>
                <th><input type="checkbox" id="cb"></th>
                <th scope="col">#</th>
                <th scope="col">部门名称</th>
                <th scope="col">部门人数</th>
                <th scope="col">部门经理</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pb.list}" var="department" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="did" value="${department.id}"></td>
                    <td>${s.count}</td>
                    <td>${department.name}</td>
                    <td>${department.pnumber}</td>
                    <td>${department.dmanager}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </form>
</div>
<div class="container">
    <div class="d1" style="float: left">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:if test="${pb.currentPage==1}">
                    <li class="page-item disabled">
                        <span class="page-link">&laquo;</span>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage!=1}">
                    <li class="page-item">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/FindDeByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&dmanager=${condition.dmanager[0]}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage==i}">
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">${i}</span>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/FindDeByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&dmanager=${condition.dmanager[0]}
                    ">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pb.currentPage==pb.totalPage}">
                    <li class="page-item disabled">
                        <span class="page-link">&raquo;</span>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage!=pb.totalPage}">
                    <li class="page-item">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/FindDeByPageServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&dmanager=${condition.dmanager[0]}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
    <div class="col-6" style="float: left">
        <span style="font-size: 25px;margin-left: 10px">
            共${pb.totalCount}条记录，共${pb.totalPage}页
        </span>
    </div>
</div>

</body>
<style>

</style>
<script>
    window.onload = function () {
        document.getElementById("delDe").onclick = function () {
            ${'from'}.
            action = "${pageContext.request.contextPath}/DelDeServlet";
            if (confirm("您确定要删除选中条目吗？")) {
                var flag = false;
                var cbs = document.getElementsByName("did");
                for (var i = 0; i < cbs.length; i++) {
                    if (cbs[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    document.getElementById("from").submit();
                }
            }
        }
        document.getElementById("upDe").onclick = function () {
            var cbs = document.getElementsByName("did");
            var id = $(cbs).parent("tr").find(${department.id}).text();
            ${'from'}.
            action = "${pageContext.request.contextPath}/FindDeServlet?id=id";
            var flag = false;
            for (var i = 0; i < cbs.length; i++) {
                if (cbs[i].checked) {
                    flag = true;
                    break;
                }
                else {
                    alert("请选择需要修改的部门！");
                    break;
                }
            }
            if (flag) {
                document.getElementById("from").submit();
            }
        }
        document.getElementById("cb").onclick = function () {
            var cbs = document.getElementsByName("did");
            for (var i = 0; i < cbs.length; i++) {
                cbs[i].checked = this.checked;
            }
        }
    }
</script>
</html>
