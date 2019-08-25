package dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public interface AppConfig {


    int porcentajeGarantiaA = 10;
    int porcentajeGarantiaB = 20;
    int diasGarantiaA = 100;
    int diasGarantiaB = 200;
    List<Integer> diasAOmitir = Arrays.asList(Calendar.MONDAY);
    double montoMaxGarantiaA = 500000.00;
    int numMaxVocales = 3;

}
