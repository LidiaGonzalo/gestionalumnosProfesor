package com.ipartek.formacion.pojo.exception;

public class CandidatoException extends Exception{

	public static final int CODIGO_ERROR_FECHA_NACIMIENTO = 100;
	public static final String MSG_ERROR_FECHA_NACIMIENTO ="La fecha introducida no es válida";
	private int codigo;
	private String mensaje;
	public CandidatoException(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	public CandidatoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public CandidatoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public CandidatoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public CandidatoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.mensaje;
	}
		
	
	
	
	
}
