
package ConexionCRUD;

import java.sql.SQLException;
import java.util.Scanner; 

public class Delete {
    Delete() throws SQLException{
        Scanner leer  = new Scanner(System.in);
        ConexionCRUD_Estudiante mostrar = new ConexionCRUD_Estudiante();
        System.out.println("<< ELIMINAR REGISTRO >>");
        
        System.out.println("Ingresar el id del registro: ");
        String id_estudianteEliminar = leer.next();
        
        //Reingreso de datos para actualizar 
        String tabla = "tb_estudiante";
        String campos = "*";
        String condicion = "id_estudiante =  " + id_estudianteEliminar;
        mostrar.guardarRegistros(tabla, campos, campos);
        
        System.out.println("Presionar << Y >> para confirmar: ");
        String confirmarBorrar = leer.next();
        
        if("Y".equals(confirmarBorrar)){
            /*
            Se le deja vacio para el metodo actualizarEliminarRegistro
            envie solamente los parametros de tabla y condicion y poder eliminar
            */
            String valoresCamposNuevos = "";
            
            mostrar.actualizarEliminarRegistro(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro borrado satisfactoriamente!");
        }
        MenuPrincipalEstudiante.MenuDesplegable();
    }
}

