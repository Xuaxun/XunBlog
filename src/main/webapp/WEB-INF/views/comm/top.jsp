<%--
  Created by IntelliJ IDEA.
  User: xuaxun
  Date: 2021-01-02
  Time: 11:13
  To change this template use File | Settings | File Templates.
  note:顶部通用
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<script src="<%=contextPath%>/static/jquery-3.1.1.js"></script>
<script src="<%=contextPath%>/static/bootstrap/js/bootstrap.js"></script>
<link href="<%=contextPath%>/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<link href="<%=contextPath%>/static/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
<div class="row">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=contextPath%>">Xun的专栏</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="nv1">
                    <li class="active" id="firstPage"><a href="<%=contextPath%>/">首页</a></li>
                    <li id="webPage"><a href="<%=contextPath%>/column/JavaWeb专栏/webPage">JavaWeb专栏</a></li>
                    <li id="androidPage"><a href="<%=contextPath%>/column/Android专栏/androidPage">Android专栏</a>
                    </li>
                    <li id="rnPage"><a href="<%=contextPath%>/column/React Native专栏/rnPage">React Native专栏</a>
                    </li>
                    <li id="ubuntuPage"><a href="<%=contextPath%>/column/Ubuntu专栏/ubuntuPage">Ubuntu专栏</a>
                    </li>
                </ul>
                <form class="navbar-form navbar-right">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="搜索">
                        <span class="input-group-btn">
							<button class="btn btn-default" type="button">嗖!</button>
						</span>
                    </div>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<script>
    var href = location.href;
    var id = href.substring(href.lastIndexOf("/") + 1, href.length);
    if (id=="") {
        id = "firstPage";
    }
    var ids = ["firstPage", "webPage", "androidPage", "rnPage", "ubuntuPage"];
    for (var i = 0; i < ids.length; i++) {
        if (id == ids[i]) {
            $("#" + id).attr("class", "active");
        } else {
            $("#" + ids[i]).removeAttr("class");
        }
    }
</script>