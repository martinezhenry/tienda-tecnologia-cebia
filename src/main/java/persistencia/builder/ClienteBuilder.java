package persistencia.builder;

import dominio.Cliente;
import persistencia.entitad.ClienteEntity;

public class ClienteBuilder {

	private ClienteBuilder() {}
	
	public static Cliente convertirADominio(ClienteEntity clienteEntity) {
		
		Cliente cliente = null;
		
		if(clienteEntity != null) {
			cliente = new Cliente(clienteEntity.getCedula(), clienteEntity.getNombre());
		}
		
		return cliente;
	}
	
	public static ClienteEntity convertirAEntity(Cliente cliente) {
		
		ClienteEntity clienteEntity = new ClienteEntity();

		clienteEntity.setCedula(cliente.getCedula());
		clienteEntity.setNombre(cliente.getNombre());

		return clienteEntity;
	}
}
