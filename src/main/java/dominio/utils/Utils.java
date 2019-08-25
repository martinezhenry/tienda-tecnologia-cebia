package dominio.utils;

import dominio.excepcion.GarantiaExtendidaException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static final String VOWELS = "[aeiouáéíóúAEIOUÁÉÍÓÚ]";


    /**
     * Metodo para contar la cantidad de vocales que tiene una cadena de caracteres
     * @param s Cadena de caracteres a evaluar
     * @return Integer Cantidad de vocales encontradas en la cadena
     */
    public static int countVowels(String s){

        int count = 0;
        Pattern pattern = Pattern.compile(VOWELS);
        for (char c : s.toCharArray()) {
            if (pattern.matcher(String.valueOf(s)).find()){
                count++;
            }
        }
        return count;

    }

}
