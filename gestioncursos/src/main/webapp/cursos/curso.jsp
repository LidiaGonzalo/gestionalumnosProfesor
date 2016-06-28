<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%
		Curso curso = (Curso) request.getAttribute("curso");
		if(curso!=null){
		 %>
		 <title>Curso <% out.write(curso.getNombre()); %></title>
		 <%
		}else{
			%>
			<title>Curso </title>
			<%
		}
		%>
		<meta  charset="UTF-8">
		
	</head>
	
	<body>
		<a href="cursos.do">Atras</a>
		<br/>
		
		<%
		if(curso!=null){
		out.write(curso.getCodigo() + " - " + curso.getNombre());
		}
		%>
	</body>
</html>