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
        estudian.setId_estudiante(leer.nextInt());
        
        String tablaBuscar = "tb_estudiante";
        String campoBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + estudian.getId_estudiante();
        mostrar.desplegarRegistros(tablaBuscar, campoBuscar, condicionBuscar);
        
        System.out.println("Nombre: ");
        estudian.setNom_estudiante(leer.nextLine());
        
        System.out.println("Apellido: ");
        estudian.setApe_estudiante(leer.nextLine());
        
        System.out.println("Edad: ");
        estudian.setEdad_estudiante(Integer.parseInt(leer.nextLine()));
        
        String tabla = "tb_estudiante";
        String CValoresNuevos = "nom_estudiante = '" + estudian.getNom_estudiante() + "', ape_estudiante = '"
                + estudian.getApe_estudiante() + "', edad_estudiante = '" + estudian.getEdad_estudiante();
        
        mostrar.actualizarEliminarRegistro(tabla, CValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente!");
        
           MenuPrincipalEstudiante.MenuDesplegable();
    
    }
}