package com.ipartek.formacion.service;

import java.util.ArrayList;


import java.util.List;

import com.ipartek.formacion.pojo.Modulo;

public class ModuloServiceImp implements ModuloService{

	private List<Modulo>modulos;
	private static int i  = 0;
	private void init(){
		Modulo modulo = new Modulo();
		modulo.setNombre("Desarrollo Aplicaciones Web");
		create(modulo);
	}
	public ModuloServiceImp(){
		this.modulos = new ArrayList<Modulo>();
		init();
	}
	@Override
	public Modulo create(Modulo modulo) {
		//le asignamos el codigo al modulo
		modulo.setCodigo(ModuloServiceImp.i);
		//lo añadimos a la "BBDD"
		modulos.add(modulo);
		i++;
		return modulo;
	}

	@Override
	public Modulo getById(int codigo) {
		Modulo modulo = this.modulos.get(getIndex(codigo));
		return modulo;
	}
	private int getIndex(int codigo){
		int index = -1;
		int i= 0,len = modulos.size();
		boolean encontrado = false;
		while(i < len && encontrado == false){
			if(this.modulos.get(i).getCodigo()==codigo){
				encontrado = true;
				index = i;
			}
			i++;
		}	
		
		return index;
	}
	@Override
	public void delete(int codigo) {
		//DELETE FROM modulo
		//WHERE id = codigo;
		modulos.remove(getIndex(codigo));
		
	}

	@Override
	public List<Modulo> getAll() {
		
		return this.modulos;
	}

	@Override
	public Modulo update(Modulo modulo) {
		this.modulos.add(getIndex(modulo.getCodigo()), modulo);
		return modulo;
	}

}
