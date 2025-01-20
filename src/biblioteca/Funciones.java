package biblioteca;

import java.util.Scanner;

import static biblioteca.FuncionesComprobacionCadenas.*;

public class Funciones {

    public static int menuPrincipalAdmin() {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        int opcionPanelControl;
        do {
            System.out.println("\n--- Panel de Control ---");
            System.out.println("1. Bloquear usuario");
            System.out.println("2. Desbloquear usuario");
            System.out.println("3. Volver");
            opcionPanelControl = sc.nextInt();
            sc.nextLine();

            if (opcionPanelControl == 1 || opcionPanelControl == 2) {
                bloquearDesbloquear(opcionPanelControl, bloqueados);
            } else if (opcionPanelControl == 3) {
                break;
            } else {
                System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }

        } while (opcionPanelControl != 3);
    }

    public static void bloquearDesbloquear(int opcionPanelControl, boolean[] bloqueados) {
        Scanner sc = new Scanner(System.in);

        String[] usuarios = {"Gestor", "Inversor 1", "Inversor 2"};
        boolean bloqueando = opcionPanelControl == 1; // Determinar si es bloqueo o desbloqueo
        String accion = bloqueando ? "bloquear" : "desbloquear";

        int opcion;
        do {
            System.out.println("\n¿A qué usuario " + accion + "?");
            for (int i = 0; i < usuarios.length; i++) {
                System.out.println((i + 1) + ". Usuario " + usuarios[i]);
            }
            System.out.println((usuarios.length + 1) + ". Volver");

            // Validar entrada numérica
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion >= 1 && opcion <= usuarios.length) {
                bloqueados[opcion - 1] = bloqueando;
                System.out.println("Has " + (bloqueando ? "bloqueado" : "desbloqueado") + " al " + usuarios[opcion - 1] + " correctamente.");
            } else if (opcion == usuarios.length + 1) {
                System.out.println("Volviendo al menú principal...");
            } else {
                System.out.println("Opción no válida, intenta nuevamente.");
            }
        } while (opcion != usuarios.length + 1);
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

    public static String cambioNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nuevo nombre de usuario");
        String nuevoNombre = sc.nextLine().toLowerCase().trim();
        System.out.println("Has reestablecido su nombre de usuario");

        return nuevoNombre;
    }

    public static void cambioPassword(String[] contrasenias, int posicionUsuario) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por seguridad, escribe tu contraseña actual:");
        String passIntroducida = sc.nextLine();

        if (passIntroducida.equals(contrasenias[posicionUsuario])) {
            System.out.println("Ingrese la nueva contraseña (mínimo 8 caracteres, con mayúsculas, minúsculas y números):");
            String nuevaPassword;
            while (true) {
                nuevaPassword = sc.nextLine();
                if (validarPassword(nuevaPassword)) {
                    break;
                }
                System.out.println("Contraseña inválida. Intente de nuevo:");
            }
            contrasenias[posicionUsuario] = nuevaPassword;
            System.out.println("Contraseña restablecida con éxito.");
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }

    public static String cambioPasswordAdmin(String contraseniaAdmin) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por seguridad, escribe tu contraseña actual:");
        String passIntroducida = sc.nextLine();

        if (passIntroducida.equals(contraseniaAdmin)) {
            System.out.println("Ingrese la nueva contraseña (mínimo 8 caracteres, con mayúsculas, minúsculas y números):");
            String nuevaPassword;
            while (true) {
                nuevaPassword = sc.nextLine();
                if (validarPassword(nuevaPassword)) {
                    break;
                }
                System.out.println("Contraseña inválida. Intente de nuevo:");
            }
            System.out.println("Contraseña restablecida con éxito.");
            return nuevaPassword;
        } else {
            System.out.println("Contraseña incorrecta.");
            return contraseniaAdmin;
        }
    }

    //GESTOR
    public static int menuPrincipalGestor() {
        Scanner sc = new Scanner(System.in);
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

    public static void crearProyecto(int[] proyectosCreados, String[] nombreProyecto, String[] descripcionProyecto, String[] categoriaProyecto, double[] cantidadNecesaria, double[] cantidadFinanciada, String[] fechaInicio, String[] fechaFin, String[] recompensa1, String[] recompensa2, String[] recompensa3) {

        if (proyectosCreados[0] >= 3) {
            System.out.println("No se pueden crear más proyectos.");
            return;
        }

        int indiceProyecto = proyectosCreados[0];

        nombreProyecto[indiceProyecto] = obtenerEntradaNoVacia("Nombre del proyecto: ");
        descripcionProyecto[indiceProyecto] = obtenerEntradaNoVacia("Descripción del proyecto: ");
        categoriaProyecto[indiceProyecto] = obtenerEntradaNoVacia("Categoría del proyecto: ");

        // Validar y recoger fechas
        do {
            fechaInicio[indiceProyecto] = obtenerEntradaNoVacia("Fecha de inicio (dd/mm/aaaa): ");
        } while (!validarFormatoFecha(fechaInicio[indiceProyecto]));

        do {
            fechaFin[indiceProyecto] = obtenerEntradaNoVacia("Fecha de fin (dd/mm/aaaa): ");
        } while (!validarFormatoFecha(fechaFin[indiceProyecto]) || !validarFechaFinPosterior(fechaInicio[indiceProyecto], fechaFin[indiceProyecto]));

        // Recoger recompensas
        recompensa1[indiceProyecto] = obtenerEntradaNoVacia("Recompensa 1: ");
        recompensa2[indiceProyecto] = obtenerEntradaNoVacia("Recompensa 2: ");
        recompensa3[indiceProyecto] = obtenerEntradaNoVacia("Recompensa 3: ");

        // Validar y recoger cantidades
        do {
            cantidadNecesaria[indiceProyecto] = obtenerDouble("Cantidad necesaria (>0): ");
        } while (cantidadNecesaria[indiceProyecto] <= 0);

        do {
            cantidadFinanciada[indiceProyecto] = obtenerDouble("Cantidad financiada (debe ser menor o igual que la necesaria): ");
        } while (cantidadFinanciada[indiceProyecto] < 0 || cantidadFinanciada[indiceProyecto] > cantidadNecesaria[indiceProyecto]);

        proyectosCreados[0]++;
        System.out.println("Proyecto creado con éxito.");
    }

    public static void mostrarProyectos(int[] proyectosCreados, String[] nombreProyecto, String[] descripcionProyecto, String[] categoriaProyecto, double[] cantidadNecesaria, double[] cantidadFinanciada, String[] fechaInicio, String[] fechaFin, String[] recompensa1, String[] recompensa2, String[] recompensa3) {

        System.out.println("\nMostrando todos los proyectos de la plataforma...");

        // Validar si no hay proyectos creados
        if (proyectosCreados[0] == 0) {
            System.out.println("No hay proyectos creados aún.");
            return;
        }

        // Verificar consistencia de los datos
        if (nombreProyecto.length != descripcionProyecto.length || nombreProyecto.length != categoriaProyecto.length || nombreProyecto.length != cantidadNecesaria.length || nombreProyecto.length != cantidadFinanciada.length || nombreProyecto.length != fechaInicio.length || nombreProyecto.length != fechaFin.length || nombreProyecto.length != recompensa1.length || nombreProyecto.length != recompensa2.length || nombreProyecto.length != recompensa3.length) {
            System.out.println("Error: Los datos de los proyectos no son consistentes.");
            return;
        }

        // Mostrar cada proyecto usando un bucle
        for (int i = 0; i < proyectosCreados[0] && i < nombreProyecto.length; i++) {
            System.out.println("\nProyecto " + (i + 1) + ":");
            System.out.println("Nombre: " + nombreProyecto[i]);
            System.out.println("Descripción: " + descripcionProyecto[i]);
            System.out.println("Categoría: " + categoriaProyecto[i]);
            System.out.println("Cantidad necesaria: " + cantidadNecesaria[i]);
            System.out.println("Cantidad financiada: " + cantidadFinanciada[i]);
            System.out.println("Fecha de inicio: " + fechaInicio[i]);
            System.out.println("Fecha de fin: " + fechaFin[i]);
            System.out.println("Recompensas: " + recompensa1[i] + ", " + recompensa2[i] + ", " + recompensa3[i]);

            // Calcular el porcentaje recaudado
            if (cantidadNecesaria[i] > 0) {
                int porcentaje = (int) ((cantidadFinanciada[i] / cantidadNecesaria[i]) * 100);
                graficoBarras(porcentaje);
                System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
            } else {
                System.out.println("Error: La cantidad necesaria no puede ser 0.");
            }
        }
    }

    public static void modificarProyectos(int[] proyectosCreados, String[] nombreProyecto, String[] descripcionProyecto, String[] categoriaProyecto, double[] cantidadNecesaria, double[] cantidadFinanciada, String[] fechaInicio, String[] fechaFin, String[] recompensa1, String[] recompensa2, String[] recompensa3) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nOpciones para modificar proyectos:");
        for (int i = 1; i <= proyectosCreados[0]; i++) {
            System.out.println(i + ". Modificar proyecto " + i);
        }
        System.out.println((proyectosCreados[0] + 1) + ". Volver");

        System.out.print("Selecciona una opción: ");
        int numProyecto = sc.nextInt();
        sc.nextLine();

        if (numProyecto == proyectosCreados[0] + 1) {
            return;
        }

        if (numProyecto < 1 || numProyecto > proyectosCreados[0]) {
            System.out.println("Proyecto no válido.");
            return;
        }

        int index = numProyecto - 1; // Ajustar índice del proyecto (base 0)

        // Pedir los nuevos datos
        System.out.print("Introduce el nuevo nombre del proyecto: ");
        nombreProyecto[index] = sc.nextLine();
        System.out.print("Introduce la nueva descripción del proyecto: ");
        descripcionProyecto[index] = sc.nextLine();
        System.out.print("Introduce la nueva categoría del proyecto: ");
        categoriaProyecto[index] = sc.nextLine();
        System.out.print("Introduce la nueva cantidad necesaria: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Introduce un valor numérico válido.");
            sc.next();
        }
        cantidadNecesaria[index] = sc.nextDouble();
        sc.nextLine();
        System.out.print("Introduce la nueva cantidad financiada: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Introduce un valor numérico válido.");
            sc.next();
        }
        cantidadFinanciada[index] = sc.nextDouble();
        sc.nextLine();
        System.out.print("Introduce la nueva fecha de inicio (formato DD/MM/AAAA): ");
        fechaInicio[index] = sc.nextLine();
        System.out.print("Introduce la nueva fecha de fin (formato DD/MM/AAAA): ");
        fechaFin[index] = sc.nextLine();

        System.out.println("Introduce las nuevas recompensas:");
        System.out.print("Recompensa 1: ");
        recompensa1[index] = sc.nextLine();
        System.out.print("Recompensa 2: ");
        recompensa2[index] = sc.nextLine();
        System.out.print("Recompensa 3: ");
        recompensa3[index] = sc.nextLine();

        System.out.println("Proyecto " + numProyecto + " modificado con éxito.");
    }

    public static String obtenerEntrada(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static double obtenerDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextDouble();
    }
    //GESTOR

    //FUNCIONES INVERSOR 1
    // Menú del inversor 1
    public static void menuInversor1(double[] saldoDisponibleInversor, String referidosInversor1, boolean[] invertidoEnProyecto, double[] cantidadInvertidaEnProyecto, String[] nombreProyecto, String[] categoriaProyecto, double[] cantidadNecesaria, double[] cantidadFinanciada, String[] descripcionProyecto, String[] recompensa1, String[] recompensa2, String[] recompensa3, int posicionUsuario) {
        Scanner sc = new Scanner(System.in);
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
            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarInversiones(invertidoEnProyecto, cantidadInvertidaEnProyecto);
                    break;
                case 2:
                    menuProyectos(saldoDisponibleInversor, nombreProyecto, categoriaProyecto, cantidadNecesaria, cantidadFinanciada, descripcionProyecto, recompensa1, recompensa2, recompensa3, invertidoEnProyecto, cantidadInvertidaEnProyecto, posicionUsuario);
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

    public static void gestionarCartera(double[] saldo, int posicionUsuario) {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
                sc.nextLine();
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
    public static void menuProyectos(double[] saldo, String[] nombresProyectos, String[] categoriasProyectos, double[] necesario, double[] financiado, String[] descripciones, String[] recompensa1, String[] recompensa2, String[] recompensa3, boolean[] invertidoEnProyecto, double[] cantidadInvertidaEnProyecto, int posicionUsuario) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Proyectos Disponibles ---");
            System.out.println("1. Listar proyectos");
            System.out.println("2. Ver detalles de un proyecto");
            System.out.println("3. Invertir en un proyecto");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

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

    public static void listarProyectos(String[] nombres, String[] categorias, double[] necesario, double[] financiado) {
        System.out.println("\n--- Listado de Proyectos ---");
        System.out.printf("%-3s | %-20s | %-12s | %-10s | %-10s\n", "N°", "Proyecto", "Categoría", "Necesario", "Financiado");
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", i + 1, nombres[i], categorias[i], necesario[i], financiado[i]);
        }
    }

    public static void verDetallesProyecto(String[] nombres, String[] categorias, String[] descripciones, double[] necesario, double[] financiado, String[] recompensa1, String[] recompensa2, String[] recompensa3) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSelecciona el número del proyecto (1-" + nombres.length + "): ");
        int proyecto = sc.nextInt() - 1;
        sc.nextLine();
        if (proyecto >= 0 && proyecto < nombres.length) {
            mostrarDetallesProyecto(nombres[proyecto], categorias[proyecto], descripciones[proyecto], necesario[proyecto], financiado[proyecto], recompensa1, recompensa2, recompensa3);
            int porcentaje = (int) ((financiado[proyecto] / necesario[proyecto]) * 100);
            graficoBarras(porcentaje);
            System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    public static void invertirEnProyecto(double[] saldo, double[] necesario, double[] financiado, boolean[] invertidoEnProyecto, double[] cantidadInvertidaEnProyecto, int posicionUsuario) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSelecciona el número del proyecto para invertir (1-" + necesario.length + "): ");
        int proyecto = sc.nextInt() - 1;
        sc.nextLine();
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
    public static void mostrarDetallesProyecto(String nombre, String categoria, String descripcion, double necesario, double financiado, String[] recompensa1, String[] recompensa2, String[] recompensa3) {
        System.out.println("\n--- Detalles del Proyecto ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Cantidad Necesaria: " + necesario);
        System.out.println("Cantidad Financiada: " + financiado);
        System.out.println("Cantidad Restante: " + (necesario - financiado));
        System.out.println("*** RECOMPENSAS ***");

        if (!recompensa1[0].isEmpty()) {
            System.out.println("Recompensa 1: " + recompensa1[0]);
            System.out.println("Recompensa 2: " + recompensa2[0]);
            System.out.println("Recompensa 3: " + recompensa3[0]);

        }

    }

    // Metodo para comprobar si el String introducido en el inicio de sesión se encuentra en el array de usuarios correspondiente
    public static boolean buscaStringEnArray(String usuarioIntroducido, String[] tipoDeUsuario) {
        boolean estaEnArray = false;
        for (String s : tipoDeUsuario) {
            if (usuarioIntroducido.equals(s)) {
                estaEnArray = true;
                break;
            }
        }
        return estaEnArray;
    }

    public static int buscaPosicionUsuarioEnArray(String[] usuario, String usuarioIntroducido) {
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i].equals(usuarioIntroducido)) {
                return i; //
            }
        }
        return -1;
    }

    public static int buscaPrimeraPosicionVacia(String[] usuario) {
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

}