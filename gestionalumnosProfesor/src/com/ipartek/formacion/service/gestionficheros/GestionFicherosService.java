package com.ipartek.formacion.service.gestionficheros;

import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.pojo.DatoFichero;

public interface GestionFicherosService {
	public List<Serializable> leerFichero();


	public void guardarFichero(List<Serializable> lista);
}
