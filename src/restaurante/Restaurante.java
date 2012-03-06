package restaurante;

import javax.swing.*;

public class Restaurante 
{

    public static void main(String[] args) 
    {
        Intercambiador x = new Intercambiador();
        System.out.println("Antes de crear el JPanel");
        JFrame pantalla = new Datos_conexion_bd(x);
        System.out.println("Después de crear el JPanel");
        pantalla.setVisible(true);
        System.out.println("Visible OK");
        
           

        
        
        
    }
}
