package biblioteca;
import java.util.Scanner;
public class funciones {

    public static int menuPrincipalAdmin (){
        Scanner sc = new Scanner (System.in);
        System.out.println("\n\033[38;5;214m--- Menú Administrador ---\033[39m");
        System.out.println("1. Panel de control");
        System.out.println("2. Mostrar todos los proyectos de la plataforma");
        System.out.println("3. Modificar un proyecto existente");
        System.out.println("4. Configuración");
        System.out.println("5. Cerrar sesión");
        System.out.print("Selecciona una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static void panelDeControl (boolean[] bloqueados) {
        Scanner sc = new Scanner(System.in);
        int opcionPanelControl;
        do {
            System.out.println("\n--- Panel de Control ---");
            System.out.println("1. Bloquear usuario");
            System.out.println("2. Desbloquear usuario");
            System.out.println("3. Volver");
            opcionPanelControl = sc.nextInt();
            sc.nextLine();

            bloquearDesbloquear(opcionPanelControl, bloqueados);

        } while (opcionPanelControl != 1 && opcionPanelControl != 2 && opcionPanelControl != 3);
    }
    public static void bloquearDesbloquear (int opcionPanelControl, boolean[] bloqueados){
        Scanner sc = new Scanner(System.in);
        switch (opcionPanelControl) {
            case 1:
                int opcionBloqueo;
                do {
                    System.out.println("\n¿A qué usuario bloquear?");
                    System.out.println("1. Usuario Gestor");
                    System.out.println("2. Usuario Inversor 1");
                    System.out.println("3. Usuario Inversor 2");
                    System.out.println("4. Volver al Menú Administrador");
                    opcionBloqueo = sc.nextInt();
                    sc.nextLine();
                } while (opcionBloqueo != 1 && opcionBloqueo != 2 && opcionBloqueo != 3 && opcionBloqueo != 4);
                switch (opcionBloqueo) {
                    case 1:
                        bloqueados[0] = true;
                        System.out.println("Has bloqueado al Gestor correctamente");
                        break;
                    case 2:
                        bloqueados[1] = true;
                        System.out.println("Has bloqueado al Inversor 1 correctamente");
                        break;
                    case 3:
                        bloqueados[2] = true;
                        System.out.println("Has bloqueado al Inversor 2 correctamente");
                        break;
                    case 4:
                        break;
                }
                break;
            case 2:
                int opcionDesbloqueo;
                do {
                    System.out.println("\n¿A qué usuario desbloquear?");
                    System.out.println("1. Usuario Gestor");
                    System.out.println("2. Usuario Inversor 1");
                    System.out.println("3. Usuario Inversor 2");
                    System.out.println("4. Volver");
                    opcionDesbloqueo = sc.nextInt();
                    sc.nextLine();
                } while (opcionDesbloqueo != 1 && opcionDesbloqueo != 2 && opcionDesbloqueo != 3 && opcionDesbloqueo != 4);
                switch (opcionDesbloqueo) {
                    case 1:
                        bloqueados[0] = false;
                        System.out.println("Has desbloqueado al Gestor correctamente");
                        break;
                    case 2:
                        bloqueados[1] = false;
                        System.out.println("Has desbloqueado al Inversor 1 correctamente");
                        break;
                    case 3:
                        bloqueados[2] = false;
                        System.out.println("Has desbloqueado al Inversor 2 correctamente");
                        break;
                    case 4:
                        break;
                }
            case 3:
                break;
        }
    }

    public static void graficoBarras (int porcentaje){
        System.out.print("\033[35m[");
        for (int i = 0; i <= 100; i++) {
            if (i <= porcentaje) {
                System.out.print("■");
            } else {
                System.out.print("_");
            }
        }
        System.out.print("]\033[39m");
    }

    public static int menuConfiguracion (){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Configuración ---");
        System.out.println("¿Que opción desea?");
        System.out.println("1. Cambiar nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        System.out.println("3. Volver");
        int opcionConfiguracion = sc.nextInt();
        sc.nextLine();

        return opcionConfiguracion;
    }
    public static String cambioNombre (String nombreActual){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nuevo nombre de usuario");
        String nuevoNombre = sc.nextLine().toLowerCase().trim();
        System.out.println("Has reestablecido su nombre de usuario");

        return nuevoNombre;
    }
    public static String cambioPassword (String passwordActual){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la nueva contraseña");
        String passwordNueva = sc.nextLine().toLowerCase().trim();
        System.out.println("Has reestablecido su contraseña");

        return passwordNueva;
    }


}
