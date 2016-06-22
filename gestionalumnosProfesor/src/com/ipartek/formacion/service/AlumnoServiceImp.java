package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;

public class AlumnoServiceImp implements AlumnoService{
	private List<Alumno> alumnos;
	private static int i = 1;
	private void init(){
		Alumno alumno = new Alumno();
		
		alumno.setCodigo(1);
		alumno.setNombre("Imanol");
		alumno.setApellidos("Jimenez Lopez");
		alumnos.add(alumno);
		i++;
		alumno = new Alumno();
		alumno.setCodigo(2);
		alumno.setNombre("Josu");
		alumno.setApellidos("Asua Gallego");
		alumnos.add(alumno);
		i++;
		alumno = new Alumno();
		alumno.setCodigo(3);
		alumno.setNombre("Alvaro");
		alumno.setApellidos("Rodriguez Miguel");
		alumnos.add(alumno);
		i++;
	}
	public AlumnoServiceImp(){
		this.alumnos = new ArrayList<Alumno>();
		init();
	}
	
	public static Alumno getAlumno(){
		Alumno alum = null;
		alum = new Alumno();
		alum.setCodigo(1);
		alum.setNombre("Urko");
		alum.setApellidos("Villanueva Alvarez");
		alum.setNota(0.0);
		alum.setCurso(crearCursoAlumno());
		
		return alum;
	}
	private static Curso crearCursoAlumno(){
		Curso curso = null;
		curso = new Curso();
		curso.setCodigo(1);
		curso.setNombre("Desarrollo de Aplicaciones con Tecnologias Web");
		return curso;
	}

	@Override
	public Alumno createAlumno(Alumno alumno) {
		alumno.setCodigo(i);
		alumnos.add(alumno);
		i++;
		return alumno;
	}

	@Override
	public Alumno getById(int codigo) {
		Alumno alumno = null;
		int index = getIndex(codigo);
		alumno = alumnos.get(index);
		
		
		return alumno;
	}

	@Override
	public void delete(int codigo) {
		int index = getIndex(codigo);
		this.alumnos.remove(index);
		
	}
	private int getIndex(int codigo){
		int index = -1;
		int i = 0,len= this.alumnos.size();
		boolean encontrado = false;
		while(i< len && encontrado ==false){
			Alumno aux = this.alumnos.get(i);//alumnos[i];
			if(aux.getCodigo()==codigo){
				encontrado = true;
				index = i;
			}
			i++;
		}
		return index;
	}
	
	@Override
	public List<Alumno> getAll() {
		return this.alumnos;
	}
	@Override
	public Alumno update(Alumno alumno) {
		int index = getIndex(alumno.getCodigo());
		this.alumnos.add(index, alumno);
		return alumno;
	}
}










