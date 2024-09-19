package com.valoraciones.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    //////
    
    public static Date stringtodate(String Fecha){
    SimpleDateFormat formatoDeFecha = new  SimpleDateFormat("yyyy/MM/dd");

    Date aux = null;
    try{
    
    aux = formatoDeFecha.parse(Fecha);
    
    
    }catch(Exception ex){
  
    }
  return aux;
    }
    
    public static String formatodate(Date fecha ){
        SimpleDateFormat formatoDeFecha = new  SimpleDateFormat("yyyy/MM/dd");
    return formatoDeFecha.format(fecha);
    }
}
