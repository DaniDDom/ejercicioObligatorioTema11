package listado.clientes;

import java.io.Serializable;

/**
 * Clase Cliente que implementa la interfaz Serializable
 * 
 * @author Dani Dom
 *
 */
public class Cliente implements Serializable {

	/** Contador de clientes */
	private static int numeroClientes = 0;

	/** ID del cliente */
	private int id;

	/** Nombre cliente */
	private String nombre;

	/** Telefono cliente */

	private String telefono;

	/** Constructor vacio sobreescrito */
	public Cliente() {
		// id generada.
		this.id = numeroClientes++;

	}

	/** Constructor sobrecargado con parametros */
	public Cliente(String nombre, String telefono) {
		// id generada
		this.id = numeroClientes++;
		// Nombre pasado como parametro
		this.nombre = nombre;
		// Telefono pasado como parametro
		this.telefono = telefono;
	}

	/**
	 * Método que reduce el numero de Cliente para seguimiento del ID
	 */
	public static void decrementarNumeroClientes() {
		numeroClientes--;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		id = iD;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método para pasar a String
	 * 
	 * @Override
	 */

	public String toString() {
		return "Cliente [ID: " + id + " nombre=" + nombre + ", telefono=" + telefono + "]";
	}

	/**
	 * @param numeroClientes the numeroClientes to set
	 */
	public static void setNumeroClientes(int numeroClientes) {
		Cliente.numeroClientes = numeroClientes;
	}

	/**
	 * @return the numeroClientes
	 */
	public static int getNumeroClientes() {
		return numeroClientes;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return id;
	}

}
