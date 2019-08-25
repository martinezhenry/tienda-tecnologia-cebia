package dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public interface AppConfig {


    public static int porcentajeGarantiaA = 10;
    public static int porcentajeGarantiaB = 20;
    public static int diasGarantiaA = 100;
    public static int diasGarantiaB = 200;
    public static List<Integer> diasAOmitir = Arrays.asList(Calendar.MONDAY);
    public static double montoMaxGarantiaA = 500000.00;
    public int numMaxVocales = 3;

}
