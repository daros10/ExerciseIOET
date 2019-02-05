/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paidworkexercise;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Daro
 */
public class Excercise {
    
    /*********************************************** VARIABLES GLOBALES *****************************************************************/
    String tempDatosLecuturArchivo = ""; 
    String[] arreglo; 
    String[] arregloDiasConHoras; 
    String[] arregloDias;
    String nombreEmpleado;
    String cadenaDatosDiayHoras;
    String datosEmpleado; 
    String dias = "";
    String horaInicio = "";
    String horaFin = "";
    
    int hInicio=0, hFin=0;
    int valorApagarEntreSemana=0,valorApagarFinSemana=0,valorSemana=0,valorFinSeman=0,valorACancelarEmpleado=0,horasTrabajadas=0;
    int rango1=0,rango2=0,rango3=0,rango4=0,rango5=0,rango6=0;
    int valorFinal=0;
    /**************************************************************************************************************************************/
    
    public void leerArchivo(String nombreArchivo) {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);

            tempDatosLecuturArchivo = br.readLine();

            while (tempDatosLecuturArchivo != null) {

                datosEmpleado = tempDatosLecuturArchivo;

                JOptionPane.showMessageDialog(null, datosEmpleado);

                //ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
                arreglo = datosEmpleado.split("="); //cuando encuenre un = separa de la cadena 
                nombreEmpleado = arreglo[0]; //obtengo el nombre del empleado
                cadenaDatosDiayHoras = arreglo[1]; // obtengo el resto de la cadena completa 
                arregloDiasConHoras = cadenaDatosDiayHoras.split(",");//separa la cadena de datos cuando encuentre ,

                tempDatosLecuturArchivo = br.readLine();

                valorFinal = PagoTotalHorasTrabajadas(arregloDiasConHoras); //envio toda la cadena 

                JOptionPane.showMessageDialog(null, "The amount to pay " + nombreEmpleado + " is: " + valorFinal + " USD");

                //luego del primer registro seteo lo valores a 0
                valorFinal = 0;
                horasTrabajadas = 0;
                hFin = 0;
                hInicio = 0;
                rango1 = 0;
                rango2 = 0;
                rango3 = 0;
                rango4 = 0;
                rango5 = 0;
                rango6 = 0;

            }

            br.close();

        } catch (Exception e) {

        }

    }

    private int PagoTotalHorasTrabajadas(String[] cadenaDatosDiasyHoras) {

        for (int i = 0; i < cadenaDatosDiasyHoras.length; i++) {
            dias = arregloDiasConHoras[i].substring(0, 2); // elijo desde la posicion 0 hasta 2(la 2 es ingoarada

            horaInicio = arregloDiasConHoras[i].substring(2, 4);// elijo solo los dos primeros elementos de mi arreglo
            horaFin = arregloDiasConHoras[i].substring(8, 10);// elijo solo los dos primeros elementos de mi arreglo

            /*transformo los string a int*/
            hInicio = Integer.parseInt(horaInicio);
            hFin = Integer.parseInt(horaFin);

            /* System.out.println(hInicio);
            System.out.println(hFin);*/
            valorSemana = verificarDiayAsignarValorEntreSemana(dias, hInicio, hFin);
            valorFinSeman = verificarDiayAsignarValorFinSemana(dias, hInicio, hFin);

        }

        valorACancelarEmpleado = valorSemana + valorFinSeman;

        return valorACancelarEmpleado;

    }

    private int verificarDiayAsignarValorEntreSemana(String dias, int hInicio, int hFin) {
        if (dias.equals("MO") || dias.equals("TU") || dias.equals("WE") || dias.equals("TH") || dias.equals("FR")) {

            if (hInicio >= 00 && hFin <= 9) {

                horasTrabajadas = (hFin - hInicio);
                rango1 += horasTrabajadas * 25;

            } else if (hInicio >= 9 && hFin <= 18) {
                horasTrabajadas = (hFin - hInicio);
                rango2 += (horasTrabajadas) * 15;

            } else if (hInicio >= 18 && hFin <= 24) {
                horasTrabajadas = (hFin - hInicio);
                rango3 += (hFin - hInicio) * 20;

            }

        }

        valorApagarEntreSemana = rango1 + rango2 + rango3;

        return valorApagarEntreSemana;
    }

    private int verificarDiayAsignarValorFinSemana(String dias, int hInicio, int hFin) {
        if (dias.equals("SU") || dias.equals("SA")) {

            if (hInicio >= 00 && hFin <= 9) {

                horasTrabajadas = (hFin - hInicio);
                rango4 += horasTrabajadas * 30;

            } else if (hInicio >= 9 && hFin <= 18) {
                horasTrabajadas = (hFin - hInicio);
                rango5 += (horasTrabajadas) * 20;

            } else if (hInicio >= 18 && hFin <= 24) {
                horasTrabajadas = (hFin - hInicio);
                rango5 += (hFin - hInicio) * 25;

            }

        }

        valorApagarFinSemana = rango4 + rango5 + rango6;

        return valorApagarFinSemana;

    }

}

