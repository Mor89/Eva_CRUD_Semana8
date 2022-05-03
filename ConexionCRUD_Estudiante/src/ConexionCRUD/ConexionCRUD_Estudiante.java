/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionCRUD_Estudiante {

    

    /* Ruta de la base de datos el servidor 127.0.0.1, el puerto 3306 y el nombre 
    de la base de datos bd_recurso_humano*/
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/bd_recurso_humano";
    //Nombre del usuario (root por defecto) de la base de datos
    private final String usuario = "root";
    //Clave del usuario de la base de datos
    private final String clave = "";
    //Libreria de mysql
    private final String driverConector = "com.mysql.jdbc.Driver";
    //Objeto de la clase Connection del paquete de java.sql
    private static Connection conexion;

    public ConexionCRUD_Estudiante() {
        try {
            Class.forName(driverConector);
            conexion = DriverManager.getConnection(servidor, usuario, clave);
            System.out.println("Conexion Exitosa!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion fallida! Error! :" + e.getMessage());

        }

    }

    public Connection getConnection() {
        return conexion;
    }

    public void guardarRegistros(String tabla, String camposTabla, String valoresCampos) {
        ConexionCRUD_Estudiante conectar = new ConexionCRUD_Estudiante();
        Connection cone = conectar.getConnection();
        
        try {
            String sqlQueryStmt = "INSERT INTO " + "(" + camposTabla + ") VALUES (" + valoresCampos + ");";
            Statement stmt;
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);

            stmt.close();
            cone.close();
            System.out.println("Registro giardado correctamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        // TODO code application logic here
       ConexionCRUD_Estudiante objeto = new ConexionCRUD_Estudiante();
    }
    
    
     public void ActualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
            
            ConexionCRUD_Estudiante conectar = new ConexionCRUD_Estudiante();
            Connection cone = conectar.getConnection();
            try{
                Statement stmt;
                String sqlQueryStmt;
                
                if(valoresCamposNuevos.isEmpty()){
                    sqlQueryStmt = "DELETE FROM " + tabla + " WHERE " + condicion + ";";
                    }else{
                    sqlQueryStmt = " UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";
                    
                    
                }
                stmt = cone.createStatement();
                stmt.executeUpdate(sqlQueryStmt);
                stmt.close();
                cone.close();
              }catch(SQLException ex){
                  System.out.println("HA OCURRIDO EL SIGUIENTE ERROR: " + ex.getMessage());
                  
            }
        }
        
        
        
        
       
    }

