package com.ipartek.formacion.service;

import java.util.List;
import java.util.Map;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;

public class CursoServiceImp implements CursoService {

	@Override
	public Curso create(Curso curso) {
		
		return null;
	}

	@Override
	public Curso getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Curso> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}
	private Curso getIndex(int codigo){
		Curso curso = null;
		
		return curso;
	}
	@Override
	public void darDeAlta(Alumno alumno) {
		//1. obtener el curso
		int codigo = alumno.getCurso().getCodigo();
		Curso curso = getById(codigo);
		//2.obtener el Map
		Map<String,Alumno> alumnos = curso.getAlumnos();
		//3.meter el alumno en el Mapa
		alumnos.put(alumno.getDni(), alumno);
		//4.guardar/actualizar el curso 
		curso.setAlumnos(alumnos);
		update(curso);
	}

	@Override
	public void darDeBaja(Alumno alumno) {
		
		
	}

}
