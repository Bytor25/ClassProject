package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class DtoPCHException extends PCHException {

	private static final long serialVersionUID = 1052504668272822924L;
	
	public DtoPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DTO);
	}
	
	public DtoPCHException(final String mensajeTecnico, final String mensajeUsuario, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario,Lugar.DTO, excepcionRaiz);
	}



}
