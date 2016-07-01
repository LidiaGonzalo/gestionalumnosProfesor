<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ipartek.formacion.controller.exception.AlumnoError"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<main>
	<%
		Alumno alumno = (Alumno) request.getAttribute(Constantes.ATT_ALUMNO);
		int op = -1;
		String tGuardar = "";
		if(alumno!=null){
			tGuardar = "guardar";
			op = Constantes.OP_UPDATE;
		}else{
			op = Constantes.OP_CREATE;
			tGuardar ="crear nuevo";
			alumno = new Alumno();
		}
	%>
		<a href="<%=Constantes.SERVLET_ALUMNOS%>">Atras</a>
	

		<%
		if(alumno instanceof AlumnoError){
			AlumnoError aux = (AlumnoError) alumno;
			out.write(aux.getMensaje());
		}
		
		%>

		
		<%
		if(alumno!=null){
		%>
			<form name="" id="" method='post' class=""
				action="<%=Constantes.SERVLET_ALUMNOS%>">
				<input type="hidden" 
					id="<%=Constantes.PAR_OPERACION %>"
					name="<%=Constantes.PAR_OPERACION %>"  
					value="<%=op %>"/>
				<input type="hidden" 
					id="<%=Constantes.PAR_CODIGO %>" 
					name="<%=Constantes.PAR_CODIGO %>" 
					value="<%=alumno.getCodigo()%>"/>
				<div class="form-group">
					<label for="<%=Constantes.PAR_NOMBRE%>">Nombre:</label>
					<input type="text" class="form-control"
						name="<%=Constantes.PAR_NOMBRE%>" 
						id="<%=Constantes.PAR_NOMBRE%>" 
						value="<%=alumno.getNombre() %>"
						/>
					<span class="alert alert-danger hide"></span>
				</div>
				<div class="form-group">
					<label for="<%=Constantes.PAR_APELLIDOS%>">Apellidos:</label>					
					<input type="text"  class="form-control"
						name="<%=Constantes.PAR_APELLIDOS%>" 
						id="<%=Constantes.PAR_APELLIDOS%>" 
						value="<%=alumno.getApellidos() %>"
						/>
				</div>
				<div class="form-group">
					<label for="<%=Constantes.PAR_DNI%>">Dni:</label>
					<input type="text" pattern="((([A-Z]|[a-z])\d{8})|(\d{8}([A-Z]|[a-z])))"
						name="<%=Constantes.PAR_DNI%>" class="form-control"
						id="<%=Constantes.PAR_DNI%>" 
						value="<%=alumno.getDni() %>"
						/>
				</div>
				<div class="form-group">
					<label >Fecha:</label>
				<%

				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(alumno.getfNacimiento());
			
				%>
					<input type="number" value="<%=calendar.get(GregorianCalendar.DAY_OF_MONTH) %>" class="form-control" min="1" max="12" step="1" name="<%=Constantes.PAR_DIA%>"	/>
						/
					<input type="number" value="<%=calendar.get(GregorianCalendar.MONTH) %>" class="form-control" min="1" max="12" step="1" name="<%=Constantes.PAR_MES%>"	/>
						/
					<input type="number" value="<%=calendar.get(GregorianCalendar.YEAR) %>" class="form-control" min="" max="" name="<%=Constantes.PAR_ANYO%>"	/> 
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">
						<%=tGuardar %>
					</button>
				</div>
			</form>
			
			
			
			
			
	<%	}
		%>
</main>
<%@include file="../includes/footer.jsp" %>