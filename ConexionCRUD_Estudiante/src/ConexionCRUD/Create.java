
package ConexionCRUD;

import java.sql.SQLException;
import java.util.Scanner;

public class Create {
    Create() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Estudiante estudian = new Estudiante();
        System.out.println("<<CREAR REGISTRO>>");
        
        System.out.println("Carnet");
        estudian.setCarnet_estudiante(leer.nextInt());
        
        System.out.println("Nombre");
        estudian.setNom_estudiante(leer.next());
        
        System.out.println("Apellido");
        estudian.setApe_estudiante(leer.next());
         
        System.out.println("Edad");
        estudian.setEdad_estudiante(Integer.parseInt(leer.next()));
          
          String tabla ="tb_estudiante";
          String campostabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
          String valoresCampos = "'" + estudian.getCarnet_estudiante() + "','" + estudian.getNom_estudiante() + "','"
                  + estudian.getApe_estudiante ()+ "','" + estudian.getEdad_estudiante()+ "'";
          ConexionCRUD_Estudiante mostrar = new ConexionCRUD_Estudiante();
          mostrar.guardarRegistros(tabla,campostabla, valoresCampos);
          
          MenuPrincipalEstudiante.MenuDesplegable();
                  
        
        
    }
}
