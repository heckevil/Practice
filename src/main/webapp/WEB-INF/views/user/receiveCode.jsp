<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-17
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> 새로 고침 및 액세스 토큰에 대한 인증 코드 교환 </h3>
<%--POST /token HTTP/1.1--%>
<%--Host: oauth2.googleapis.com--%>
<%--Content-Type: application/x-www-form-urlencoded--%>

<%--code=4/P7q7W91a-oMsCeLvIaQm6bTrgtp7&--%>
<%--client_id=your_client_id&--%>
<%--client_secret=your_client_secret&--%>
<%--redirect_uri=https%3A//oauth2.example.com/code&--%>
<%--grant_type=authorization_code--%>

<form action="https://www.oauth2.googleapis.com/token HTTP/" method="post" enctype="application/x-www-form-urlencoded">
   code :  <input type="text" name="code" value="${param.code}"> <br>
    client_id: <input type="text" name="client_id" value="211451799850-2a0egv7o5d6utv4ajied1v2bdqfcppd3.apps.googleusercontent.com"> <br>
    client_secret:  <input type="text" name="client_secret" value="yiLY6mV4QNwIEurYKeZBOVQi"><br>
    redirect_uri: <input type="text" name="redirect_uri" value="http://localhost:8888/user/receiveCode"><br> <%-- --%>
    grant_type: <input type="text" name="grant_type" value="https://accounts.google.com/o/oauth2/auth"><br>
<input type="submit">
</form>

</body>
</html>
