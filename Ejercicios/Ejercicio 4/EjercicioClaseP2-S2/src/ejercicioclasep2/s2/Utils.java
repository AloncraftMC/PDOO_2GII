/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasep2.s2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bihut
 */
public class Utils {
    public static long getMarcaTiempo(){
        return System.currentTimeMillis();
    }
     public static String convertMillisToString(long millis) {
        // Crear un objeto Date a partir de los milisegundos
        Date date = new Date(millis);
        // Definir el formato deseado
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        // Formatear la fecha y devolver como string
        return formatter.format(date);
    }
}
