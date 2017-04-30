/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcd;

/**
 *
 * @author carlos
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) 
    {
       /* se crea una única instancia de la clase ImpresorLCD para facilitar 
          modificaciones futuras y ahorrar tiempo. En esta clase se usa dos veces.
          Solo sería necesario modificar una vez, en vez de dos.
        */
       ImpresorLCD impresorLCD = new ImpresorLCD();

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;
        int espacioDig;
        
        try {
            try (Scanner lector = new Scanner(System.in)){               
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un numero
                if (ImpresorLCD.isNumeric(comando)){
                    espacioDig = Integer.parseInt(comando);
                    
                    // se valida que el espaciado esté entre 0 y 5
                   impresorLCD.SpaceIsBetweenCeroAndFive(espacioDig);   
                } 
                else{
                    throw new IllegalArgumentException("Cadena " + comando
                            + " no es un entero");
                }
                do{
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    if(!comando.equalsIgnoreCase(CADENA_FINAL)){
                        listaComando.add(comando);
                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
            }

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()){
                try {
                    impresorLCD.procesar(iterator.next(), espacioDig);
                }catch (Exception ex){
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        } catch (Exception ex){
                    System.out.println("Error: "+ex.getMessage());
          }
    }
}

