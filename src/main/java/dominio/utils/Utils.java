package dominio.utils;

import dominio.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Utils {

    public static final String VOWELS = "[aeiou·ÈÌÛ˙AEIOU¡…Õ”⁄]";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(Constants.FORMATO_FECHA);
    //public static final List<Date> diasFestivosCol = Arrays.asList("");


    /**
     * Permite contar la cantidad de vocales que tiene una cadena de caracteres
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

    /**
     * Permite agregar dias a una fecha & omite los dias de la semana que se le indiquen
     * @param initialDate fecha a la que se le sumaran los dias
     * @param days cantidad de dias a sumar
     * @param diasNoHabil lista de dias de la semana que no seran considerados en la suma
     * @return Date
     */
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


    public static Date calcularPascua(int anio) throws ParseException {

        // Algoritmo de Butcher
        int a, b, c, d, e, f, g, h, i, k, l, m, n, mes, dia;

        a = anio % 19;
        b = anio / 100;
        c = anio % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = ((b - f) + 1) / 3;
        h = ((19*a) + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        l = (32 + (2*e) + (2*i) - h - k) % 7;
        m = (a + (11*h) + (22*l)) / 451;
        n = h + l - (7*m) + 114;
        mes = n / 31;
        dia = 1 + (n - (mes * 31 ));

        return new SimpleDateFormat(Constants.FORMATO_FECHA).parse(String.valueOf(dia) + Constants.SEPARADOR_FECHA + String.valueOf(mes) + Constants.SEPARADOR_FECHA + String.valueOf(anio));

    }

    public static List<Date> calcularFestivosCol(String anio) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
        List<Date> diasFijos = new ArrayList<>();
        List<Date> lunesFestivos = new ArrayList<>();
        List<Date> festivos = new ArrayList<>();
        for (String diames : Constants.festivosFijos){
             diasFijos.add(dateFormat.parse(diames + Constants.SEPARADOR_FECHA + anio ));
        }

        for (String diames : Constants.festivosBase1erLunes){
            Date fechaBase = dateFormat.parse(diames + Constants.SEPARADOR_FECHA + anio );
            calendar.setTime(fechaBase);
            int diaDeSemana = calendar.get(Calendar.DAY_OF_WEEK);
            if (diaDeSemana == Calendar.MONDAY) {
                lunesFestivos.add(calendar.getTime());
                break;
            } else if (diaDeSemana != Calendar.SUNDAY) {
                int diferenciaDiasDeSemana = (Calendar.SATURDAY - diaDeSemana) + 2;
                calendar.add(Calendar.DAY_OF_MONTH, diferenciaDiasDeSemana);
            } else  {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }

            lunesFestivos.add(calendar.getTime());
        }

        Date pascua = Utils.calcularPascua(Integer.parseInt(anio));

        festivos.addAll(diasFijos);
        festivos.addAll(lunesFestivos);
        festivos.add(pascua);
        calendar.setTime(pascua);
        //Domingo de ramos
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        festivos.add(calendar.getTime());

        calendar.setTime(pascua);
        //Jueves santo
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        festivos.add(calendar.getTime());

        //Viernes santo
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        festivos.add(calendar.getTime());

        calendar.setTime(pascua);
        //asecion de Jesus
        calendar.add(Calendar.DAY_OF_MONTH, 43);
        festivos.add(calendar.getTime());
        //Corpus Christi
        calendar.add(Calendar.DAY_OF_MONTH, 21);
        festivos.add(calendar.getTime());
        //Sagrado Corazon de Jesus
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        festivos.add(calendar.getTime());

        return festivos;

    }


}
