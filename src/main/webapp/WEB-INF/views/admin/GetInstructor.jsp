
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Get Instructor</title>
</head>
<body>

    <%@include file="AdminName.jsp"%>

    <jsp:include page="../generic/GetById.jsp" >
        <jsp:param name="url" value="${url}"/>
        <jsp:param name="methodType" value="${methodType}"/>
        <jsp:param name="displayWho" value="${displayWho}"/>
        <jsp:param name="inputId" value="${inputId}"/>
        <jsp:param name="max" value="${max}"/>
        <jsp:param name="min" value="${min}"/>
    </jsp:include>

    <%@include file="ServiceCenter.jsp"%>

</body>
</html>
