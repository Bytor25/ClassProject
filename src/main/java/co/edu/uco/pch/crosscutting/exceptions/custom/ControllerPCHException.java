package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class ControllerPCHException extends PCHException  {

	private static final long serialVersionUID = 659875740537612406L;
	
	public ControllerPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CONTROLLER);
	}
	public ControllerPCHException(final String mensajeTecnico, final String mensajeUsuario, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CONTROLLER, excepcionRaiz);

	}

}
