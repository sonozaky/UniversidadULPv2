/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulpv2;

import universidadulpv2.vistas.Principio;

/**
 *
 * @author shion
 */
public class UniversidadULPv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ///pantalla de principio y fondo 
        Principio nuevoPrincipio=new Principio();
       //Hace visible
        nuevoPrincipio.setVisible(true);
       //centra
        nuevoPrincipio.setLocationRelativeTo(null);
    }
    
}
