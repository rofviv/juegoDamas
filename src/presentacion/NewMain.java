/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import clases.Sonido;

/**
 *
 * @author Roy Favio
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sonido s = new Sonido();
        s.activar();
        s.reproducir("error");
    }
}
