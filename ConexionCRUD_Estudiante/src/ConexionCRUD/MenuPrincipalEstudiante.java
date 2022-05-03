package ConexionCRUD;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipalEstudiante {

    public static void main(String[] args) throws SQLException {
        MenuDesplegable();
    }

    static void MenuDesplegable() throws SQLException {
        Scanner opcion = new Scanner(System.in);
        String MenuOp;

        System.out.println("------------------------------");
        System.out.println("         OPCIONES:            ");
        System.out.println("------------------------------");
        System.out.println("     1. CREAR REGISTRO        ");
        System.out.println("     2. CONSULTAR REGISTRO    ");
        System.out.println("     3. ACTUALIZAR REGISTROS  ");
        System.out.println("     4. ELIMINAR REGISTRO     ");
        System.out.println("     5. SALIR                 ");
        System.out.println("------------------------------");
        System.out.println("     SELECCIONAR OPCION:      ");
        System.out.println("----------------------------- ");
        MenuOp = opcion.next();

        switch (MenuOp) {

            case "1":
                Create crear = new Create();
                break;
            case "2":
               Read leer = new Read();
                break;
            case "3":
              Update actualizar = new Update();
                break;
            case "4":
               Delete eliminar = new Delete();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println(" Seleccion invalida! ");
                break;
        }
    }
}
