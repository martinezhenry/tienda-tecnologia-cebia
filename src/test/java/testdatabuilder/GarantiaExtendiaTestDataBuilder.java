package testdatabuilder;

import dominio.Cliente;
import dominio.GarantiaExtendida;
import dominio.Producto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GarantiaExtendiaTestDataBuilder {

	private static final Producto PRODUCTO = new ProductoTestDataBuilder().build();
	private static Date FECHA_SOLICITUD;
	private static Date FECHA_FIN;
	private static final double PRECIO = 130000.00;

	static {
		try {
			FECHA_SOLICITUD = new SimpleDateFormat("dd/MM/yyyy").parse("16/08/2018");
			FECHA_FIN = new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	private static final String NOMBRE = "Pedro Peréz";


	private Producto producto;
	private Date fechaSolicitudGarantia;
	private Date fechaFinGarantia;
	private double precioGarantia;
	private String nombreCliente;

	public GarantiaExtendiaTestDataBuilder() {
		this.producto = PRODUCTO;
		this.fechaSolicitudGarantia = FECHA_SOLICITUD;
		this.fechaFinGarantia = FECHA_FIN;
		this.precioGarantia = PRECIO;
		this.nombreCliente = NOMBRE;
	}

	public GarantiaExtendiaTestDataBuilder conFechas(Date fechaSolicitudGarantia, Date fechaFinGarantia) {
		this.fechaSolicitudGarantia = fechaSolicitudGarantia;
		this.fechaFinGarantia = fechaFinGarantia;
		return this;
	}

	public GarantiaExtendiaTestDataBuilder conProducto(Producto producto) {
		this.producto = producto;
		return this;
	}


	public GarantiaExtendiaTestDataBuilder conPrecio(double precio) {
		this.precioGarantia = precio;
		return this;
	}


	public GarantiaExtendida build() {
		return new GarantiaExtendida(this.producto, this.fechaSolicitudGarantia, this.fechaFinGarantia, this.precioGarantia, this.nombreCliente);
	}
}
