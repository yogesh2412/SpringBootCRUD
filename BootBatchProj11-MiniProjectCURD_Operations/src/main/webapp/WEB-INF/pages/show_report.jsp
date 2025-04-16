<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>

	<c:choose>
		<c:when test="${not empty (empsList)}">
			<h1 style="color: red; text-align: center;">EmployeeReport</h1>
			<table align="center" border="1" bgcolor="yellow">
				<tr>
					<th>EMPNO</th>
					<th>ENAME</th>
					<th>JOB</th>
					<th>SALARY</th>
					<th>DEPTNO</th>
					<th>ACTIONS</th> <%-- Added Actions column --%>
				</tr>
				
                <c:forEach var="emp" items="${empsList}">
                    <tr style="color: blue;">
                        <td>${emp.empno}</td>
                        <td>${emp.ename}</td>
                        <td>${emp.job}</td>
                        <td>${emp.sal}</td>
                        <td>${emp.deptno}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit?no=${emp.empno}">Edit</a> |
                            <form action="${pageContext.request.contextPath}/delete/${emp.empno}" method="post" style="display:inline;">
                                <input type="hidden" name="_method" value="POST">
                                <button type="submit" onclick="return confirm('Are you sure you want to delete this employee?')">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h1 style="color: red; text-align: center">No Data Found</h1>
        </c:otherwise>
    </c:choose>
	<br>
	<br>
	<h1 style="color: green; text-align: center">${resultMsg }</h1>
	<center>
		<a href="${pageContext.request.contextPath}/register">Add Employee</a>
		<a href="./">Home</a>
	</center>

</body>
</html>