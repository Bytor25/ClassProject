package co.edu.uco.pch.crosscutting.helpers;

public final class ObjectHelper {
	
	private static final ObjectHelper INSTANCE = new ObjectHelper();
	private ObjectHelper() {
		super();
	}
	public static final ObjectHelper getObjectHelper() {
		return INSTANCE;
	}
	public <T> boolean isNull(T objeto) {
		return objeto == null;
	}
	
	public <T> T getDefaultValue(T objeto, T defaultValue) {
		return this.isNull(objeto)? defaultValue : objeto;
		
	}
}


