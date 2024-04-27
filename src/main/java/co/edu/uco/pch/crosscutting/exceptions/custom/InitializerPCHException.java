package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class InitializerPCHException extends PCHException {

	private static final long serialVersionUID = 8642917776143912890L;

	public InitializerPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.INITIALIZER);
	}

	public InitializerPCHException(final String mensajeTecnico, final String mensajeUsuario, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.INITIALIZER, excepcionRaiz);
	}
}
