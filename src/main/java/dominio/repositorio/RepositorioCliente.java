package dominio.repositorio;

import dominio.Cliente;
import dominio.Producto;

public interface RepositorioCliente {

	/**
	 * Permite obtener un cliente dado una cedula
	 * @param cedula
	 * @return
	 */
	Cliente obtenerPorCedula(String cedula);

	/**
	 * Permite agregar un cliente al repositorio
	 * @param cliente
	 */
	void agregar(Cliente cliente);

}