<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>
<body>
    <h1 style="color: red; text-align: center">Edit Employee</h1>
    <form:form action="${pageContext.request.contextPath}/update" method="post" modelAttribute="emp">
        <form:hidden path="empno" />
        <table align="center" bgcolor="lightgray">
            <tr>
                <td>Employee Name</td>
                <td>
                    <form:input path="ename" />
                    <form:errors path="ename" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Designation</td>
                <td>
                    <form:input path="job" />
                    <form:errors path="job" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Salary</td>
                <td>
                    <form:input path="sal" />
                    <form:errors path="sal" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Department No</td>
                <td>
                    <form:select path="deptno">
                        <form:option value="10">10</form:option>
                        <form:option value="20">20</form:option>
                        <form:option value="30">30</form:option>
                        <form:option value="40">40</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="60">60</form:option>
                    </form:select>
                    <form:errors path="deptno" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Update Employee" />
                    <a href="${pageContext.request.contextPath}/report">
                        <input type="button" value="Cancel" />
                    </a>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
