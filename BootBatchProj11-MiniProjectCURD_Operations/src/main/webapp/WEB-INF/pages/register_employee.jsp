<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: red; text-align: center">Register Employee</h1>
<frm:form modelAttribute="emp" action="register" method="post">
	<table align="center" bgcolor="yellow">
		<tr>
			<td>Employee Name</td>
			<td><frm:input path="ename" /></td>
		</tr> 
		<tr>
			<td>Employee Desg</td>
			<td><frm:input path="job" /></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><frm:input path="sal" /></td>
		</tr>
		<tr>
			<td>Dept No</td>
			<td>
				<frm:select path="deptno">
					<frm:option value="10">10</frm:option>
					<frm:option value="20">20</frm:option>
					<frm:option value="30">30</frm:option>
					<frm:option value="40">40</frm:option>
					<frm:option value="50">50</frm:option>
					<frm:option value="60">60</frm:option>
				</frm:select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="register" /></td>
			<td><input type="reset" value="Cancel" /></td>
		</tr>
	</table>
</frm:form>