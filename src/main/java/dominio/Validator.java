package dominio;

import dominio.excepcion.GarantiaExtendidaException;
import dominio.utils.Utils;

import java.util.regex.Pattern;

public class Validator {

    public static final int MAX_VOCALS = 3;

    /**
     * Metodo para validar que la cantidad de vocales que tiene el codigo del producto no supere el maximo permitido.
     * @param code Codigo del producto
     * @return
     */
    public static boolean validateProductCode(String code){

       return (Utils.countVowels(code) >=  MAX_VOCALS) ? false: true ;

    }
}
