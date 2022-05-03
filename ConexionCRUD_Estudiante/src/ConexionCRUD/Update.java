package ConexionCRUD;


import java.sql.SQLException;
import java.util.Scanner;


public class Update {
    Update () throws SQLException {
        Scanner leer = new Scanner (System.in);
        Estudiante estudian = new Estudiante ();
        ConexionCRUD_Estudiante mostrar = new ConexionCRUD_Estudiante ();
        System.out.println("<< ACTUALIZAR REGISTRO >>");
        
        System.out.println("Ingresar ID del registro a modificar: ");
        estudian.setIdEstudiante(leer.nextInt());
        
        String tablaBuscar = "tb_estudiante";
        String campoBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + estudian.getIdEstudiante();
        mostrar.desplegarRegistros(tablaBuscar, campoBuscar, condicionBuscar);
        
        System.out.println("Nombre: ");
        estudian.setNomEstudiante(leer.next());
        
        System.out.println("Apellido: ");
        estudian.setApeEstudiante(leer.next());
        
        System.out.println("Edad: ");
        estudian.setEdadEstudiante(leer.next());
        
        String tabla = "tb_estudiante";
        String CValoresNuevos = "nom_estudiante  " + estudian.getNomEstudiante() + " ape_estudiante "
                + estudian.getApeEstudiante() + " edad_estudiante " + estudian.getEdadEstudiante();
        
        mostrar.actualizarEliminarRegistro(tabla, CValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente!");
        
           MenuPrincipalEstudiante.MenuDesplegable();
    
    }
}