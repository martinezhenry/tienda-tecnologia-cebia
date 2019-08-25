package dominio.utils;

import dominio.excepcion.GarantiaExtendidaException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    public static Date addDays(Date initialDate, int days, List<Integer> diasNoHabil) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);

        for (int i=0; i < days; i++){

            if (!diasNoHabil.contains(calendar.get(Calendar.DAY_OF_WEEK))) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            } else {
                calendar.add(Calendar.DAY_OF_MONTH, 2);
            }
        }

        return calendar.getTime();
    }

}
