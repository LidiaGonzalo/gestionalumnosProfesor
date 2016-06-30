<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestion de Cursos </title>
	 <!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
</head>
<body>
	<header><h1>Ipartek - Gestion de Cursos</h1></header>
	<nav>
		<ul>
			<li>
				<a href="<%=Constantes.SERVLET_CURSOS%>">
					Ver todos los cursos
				</a>
			</li>
			<li>
				<a href="<%=Constantes.SERVLET_ALUMNOS%>">
					Ver todos los alumnos
				</a>
			</li>
			<li>
				<a href="<%=Constantes.SERVLET_MODULOS%>">
					Ver todos los modulos
				</a>
			</li>
		</ul>
	</nav>