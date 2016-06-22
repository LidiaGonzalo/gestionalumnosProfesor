package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;

public class CursoServiceImp implements CursoService {

	private List<Curso> cursos;
	private static int i = 1;
	public CursoServiceImp(){
		init();
	}
	private void init() {
		cursos = new ArrayList<Curso>();
		Curso curso = new Curso();
		curso.setNombre("Desarrollo de aplicaciones con tecnologías web Java / ASP.NET");
		create(curso);
	}
	@Override
	public Curso create(Curso curso) {
		curso.setCodigo(i);
		this.cursos.add(curso);
		
		return curso;
	}

	@Override
	public Curso getById(int codigo) {
		 
		return this.cursos.get(getIndex(codigo));
	}

	@Override
	public void delete(int codigo) {
		this.cursos.remove(getIndex(codigo));
	}

	@Override
	public List<Curso> getAll() {
		
		return this.cursos;
	}

	@Override
	public Curso update(Curso curso) {
		this.cursos.add(getIndex(i), curso);
		return curso;
	}
	private int getIndex(int codigo){
		int i = 0,index = -1,len = cursos.size();
		boolean econtrado = false;
		while (i < len && econtrado == false){
			if(cursos.get(i).getCodigo()==codigo){
				econtrado = true;
				index = i;
			}
			i++;
		}
		return index;
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
