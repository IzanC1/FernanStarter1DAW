package biblioteca;
import java.util.Scanner;

public class funcionesGenerales {
    private static final Scanner sc = new Scanner(System.in);

    public static int menuPrincipalAdmin() {
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

    public static void panelDeControl(boolean[] bloqueados) {
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

    public static void bloquearDesbloquear(int opcionPanelControl, boolean[] bloqueados) {
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

    public static void graficoBarras(int porcentaje) {
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

    public static int menuConfiguracion() {

        System.out.println("\n--- Configuración ---");
        System.out.println("¿Que opción desea?");
        System.out.println("1. Cambiar nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        System.out.println("3. Volver");
        int opcionConfiguracion = sc.nextInt();
        sc.nextLine();

        return opcionConfiguracion;
    }

    public static String cambioNombre(String nombreActual) {

        System.out.println("Ingrese su nuevo nombre de usuario");
        String nuevoNombre = sc.nextLine().toLowerCase().trim();
        System.out.println("Has reestablecido su nombre de usuario");

        return nuevoNombre;
    }

    public static void cambioPassword(String [] passGestor, int posicionUsuario) {
        System.out.println("Por seguridad, escribe tu contraseña actual:");
        String passIntroducida = sc.nextLine().toLowerCase().trim();
        if (passIntroducida.equals(passGestor[posicionUsuario])){
            System.out.println("Ingrese la nueva contraseña");
            String passNueva = sc.nextLine().toLowerCase().trim();
            System.out.println("Has reestablecido su contraseña");
            passGestor[posicionUsuario] = passNueva;
        } else System.out.println("Contraseña incorrecta.");
    }

    public static String cambioPasswordAdmin(String passAdmin) {
        String nuevaPassAdmin = passAdmin;
        System.out.println("Por seguridad, escribe tu contraseña actual:");
        String passIntroducida = sc.nextLine().toLowerCase().trim();
        if (passIntroducida.equals(passAdmin)){
            System.out.println("Ingrese la nueva contraseña");
            String passNueva = sc.nextLine().toLowerCase().trim();
            System.out.println("Has reestablecido su contraseña");
            nuevaPassAdmin = passNueva;
        } else System.out.println("Contraseña incorrecta.");
        return nuevaPassAdmin;
    }

    //GESTOR
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

    public static void crearProyecto(int [] proyectosCreados, String[]nombreProyecto, String[] descripcionProyecto,
                                     String[] categoriaProyecto, double[] cantidadNecesaria, double[] cantidadFinanciada,
                                     String[] fechaInicio, String[] fechaFin, String[] recompensa1, String[] recompensa2, String[] recompensa3) {
        if (proyectosCreados[0] >= 3) {
            System.out.println("No se pueden crear más proyectos.");
            return;
        }
        if (proyectosCreados[0] == 0){
            nombreProyecto[0] = obtenerEntrada("Nombre del proyecto: ");
            descripcionProyecto[0] = obtenerEntrada("Descripción del proyecto: ");
            categoriaProyecto[0] = obtenerEntrada("Categoría del proyecto: ");
            fechaInicio[0] = obtenerEntrada("Fecha de inicio (dd/mm/aaaa): ");
            fechaFin[0] = obtenerEntrada("Fecha de fin (dd/mm/aaaa): ");
            recompensa1[0] = obtenerEntrada("Recompensa 1: ");
            recompensa2[0] = obtenerEntrada("Recompensa 2: ");
            recompensa3[0] = obtenerEntrada("Recompensa 3: ");
            cantidadNecesaria[0] = obtenerDouble("Cantidad necesaria: ");
            cantidadFinanciada[0] = obtenerDouble("Cantidad financiada: ");

            proyectosCreados[0]++;
            System.out.println("Proyecto creado con éxito.");
        }
        else if (proyectosCreados[0] == 1){
            nombreProyecto[1] = obtenerEntrada("Nombre del proyecto: ");
            descripcionProyecto[1] = obtenerEntrada("Descripción del proyecto: ");
            categoriaProyecto[1] = obtenerEntrada("Categoría del proyecto: ");
            fechaInicio[1] = obtenerEntrada("Fecha de inicio (dd/mm/aaaa): ");
            fechaFin[1] = obtenerEntrada("Fecha de fin (dd/mm/aaaa): ");
            recompensa1[1] = obtenerEntrada("Recompensa 1: ");
            recompensa2[1] = obtenerEntrada("Recompensa 2: ");
            recompensa3[1] = obtenerEntrada("Recompensa 3: ");
            cantidadNecesaria[1] = obtenerDouble("Cantidad necesaria: ");
            cantidadFinanciada[1] = obtenerDouble("Cantidad financiada: ");

            proyectosCreados[0]++;
            System.out.println("Proyecto creado con éxito.");
        }
        else if (proyectosCreados[0] == 2){
            nombreProyecto[2] = obtenerEntrada("Nombre del proyecto: ");
            descripcionProyecto[2] = obtenerEntrada("Descripción del proyecto: ");
            categoriaProyecto[2] = obtenerEntrada("Categoría del proyecto: ");
            fechaInicio[2] = obtenerEntrada("Fecha de inicio (dd/mm/aaaa): ");
            fechaFin[2] = obtenerEntrada("Fecha de fin (dd/mm/aaaa): ");
            recompensa1[2] = obtenerEntrada("Recompensa 1: ");
            recompensa2[2] = obtenerEntrada("Recompensa 2: ");
            recompensa3[2] = obtenerEntrada("Recompensa 3: ");
            cantidadNecesaria[2] = obtenerDouble("Cantidad necesaria: ");
            cantidadFinanciada[2] = obtenerDouble("Cantidad financiada: ");

            proyectosCreados[0]++;
            System.out.println("Proyecto creado con éxito.");
        }
    }

    public static void mostrarProyectos (int [] proyectosCreados, String[]nombreProyecto, String[] descripcionProyecto,
                                         String[] categoriaProyecto, double[] cantidadNecesaria, double[] cantidadFinanciada,
                                         String[] fechaInicio, String[] fechaFin, String[] recompensa1, String[] recompensa2, String[] recompensa3){

        System.out.println("\nMostrando todos los proyectos de la plataforma...");
        if (proyectosCreados[0] == 0) {
            System.out.println("No hay proyectos creados aun");
        }
        if (proyectosCreados[0] >= 1) {
            System.out.println("\nProyecto 1: ");
            System.out.println("Nombre: " + nombreProyecto[0]);
            System.out.println("Descripción: " + descripcionProyecto[0]);
            System.out.println("Categoría: " + categoriaProyecto[0]);
            System.out.println("Cantidad necesaria: " + cantidadNecesaria[0]);
            System.out.println("Cantidad financiada: " + cantidadFinanciada[0]);
            System.out.println("Fecha de inicio: " + fechaInicio[0]);
            System.out.println("Fecha de fin: " + fechaFin[0]);
            System.out.println("Recompensas: " + recompensa1[0] + ", " + recompensa2[0] + ", " + recompensa3[0]);
            // BARRA DE PROGRESO PROYECTO 1
            int porcentaje = (int) ((cantidadFinanciada[0] / cantidadNecesaria[0]) * 100);
            graficoBarras(porcentaje);
            System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
        }
        if (proyectosCreados[0] >= 2) {
            System.out.println("\nProyecto 2:");
            System.out.println("Nombre: " + nombreProyecto[1]);
            System.out.println("Descripción: " + descripcionProyecto[1]);
            System.out.println("Categoría: " + categoriaProyecto[1]);
            System.out.println("Cantidad necesaria: " + cantidadNecesaria[1]);
            System.out.println("Cantidad financiada: " + cantidadFinanciada[1]);
            System.out.println("Fecha de inicio: " + fechaInicio[1]);
            System.out.println("Fecha de fin: " + fechaFin[1]);
            System.out.println("Recompensas: " + recompensa1[1] + ", " + recompensa2[1] + ", " + recompensa3[1]);
            // BARRA DE PROGRESO PROYECTO 2
            int porcentaje = (int) ((cantidadFinanciada[1] / cantidadNecesaria[1]) * 100);
            graficoBarras(porcentaje);
            System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
        }
        if (proyectosCreados[0] >= 3) {
            System.out.println("\nProyecto 3:");
            System.out.println("Nombre: " + nombreProyecto[2]);
            System.out.println("Descripción: " + descripcionProyecto[2]);
            System.out.println("Categoría: " + categoriaProyecto[2]);
            System.out.println("Cantidad necesaria: " + cantidadNecesaria[2]);
            System.out.println("Cantidad financiada: " + cantidadFinanciada[2]);
            System.out.println("Fecha de inicio: " + fechaInicio[2]);
            System.out.println("Fecha de fin: " + fechaFin[2]);
            System.out.println("Recompensas: " + recompensa1[2] + ", " + recompensa2[2] + ", " + recompensa3[2]);
            // BARRA DE PROGRESO PROYECTO 3
            int porcentaje = (int) ((cantidadFinanciada[2] / cantidadNecesaria[2]) * 100);
            graficoBarras(porcentaje);
            System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
        }
    }

    public static void modificarProyectos (int [] proyectosCreados, String[]nombreProyecto, String[] descripcionProyecto,
                                           String[] categoriaProyecto, double[] cantidadNecesaria, double[] cantidadFinanciada,
                                           String[] fechaInicio, String[] fechaFin, String[] recompensa1, String[] recompensa2, String[] recompensa3){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n1. Modificar proyecto 1 ");
        System.out.println("2. Modificar proyecto 2 ");
        System.out.println("3. Modificar proyecto 3 ");
        System.out.println("4. Volver ");

        int numProyecto = sc.nextInt();
        sc.nextLine();

        if (numProyecto == 4) {
            return;
        }
        if (numProyecto < 1 || numProyecto > proyectosCreados[0]) {
            System.out.println("Proyecto no válido.");
            return;
        }

        System.out.print("Introduce el nuevo nombre del proyecto: ");
        String nuevoNombre = sc.nextLine();
        System.out.print("Introduce la nueva descripción del proyecto: ");
        String nuevaDescripcion = sc.nextLine();
        System.out.print("Introduce la nueva categoría del proyecto: ");
        String nuevaCategoria = sc.nextLine();
        System.out.print("Introduce la nueva cantidad necesaria: ");
        double nuevaCantidadNecesaria = sc.nextDouble();
        sc.nextLine();
        System.out.print("Introduce la nueva cantidad financiada: ");
        double nuevaCantidadFinanciada = sc.nextDouble();
        sc.nextLine();
        System.out.print("Introduce la nueva fecha de inicio (formato DD/MM/AAAA): ");
        String nuevaFechaInicio = sc.nextLine();
        System.out.print("Introduce la nueva fecha de fin (formato DD/MM/AAAA): ");
        String nuevaFechaFin = sc.nextLine();
        System.out.println("Introduce las nuevas recompensas:");
        System.out.print("Recompensa 1: ");
        String nuevaRecompensa1 = sc.nextLine();
        System.out.print("Recompensa 2: ");
        String nuevaRecompensa2 = sc.nextLine();
        System.out.print("Recompensa 3: ");
        String nuevaRecompensa3 = sc.nextLine();

        if (numProyecto == 1) {
            nombreProyecto[0] = nuevoNombre;
            descripcionProyecto[0] = nuevaDescripcion;
            categoriaProyecto[0] = nuevaCategoria;
            cantidadNecesaria[0] = nuevaCantidadNecesaria;
            cantidadFinanciada[0] = nuevaCantidadFinanciada;
            fechaInicio[0] = nuevaFechaInicio;
            fechaFin[0] = nuevaFechaFin;
            recompensa1[0] = nuevaRecompensa1;
            recompensa2[0] = nuevaRecompensa2;
            recompensa3[0] = nuevaRecompensa3;
        } else if (numProyecto == 2) {
            nombreProyecto[1] = nuevoNombre;
            descripcionProyecto[1] = nuevaDescripcion;
            categoriaProyecto[1] = nuevaCategoria;
            cantidadNecesaria[1] = nuevaCantidadNecesaria;
            cantidadFinanciada[1] = nuevaCantidadFinanciada;
            fechaInicio[1] = nuevaFechaInicio;
            fechaFin[1] = nuevaFechaFin;
            recompensa1[1] = nuevaRecompensa1;
            recompensa2[1] = nuevaRecompensa2;
            recompensa3[1] = nuevaRecompensa3;
        } else if (numProyecto == 3) {
            nombreProyecto[2] = nuevoNombre;
            descripcionProyecto[2] = nuevaDescripcion;
            categoriaProyecto[2] = nuevaCategoria;
            cantidadNecesaria[2] = nuevaCantidadNecesaria;
            cantidadFinanciada[2] = nuevaCantidadFinanciada;
            fechaInicio[2] = nuevaFechaInicio;
            fechaFin[2] = nuevaFechaFin;
            recompensa1[2] = nuevaRecompensa1;
            recompensa2[2] = nuevaRecompensa2;
            recompensa3[2] = nuevaRecompensa3;
        }

        System.out.println("Proyecto modificado con éxito.");
    }

    /*
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
    */
    public static String obtenerEntrada(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static double obtenerDouble(String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }
    //GESTOR

    //FUNCIONES INVERSOR 1
    // Menú del inversor 1
    public static void menuInversor1(double [] saldoDisponibleInversor, String referidosInversor1,
                                     boolean[] invertidoEnProyecto,
                                     double [] cantidadInvertidaEnProyecto,
                                     String [] nombreProyecto,
                                     String [] categoriaProyecto,
                                     String [] fechaInicio, String[] fechaFin,
                                     double [] cantidadNecesaria,
                                     double [] cantidadFinanciada,
                                     String [] descripcionProyecto,
                                     String [] recompensa1,
                                     String [] recompensa2,
                                     String [] recompensa3,
                                     String [] inversor,
                                     int posicionUsuario){
        while (true) {
            System.out.println("\n\033[32m--- Menú Inversor ---\033[0m");
            System.out.println("1. Mis inversiones");
            System.out.println("2. Proyectos Disponibles");
            System.out.println("3. Cartera digital");
            System.out.println("4. Referidos");
            System.out.println("5. Configuración");
            System.out.println("6. Cerrar sesión");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarInversiones(invertidoEnProyecto, cantidadInvertidaEnProyecto);
                    break;
                case 2:
                    menuProyectos(saldoDisponibleInversor,
                            nombreProyecto,
                            categoriaProyecto,
                            cantidadNecesaria,
                            cantidadFinanciada,
                            descripcionProyecto,
                            recompensa1,
                            recompensa2,
                            recompensa3, invertidoEnProyecto, cantidadInvertidaEnProyecto, posicionUsuario);
                    break;
                case 3:
                    gestionarCartera(saldoDisponibleInversor, posicionUsuario);
                    break;
                case 4:
                    referidosInversor1 = gestionarReferidos(referidosInversor1);
                    break;
                case 5:
                    configurarUsuario();
                    break;
                case 6:
                    System.out.println("Sesión cerrada.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void mostrarInversiones(boolean[] invertido, double[] cantInvertida) {
        System.out.println("\n--- Mis Inversiones ---");
        boolean tieneInversion = false;
        for (int i = 0; i < invertido.length; i++) {
            if (invertido[i]) {
                System.out.println("Inversión en Proyecto " + (i + 1) + " por: " + cantInvertida[i]);
                tieneInversion = true;
            }
        }
        if (!tieneInversion) {
            System.out.println("No has realizado inversiones.");
        }
    }

    public static void gestionarCartera(double [] saldo, int posicionUsuario) {
        System.out.println("\n--- Cartera Digital ---");
        System.out.println("Saldo disponible: " + saldo[posicionUsuario]);
        System.out.print("¿Cuánto deseas añadir a tu saldo? ");
        double cantidad = sc.nextDouble();
        if (cantidad > 0) {
            saldo[posicionUsuario] += cantidad;
            System.out.println("Saldo añadido con éxito.");
        } else {
            System.out.println("Cantidad inválida.");
        }
    }

    public static String gestionarReferidos(String referidos) {
        System.out.println("\n--- Referidos ---");
        System.out.println("Referidos actuales: " + (referidos.isEmpty() ? "Ninguno" : referidos));
        System.out.print("Introduce el correo del nuevo referido: ");
        sc.nextLine();
        String nuevoReferido = sc.nextLine();
        referidos += (referidos.isEmpty() ? "" : ", ") + nuevoReferido;
        System.out.println("Referido añadido con éxito.");
        return referidos;
    }

    public static void configurarUsuario() {
        System.out.println("\n--- Configuración ---");
        System.out.println("1. Cambiar nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        System.out.println("3. Volver");
        System.out.print("Selecciona una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                System.out.print("Introduce el nuevo nombre de usuario: ");
                String nuevoNombre = sc.nextLine();
                System.out.println("Nombre cambiado a: " + nuevoNombre);
                break;
            case 2:
                System.out.print("Introduce la nueva contraseña: ");
                String nuevaPass = sc.nextLine();
                System.out.println("Contraseña cambiada.");
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // Menú de proyectos
    public static void menuProyectos(double[] saldo, String[] nombresProyectos, String[] categoriasProyectos,
                                     double[] necesario, double[] financiado, String[] descripciones,
                                     String[] recompensa1, String[] recompensa2, String[] recompensa3,
                                     boolean[] invertidoEnProyecto, double[] cantidadInvertidaEnProyecto,
                                     int posicionUsuario){
        while (true) {
            System.out.println("\n--- Proyectos Disponibles ---");
            System.out.println("1. Listar proyectos");
            System.out.println("2. Ver detalles de un proyecto");
            System.out.println("3. Invertir en un proyecto");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listarProyectos(nombresProyectos, categoriasProyectos, necesario, financiado);
                    break;
                case 2:
                    verDetallesProyecto(nombresProyectos, categoriasProyectos, descripciones, necesario, financiado, recompensa1, recompensa2, recompensa3);
                    break;
                case 3:
                    invertirEnProyecto(saldo, necesario, financiado, invertidoEnProyecto, cantidadInvertidaEnProyecto, posicionUsuario);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void listarProyectos(String[] nombres, String[] categorias, double[] necesario, double[] financiado) {
        System.out.println("\n--- Listado de Proyectos ---");
        System.out.printf("%-3s | %-20s | %-12s | %-10s | %-10s\n", "N°", "Proyecto", "Categoría", "Necesario", "Financiado");
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", i + 1, nombres[i], categorias[i], necesario[i], financiado[i]);
        }
    }

    private static void verDetallesProyecto(String[] nombres, String[] categorias, String[] descripciones,
                                            double[] necesario, double[] financiado, String[]recompensa1, String[] recompensa2,String[] recompensa3) {
        System.out.print("\nSelecciona el número del proyecto (1-" + nombres.length + "): ");
        int proyecto = sc.nextInt() - 1;
        if (proyecto >= 0 && proyecto < nombres.length) {
            mostrarDetallesProyecto(nombres[proyecto], categorias[proyecto], descripciones[proyecto],
                    necesario[proyecto], financiado[proyecto], recompensa1, recompensa2, recompensa3);
            int porcentaje = (int) ((financiado[proyecto] / necesario[proyecto]) * 100);
            graficoBarras(porcentaje);
            System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    private static void invertirEnProyecto(double[] saldo, double[] necesario, double[] financiado, boolean[] invertidoEnProyecto, double[] cantidadInvertidaEnProyecto, int posicionUsuario) {
        System.out.print("\nSelecciona el número del proyecto para invertir (1-" + necesario.length + "): ");
        int proyecto = sc.nextInt() - 1;
        if (proyecto >= 0 && proyecto < necesario.length) {
            double cantidadRestante = necesario[proyecto] - financiado[proyecto];
            System.out.println("Cantidad restante para financiar: " + cantidadRestante);
            System.out.print("¿Cuánto deseas invertir? (Saldo disponible: " + saldo[posicionUsuario] + "): ");
            double cantidadInvertir = sc.nextDouble();

            if (cantidadInvertir > 0 && cantidadInvertir <= saldo[posicionUsuario] && cantidadInvertir <= cantidadRestante) {
                financiado[proyecto] += cantidadInvertir;
                invertidoEnProyecto[proyecto] = true;
                cantidadInvertidaEnProyecto[proyecto] += cantidadInvertir;
                saldo[posicionUsuario] -= cantidadInvertir;
                System.out.println("Inversión realizada con éxito.");
            } else {
                System.out.println("Cantidad inválida o insuficiente.");
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    // Metodo para mostrar detalles del proyecto
    private static void mostrarDetallesProyecto(String nombre, String categoria, String descripcion,
                                                double necesario, double financiado, String[] recompensa1, String[] recompensa2, String[] recompensa3) {
        System.out.println("\n--- Detalles del Proyecto ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Cantidad Necesaria: " + necesario);
        System.out.println("Cantidad Financiada: " + financiado);
        System.out.println("Cantidad Restante: " + (necesario - financiado));
        System.out.println("*** RECOMPENSAS ***");

        if (!recompensa1[0].equals("")){
            System.out.println("Recompensa 1: " + recompensa1[0]);
            System.out.println("Recompensa 2: " + recompensa2[0]);
            System.out.println("Recompensa 3: " + recompensa3[0]);

        }

    }

    // Metodo para comprobar si el String introducido en el inicio de sesión se encuentra en el array de usuarios correspondiente
    public static boolean buscaStringEnArray (String usuarioIntroducido, String [] tipoDeUsuario){
        boolean estaEnArray = false;
        for (int i=0; i<tipoDeUsuario.length; i++){
            if (usuarioIntroducido.equals(tipoDeUsuario[i])){
                estaEnArray = true;
            }
        }
        return estaEnArray;
    }

    public static int buscaPosicionUsuarioEnArray(String [] usuario, String usuarioIntroducido){
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i].equals(usuarioIntroducido)) {
                return i; //
            }
        }
        return -1;
    }

    public static int buscaPrimeraPosicionVacia (String[] usuario, String usuarioIntroducido){
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    // Función para comprobar el estado y posiciones del array (sólo se utiliza de manera interna para hacer comprobaciones
    public static void imprimeArray (String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print("Posición " + i + " : " + array[i] + ", ");
        }
    }



}
