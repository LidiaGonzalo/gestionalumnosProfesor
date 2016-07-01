<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"/>	
<main>
		<%
		Curso curso = (Curso) request.getAttribute(Constantes.ATT_CURSO);
		int op = -1;
		String tGuardar = "";
		if(curso!=null){
			op = Constantes.OP_UPDATE;
			tGuardar ="guardar";
		}else{

			curso = new Curso();
			op = Constantes.OP_CREATE;
			tGuardar = "Crear";
		}
		%>
		<a class="btn btn-warning" href="<%=Constantes.SERVLET_CURSOS %>">Atras</a>

		
		<%
		if(curso!=null){
		%>
		<%=Constantes.SERVLET_CURSOS%>
			<form name="formcurso" class="" id="formcurso" method='post' 
				action="<%=Constantes.SERVLET_CURSOS%>">
				<input type="hidden" 
					id="<%=Constantes.PAR_OPERACION %>"
					name="<%=Constantes.PAR_OPERACION %>"  
					value="<%=op %>"/>
				<input type="hidden" 
					id="<%=Constantes.PAR_CODIGO %>" 
					name="<%=Constantes.PAR_CODIGO %>" 
					value="<%=curso.getCodigo()%>"/>
				<div class="form-group">
					<label class="sr-only" for="<%=Constantes.PAR_NOMBRE%>">Nombre:</label>
					<input  type="text" class="form-control "
					placeholder="Indrodruzca el nombre del Curso"
						name="<%=Constantes.PAR_NOMBRE%>" 
						id="<%=Constantes.PAR_NOMBRE%>" 
						value="<%=curso.getNombre() %>"
						/>
					<div class="hidden"></div>
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
<%@ include file="../includes/footer.jsp" %>