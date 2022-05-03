
package ConexionCRUD;

import java.sql.SQLException;


public class Read {
     public Read () throws SQLException {
        System.out.println("<< CONSULTA DE REGISTROS >>");
        Resultado();
    }
    private void Resultado () throws SQLException {
        try {
            ConexionCRUD_Estudiante mostrar = new ConexionCRUD_Estudiante ();
            
                String tabla = "tb_estudiante";
                String camposTabla = "*";
                String condicionBusqueda = "";
                
                mostrar.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch (SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }finally{
            MenuPrincipalEstudiante.MenuDesplegable();
        }
    }
}
