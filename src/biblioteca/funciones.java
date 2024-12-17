package biblioteca;

import java.util.Scanner;

public class funciones {

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

    public static String cambioPassword(String passwordActual) {

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
            graficoBarras(porcentaje);
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
    //GESTOR

    //FUNCIONES INVERSOR 1
    // Menú del inversor 1
    public static void menuInversor1(double saldoDisponibleInversor1, String referidosInversor1,
                                     boolean invertidoEnProyecto1_1, boolean invertidoEnProyecto2_1, boolean invertidoEnProyecto3_1,
                                     double cantidadFinanciada1_1, double cantidadFinanciada2_1, double cantidadFinanciada3_1,
                                     String nombreProyecto1, String nombreProyecto2, String nombreProyecto3,
                                     String categoriaProyecto1, String categoriaProyecto2, String categoriaProyecto3,
                                     double cantidadNecesaria1, double cantidadNecesaria2, double cantidadNecesaria3,
                                     double cantidadFinanciada1, double cantidadFinanciada2, double cantidadFinanciada3,
                                     String descripcionProyecto1, String descripcionProyecto2, String descripcionProyecto3,
                                     String recompensa1_1, String recompensa1_2, String recompensa1_3,
                                     String recompensa2_1, String recompensa2_2, String recompensa2_3,
                                     String recompensa3_1, String recompensa3_2, String recompensa3_3) {
        while (true) {
            System.out.println("\n\033[32m--- Menú Inversor 1 ---\033[0m");
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
                    mostrarInversiones(new boolean[]{invertidoEnProyecto1_1, invertidoEnProyecto2_1, invertidoEnProyecto3_1},
                            new double[]{cantidadFinanciada1_1, cantidadFinanciada2_1, cantidadFinanciada3_1});
                    break;
                case 2:
                    menuProyectos(saldoDisponibleInversor1,
                            new String[]{nombreProyecto1, nombreProyecto2, nombreProyecto3},
                            new String[]{categoriaProyecto1, categoriaProyecto2, categoriaProyecto3},
                            new double[]{cantidadNecesaria1, cantidadNecesaria2, cantidadNecesaria3},
                            new double[]{cantidadFinanciada1, cantidadFinanciada2, cantidadFinanciada3},
                            new String[]{descripcionProyecto1, descripcionProyecto2, descripcionProyecto3},
                            new String[][]{{recompensa1_1, recompensa1_2, recompensa1_3},
                                    {recompensa2_1, recompensa2_2, recompensa2_3},
                                    {recompensa3_1, recompensa3_2, recompensa3_3}});
                    break;
                case 3:
                    saldoDisponibleInversor1 = gestionarCartera(saldoDisponibleInversor1);
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

    public static double gestionarCartera(double saldo) {
        System.out.println("\n--- Cartera Digital ---");
        System.out.println("Saldo disponible: " + saldo);
        System.out.print("¿Cuánto deseas añadir a tu saldo? ");
        double cantidad = sc.nextDouble();
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Saldo añadido con éxito.");
        } else {
            System.out.println("Cantidad inválida.");
        }
        return saldo;
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
    public static void menuProyectos(double saldo, String[] nombresProyectos, String[] categoriasProyectos,
                                     double[] necesario, double[] financiado, String[] descripciones,
                                     String[][] recompensas) {
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
                    verDetallesProyecto(nombresProyectos, categoriasProyectos, descripciones, necesario, financiado, recompensas);
                    break;
                case 3:
                    saldo = invertirEnProyecto(saldo, necesario, financiado);
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
                                            double[] necesario, double[] financiado, String[][] recompensas) {
        System.out.print("\nSelecciona el número del proyecto (1-" + nombres.length + "): ");
        int proyecto = sc.nextInt() - 1;
        if (proyecto >= 0 && proyecto < nombres.length) {
            mostrarDetallesProyecto(nombres[proyecto], categorias[proyecto], descripciones[proyecto],
                    necesario[proyecto], financiado[proyecto], recompensas[proyecto]);
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    private static double invertirEnProyecto(double saldo, double[] necesario, double[] financiado) {
        System.out.print("\nSelecciona el número del proyecto para invertir (1-" + necesario.length + "): ");
        int proyecto = sc.nextInt() - 1;
        if (proyecto >= 0 && proyecto < necesario.length) {
            double cantidadRestante = necesario[proyecto] - financiado[proyecto];
            System.out.println("Cantidad restante para financiar: " + cantidadRestante);
            System.out.print("¿Cuánto deseas invertir? (Saldo disponible: " + saldo + "): ");
            double cantidadInvertir = sc.nextDouble();

            if (cantidadInvertir > 0 && cantidadInvertir <= saldo && cantidadInvertir <= cantidadRestante) {
                financiado[proyecto] += cantidadInvertir;
                saldo -= cantidadInvertir;
                System.out.println("Inversión realizada con éxito.");
            } else {
                System.out.println("Cantidad inválida o insuficiente.");
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
        return saldo;
    }

    // Método para mostrar detalles del proyecto
    private static void mostrarDetallesProyecto(String nombre, String categoria, String descripcion,
                                                double necesario, double financiado, String[] recompensas) {
        System.out.println("\n--- Detalles del Proyecto ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Cantidad Necesaria: " + necesario);
        System.out.println("Cantidad Financiada: " + financiado);
        System.out.println("Cantidad Restante: " + (necesario - financiado));
        System.out.println("*** RECOMPENSAS ***");
        for (int i = 0; i < recompensas.length; i++) {
            System.out.println("Recompensa " + (i + 1) + ": " + recompensas[i]);
        }
    }
    //FUNCIONES INVERSOR 1

    //FUNCIONES INVERSOR 2
    public static void menuInversor2(double saldoDisponibleInversor2, String referidosInversor2,
                                     boolean invertidoEnProyecto1_2, boolean invertidoEnProyecto2_2, boolean invertidoEnProyecto3_2,
                                     double cantidadFinanciada1_2, double cantidadFinanciada2_2, double cantidadFinanciada3_2,
                                     String nombreProyecto1, String nombreProyecto2, String nombreProyecto3,
                                     String categoriaProyecto1, String categoriaProyecto2, String categoriaProyecto3,
                                     double cantidadNecesaria1, double cantidadNecesaria2, double cantidadNecesaria3,
                                     double cantidadFinanciada1, double cantidadFinanciada2, double cantidadFinanciada3,
                                     String descripcionProyecto1, String descripcionProyecto2, String descripcionProyecto3,
                                     String recompensa1_1, String recompensa1_2, String recompensa1_3,
                                     String recompensa2_1, String recompensa2_2, String recompensa2_3,
                                     String recompensa3_1, String recompensa3_2, String recompensa3_3) {
        while (true) {
            System.out.println("\n\033[32m--- Menú Inversor 2 ---\033[0m");
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
                    mostrarInversionesInversor2(invertidoEnProyecto1_2, invertidoEnProyecto2_2, invertidoEnProyecto3_2,
                            cantidadFinanciada1_2, cantidadFinanciada2_2, cantidadFinanciada3_2,
                            nombreProyecto1, nombreProyecto2, nombreProyecto3);
                    break;
                case 2:
                    menuProyectosInversor2(saldoDisponibleInversor2,
                            new String[]{nombreProyecto1, nombreProyecto2, nombreProyecto3},
                            new String[]{categoriaProyecto1, categoriaProyecto2, categoriaProyecto3},
                            new double[]{cantidadNecesaria1, cantidadNecesaria2, cantidadNecesaria3},
                            new double[]{cantidadFinanciada1, cantidadFinanciada2, cantidadFinanciada3},
                            new String[]{descripcionProyecto1, descripcionProyecto2, descripcionProyecto3},
                            new String[][]{{recompensa1_1, recompensa1_2, recompensa1_3},
                                    {recompensa2_1, recompensa2_2, recompensa2_3},
                                    {recompensa3_1, recompensa3_2, recompensa3_3}},
                            new String[]{"fechaInicio1", "fechaInicio2", "fechaInicio3"},
                            new String[]{"fechaFin1", "fechaFin2", "fechaFin3"},
                            new boolean[]{invertidoEnProyecto1_2, invertidoEnProyecto2_2, invertidoEnProyecto3_2},
                            new double[]{cantidadFinanciada1_2, cantidadFinanciada2_2, cantidadFinanciada3_2});
                    break;
                case 3:
                    saldoDisponibleInversor2 = gestionarCarteraInversor2(saldoDisponibleInversor2);
                    break;
                case 4:
                    referidosInversor2 = gestionarReferidosInversor2(referidosInversor2);
                    break;
                case 5:
                    configurarUsuarioInversor2("inversor2", "passInversor2");
                    break;
                case 6:
                    System.out.println("Sesión cerrada.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Mostrar Inversiones para Inversor 2
    public static void mostrarInversionesInversor2(boolean invertidoEnProyecto1_2, boolean invertidoEnProyecto2_2, boolean invertidoEnProyecto3_2,
                                                   double cantidadFinanciada1_2, double cantidadFinanciada2_2, double cantidadFinanciada3_2,
                                                   String nombreProyecto1, String nombreProyecto2, String nombreProyecto3) {
        System.out.println("\n--- Mis Inversiones ---");
        if (invertidoEnProyecto1_2) System.out.println("Inversión en " + nombreProyecto1 + " por " + cantidadFinanciada1_2);
        if (invertidoEnProyecto2_2) System.out.println("Inversión en " + nombreProyecto2 + " por " + cantidadFinanciada2_2);
        if (invertidoEnProyecto3_2) System.out.println("Inversión en " + nombreProyecto3 + " por " + cantidadFinanciada3_2);
        if (!invertidoEnProyecto1_2 && !invertidoEnProyecto2_2 && !invertidoEnProyecto3_2) {
            System.out.println("Aún no has realizado ninguna inversión.");
        }
    }

    // Menú de Proyectos para Inversor 2
    public static void menuProyectosInversor2(double saldoDisponibleInversor2,
                                              String[] nombresProyectos, String[] categoriasProyectos,
                                              double[] cantidadNecesaria, double[] cantidadFinanciada,
                                              String[] descripciones, String[][] recompensas,
                                              String[] fechasInicio, String[] fechasFin,
                                              boolean[] invertidoEnProyecto2, double[] cantidadFinanciada2) {
        while (true) {
            System.out.println("\n--- Proyectos Disponibles ---");
            System.out.println("1. Listar proyectos");
            System.out.println("2. Ver detalles de un proyecto");
            System.out.println("3. Invertir en un proyecto");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcionProyectos = sc.nextInt();

            switch (opcionProyectos) {
                case 1:
                    listarProyectos(nombresProyectos, categoriasProyectos, cantidadNecesaria, cantidadFinanciada);
                    break;
                case 2:
                    verDetallesProyectoInversor2(nombresProyectos, categoriasProyectos, descripciones, cantidadNecesaria, cantidadFinanciada, recompensas, fechasInicio, fechasFin);
                    break;
                case 3:
                    saldoDisponibleInversor2 = invertirEnProyectoInversor2(saldoDisponibleInversor2, cantidadNecesaria, cantidadFinanciada, invertidoEnProyecto2, cantidadFinanciada2);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void verDetallesProyectoInversor2(String[] nombres, String[] categorias, String[] descripciones,
                                                     double[] necesario, double[] financiado, String[][] recompensas,
                                                     String[] fechasInicio, String[] fechasFin) {
        System.out.print("\nSelecciona el número del proyecto (1-3): ");
        int proyectoSeleccionado = sc.nextInt() - 1;
        if (proyectoSeleccionado >= 0 && proyectoSeleccionado < nombres.length) {
            System.out.println("\n--- Detalles del Proyecto ---");
            System.out.println("Nombre: " + nombres[proyectoSeleccionado]);
            System.out.println("Categoría: " + categorias[proyectoSeleccionado]);
            System.out.println("Descripción: " + descripciones[proyectoSeleccionado]);
            System.out.println("Cantidad Necesaria: " + necesario[proyectoSeleccionado]);
            System.out.println("Cantidad Financiada: " + financiado[proyectoSeleccionado]);
            System.out.println("Cantidad Restante: " + (necesario[proyectoSeleccionado] - financiado[proyectoSeleccionado]));
            System.out.println("Fecha inicio de apertura para recibir inversiones: " + fechasInicio[proyectoSeleccionado]);
            System.out.println("Fecha fin de cierre de las inversiones: " + fechasFin[proyectoSeleccionado]);
            System.out.println("*** RECOMPENSAS ***");
            for (int i = 0; i < recompensas[proyectoSeleccionado].length; i++) {
                System.out.println("Recompensa " + (i + 1) + ": " + recompensas[proyectoSeleccionado][i]);
            }
            int porcentaje = (int) ((financiado[proyectoSeleccionado] / necesario[proyectoSeleccionado]) * 100);
            graficoBarras(porcentaje);
            System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
            sc.nextLine();
            sc.nextLine();
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    private static double invertirEnProyectoInversor2(double saldoDisponibleInversor2, double[] cantidadNecesaria, double[] cantidadFinanciada,
                                                      boolean[] invertidoEnProyecto2, double[] cantidadFinanciada2) {
        System.out.print("\nSelecciona el número del proyecto para invertir (1-3): ");

        int proyectoInvertir = sc.nextInt() - 1;
        if (proyectoInvertir >= 0 && proyectoInvertir < cantidadNecesaria.length) {
            double cantidadRestante = cantidadNecesaria[proyectoInvertir] - cantidadFinanciada[proyectoInvertir];

            System.out.println("Cantidad restante para financiar: " + cantidadRestante);
            System.out.print("¿Cuánto deseas invertir? (Saldo disponible: " + saldoDisponibleInversor2 + "): ");
            double cantidadInvertir = sc.nextDouble();

            if (cantidadInvertir > 0 && cantidadInvertir <= saldoDisponibleInversor2 && cantidadInvertir <= cantidadRestante) {
                cantidadFinanciada[proyectoInvertir] += cantidadInvertir;
                cantidadFinanciada2[proyectoInvertir] += cantidadInvertir;
                invertidoEnProyecto2[proyectoInvertir] = true;
                saldoDisponibleInversor2 -= cantidadInvertir;
                System.out.println("Inversión realizada con éxito.");
            } else {
                System.out.println("Cantidad inválida.");
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
        return saldoDisponibleInversor2;
    }

    // Gestionar Cartera para Inversor 2
    public static double gestionarCarteraInversor2(double saldoDisponibleInversor2) {
        System.out.println("\n--- Cartera Digital ---");
        System.out.println("Saldo disponible: " + saldoDisponibleInversor2);
        System.out.print("¿Cuánto deseas añadir a tu saldo? ");
        double cantidad = sc.nextDouble();
        if (cantidad > 0) {
            saldoDisponibleInversor2 += cantidad;
            System.out.println("Saldo añadido con éxito.");
        } else {
            System.out.println("Cantidad inválida.");
        }
        return saldoDisponibleInversor2;
    }

    // Gestionar Referidos para Inversor 2
    public static String gestionarReferidosInversor2(String referidosInversor2) {
        System.out.println("\n--- Referidos ---");
        System.out.println("Referidos actuales: " + (referidosInversor2.isEmpty() ? "Ninguno" : referidosInversor2));
        System.out.print("Introduce el correo del nuevo referido: ");
        sc.nextLine();
        String nuevoReferido = sc.nextLine();
        referidosInversor2 += (referidosInversor2.isEmpty() ? "" : ", ") + nuevoReferido;
        System.out.println("Referido añadido con éxito.");
        return referidosInversor2;
    }

    // Configuración de Usuario para Inversor 2
    public static void configurarUsuarioInversor2(String inversor2, String passInversor2) {
        int opcionConfiguracion = menuConfiguracion();
        if (opcionConfiguracion == 1) {
            inversor2 = cambioNombre(inversor2);
        }
        if (opcionConfiguracion == 2) {
            passInversor2 = cambioPassword(passInversor2);
        }
        if (opcionConfiguracion == 3) {
            System.out.println("Volviendo...");
        }
    }
        //FUNCIONES INVERSOR 2
}