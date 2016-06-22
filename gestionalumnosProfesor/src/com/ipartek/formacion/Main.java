package com.ipartek.formacion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Candidato;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.AlumnoServiceImp;
import com.ipartek.formacion.service.ModuloService;
import com.ipartek.formacion.service.ModuloServiceImp;

public class Main {

	public static void main(String[] args) {
		AlumnoService aService = new AlumnoServiceImp();
	
		System.out.println(aService.getById(1).toString());
		List<Alumno> listAlumnos = aService.getAll();
				
		Alumno alum = AlumnoServiceImp.getAlumno();
		int[] notas = {0,6,9};
		Alumno[] alumnos = {alum,alum};

		Arrays.sort(alumnos);
		for(int i = 0; i< alumnos.length; i++){
			Alumno aux = alumnos[i];
		}
		for(Alumno aux: alumnos){
			System.out.println(aux.getNombre());
		}
		int i = 0;
		while (i < alumnos.length){
			i++;
		}
		evaluar(alum);	
	}
	public static String saludarAlumno(Candidato alumno){
		String saludo = ""; //&
		saludo += "Hola "+ alumno.getNombre(); 
		return saludo;
	}
	private static void hasAprobado(Candidato alumno){
		String mensaje = "";
		if (alumno.getNota() > 5 && alumno.getNota()>=5){
			mensaje = "Has aprobado";
		}else{
			mensaje = "Has suspendido";
		}
		
		System.out.println(mensaje);
	}
	private static void evaluar(Candidato alumno){
		int nota = (int) Math.floor(alumno.getNota());
		if(alumno instanceof Alumno){
			Alumno aux = (Alumno) alumno;
			aux.getCurso();
		}
		switch(nota){
		case 5:{
			String mensaje = "Es un candidato normalillo "+alumno.getNombre();
			System.out.println(mensaje);
			break;
		}
		case 6:{
			String mensaje = "No esta mal el candidato "+alumno.getNombre();
			break;
		}
		case 7:{
			String mensaje = "Es un buen candidato"+ alumno.getNombre();
			break;
		}
		case 8:{
			String mensaje = "Esta un gran candidato "+ alumno.getNombre();
			break;
		}
		case 9://if (nota == 9 || nota ==10)
		case 10:{
			String mensaje = "HAY QUE PILLARLO"+ alumno.getNombre();
			break;
		}
		default:
		{
			String mensaje = "Mejor que no venga"+alumno.getNombre();
			break;
		}
			
		}
		
	}
	private void gestionarMap(){
		Curso curso = new Curso();
		ModuloService mService = new ModuloServiceImp();
		Modulo modulo = mService.getById(0);
		Map<Integer,Modulo> modulos = curso.getModulos();
		modulos.put(modulo.getCodigo(), modulo);
		modulo = modulos.get(modulo.getCodigo());
		
		for(Entry<Integer, Modulo> aux: modulos.entrySet()){
			System.out.println(aux.getKey());
			System.out.println(aux.getValue().getNombre());
		}
		for(Modulo aux: modulos.values()){
			System.out.println(aux.getNombre());
		}
		
	}
}
