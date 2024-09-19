package com.valoracion.config.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.valoraciones.util.ExceptionUtil;
import com.valoraciones.util.SerialClone;


public class Propiedad {


	Properties propVersion = new Properties();
	Properties propGlobal = new Properties();

	private static Propiedad p = null;

	private Propiedad() {
		try {
			InputStream in = this.getClass()
					.getResourceAsStream("/com/valoracion/config/properties/version.properties");
			propVersion.load(in);
			in.close();

			in = this.getClass().getResourceAsStream("/com/valoracion/config/properties/param.properties");
			propGlobal.load(in);
			in.close();

			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static Propiedad getCurrentInstance() {
		if (p == null) {
			p = new Propiedad();
		}
		return p;
	}

	public String getVersion() {
		return propVersion.getProperty("VERSION");
	}

	public String getBDJdbc() {
		return propGlobal.getProperty("BD.JDBC");
	}

	public String getBDUsuario() {
		return propGlobal.getProperty("BD.USUARIO");
	}

	public String getBDClave() {
		return propGlobal.getProperty("BD.CLAVE");
	}

	public String getPathTmp() {
		return propGlobal.getProperty("PATH_TMP");
	}
	
	
	public String getClientes() {
		return propGlobal.getProperty("CLIENTES");
	}

	public String getEstablecimientos() {
		return propGlobal.getProperty("ESTABLECIMIENTOS");
	}

	public String getServicios() {
		return propGlobal.getProperty("SERVICIOS");
	}

	public String getUsuarios() {
		return propGlobal.getProperty("USUARIOS");
	}
	public String getValoraciones() {
		return propGlobal.getProperty("VALORACIONES");
	}
	
	public String getEstablecimientoServicios() {
		return propGlobal.getProperty("ESTABLECIMIENTOSSERVICIOS");
	}
	

	public static void main(String args[]) {
		System.out.println("PARAM="
				+ Propiedad.getCurrentInstance().getVersion() + " " + Propiedad.getCurrentInstance().getBDJdbc() + " " + Propiedad.getCurrentInstance().getBDUsuario() + " " + Propiedad.getCurrentInstance().getBDClave());
	}
}
