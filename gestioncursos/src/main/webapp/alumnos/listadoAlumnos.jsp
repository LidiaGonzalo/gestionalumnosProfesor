<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado Alumnos</title>
	</head>
	
	<body>
		<a href="index.jsp">Atras</a>
		<br/>
		
		<%		
			List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado_alumnos");
			if(alumnos!=null){
				int i=1;
				for(Alumno alumno: alumnos){
					out.write("<p><a href='alumnos.do?id=" + alumno.getCodigo() + "'>Alumno " + i + ": " + alumno.getNombre() + " " + alumno.getApellidos() + "</a></p>");
					i++;
				}
			}
		%>
	</body>
</html>