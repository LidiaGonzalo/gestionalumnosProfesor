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
    private int operacion = -1;
    private RequestDispatcher rd = null;
    private CursoService cService = new CursoServiceImp();
    private List<Curso> cursos = null;
    private Curso curso = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			recogerId(request);
			if(id<0){
				rd = request.getRequestDispatcher(Constantes.JSP_CURSO);
			}else{
				getById(request);
			}
			
		} catch(Exception e){
			getAll(request);
		}
		rd.forward(request, response);
		
	}

	private void getById(HttpServletRequest request) {
	
		curso = cService.getById(id);
		System.out.println(curso.getCodigo());
		request.setAttribute(Constantes.ATT_CURSO, curso);
		rd = request.getRequestDispatcher(Constantes.JSP_CURSO);
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
		//Procesaremos el DELETE, UPDATE y CREATE
		//1º recoger datos del objeto curso
		String op = request.getParameter(Constantes.PAR_OPERACION);
		try{
			
			operacion = Integer.parseInt(op);
		
			switch(operacion){
				case Constantes.OP_CREATE:
					recogerDatos(request);
					cService.create(curso);
				break;
				case Constantes.OP_DELETE:
					recogerId(request);
					cService.delete(id);
				break;
				case Constantes.OP_UPDATE:
					recogerDatos(request);
					cService.update(curso);
				break;
			}
		} catch (NumberFormatException e){
			//TODO alguien nos toquetea los argumentos del form
		}
		
		getAll(request);
		rd.forward(request, response);
	}

	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		
	}

	private void recogerDatos(HttpServletRequest request) {
		curso = new Curso();
		recogerId(request);
		curso.setCodigo(id);
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		curso.setNombre(nombre);
	}

}
