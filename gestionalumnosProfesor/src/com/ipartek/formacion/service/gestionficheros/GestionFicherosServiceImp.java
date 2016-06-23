package com.ipartek.formacion.service.gestionficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.pojo.DatoFichero;

public class GestionFicherosServiceImp implements GestionFicherosService {
	private DatoFichero datosFichero;
	public GestionFicherosServiceImp(DatoFichero datosFichero){
		this.datosFichero = datosFichero;
	}
	
	public DatoFichero getDatosFichero() {
		return datosFichero;
	}

	public void setDatosFichero(DatoFichero datosFichero) {
		this.datosFichero = datosFichero;
	}

	@Override
	public List<Serializable> leerFichero() {
		List<Serializable> lista = null;
		String path = datosFichero.getRuta()+File.pathSeparator+datosFichero.getNombre()+File.separator+datosFichero.getExtension();
		File archivo = new File(path);
		FileInputStream fileInput;
		ObjectInputStream input;
		
		try {
			int len;
			fileInput = new FileInputStream(archivo);
			input = new ObjectInputStream(fileInput);
			lista = (List<Serializable>) input.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			
		}finally{
			
		}
		
		
		return lista;
	}

	@Override
	public void guardarFichero(List<Serializable> lista) {
		String path = datosFichero.getRuta()+File.pathSeparator+datosFichero.getNombre()+File.separator+datosFichero.getExtension();
		File archivo = new File(path);
		FileOutputStream fileOutput;
		ObjectOutputStream out;
		try {
			fileOutput = new FileOutputStream(archivo);
			out = new ObjectOutputStream(fileOutput);
			out.writeObject(lista);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
