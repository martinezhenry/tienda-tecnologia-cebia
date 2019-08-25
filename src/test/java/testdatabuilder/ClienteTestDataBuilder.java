package testdatabuilder;

import dominio.Cliente;

public class ClienteTestDataBuilder {

	private static final String CEDULA = "CC123456789";
	private static final String NOMBRE = "Pedro Peréz";

	private String cedula;
	private String nombre;

	public ClienteTestDataBuilder() {
		this.cedula = CEDULA;
		this.nombre = NOMBRE;
	}

	public ClienteTestDataBuilder conNombreAndCedula(String cedula, String nombre) {
		this.cedula=cedula;
		this.nombre=nombre;
		return this;
	}

	public Cliente build() {
		return new Cliente(this.cedula, this.nombre);
	}
}
