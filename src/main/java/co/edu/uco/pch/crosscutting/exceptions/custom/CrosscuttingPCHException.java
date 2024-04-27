package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingPCHException extends PCHException {
	
	private static final long serialVersionUID = -7289308713860840516L;

	public CrosscuttingPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CROSSCUTTING);
	}

	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING, excepcionRaiz);
	}
}
