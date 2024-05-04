package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.pch.crosscutting.exceptions.custom.CrosscuttingPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {
	
	private final Map<String, Mensaje> mensajes = new HashMap<>();
	
	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), 
				new Mensaje(CodigoMensaje.M00001, "El código del mensaje que se quiere obtener del catalogo de mensajes llego nulo"));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), 
				new Mensaje(CodigoMensaje.M00002, "Se ha presentado un problema tratando de llevar a cabo la operaci+on deseada"));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), 
				new Mensaje(CodigoMensaje.M00003, "El idetificador del mensaje \"${1}\" que se intentó obtener, no está en el catálo de mensajes base"));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), 
				new Mensaje(CodigoMensaje.M00004, "El mensaje con identificador \"${1}\" que se intento obtener, no esta configurado para residir en el catalogo de mensajes base"));
		}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, String... parametros) {
		return obtenerMensaje(codigo,parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {
		if(ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);

		}
		if(!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004,codigo.getIdentificador());
			
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		if(!mensajes.containsKey(codigo.getIdentificador())) {
			
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004,codigo.getIdentificador());
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		// Tarea: Asegure que si tiene parametros, el contenido del mensaje se retorne con los parametros reemplazados --- {1],{2},{3}
		return mensajes.get(codigo.getIdentificador());
	}

}
