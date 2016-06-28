<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado Cursos</title>
	</head>
	<body>
		<div id="wrapper">
		<a href="index.jsp">Atras</a>
			<a href="curso.jsp">Añadir Curso Nuevo</a> 
		
		
		<%		
			List<Curso> cursos = (List<Curso>) request.getAttribute("listado_cursos");
			if(cursos!=null){
				int i=1;
				for(Curso curso: cursos){
					out.write("<p><a href='cursos.do?"+Constantes.PAR_CODIGO+"=" + curso.getCodigo() + "'>Curso " + i + ": " + curso.getNombre() + "</a></p>");
					i++;
				}
			}
		%>
		</div>
	</body>
</html>