package br.com.sgp.util;

import java.io.File;

public class Constants {

	public static final String UPLOADED_FOLDER = System.getProperty("user.home") + File.separator + "sgpfile"
			+ File.separator;
	
	public static final String PORTA = "80";

	public static final String LOCAL_IP = "127.0.0.1";
	
	public static final String getFolderAnexoDispendio() {
		return UPLOADED_FOLDER+File.separator+"anexo_dispendio";
	}
	public static final String getFolderAnexoTermo() {
		return UPLOADED_FOLDER+File.separator+"anexo_termo";
	}
}
