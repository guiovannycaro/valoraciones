package com.valoraciones.controller;


import com.valoracion.config.properties.Propiedad;
import com.valoracion.interfases.valoracionesInterfaces;
import com.valoraciones.Models.Clientes;
import com.valoraciones.Models.Establecimiento;
import com.valoraciones.Models.EstablecimientoXServicio;
import com.valoraciones.Models.Servicio;
import com.valoraciones.Models.Usuarios;
import com.valoraciones.Models.Valoracion;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class valoracionesController implements valoracionesInterfaces{

	 public static final File PLANTILLA_EXEL_GENERIC = new File(Propiedad.getCurrentInstance().getUsuarios() + "reportefechastnpagos.pdf");
	 
	private int maxUsuarios = 50;
	private int maxServicios = 100;
	private int maxEstablecimientos = 100;
	private int maxClientes = 100;

	private int maxEstablecimientosXServicio = 100;
	private int maxValoracion = 100;

	private Usuarios misusuarios[] = new Usuarios[maxUsuarios];
	private Servicio misServicios[] = new Servicio[maxServicios];
	private Establecimiento misEstablecimiento[] = new Establecimiento[maxEstablecimientos];
	private Clientes misClientes[] = new Clientes[maxClientes];

	private EstablecimientoXServicio misEstablecimientosXServicio[] = new EstablecimientoXServicio[maxEstablecimientosXServicio];
	private Valoracion misValoracion[] = new Valoracion[maxValoracion];

	private int contadorusuarios = 0;
	private int contadorservicios = 0;
	private int contadorestablecimientos = 0;
	private int contadorclientes = 0;
	private int contadorestablecimientoxservicio = 0;
	private int contadorvaloracion = 0;

	public valoracionesController() {

		 Usuarios miusuario;

	        miusuario = new Usuarios(1,"guiovanny", "Guiovanny Caro", "guiovanny.caro@gmail.com", 1, "123");
	        misusuarios[contadorusuarios] = miusuario;
	        contadorusuarios++;
	        
	        miusuario = new Usuarios(2,"zulu", "juan  Carlos", "Zuluaga.Cardona@gmail.com", 1, "123");
	        misusuarios[contadorusuarios] = miusuario;
	        contadorusuarios++;
	        
	        miusuario = new Usuarios(3,"zulu", "juan  Carlos", "Zuluaga.Cardona@gmail.com", 1, "123");
	        misusuarios[contadorusuarios] = miusuario;
	        contadorusuarios++;
	  /*      
		cargarusuarios();
		cargarservicios();
		cargarestablecimientos();
		cargarclientes();

		cargarestablecimientosxservicio();
		cargarvaloracion();*/
	}

	public int numerousuarios() {
		return contadorusuarios;

	}

	public int numeroservicios() {
		return contadorservicios;

	}

	public int numeroestablecimientos() {
		return contadorestablecimientos;

	}

	public int numeroclientes() {
		return contadorclientes;

	}

	public int numerosestablecimientoxservicio() {
		return contadorestablecimientoxservicio;

	}

	public int numerovaloracion() {
		return contadorvaloracion;

	}

	public Usuarios[] getUsuarios() {
		return misusuarios;
	}

	public Servicio[] getServicios() {
		return misServicios;
	}

	public Establecimiento[] getEstablecimiento() {
		return misEstablecimiento;
	}

	public Clientes[] getClientes() {
		return misClientes;
	}

	public EstablecimientoXServicio[] getEstablecimientosXServicio() {
		return misEstablecimientosXServicio;
	}

	public Valoracion[] getValoracion() {
		return misValoracion;
	}
	
	@Override
	public int validarUsuario(String usuario, String clave) {
		
	
		int aux = -1;

		for (int i = 0; i < contadorusuarios; i++) {
			System.err.println("usuario " + usuario + "clave " + clave);
			if (misusuarios[i].getUsuario().equals(usuario) && misusuarios[i].getPassword().equals(clave)) {
				
				System.err.println("returna " + misusuarios[i].getPerfil());
				return misusuarios[i].getPerfil();
			}
		}

		return aux;
	}
	
	@Override
	public int getPerfil(String usuario) {
		int aux = -1;

		for (int i = 0; i < contadorusuarios; i++) {

			if (misusuarios[i].getIdUsuario().equals(usuario)) {
				return misusuarios[i].getPerfil();
			}
		}

		return aux;
	}
	
	@Override
	public String getUsuario(String usuario) {
		String aux = "";

		for (int i = 0; i < contadorusuarios; i++) {

			if (misusuarios[i].getIdUsuario().equals(usuario)) {
				return misusuarios[i].getUsuario();
			}
		}

		return aux;
	}
	
	@Override
	public void cambioclave(String usuario, String clave) {
		int aux = -1;

		for (int i = 0; i < contadorusuarios; i++) {

			if (misusuarios[i].getIdUsuario().equals(usuario)) {
				misusuarios[i].setPassword(clave);
				return;
			}
		}

	}
	
	@Override
	public int posicionUsuario(String usuario) {

		for (int i = 0; i < contadorusuarios; i++) {

			if (misusuarios[i].getIdUsuario().equals(usuario)) {
				return i;
			}
		}

		return -1;
	}
	
	@Override
	public int posicionSevicio(String servicio) {

		for (int i = 0; i < contadorservicios; i++) {

			if (misServicios[i].getIdServicio().equals(servicio)) {
				return i;
			}
		}

		return -1;
	}
	
	@Override
	public int posicionEstablecimiento(String establecimiento) {

		for (int i = 0; i < contadorestablecimientos; i++) {

			if (misEstablecimiento[i].getIdEstablecimiento().equals(establecimiento)) {
				return i;
			}
		}

		return -1;
	}
	
	@Override
	public int posicionCliente(String cliente) {

		for (int i = 0; i < contadorclientes; i++) {

			if (misClientes[i].getIdCliente().equals(cliente)) {
				return i;
			}
		}

		return -1;
	}
	
	@Override
	public int posicionContadorEstablecimientoXServicio(String estser) {

		for (int i = 0; i < contadorestablecimientoxservicio; i++) {

			if (misEstablecimientosXServicio[i].getIdEstablecimientoServicio().equals(estser)) {
				return i;
			}
		}

		return -1;
	}
	
	@Override
	public int posicionValoracion(String valor) {

		for (int i = 0; i < contadorvaloracion; i++) {

			if (misValoracion[i].getIdValoracion().equals(valor)) {
				return i;
			}
		}

		return -1;
	}
	
	@Override
	public String agregarUsuario(Usuarios miUsuario) {
		if (contadorusuarios == maxUsuarios) {

			return "se ha alcanzado el numero maximo de usuarios";
		}

		misusuarios[contadorusuarios] = miUsuario;
		contadorusuarios++;
		return "Usuario Agregado oorrectamente";
	}
	
	@Override
	public String agregarServicio(Servicio miServicio) {
		if (contadorservicios == maxServicios) {

			return "se ha alcanzado el numero maximo de servicios";
		}

		misServicios[contadorservicios] = miServicio;
		contadorservicios++;
		return "Servicio Agregado oorrectamente";
	}
	
	@Override
	public String agregarEstablecimiento(Establecimiento miEstablecimiento) {
		if (contadorestablecimientos == maxEstablecimientos) {

			return "se ha alcanzado el numero maximo de Establecimientos";
		}

		misEstablecimiento[contadorestablecimientos] = miEstablecimiento;
		contadorestablecimientos++;
		return "Establecimiento Agregado oorrectamente";
	}
	
	@Override
	public String agregarClientes(Clientes miCliente) {
		if (contadorclientes == maxEstablecimientos) {

			return "se ha alcanzado el numero maximo de Clientes";
		}

		misClientes[contadorclientes] = miCliente;
		contadorclientes++;
		return "Cliente Agregado oorrectamente";
	}
	
	@Override
	public String agregarEstablecimientosXServicio(EstablecimientoXServicio miEstablecimientoXServicio) {
		if (contadorestablecimientoxservicio == maxEstablecimientosXServicio) {

			return "se ha alcanzado el numero maximo de Relaciones Establecimiento Cliente";
		}

		misEstablecimientosXServicio[contadorestablecimientoxservicio] = miEstablecimientoXServicio;
		contadorestablecimientoxservicio++;
		return "La RelacionEstablecimiento Cliente  Agregado oorrectamente";
	}
	
	@Override
	public String agregarClientes(Valoracion miValoracion) {
		if (contadorvaloracion == maxValoracion) {

			return "se ha alcanzado el numero maximo de Valoraciones";
		}

		misValoracion[contadorvaloracion] = miValoracion;
		contadorvaloracion++;
		return "Valoracion Agregado oorrectamente";
	}
	
	@Override
	public String modificarUsuario(Usuarios miUsuario, int pos) {
		misusuarios[pos].setUsuario(miUsuario.getUsuario());
		misusuarios[pos].setNombres(miUsuario.getNombres());
		misusuarios[pos].setCorreo(miUsuario.getCorreo());
		misusuarios[pos].setPerfil(miUsuario.getPerfil());
		misusuarios[pos].setPassword(miUsuario.getPassword());

		return "Usuario modificado oorrectamente";
	}
	
	@Override
	public String modificarCliente(Clientes miCliente, int pos) {

		misClientes[pos].setCodCliente(miCliente.getCodCliente());
		misClientes[pos].setNombres(miCliente.getNombres());
		misClientes[pos].setFecha(miCliente.getFecha());
		misClientes[pos].setCorreo(miCliente.getCorreo());

		return "Cliente modificado oorrectamente";
	}
	
	@Override
	public String borrarUsuario(int pos) {
		for (int i = pos; i < contadorusuarios - 1; i++) {
			misusuarios[i] = misusuarios[i + 1];
		}
		contadorusuarios--;
		return "Usuario eliminado oorrectamente";
	}
	
	@Override
	public String borrarServicio(int pos) {
		for (int i = pos; i < contadorservicios - 1; i++) {
			misServicios[i] = misServicios[i + 1];
		}
		contadorservicios--;
		return "Servicio eliminado oorrectamente";
	}
	
	@Override
	public String borrarEstablecimiento(int pos) {
		for (int i = pos; i < contadorestablecimientos - 1; i++) {
			misEstablecimiento[i] = misEstablecimiento[i + 1];
		}
		contadorestablecimientos--;
		return "Establecimiento eliminado oorrectamente";
	}
	
	@Override
	public String borrarCliente(int pos) {
		for (int i = pos; i < contadorclientes - 1; i++) {
			misClientes[i] = misClientes[i + 1];
		}
		contadorclientes--;
		return "Cliente eliminado oorrectamente";
	}
	
	@Override
	public String borrarEstablecimientoXServicio(int pos) {
		for (int i = pos; i < contadorestablecimientoxservicio - 1; i++) {
			misEstablecimientosXServicio[i] = misEstablecimientosXServicio[i + 1];
		}
		contadorestablecimientoxservicio--;
		return "Establecimiento Servicio eliminado oorrectamente";
	}
	
	@Override
	public String borrarValoracion(int pos) {
		for (int i = pos; i < contadorvaloracion - 1; i++) {
			misValoracion[i] = misValoracion[i + 1];
		}
		contadorvaloracion--;
		return "Valoracion eliminado oorrectamente";
	}
	
	@Override
	public void GrabarTodo() {

		GrabarUsuarios();
		GrabarServicios();
		GrabarEstablecimientos();
		GrabarClientes();
		GrabarEstablecimientoServicio();
		GrabarValoracion();

	}
	
	@Override
	public void GrabarUsuarios() {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("Data/usuarios.txt");
			pw = new PrintWriter(fw);

			for (int i = 0; i < contadorusuarios; i++) {
				pw.println(misusuarios[i].toString());
			}
		} catch (Exception err1) {
			err1.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception err2) {
				err2.printStackTrace();
			}

		}

	}
	
	@Override
	public void GrabarServicios() {

		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("Data/servicios.txt");
			pw = new PrintWriter(fw);

			for (int i = 0; i < contadorservicios; i++) {
				pw.println(misServicios[i].toString());
			}
		} catch (Exception err1) {
			err1.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception err2) {
				err2.printStackTrace();
			}

		}
	}
	
	@Override
	public void GrabarEstablecimientos() {

		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("Data/establecimientos.txt");
			pw = new PrintWriter(fw);

			for (int i = 0; i < contadorestablecimientos; i++) {
				pw.println(misEstablecimiento[i].toString());
			}
		} catch (Exception err1) {
			err1.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception err2) {
				err2.printStackTrace();
			}

		}
	}
	
	@Override
	public void GrabarClientes() {

		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("Data/clientes.txt");
			pw = new PrintWriter(fw);

			for (int i = 0; i < contadorclientes; i++) {
				pw.println(misClientes[i].toString());
			}
		} catch (Exception err1) {
			err1.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception err2) {
				err2.printStackTrace();
			}

		}
	}
	
	@Override
	public void GrabarEstablecimientoServicio() {

		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("Data/establecimientosxservicios.txt");
			pw = new PrintWriter(fw);

			for (int i = 0; i < contadorestablecimientoxservicio; i++) {
				pw.println(misEstablecimientosXServicio[i].toString());
			}
		} catch (Exception err1) {
			err1.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception err2) {
				err2.printStackTrace();
			}

		}
	}
	
	@Override
	public void GrabarValoracion() {

		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("Data/valoraciones.txt");
			pw = new PrintWriter(fw);

			for (int i = 0; i < contadorvaloracion; i++) {
				pw.println(misValoracion[i].toString());
			}
		} catch (Exception err1) {
			err1.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception err2) {
				err2.printStackTrace();
			}

		}
	}

	


	@Override
	public void cargarusuarios() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
		archivo = new File(Propiedad.getCurrentInstance().getUsuarios() + "usuarios.txt");
		fr = new FileReader(archivo);

		br = new BufferedReader(fr);
		
			int pos;
			String aux;
			String linea;
			int iDUsuario;
			String usuario;
			String nombres;
			String correo;
			int perfil;
			String password;

			while ((linea = br.readLine()) != null) {

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				iDUsuario = new Integer(aux);
				linea = linea.substring(pos + 1);
				
				
				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				usuario = aux;
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				nombres = aux;
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				correo = aux;
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				perfil = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				password = aux;
				linea = linea.substring(pos + 1);

				Usuarios miusuario;
			
				miusuario = new Usuarios(iDUsuario,usuario, nombres, correo, perfil, password);
				misusuarios[contadorusuarios] = miusuario;
				contadorusuarios++;

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			try {

				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		}

	}
	
	@Override
	public void cargarservicios() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(Propiedad.getCurrentInstance().getServicios() + "servicios.txt");
			fr = new FileReader(archivo);

			br = new BufferedReader(fr);
			int pos;
			String aux;
			String linea;
			int idServicio;
			String nombre;
			String detalle;
			

			while ((linea = br.readLine()) != null) {

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				idServicio = new Integer(aux);
				linea = linea.substring(pos + 1);
				
				
				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				nombre = aux;
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				detalle = aux;
				linea = linea.substring(pos + 1);

				

				Servicio miServicio;
			
				miServicio = new Servicio(idServicio,nombre, detalle);
				misServicios[contadorservicios] = miServicio;
				contadorservicios++;

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			try {

				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		}

	}
	
	@Override
	public void cargarestablecimientos() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(Propiedad.getCurrentInstance().getEstablecimientos() + "establecimientos.txt");
			fr = new FileReader(archivo);

			br = new BufferedReader(fr);
			int pos;
			String aux;
			String linea;
			int IdEstablecimiento;
			String nombre;
			String direccion;
			String telefono;

			while ((linea = br.readLine()) != null) {

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				IdEstablecimiento = new Integer(aux);
				linea = linea.substring(pos + 1);
				
				
				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				nombre = aux;
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				nombre = aux;
				linea = linea.substring(pos + 1);

				
				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				direccion = aux;
				linea = linea.substring(pos + 1);
				
				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				telefono = aux;
				linea = linea.substring(pos + 1);
				
				
				Establecimiento miEstablecimiento;
			
				miEstablecimiento = new Establecimiento(IdEstablecimiento,nombre, direccion,telefono);
				misEstablecimiento[contadorestablecimientos] = miEstablecimiento;
				contadorestablecimientos++;

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			try {

				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		}

	}
	
	@Override
	public void cargarclientes() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
	
		try {
			archivo = new File(Propiedad.getCurrentInstance().getClientes() + "clientes.txt");
			fr = new FileReader(archivo);

			br = new BufferedReader(fr);
			int pos;
			String aux;
			String linea;
			Integer idCliente;
			Integer codCliente;
			String nombres;
			String fecha;
			String correo;

			while ((linea = br.readLine()) != null) {

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				idCliente = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				codCliente = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				nombres = aux;
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				fecha = aux;
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				correo = aux;
				linea = linea.substring(pos + 1);

				Clientes miCliente;

				miCliente = new Clientes(idCliente, codCliente, nombres, fecha, correo);
				misClientes[contadorclientes] = miCliente;
				contadorclientes++;

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			try {

				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		}

	}
	
	@Override
	public void cargarestablecimientosxservicio() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(Propiedad.getCurrentInstance().getEstablecimientoServicios() + "establecimientosxservicios.txt");
			fr = new FileReader(archivo);

			br = new BufferedReader(fr);
			int pos;
			String aux;
			String linea;
			Integer IdEstablecimientoServicio;
			Integer IdEstablecimiento;
			Integer IdValoracion;

			while ((linea = br.readLine()) != null) {

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				IdEstablecimientoServicio = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				IdEstablecimiento = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				IdValoracion =  new Integer(aux);
				linea = linea.substring(pos + 1);

				

				EstablecimientoXServicio miEstablecimientoXServicio;

				miEstablecimientoXServicio = new EstablecimientoXServicio(IdEstablecimientoServicio, IdEstablecimiento, IdValoracion);
				misEstablecimientosXServicio[contadorestablecimientoxservicio] = miEstablecimientoXServicio;
				contadorestablecimientoxservicio++;

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			try {

				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		}

	}

	@Override
	public void cargarvaloracion() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			
			
			archivo = new File(Propiedad.getCurrentInstance().getValoraciones() + "valoraciones.txt");
			fr = new FileReader(archivo);

			br = new BufferedReader(fr);
			int pos;
			String aux;
			String linea;
			Integer idValoracion;
			Integer idServicio;
			Integer IdCliente;
			Integer Puntuacion;

			while ((linea = br.readLine()) != null) {

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				idValoracion = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				idServicio = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				IdCliente = new Integer(aux);
				linea = linea.substring(pos + 1);

				pos = linea.indexOf('|');
				aux = linea.substring(0, pos);
				Puntuacion = new Integer(aux);
				linea = linea.substring(pos + 1);

				

				Valoracion miValoracion;

				miValoracion = new Valoracion(idValoracion, idServicio, IdCliente, Puntuacion);
				misValoracion[contadorvaloracion] = miValoracion;
				contadorvaloracion++;

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			try {

				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		}

	}


}
