package com.excepcion;

public class ExcepcionServicio extends Exception {

	private static final long serialVersionUID = 5L;

	public ExcepcionServicio(String msg) {
		super("Ha ocurrido una excepcion en el servicio: " + msg);
	}
}
