
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Student ID</title>
</head>
<body>
    <%@include file="AdminName.jsp" %>

    <form action="/admin/services/update/updateable/student" method="get">
        Student ID: <input name="studentId" type="text" maxlength="8" minlength="8">
        <input type="submit" value="Get Student">
    </form>

    <%@include file="BackToService.jsp" %>

</body>
</html>