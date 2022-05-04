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

   
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/bd_estudiante";
   
    private final String usuario = "root";
    
    private final String clave = "";
   
    private final String driverConector = "com.mysql.jdbc.Driver";
    
    private static Connection conexion;

    public ConexionCRUD_Estudiante() {
        try {
            Class.forName(driverConector);
            conexion = DriverManager.getConnection(servidor, usuario, clave);
           
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
            String sqlQueryStmt = "INSERT INTO " + tabla + "(" + camposTabla + ") VALUES (" + valoresCampos + ");";
            Statement stmt;
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);

            stmt.close();
            cone.close();
            System.out.println("Registro guardado correctamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 // Toda esta parte es mi aporte al proyecto MARLIN GABRIELA ROSALES GARCIA
    public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion) {

        ConexionCRUD_Estudiante conectar = new ConexionCRUD_Estudiante();
        Connection cone = conectar.getConnection();
        try {
            Statement stmt;
            String sqlQueryStmt;

            if (valoresCamposNuevos.isEmpty()) {
                sqlQueryStmt = "DELETE FROM " + tabla + " WHERE " + condicion + ";";
            } else {
                sqlQueryStmt = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";

            }
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
        } catch (SQLException ex) {
            System.out.println("HA OCURRIDO EL SIGUIENTE ERROR: " + ex.getMessage());

        }
    }
            
    public void desplegarRegistros(String tablaBuscar, String campoBuscar, String condicionBuscar) throws SQLException {
        ConexionCRUD_Estudiante conectar = new ConexionCRUD_Estudiante();
        Connection cone = conectar.getConnection();
        try {
            Statement stmt;
            String sqlQueryStmt;
            if (condicionBuscar.equals("")) {
                sqlQueryStmt = "SELECT " + campoBuscar + " FROM " + tablaBuscar + ";";

            } else {
                sqlQueryStmt = " SELECT " + campoBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;

            }

            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);

            try ( ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)) {

                if (miResultSet.next()) {
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount();
                    System.out.println("<<REGISTROS ALMACENADOS>>");
                    System.out.println();

                    for (int i = 1; i <= numColumnas; i++) {

                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                    }

                    System.out.println();
                    do {
                        for (int i = 1; i <= numColumnas; i++) {
                            System.out.printf("%-20s\t", miResultSet.getObject(i));

                        }
                        System.out.println();

                    } while (miResultSet.next());
                    System.out.println();

                } else {
                    System.out.println("NO SE HAN ENCONTRADO REGISTROS");
                }
                miResultSet.close();
            } finally {

                stmt.close();
                cone.close();
            }
        } catch (SQLException ex) {

            System.out.println("HA OCURRIDO EL SIGUIENTE ERROR: " + ex.getMessage());
  //aporte al proyecto
        }
    }
}
