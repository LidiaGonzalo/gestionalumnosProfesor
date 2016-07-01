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
<main class="">
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
		<a class="btn btn-warning" href="<%=Constantes.SERVLET_ALUMNOS%>">Atras</a>
	

		<%
		if(alumno instanceof AlumnoError){
			AlumnoError aux = (AlumnoError) alumno;
			out.write(aux.getMensaje());
		}
		
		%>

		
		<%
		if(alumno!=null){
		%>
			<form name="" id="" method='post' class="form-horizontal"
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
					<label class="col-xs-2" for="<%=Constantes.PAR_NOMBRE%>">Nombre:</label>
					<div class="col-xs-10">
					<input type="text" class="form-control"
						name="<%=Constantes.PAR_NOMBRE%>" 
						id="<%=Constantes.PAR_NOMBRE%>" 
						value="<%=alumno.getNombre() %>"
						/>
					</div>
					<span class="alert alert-danger hide"></span>
				</div>
				<div class="form-group">
					<label class="col-xs-2" for="<%=Constantes.PAR_APELLIDOS%>">Apellidos:</label>
					<div class="col-xs-10">					
					<input type="text"  class="form-control"
						name="<%=Constantes.PAR_APELLIDOS%>" 
						id="<%=Constantes.PAR_APELLIDOS%>" 
						value="<%=alumno.getApellidos() %>"
						/>
						</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2" for="<%=Constantes.PAR_DNI%>">Dni:</label>
					<div class="col-xs-10">
					<input type="text" pattern="((([A-Z]|[a-z])\d{8})|(\d{8}([A-Z]|[a-z])))"
						name="<%=Constantes.PAR_DNI%>" class="form-control"
						id="<%=Constantes.PAR_DNI%>" 
						value="<%=alumno.getDni() %>"
						/>
						</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2">Fecha:</label>
					<div class="col-xs-10">
				<%

				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(alumno.getfNacimiento());
			
				%>
						<div class="row">
							<div class="col-xs-3">
								<label for="">Día</label>
								<input type="number"  value="<%=calendar.get(GregorianCalendar.DAY_OF_MONTH) %>" class="form-control" min="1" max="31" step="1" name="<%=Constantes.PAR_DIA%>"	/>
							</div>
							<div class="col-xs-3">
									<label for="">Mes</label>
									<input type="number" value="<%=calendar.get(GregorianCalendar.MONTH)+1 %>" class="form-control" min="1" max="12" step="1" name="<%=Constantes.PAR_MES%>"	/>
								
							</div>
							<div class="col-xs-6">
								<label for="">Año</label>
								<input type="number"  value="<%=calendar.get(GregorianCalendar.YEAR) %>" class="form-control" min="" max="" name="<%=Constantes.PAR_ANYO%>"	/>
							</div>
						</div>
					</div> 
				</div>
				<div class="">
				</div>
				<div class="form-group">
					<div class="col-xs-10">
						<button type="submit" class="btn btn-success col-xs-6">
							<%=tGuardar %>
						</button>
					</div>
				</div>
			</form>
			
			
			
			
			
	<%	}
		%>
</main>
<%@include file="../includes/footer.jsp" %>