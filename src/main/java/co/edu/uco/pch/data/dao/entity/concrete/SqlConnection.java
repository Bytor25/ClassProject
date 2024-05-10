package co.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

class SqlConnection {
	
	private Connection conexion;
	
	protected SqlConnection(final Connection conexion) {
		setConexion(conexion);
	}

	protected final Connection getConexion() {
		return conexion;
	}

	private final void setConexion(final Connection conexion) {
		this.conexion = conexion;
	}
	
}
