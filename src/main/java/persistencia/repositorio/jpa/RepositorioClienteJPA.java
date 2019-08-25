package persistencia.repositorio.jpa;

import persistencia.entitad.ClienteEntity;

public interface RepositorioClienteJPA {

	/**
	 * Permite obtener un cliente entity por un cedula
	 * @param cedula
	 * @return
	 */
	ClienteEntity obtenerClienteEntityPorCedula(String cedula);

}
