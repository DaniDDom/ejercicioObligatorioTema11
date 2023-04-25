package listado.clientes;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Clase principal
 * 
 * @author Dani Dom
 *
 */
public class Main {

	/**
	 * Método principal
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		// Bandera de salida.
		boolean fin = false;
		// Contenedor de clientes.
		List<Cliente> lista = new ArrayList<>();

		// Número de clientes, para asignación de ID
		int numeroClientes = 0;

		// Leemos el archivo facilitado.
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Ejercicio20.dat"))) {
			// Recuperación de numero de clientes
			numeroClientes = entrada.readInt();
			// Recuperación de la lista
			lista = (List<Cliente>) entrada.readObject();
			// Error en caso de no existir el archivo
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
			// Error en caso de no encontrar la clase, o una excepción de IO.
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}

		// Asignación del valor recogido previamente.
		Cliente.setNumeroClientes(numeroClientes);
		do {
			// Opción a elegir del menu.
			int opcion = menu();
			// Casos del menu.
			switch (opcion) {
			case 1 -> darAlta(lista);
			case 2 -> modificarDatos(lista);
			case 3 -> darBaja(lista);
			case 4 -> mostrarContenido(lista);
			case 5 -> fin = true;
			}
		} while (!fin);

		// Obtención del número de clientes.
		numeroClientes = Cliente.getNumeroClientes();

		// Guardado de datos.
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Ejercicio20.dat"))) {

			// Guardado del número de clientes.
			salida.writeInt(numeroClientes);
			// Guardado de la lista.
			salida.writeObject(lista);

		} catch (IOException e) {

			System.out.println(e);
		}
		// Imprime despedida.
		System.out.println("Gracias por usar nuestro software, adios.");
	}

	/**
	 * Método para mostrar contenido de una lista.
	 * 
	 * @param lista
	 */
	public static void mostrarContenido(List<Cliente> lista) {

		// Iteración de la lista.
		for (Cliente cliente : lista) {
			System.out.println(cliente);
		}
	}

	/**
	 * Método para dar de alta un usuario.
	 * 
	 * @param lista
	 */
	public static void darAlta(List<Cliente> lista) {
		// Télefono del cliente.
		String telefono;
		// Nombre del cliente.
		String nombre;
		nombre = Entrada.pedirCadena("Introduzca el nombre del cliente: ");

		// Bucle mientras el telefono no cumpla las condiciones. Debe ser de 9 digitos.
		do {
			telefono = Entrada
					.pedirCadena("Introduzca el número de telefono del cliente, debe ser númerico de 9 digitos: ");
		} while (!telefono.matches("\\d{9}"));
		// Creación y añadido del cliente a la lista.
		Cliente c = new Cliente(nombre, telefono);
		lista.add(c);
	}

	/**
	 * Método para modificar datos de usuario.
	 * 
	 * @param lista
	 */
	public static void modificarDatos(List<Cliente> lista) {

		// ID del usuario
		int identificacion;
		// Télefono del cliente.
		String telefono;
		// Nombre del cliente.
		String nombre;
		// Bucle mientras el ID no cumpla las condiciones.
		do {
			identificacion = Entrada.pedirEntero("Introduzca la ID del cliente que desea modificar");
		} while (identificacion > lista.size() || (identificacion < 0));
		nombre = Entrada.pedirCadena("Introduzca el nombre del cliente: ");
		do {
			telefono = Entrada
					.pedirCadena("Introduzca el número de telefono del cliente, debe ser númerico de 9 digitos: ");
		} while (!telefono.matches("\\d{9}") && (telefono == null));

		// Obtención cliente a modificar.
		Cliente c = lista.get(identificacion);

		// Nombre será modificado en caso de tener contenido.
		if (nombre.isBlank()) {
			c.setNombre(nombre);
		}
		// Teléfono será modificado en caso de tener contenido.
		if (!telefono.isBlank()) {
			c.setTelefono(telefono);
		}
	}

	/**
	 * Método para dar de baja al usuario.
	 * 
	 * @param lista
	 */
	public static void darBaja(List<Cliente> lista) {
		// Clave de identificación del usuario a dar de baja.
		int identificacion;
		identificacion = Entrada.pedirEntero("Introduzca la ID del cliente que desea dar de baja");
		// Elimina cliente seleccionado.
		lista.remove(identificacion);
		// Reduce el número de clientes.
		Cliente.decrementarNumeroClientes();
		// Iteración para reasignar ID.
		for (int i = identificacion; i < lista.size(); i++) {
			Cliente c = lista.get(i);
			c.setID(c.getID() - 1);
		}
	}

	/**
	 * Basic menu.
	 * 
	 * @return opcion.
	 */
	public static int menu() {
		// Opcion indicada por el usuario.
		int opcion = 0;

		// Opciones del menu.
		do {
			System.out.println("1. Añadir nuevo cliente.");
			System.out.println("2. Modificar datos.");
			System.out.println("3. Dar de baja cliente");
			System.out.println("4. Listar los clientes");
			System.out.println("5. Salir");
			opcion = Entrada.pedirEntero("Escriba su opcion");
		} while ((opcion < 0) || (opcion > 5));
		return opcion;
	}

}
