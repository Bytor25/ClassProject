package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class DataPCHException extends PCHException  {


	private static final long serialVersionUID = -6558019585349631358L;
	private static final Lugar lugar = Lugar.DATA;
	
	public DataPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);

	}
	public DataPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario,lugar);
	}
	
	public DataPCHException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}



}

