package co.edu.uco.pch.crosscutting.exceptions.custom;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class EntityPCHException extends PCHException {

	private static final long serialVersionUID = 463187619217737455L;

	public EntityPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.ENTITY);
	}

	public EntityPCHException(final String mensajeTecnico, final String mensajeUsuario, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.ENTITY, excepcionRaiz);
	}


}
