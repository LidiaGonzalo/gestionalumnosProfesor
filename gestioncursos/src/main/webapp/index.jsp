<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ipartek - Gestion de Cursos</title>
	</head>
	
	<body>
	
		<!-- 
		Esto es un comentario
		 -->
		 
		<h1>Ipartek - Gestion de Curssos</h1>
		
		Bienvenidos a la pagina de Gestion de Alumnos de Ipartek
		<p>
			<a href="<% out.write(Constantes.SERVLET_CURSOS); %>">Ver todos los cursos</a>
			
			<a href="<% out.write(Constantes.SERVLET_ALUMNOS); %>">Ver todos los alumnos</a>
		</p>

	</body>
</html>