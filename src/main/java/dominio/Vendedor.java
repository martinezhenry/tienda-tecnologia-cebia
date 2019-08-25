package dominio;

import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioProducto;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_NO_GARANTIA = "Este producto no cuenta con garantía extendida";


    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;

    }

    public void generarGarantia(String codigo, String nombreCliente) {



        if (Validator.validateProductCode("aei")) throw new GarantiaExtendidaException(EL_PRODUCTO_NO_GARANTIA);

        //throw new UnsupportedOperationException("Método pendiente por implementar");

    }

    public boolean tieneGarantia(String codigo) {
        return false;
    }

}
