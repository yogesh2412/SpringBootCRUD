<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
</head>
<body>
    <h1 style="color: red; text-align: center">Delete Employee</h1>
    <form:form
        action="${pageContext.request.contextPath}/delete/${emp.empno}"
        method="get" modelAttribute="emp">
        <table align="center" bgcolor="lightgray">
            <tr>
                <td colspan="2" style="text-align: center;">
                    <p>Are you sure you want to delete this employee?</p>
                    <p>Employee ID: ${emp.empno}</p>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Delete Employee" />
                    <a href="${pageContext.request.contextPath}/delete/${emp.empno}"
                       onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
