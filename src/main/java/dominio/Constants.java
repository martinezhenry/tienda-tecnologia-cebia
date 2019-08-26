package dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface Constants {


    int CIEN = 100;
    String FORMATO_FECHA = "dd/MM/yyyy";
    String SEPARADOR_FECHA = "/";
    String[] festivosFijos = new String[] {"01/01", "01/05", "20/07", "07/08", "08/12", "25/12"};
    String[] festivosBase1erLunes = new String[] {"06/01", "19/03", "29/06", "15/08", "12/10", "01/11", "11/11"};

}
