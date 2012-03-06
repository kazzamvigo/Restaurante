package restaurante;

import java.sql.*;


public class BaseDeDatos 
{
    Connection conexion;
    String host;
    String nombre_bd;
    String usuario;
    String password;
    String puerto;
    

    
    BaseDeDatos(String ip, String port, String bd, String user, String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){ System.out.println("Error al cargar el conector mysql");}

       host=ip;
       nombre_bd=bd;
       usuario=user;
       password=pass;
       puerto=port;
       
       try
       {
           conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+nombre_bd, usuario, password);
       } 
       catch (SQLException e){System.out.println("Error en la conexión. Comprueba ruta, usuario y contraseña...");} 
    }

    boolean tiene_tablas()
    {
        DatabaseMetaData dbmd=null;
        Integer contador=0;
        try
        {
            dbmd = conexion.getMetaData();
            String[] tipo = { "TABLE" };
            ResultSet rs = dbmd.getTables(null, null, "%", tipo);
            while (rs.next()) 
            {
                contador++;
            }
        }
        catch(SQLException e){System.out.println("Error al obtener información de la bd...");}

        return contador>0;
    }
    
    void crea_tablas()
    {
        String createString = "create table SUPPLIERSPK " +
                "(SUP_ID INTEGER NOT NULL, " +
                "SUP_NAME VARCHAR(40), " +
                "STREET VARCHAR(40), " +
                "CITY VARCHAR(20), " +
                "STATE CHAR(2), " +
                "ZIP CHAR(5), " +
                "primary key(SUP_ID))";
        Statement stmt;
        try
        {
            stmt  = conexion.createStatement();
            stmt.executeUpdate(createString);
        }
        catch(SQLException e){System.out.println("Error al crear tablas...");}
    }
    
}
