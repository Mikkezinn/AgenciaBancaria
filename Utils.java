package Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat; 
import java.util.Date;

public class Utils {
	

	static NumberFormat FormatandoNumeros = new DecimalFormat("R$ #,##0.00"); 
	static SimpleDateFormat FormatandoData = new SimpleDateFormat("dd/MM/yyyy"); 

	public static String dateToString(Date data) {
		return Utils.FormatandoData.format(data);
	}

	public static String doubleToString(Double valor) {
		return Utils.FormatandoNumeros.format(valor);
	}
}


