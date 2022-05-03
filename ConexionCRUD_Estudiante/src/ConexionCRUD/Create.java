
package ConexionCRUD;

import java.sql.SQLException;
import java.util.Scanner;

public class Create {
    Create() throws SQLException{
        Scanner leer =new Scanner(System.in);
        Estudiante estudian = new Estudiante();
        System.out.println("<<CREAR REGISTRO>>");
        
        System.out.println("Carnet");
        estudian.setCarnetEstudiante(leer.nextLine());
        
        System.out.println("Nombre");
        estudian.setNomEstudiante(leer.nextLine());
        
        System.out.println("Apellido");
        estudian.setApeEstudiante(leer.nextLine());
         
        System.out.println("Edad");
        estudian.setEdadEstudiante(leer.nextLine());
          
          String tabla ="tb_estudiante";
          String campostabla = "Carnet_estudiante,Nombre_estudiante,Apellido_estudiante,Edad_estudiante";
          String valoresCampos = "'" + estudian.getCarnetEstudiante() + "','" + estudian.getNomEstudiante() + "','"
                  + estudian.getApeEstudiante ()+ "','" + estudian.getEdadEstudiante()+ "'";
          ConexionCRUD_Estudiante mostrar =new ConexionCRUD_Estudiante();
          mostrar.guardarRegistros(tabla,campostabla, valoresCampos);
          
          MenuPrincipalEstudiante.MenuDesplegable();
                  
        
        
    }
}
