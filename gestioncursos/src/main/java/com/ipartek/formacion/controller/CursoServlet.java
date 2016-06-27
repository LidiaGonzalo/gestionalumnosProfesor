package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;

/**
 * Servlet implementation class CursoServlet
 */
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int id = -1;
    private RequestDispatcher rd = null;
    private CursoService cService = new CursoServiceImp();
    private List<Curso> cursos = null;
    private Curso curso = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo  = request.getParameter(Constantes.PAR_CODIGO);
		try{
			id = Integer.parseInt(codigo);
			getById(request);
		} catch(Exception e){
			getAll(request);
		}
		rd.forward(request, response);
		
	}

	private void getById(HttpServletRequest request) {
	
		curso = cService.getById(id);
		request.setAttribute(Constantes.ATT_ALUMNO, curso);
		rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
	}

	private void getAll(HttpServletRequest request) {

		cursos = cService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_CURSOS, cursos);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_CURSOS);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
