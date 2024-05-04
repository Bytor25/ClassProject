package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingPCHException extends PCHException {
	
	private static final long serialVersionUID = -7289308713860840516L;
	private static final Lugar lugar = Lugar.CROSSCUTTING;

	public CrosscuttingPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario,lugar);
	}

	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
