package persistencia.entitad;

import javax.persistence.*;

@Entity(name = "Cliente")
@NamedQuery(name = "Cliente.findByCedula", query = "SELECT cliente FROM Cliente cliente WHERE cliente.cedula = :cedula")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String cedula;

	@Column(nullable = false)
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
