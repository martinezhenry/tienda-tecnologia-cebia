package dominio;

import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioProducto;
import dominio.repositorio.RepositorioGarantiaExtendida;
import dominio.utils.Utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_NO_GARANTIA = "Este producto no cuenta con garant�a extendida";


    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;

    }

    public void generarGarantia(String codigo, String nombreCliente) {

        if (validarProducto(codigo)) throw new GarantiaExtendidaException(EL_PRODUCTO_NO_GARANTIA);
        if (tieneGarantia(codigo)) throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);

        // buscar producto por codigo
        Producto producto = repositorioProducto.obtenerPorCodigo(codigo);
        Date fechaSolicitudGarantia = generarFechaSolicitudGarantia();
        Date fechaFinGarantia = generarFechaFinGarantia(fechaSolicitudGarantia, producto.getPrecio());

        fechaFinGarantia = validarFechaFinGarantia(fechaFinGarantia);

        double precioGarantia = generarPrecioGarantia(producto.getPrecio());
        GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto, fechaSolicitudGarantia, fechaFinGarantia,  precioGarantia, nombreCliente);
        repositorioGarantia.agregar(garantiaExtendida);

        GarantiaExtendida ga = repositorioGarantia.obtener(codigo);

        System.out.printf("otracosa");
    }

    public boolean tieneGarantia(String codigo) {
        return ((repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo)) != null);
    }

    /**
     * Permite validar que la cantidad de vocales que tiene el codigo del producto no supere el maximo permitido.
     * @param codigo Codigo del producto
     * @return boolean
     */
    public boolean validarProducto(String codigo) {
        return (Utils.countVowels(codigo) <=  AppConfig.numMaxVocales);
    }


    /**
     * Permite obtener una fecha de solicitud de garantia.
     * @return Date
     */
    public Date generarFechaSolicitudGarantia() {
        return new Date();
    }


    /**
     * Permite obtener una fecha de fin de garantia.
     * @param fechaSolicitudGarantia fecha en que se realiza la garantia
     * @param precioProducto precio del producto al que se le esta generando la garantia
     * @return Date
     */
    public Date generarFechaFinGarantia(Date fechaSolicitudGarantia, double precioProducto) {

        return Utils.addDays(fechaSolicitudGarantia,obtenerNumDiasGarantia(precioProducto), AppConfig.diasAOmitir);
    }

    /**
     * Permite calcular el precio de la garantia
     * @param precioProducto precio del producto al que se le esta generando la garantia
     * @return double
     */
    public double generarPrecioGarantia(double precioProducto) {

        return  (precioProducto * (obtenerPorcentajeGarantia(precioProducto)/ Constants.CIEN));

    }


    /**
     * Permite obtener el numero de dias de la garantia
     * @param precioProducto precio del producto al que se le esta generando la garantia
     * @return int
     */
    public int obtenerNumDiasGarantia(double precioProducto) {

        int numDiasGarantia = AppConfig.diasGarantiaA;
        if (precioProducto > AppConfig.montoMaxGarantiaA) {
            numDiasGarantia = AppConfig.diasGarantiaB;
        }
        return numDiasGarantia;

    }

    /**
     * Permite obtener el porcentaje que se aplciara a la garantia
     * @param precioProducto precio del producto al que se le esta generando la garantia
     * @return double
     */
    public double obtenerPorcentajeGarantia(double precioProducto) {

        double porcentajeGarantia = AppConfig.porcentajeGarantiaA;
        if (precioProducto > AppConfig.montoMaxGarantiaA) {
            porcentajeGarantia = AppConfig.porcentajeGarantiaB;
        }
        return porcentajeGarantia;

    }


    /**
     * Permite validar que la fecha final de la garantia no sea domingo, si es asi le agrega los dias necesarios hasta el siguiente dia habil
     * @param fechaFinGarantia
     * @return
     */
    public Date validarFechaFinGarantia(Date fechaFinGarantia) {


        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaFinGarantia);
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                List<Date> festivos = Utils.calcularFestivosCol(String.valueOf(calendar.get(Calendar.YEAR)));
                do {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                } while (festivos.contains(calendar.getTime()));

                fechaFinGarantia = calendar.getTime();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fechaFinGarantia;

    }



}
