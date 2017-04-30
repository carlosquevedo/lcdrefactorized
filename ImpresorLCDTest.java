/*
 *
 */
package lcd;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Particularmente, consideré necesario diseñar solo dos pruebas para verificar las
 * partes fundamentales del programa. 
 *
 * 
 * @author carlos
 */
public class ImpresorLCDTest {
    
    public ImpresorLCDTest()
    {
    }
    
    /**
     * Prueba del método procesar, de la clase ImpresorLCD. Con esta prueba
     * se pueden verificar 6 validaciones, las cuales están detalladas en el
     * documento PDF que acompaña a este código fuente.
     */
    @Test ()
    public void testProcesar()
    {
        System.out.println("procesar");
        /*el primer parametro es el tamaño de la impresión y el que sigue es el
        *número a imprimir
        */
        String comando = "2,5"; 
        int espacioDig =3;
        ImpresorLCD instance = new ImpresorLCD();
        instance.procesar(comando, espacioDig);        
    }

    /**
     * Prueba del método isNumeric, de la clase ImpresorLCD.
     */
    @Test
    public void testIsNumeric()
    {
        System.out.println("isNumeric");
        String cadena = "Hello PSL";
        boolean esperado = true;
        boolean resultadoActual = ImpresorLCD.isNumeric(cadena);
        //se comparan ambos resultados, si son iguales se pasa la prueba.
        assertEquals(esperado, resultadoActual);
    }   
}
