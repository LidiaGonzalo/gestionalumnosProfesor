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
		<a href="index.jsp">Atras</a>
		<br/>
		
		<%		
			List<Curso> cursos = (List<Curso>) request.getAttribute("listado_cursos");
			if(cursos!=null){
				int i=1;
				for(Curso curso: cursos){
					out.write("<p><a href='cursos.do?id=" + curso.getCodigo() + "'>Curso " + i + ": " + curso.getNombre() + "</a></p>");
					i++;
				}
			}
		%>
	</body>
</html>