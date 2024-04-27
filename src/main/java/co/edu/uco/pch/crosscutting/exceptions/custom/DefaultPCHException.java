package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class DefaultPCHException extends PCHException {
	

	private static final long serialVersionUID = -3781813477717618768L;

	public DefaultPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DEFAULT);
	}

	public DefaultPCHException(final String mensajeTecnico, final String mensajeUsuario, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DEFAULT, excepcionRaiz);
	}
}
