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


    //GESTOR
    public class GestorProyectos {

        static String nombreProyecto1, nombreProyecto2, nombreProyecto3;
        static String descripcionProyecto1, descripcionProyecto2, descripcionProyecto3;
        static String categoriaProyecto1, categoriaProyecto2, categoriaProyecto3;
        static String fechaInicioProyecto1, fechaInicioProyecto2, fechaInicioProyecto3;
        static String fechaFinProyecto1, fechaFinProyecto2, fechaFinProyecto3;
        static String recompensa1_1, recompensa2_1, recompensa3_1;
        static String recompensa1_2, recompensa2_2, recompensa3_2;
        static String recompensa1_3, recompensa2_3, recompensa3_3;
        static double cantidadNecesaria1, cantidadNecesaria2, cantidadNecesaria3;
        static double cantidadFinanciada1, cantidadFinanciada2, cantidadFinanciada3;
        static int proyectosCreados = 0;
        static Scanner sc = new Scanner(System.in);

        public static int menuPrincipalGestor() {
            System.out.println("\n\033[34m--- Menú Gestor ---\033[0m");
            System.out.println("1. Mostrar todos los proyectos de la plataforma");
            System.out.println("2. Crear un nuevo proyecto");
            System.out.println("3. Modificar un proyecto existente");
            System.out.println("4. Configuración");
            System.out.println("5. Cerrar sesión");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            return opcion;
        }

        public static void mostrarProyectos() {
            if (proyectosCreados == 0) {
                System.out.println("No hay proyectos.");
            } else {
                if (proyectosCreados >= 1) mostrarProyecto(1);
                if (proyectosCreados >= 2) mostrarProyecto(2);
                if (proyectosCreados >= 3) mostrarProyecto(3);
            }
        }

        public static void mostrarProyecto(int proyectoNum) {
            String nombre = obtenerNombre(proyectoNum);
            String descripcion = obtenerDescripcion(proyectoNum);
            String categoria = obtenerCategoria(proyectoNum);
            String fechaInicio = obtenerFechaInicio(proyectoNum);
            String fechaFin = obtenerFechaFin(proyectoNum);
            String recompensa1 = obtenerRecompensa(proyectoNum, 1);
            String recompensa2 = obtenerRecompensa(proyectoNum, 2);
            String recompensa3 = obtenerRecompensa(proyectoNum, 3);
            double cantidadNecesaria = obtenerCantidadNecesaria(proyectoNum);
            double cantidadFinanciada = obtenerCantidadFinanciada(proyectoNum);

            System.out.println("Proyecto " + proyectoNum + ":");
            System.out.println("Nombre: " + nombre);
            System.out.println("Descripción: " + descripcion);
            System.out.println("Categoría: " + categoria);
            System.out.println("Fecha de inicio: " + fechaInicio);
            System.out.println("Fecha de fin: " + fechaFin);
            System.out.println("Recompensas: " + recompensa1 + ", " + recompensa2 + ", " + recompensa3);
            System.out.println("Cantidad necesaria: " + cantidadNecesaria);
            System.out.println("Cantidad financiada: " + cantidadFinanciada);
            int porcentaje = (int) ((cantidadFinanciada / cantidadNecesaria) * 100);
            System.out.println("Progreso: " + porcentaje + "%");
        }

        public static String obtenerNombre(int proyectoNum) {
            if (proyectoNum == 1) return nombreProyecto1;
            if (proyectoNum == 2) return nombreProyecto2;
            return nombreProyecto3;
        }

        public static String obtenerDescripcion(int proyectoNum) {
            if (proyectoNum == 1) return descripcionProyecto1;
            if (proyectoNum == 2) return descripcionProyecto2;
            return descripcionProyecto3;
        }

        public static String obtenerCategoria(int proyectoNum) {
            if (proyectoNum == 1) return categoriaProyecto1;
            if (proyectoNum == 2) return categoriaProyecto2;
            return categoriaProyecto3;
        }

        public static String obtenerFechaInicio(int proyectoNum) {
            if (proyectoNum == 1) return fechaInicioProyecto1;
            if (proyectoNum == 2) return fechaInicioProyecto2;
            return fechaInicioProyecto3;
        }

        public static String obtenerFechaFin(int proyectoNum) {
            if (proyectoNum == 1) return fechaFinProyecto1;
            if (proyectoNum == 2) return fechaFinProyecto2;
            return fechaFinProyecto3;
        }

        public static String obtenerRecompensa(int proyectoNum, int recompensaNum) {
            if (proyectoNum == 1) {
                if (recompensaNum == 1) return recompensa1_1;
                if (recompensaNum == 2) return recompensa2_1;
                return recompensa3_1;
            } else if (proyectoNum == 2) {
                if (recompensaNum == 1) return recompensa1_2;
                if (recompensaNum == 2) return recompensa2_2;
                return recompensa3_2;
            } else {
                if (recompensaNum == 1) return recompensa1_3;
                if (recompensaNum == 2) return recompensa2_3;
                return recompensa3_3;
            }
        }

        public static double obtenerCantidadNecesaria(int proyectoNum) {
            if (proyectoNum == 1) return cantidadNecesaria1;
            if (proyectoNum == 2) return cantidadNecesaria2;
            return cantidadNecesaria3;
        }

        public static double obtenerCantidadFinanciada(int proyectoNum) {
            if (proyectoNum == 1) return cantidadFinanciada1;
            if (proyectoNum == 2) return cantidadFinanciada2;
            return cantidadFinanciada3;
        }

        public static void crearProyecto() {
            if (proyectosCreados >= 3) {
                System.out.println("No se pueden crear más proyectos.");
                return;
            }

            String nombre = obtenerEntrada("Nombre del proyecto: ");
            String descripcion = obtenerEntrada("Descripción del proyecto: ");
            String categoria = obtenerEntrada("Categoría del proyecto: ");
            String fechaInicio = obtenerEntrada("Fecha de inicio (dd/mm/aaaa): ");
            String fechaFin = obtenerEntrada("Fecha de fin (dd/mm/aaaa): ");
            String recompensa1 = obtenerEntrada("Recompensa 1: ");
            String recompensa2 = obtenerEntrada("Recompensa 2: ");
            String recompensa3 = obtenerEntrada("Recompensa 3: ");
            double cantidadNecesaria = obtenerDouble("Cantidad necesaria: ");
            double cantidadFinanciada = obtenerDouble("Cantidad financiada: ");

            guardarProyecto(nombre, descripcion, categoria, fechaInicio, fechaFin, recompensa1, recompensa2, recompensa3, cantidadNecesaria, cantidadFinanciada);
            proyectosCreados++;
            System.out.println("Proyecto creado con éxito.");
        }

        public static void modificarProyecto() {
            if (proyectosCreados == 0) {
                System.out.println("No hay proyectos para modificar.");
                return;
            }

            System.out.println("Seleccione el proyecto a modificar:");
            for (int i = 1; i <= proyectosCreados; i++) {
                System.out.println(i + ". " + obtenerNombre(i));
            }

            int proyectoNum = sc.nextInt();
            sc.nextLine();

            if (proyectoNum < 1 || proyectoNum > proyectosCreados) {
                System.out.println("Proyecto no válido.");
                return;
            }

            System.out.println("Modificar proyecto: " + obtenerNombre(proyectoNum));

            String nuevoNombre = obtenerEntrada("Nuevo nombre del proyecto (o deje en blanco para no cambiar): ");
            if (!nuevoNombre.isEmpty()) {
                actualizarNombre(proyectoNum, nuevoNombre);
            }

            String nuevaDescripcion = obtenerEntrada("Nueva Descripción del proyecto (o deje en blanco para no cambiar): ");
            if (!nuevaDescripcion.isEmpty()) {
                actualizarDescripcion(proyectoNum, nuevaDescripcion);
            }

            String nuevaCategoria = obtenerEntrada("Nueva categoría del proyecto (o deje en blanco para no cambiar): ");
            if (!nuevaCategoria.isEmpty()) {
                actualizarCategoria(proyectoNum, nuevaCategoria);
            }

            String nuevaFechaInicio = obtenerEntrada("Nueva fecha de inicio (dd/mm/aaaa) (o deje en blanco para no cambiar): ");
            if (!nuevaFechaInicio.isEmpty()) {
                actualizarFechaInicio(proyectoNum, nuevaFechaInicio);
            }

            String nuevaFechaFin = obtenerEntrada("Nueva fecha de fin (dd/mm/aaaa) (o deje en blanco para no cambiar): ");
            if (!nuevaFechaFin.isEmpty()) {
                actualizarFechaFin(proyectoNum, nuevaFechaFin);
            }

            String nuevaRecompensa1 = obtenerEntrada("Nueva recompensa 1 (o deje en blanco para no cambiar): ");
            if (!nuevaRecompensa1.isEmpty()) {
                actualizarRecompensa(proyectoNum, 1, nuevaRecompensa1);
            }

            String nuevaRecompensa2 = obtenerEntrada("Nueva recompensa 2 (o deje en blanco para no cambiar): ");
            if (!nuevaRecompensa2.isEmpty()) {
                actualizarRecompensa(proyectoNum, 2, nuevaRecompensa2);
            }

            String nuevaRecompensa3 = obtenerEntrada("Nueva recompensa 3 (o deje en blanco para no cambiar): ");
            if (!nuevaRecompensa3.isEmpty()) {
                actualizarRecompensa(proyectoNum, 3, nuevaRecompensa3);
            }

            double nuevaCantidadNecesaria = obtenerDouble("Nueva cantidad necesaria (o 0 para no cambiar): ");
            if (nuevaCantidadNecesaria > 0) {
                actualizarCantidadNecesaria(proyectoNum, nuevaCantidadNecesaria);
            }

            double nuevaCantidadFinanciada = obtenerDouble("Nueva cantidad financiada (o 0 para no cambiar): ");
            if (nuevaCantidadFinanciada > 0) {
                actualizarCantidadFinanciada(proyectoNum, nuevaCantidadFinanciada);
            }

            System.out.println("Proyecto modificado con éxito.");
        }
        public static void guardarProyecto(String nombre, String descripcion, String categoria, String fechaInicio, String fechaFin,
                                           String recompensa1, String recompensa2, String recompensa3, double cantidadNecesaria, double cantidadFinanciada) {
            if (proyectosCreados == 0) {
                nombreProyecto1 = nombre;
                descripcionProyecto1 = descripcion;
                categoriaProyecto1 = categoria;
                fechaInicioProyecto1 = fechaInicio;
                fechaFinProyecto1 = fechaFin;
                recompensa1_1 = recompensa1;
                recompensa2_1 = recompensa2;
                recompensa3_1 = recompensa3;
                cantidadNecesaria1 = cantidadNecesaria;
                cantidadFinanciada1 = cantidadFinanciada;
            } else if (proyectosCreados == 1) {
                nombreProyecto2 = nombre;
                descripcionProyecto2 = descripcion;
                categoriaProyecto2 = categoria;
                fechaInicioProyecto2 = fechaInicio;
                fechaFinProyecto2 = fechaFin;
                recompensa1_2 = recompensa1;
                recompensa2_2 = recompensa2;
                recompensa3_2 = recompensa3;
                cantidadNecesaria2 = cantidadNecesaria;
                cantidadFinanciada2 = cantidadFinanciada;
            } else {
                nombreProyecto3 = nombre;
                descripcionProyecto3 = descripcion;
                categoriaProyecto3 = categoria;
                fechaInicioProyecto3 = fechaInicio;
                fechaFinProyecto3 = fechaFin;
                recompensa1_3 = recompensa1;
                recompensa2_3 = recompensa2;
                recompensa3_3 = recompensa3;
                cantidadNecesaria3 = cantidadNecesaria;
                cantidadFinanciada3 = cantidadFinanciada;
            }
        }

        public static void actualizarNombre(int proyectoNum, String nuevoNombre) {
            if (proyectoNum == 1) nombreProyecto1 = nuevoNombre;
            else if (proyectoNum == 2) nombreProyecto2 = nuevoNombre;
            else nombreProyecto3 = nuevoNombre;
        }

        public static void actualizarDescripcion(int proyectoNum, String nuevaDescripcion) {
            if (proyectoNum == 1) descripcionProyecto1 = nuevaDescripcion;
            else if (proyectoNum == 2) descripcionProyecto2 = nuevaDescripcion;
            else descripcionProyecto3 = nuevaDescripcion;
        }

        public static void actualizarCategoria(int proyectoNum, String nuevaCategoria) {
            if (proyectoNum == 1) categoriaProyecto1 = nuevaCategoria;
            else if (proyectoNum == 2) categoriaProyecto2 = nuevaCategoria;
            else categoriaProyecto3 = nuevaCategoria;
        }

        public static void actualizarFechaInicio(int proyectoNum, String nuevaFechaInicio) {
            if (proyectoNum == 1) fechaInicioProyecto1 = nuevaFechaInicio;
            else if (proyectoNum == 2) fechaInicioProyecto2 = nuevaFechaInicio;
            else fechaInicioProyecto3 = nuevaFechaInicio;
        }

        public static void actualizarFechaFin(int proyectoNum, String nuevaFechaFin) {
            if (proyectoNum == 1) fechaFinProyecto1 = nuevaFechaFin;
            else if (proyectoNum == 2) fechaFinProyecto2 = nuevaFechaFin;
            else fechaFinProyecto3 = nuevaFechaFin;
        }

        public static void actualizarRecompensa(int proyectoNum, int recompensaNum, String nuevaRecompensa) {
            if (proyectoNum == 1) {
                if (recompensaNum == 1) recompensa1_1 = nuevaRecompensa;
                else if (recompensaNum == 2) recompensa2_1 = nuevaRecompensa;
                else recompensa3_1 = nuevaRecompensa;
            } else if (proyectoNum == 2) {
                if (recompensaNum == 1) recompensa1_2 = nuevaRecompensa;
                else if (recompensaNum == 2) recompensa2_2 = nuevaRecompensa;
                else recompensa3_2 = nuevaRecompensa;
            } else {
                if (recompensaNum == 1) recompensa1_3 = nuevaRecompensa;
                else if (recompensaNum == 2) recompensa2_3 = nuevaRecompensa;
                else recompensa3_3 = nuevaRecompensa;
            }
        }

        public static void actualizarCantidadNecesaria(int proyectoNum, double nuevaCantidad) {
            if (proyectoNum == 1) cantidadNecesaria1 = nuevaCantidad;
            else if (proyectoNum == 2) cantidadNecesaria2 = nuevaCantidad;
            else cantidadNecesaria3 = nuevaCantidad;
        }

        public static void actualizarCantidadFinanciada(int proyectoNum, double nuevaCantidad) {
            if (proyectoNum == 1) cantidadFinanciada1 = nuevaCantidad;
            else if (proyectoNum == 2) cantidadFinanciada2 = nuevaCantidad;
            else cantidadFinanciada3 = nuevaCantidad;
        }
        public static String obtenerEntrada(String mensaje) {
            System.out.print(mensaje);
            return sc.nextLine();
        }

        public static double obtenerDouble(String mensaje) {
            System.out.print(mensaje);
            return sc.nextDouble();
        }
    }
}


