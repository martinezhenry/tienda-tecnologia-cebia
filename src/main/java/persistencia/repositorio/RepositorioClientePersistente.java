package persistencia.repositorio;

import dominio.Cliente;
import dominio.Producto;
import dominio.repositorio.RepositorioCliente;
import persistencia.builder.ClienteBuilder;
import persistencia.builder.ProductoBuilder;
import persistencia.entitad.ClienteEntity;
import persistencia.entitad.ProductoEntity;
import persistencia.repositorio.jpa.RepositorioClienteJPA;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RepositorioClientePersistente implements RepositorioCliente, RepositorioClienteJPA {

	private static final String CEDULA = "cedula";
	private static final String CLIENTE_FIND_BY_CEDULA = "Cliente.findByCedula";

	private EntityManager entityManager;

	public RepositorioClientePersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Cliente obtenerPorCedula(String cedula) {
		
		ClienteEntity clienteEntity = obtenerClienteEntityPorCedula(cedula);
		return ClienteBuilder.convertirADominio(clienteEntity);
	}

	@Override
	public ClienteEntity obtenerClienteEntityPorCedula(String cedula) {

		Query query = entityManager.createNamedQuery(CLIENTE_FIND_BY_CEDULA);
		query.setParameter(CEDULA, cedula);

		return (ClienteEntity) query.getSingleResult();
	}

	@Override
	public void agregar(Cliente cliente) {
		entityManager.persist(ClienteBuilder.convertirAEntity(cliente));
	}	

	

}
