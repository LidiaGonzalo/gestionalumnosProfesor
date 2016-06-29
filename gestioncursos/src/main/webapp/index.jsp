<%@page import="com.ipartek.formacion.controller.Constantes"%>

<%@ include file="includes/header.jsp" %>	
		 
		<h1>Ipartek - Gestion de Cursos</h1>
		<!-- 
<jsp:include page="includes/error.jsp"/>
 -->		
		Bienvenidos a la pagina de Gestion de Alumnos de Ipartek
	
		<p>
			<a href="<% out.write(Constantes.SERVLET_CURSOS); %>">Ver todos los cursos</a>
			
			<a href="<% out.write(Constantes.SERVLET_ALUMNOS); %>">Ver todos los alumnos</a>
		</p>

<%@ include file="includes/footer.jsp" %>








