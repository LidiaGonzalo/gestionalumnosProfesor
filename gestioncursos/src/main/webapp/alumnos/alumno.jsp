<%@page import="com.ipartek.formacion.controller.exception.AlumnoError"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
	<%
		Alumno alumno = (Alumno) request.getAttribute(Constantes.ATT_ALUMNO);
		int op = -1;
		if(alumno!=null){
			op = Constantes.OP_UPDATE;
		}else{
			op = Constantes.OP_CREATE;
			alumno = new Alumno();
		}
	%>
		<a href="<%=Constantes.SERVLET_ALUMNOS%>">Atras</a>
	
		<div id="wrapper">
		<%
		if(alumno instanceof AlumnoError){
			AlumnoError aux = (AlumnoError) alumno;
			out.write(aux.getMensaje());
		}
		
		%>

		
		<%
		if(alumno!=null){
		%>
			<form name="" id="" method='post' 
				action="<%=Constantes.SERVLET_ALUMNOS%>">
				<input type="hidden" 
					id="<%=Constantes.PAR_OPERACION %>"
					name="<%=Constantes.PAR_OPERACION %>"  
					value="<%=op %>"/>
				<input type="hidden" 
					id="<%=Constantes.PAR_CODIGO %>" 
					name="<%=Constantes.PAR_CODIGO %>" 
					value="<%=alumno.getCodigo()%>"/>
				<label for="<%=Constantes.PAR_NOMBRE%>">Nombre:</label>
				<input type="text" 
					name="<%=Constantes.PAR_NOMBRE%>" 
					id="<%=Constantes.PAR_NOMBRE%>" 
					value="<%=alumno.getNombre() %>"
					/>
				<label for="<%=Constantes.PAR_APELLIDOS%>">Apellidos:</label>					
				<input type="text" 
					name="<%=Constantes.PAR_APELLIDOS%>" 
					id="<%=Constantes.PAR_APELLIDOS%>" 
					value="<%=alumno.getApellidos() %>"
					/>
				<label for="<%=Constantes.PAR_DNI%>">Dni:</label>
				<input type="text" 
					name="<%=Constantes.PAR_DNI%>" 
					id="<%=Constantes.PAR_DNI%>" 
					value="<%=alumno.getDni() %>"
					/>
				<input type="submit" />
			</form>
			
			
			
			
			
	<%	}
		%>
		</div>
<%@include file="../includes/footer.jsp" %>