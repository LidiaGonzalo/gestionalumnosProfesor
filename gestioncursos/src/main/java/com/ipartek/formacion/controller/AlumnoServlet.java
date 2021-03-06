package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.exception.AlumnoError;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.AlumnoServiceImp;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;

/**
 * Servlet implementation class AlumnoServlet
 */
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private int id = -1;
	 private RequestDispatcher rd = null;
	 private AlumnoService aService = new AlumnoServiceImp();
	 private List<Alumno> alumnos = null;
	 private Alumno alumno = null;   
	 private int operacion = -1;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			recogerId(request);
			if(id < 0){//REDIGIRIMOS PARA UN CREATE
				rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
			}else{//REDIGIMOS PARA UNA UPDATE
				getById(request);
			}
			
		}catch(Exception e){
			getAll(request);
		}
		rd.forward(request, response); 
	}

	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
	}

	private void getAll(HttpServletRequest request) {
		alumnos = aService.getAll();
		System.out.println(alumnos.size());
		request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, alumnos);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_ALUMNOS);
	}

	private void getById(HttpServletRequest request) {
		alumno = aService.getById(id);
		request.setAttribute(Constantes.ATT_ALUMNO, alumno);
		rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter(Constantes.PAR_OPERACION);
		try {
			operacion = Integer.parseInt(op);
			recogerId(request);
			switch (operacion) {
			case Constantes.OP_CREATE:
				recogerDatosAlumno(request);
				aService.createAlumno(alumno);
				break;
			case Constantes.OP_DELETE:
				aService.delete(id);
				break;
			case Constantes.OP_UPDATE:
				recogerDatosAlumno(request);
				aService.update(alumno);
				break;
			default:
				break;
			}
			getAll(request);
		} catch (NumberFormatException e){
			
		} catch(NullPointerException e){
			
		} catch(CandidatoException e){
			try {
				AlumnoError alumnoError = new AlumnoError();
				alumnoError = recogerDatosError(request);
				alumnoError.setMensaje(e.getMessage());
				request.setAttribute(Constantes.ATT_ALUMNO, alumnoError);
				rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
			} catch (CandidatoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		catch(Exception e){
			
			
		}
		rd.forward(request, response);
	}

	private AlumnoError recogerDatosError(HttpServletRequest request) throws CandidatoException {
		AlumnoError alError = new AlumnoError();
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String dni = request.getParameter(Constantes.PAR_DNI);
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		alError.setCodigo(id);
		alError.setNombre(nombre);
		alError.setDni(dni);
		alError.setApellidos(apellidos);
		return alError;
	}

	private void recogerDatosAlumno(HttpServletRequest request) throws CandidatoException {
		alumno = new Alumno();
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String dni = request.getParameter(Constantes.PAR_DNI);
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		alumno.setCodigo(id);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setDni(dni);
		
	}

}
