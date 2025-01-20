package biblioteca;

import java.util.Scanner;

import static biblioteca.FuncionesComprobacionCadenas.*;

/**
 * La clase <code>Funciones</code> contiene métodos estáticos para manejar interfaces de usuario,
 * gestión de proyectos, autenticación y operaciones relacionadas con los usuarios en un sistema de gestión de proyectos.
 */
public class Funciones {

    /**
     * Muestra el menú principal para el Administrador y obtiene la opción seleccionada.
     * El menú incluye opciones para acceder al panel de control, ver proyectos, modificar proyectos,
     * cambiar configuraciones y cerrar sesión.
     *
     * @return La opción seleccionada por el Administrador como un número entero.
     * La opción se representa como un valor entre 1 y 5:
     * 1: Panel de control
     * 2: Mostrar todos los proyectos
     * 3: Modificar un proyecto existente
     * 4: Configuración
     * 5: Cerrar sesión
     */
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

    /**
     * Muestra el panel de control para el Administrador, permitiéndole bloquear o desbloquear usuarios.
     * El panel de control ofrece las siguientes opciones:
     * 1. Bloquear un usuario.
     * 2. Desbloquear un usuario.
     * 3. Volver al menú anterior.
     * <p>
     * El panel de control se mantiene activo hasta que el Administrador elija la opción de "Volver".
     *
     * @param bloqueados Un arreglo de valores booleanos que indica si los usuarios están bloqueados.
     *                   Un valor `true` significa que el usuario está bloqueado, y `false` indica que no lo está.
     */
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

    /**
     * Permite al Administrador bloquear o desbloquear usuarios de la plataforma.
     * Esta función muestra una lista de usuarios y permite seleccionar cuál bloquear o desbloquear.
     * <p>
     * La acción de bloqueo o desbloqueo se determina según la opción seleccionada en el menú anterior.
     * El proceso se repite hasta que el Administrador decide volver al menú principal.
     *
     * @param opcionPanelControl La opción seleccionada en el panel de control:
     *                           1 para bloquear usuarios y 2 para desbloquear.
     * @param bloqueados         Un arreglo de valores booleanos que indica el estado de bloqueo de los usuarios.
     *                           Un valor `true` significa que el usuario está bloqueado, y `false` indica que no lo está.
     */
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

    /**
     * Muestra un gráfico de barras en la consola que representa el porcentaje proporcionado.
     * El gráfico se construye usando caracteres de barra (`■`) para representar el porcentaje completado
     * y caracteres de subrayado (`_`) para representar la parte restante.
     * <p>
     * El gráfico se dibuja en una longitud fija de 101 caracteres, donde el número de barras llenas
     * se ajusta según el valor del porcentaje proporcionado.
     *
     * @param porcentaje El porcentaje a representar en el gráfico, un valor entre 0 y 100.
     *                   Un valor de 100 mostrará una barra completamente llena, mientras que 0 será completamente vacía.
     */
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

    /**
     * Muestra el menú de configuración para el usuario, donde se pueden cambiar el nombre de usuario,
     * la contraseña o volver al menú anterior.
     * <p>
     * Este método presenta las opciones disponibles y espera la selección del usuario.
     *
     * @return Un valor entero que representa la opción seleccionada por el usuario:
     * - 1 para cambiar el nombre de usuario
     * - 2 para cambiar la contraseña
     * - 3 para volver al menú anterior
     */
    public static int menuConfiguracion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Configuración ---");
        System.out.println("¿Qué opción desea?");
        System.out.println("1. Cambiar nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        System.out.println("3. Volver");
        int opcionConfiguracion = sc.nextInt();
        sc.nextLine();

        return opcionConfiguracion;
    }

    /**
     * Permite al usuario cambiar su nombre de usuario a uno nuevo.
     * El método solicita al usuario ingresar un nuevo nombre, lo valida y lo retorna en formato en minúsculas y sin espacios adicionales.
     *
     * @return El nuevo nombre de usuario ingresado por el usuario, en minúsculas y sin espacios al inicio o al final.
     */
    public static String cambioNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nuevo nombre de usuario");
        String nuevoNombre = sc.nextLine().toLowerCase().trim();
        System.out.println("Has reestablecido su nombre de usuario");

        return nuevoNombre;
    }

    /**
     * Permite al usuario cambiar su contraseña actual por una nueva, luego de verificar la contraseña actual.
     * El método valida la contraseña nueva, asegurándose de que cumpla con los requisitos de seguridad: al menos 8 caracteres, con mayúsculas, minúsculas y números.
     *
     * @param contrasenias    Array que contiene las contraseñas de los usuarios.
     * @param posicionUsuario Índice que indica la posición del usuario cuya contraseña será cambiada.
     */
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

    /**
     * Permite al administrador cambiar su contraseña actual por una nueva, luego de verificar la contraseña actual.
     * El método valida la contraseña nueva, asegurándose de que cumpla con los requisitos de seguridad: al menos 8 caracteres, con mayúsculas, minúsculas y números.
     *
     * @param contraseniaAdmin Contraseña actual del administrador.
     * @return La nueva contraseña del administrador si la contraseña actual es válida, o la contraseña original si es incorrecta.
     */
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

    /**
     * Muestra el menú principal del gestor, donde puede elegir entre diferentes opciones como mostrar proyectos, crear nuevos proyectos, modificar proyectos existentes, configurar su cuenta o cerrar sesión.
     *
     * @return La opción seleccionada por el gestor.
     */
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

    /**
     * Crea un nuevo proyecto en la plataforma, recogiendo todos los datos necesarios como nombre, descripción,
     * categoría, fechas, recompensas y cantidades, con las respectivas validaciones.
     *
     * @param proyectosCreados    Un array que mantiene el número total de proyectos creados en la plataforma.
     * @param nombreProyecto      Un array que almacena los nombres de los proyectos creados.
     * @param descripcionProyecto Un array que almacena las descripciones de los proyectos creados.
     * @param categoriaProyecto   Un array que almacena las categorías de los proyectos creados.
     * @param cantidadNecesaria   Un array que almacena la cantidad necesaria para financiar cada proyecto.
     * @param cantidadFinanciada  Un array que almacena la cantidad financiada de cada proyecto.
     * @param fechaInicio         Un array que almacena las fechas de inicio de los proyectos.
     * @param fechaFin            Un array que almacena las fechas de finalización de los proyectos.
     * @param recompensa1         Un array que almacena la primera recompensa para cada proyecto.
     * @param recompensa2         Un array que almacena la segunda recompensa para cada proyecto.
     * @param recompensa3         Un array que almacena la tercera recompensa para cada proyecto.
     * @throws IllegalArgumentException Si los datos introducidos no cumplen con los requisitos de validación.
     */
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

    /**
     * Muestra todos los proyectos creados en la plataforma, incluyendo sus detalles como nombre, descripción,
     * categoría, cantidades necesarias y financiadas, fechas, recompensas y el porcentaje recaudado.
     * <p>
     * Además, valida si no hay proyectos creados o si los datos de los proyectos son inconsistentes.
     *
     * @param proyectosCreados    Un array que mantiene el número total de proyectos creados en la plataforma.
     * @param nombreProyecto      Un array que almacena los nombres de los proyectos creados.
     * @param descripcionProyecto Un array que almacena las descripciones de los proyectos creados.
     * @param categoriaProyecto   Un array que almacena las categorías de los proyectos creados.
     * @param cantidadNecesaria   Un array que almacena la cantidad necesaria para financiar cada proyecto.
     * @param cantidadFinanciada  Un array que almacena la cantidad financiada de cada proyecto.
     * @param fechaInicio         Un array que almacena las fechas de inicio de los proyectos.
     * @param fechaFin            Un array que almacena las fechas de finalización de los proyectos.
     * @param recompensa1         Un array que almacena la primera recompensa para cada proyecto.
     * @param recompensa2         Un array que almacena la segunda recompensa para cada proyecto.
     * @param recompensa3         Un array que almacena la tercera recompensa para cada proyecto.
     * @throws IllegalArgumentException Si los datos de los proyectos no son consistentes.
     */
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

    /**
     * Permite modificar los detalles de un proyecto existente en la plataforma.
     * Los detalles que se pueden modificar incluyen el nombre, descripción, categoría,
     * cantidades necesarias y financiadas, fechas de inicio y fin, y las recompensas.
     * <p>
     * El usuario selecciona el proyecto a modificar a través de un menú, y luego se solicita la nueva información.
     * Si se introduce una opción no válida, o si se elige volver, el proceso de modificación se cancela.
     *
     * @param proyectosCreados    Un array que mantiene el número total de proyectos creados en la plataforma.
     * @param nombreProyecto      Un array que almacena los nombres de los proyectos creados.
     * @param descripcionProyecto Un array que almacena las descripciones de los proyectos creados.
     * @param categoriaProyecto   Un array que almacena las categorías de los proyectos creados.
     * @param cantidadNecesaria   Un array que almacena la cantidad necesaria para financiar cada proyecto.
     * @param cantidadFinanciada  Un array que almacena la cantidad financiada de cada proyecto.
     * @param fechaInicio         Un array que almacena las fechas de inicio de los proyectos.
     * @param fechaFin            Un array que almacena las fechas de finalización de los proyectos.
     * @param recompensa1         Un array que almacena la primera recompensa para cada proyecto.
     * @param recompensa2         Un array que almacena la segunda recompensa para cada proyecto.
     * @param recompensa3         Un array que almacena la tercera recompensa para cada proyecto.
     */
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

    /**
     * Solicita al usuario una entrada de texto.
     * <p>
     * Esta función muestra un mensaje al usuario y espera que ingrese una cadena de texto.
     * Una vez que el usuario ingresa la información, se devuelve como un String.
     *
     * @param mensaje El mensaje que se mostrará al usuario para solicitar la entrada.
     * @return La cadena de texto ingresada por el usuario.
     */
    public static String obtenerEntrada(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextLine();
    }

    /**
     * Solicita al usuario una entrada de tipo numérico (double).
     * <p>
     * Esta función muestra un mensaje al usuario y espera que ingrese un número de tipo double.
     * Una vez que el usuario ingresa la información, se devuelve como un valor de tipo double.
     *
     * @param mensaje El mensaje que se mostrará al usuario para solicitar la entrada numérica.
     * @return El valor numérico ingresado por el usuario.
     */
    public static double obtenerDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextDouble();
    }
    //GESTOR

    //FUNCIONES INVERSOR 1
    // Menú del inversor 1

    /**
     * Muestra el menú principal para el inversor y maneja las opciones seleccionadas.
     * <p>
     * Esta función presenta las opciones disponibles para el inversor, permitiéndole elegir entre ver sus inversiones, explorar proyectos disponibles, gestionar su cartera digital, administrar referidos, configurar su cuenta o cerrar sesión.
     * Según la opción seleccionada, se ejecutan diferentes acciones relacionadas con la inversión y la configuración de su cuenta.
     *
     * @param saldoDisponibleInversor     Arreglo que contiene el saldo disponible del inversor.
     * @param referidosInversor1          Cadena que representa los referidos del inversor.
     * @param invertidoEnProyecto         Arreglo que indica si el inversor ha invertido en un proyecto específico.
     * @param cantidadInvertidaEnProyecto Arreglo que contiene la cantidad invertida en cada proyecto.
     * @param nombreProyecto              Arreglo que contiene los nombres de los proyectos disponibles.
     * @param categoriaProyecto           Arreglo que contiene las categorías de los proyectos.
     * @param cantidadNecesaria           Arreglo que contiene la cantidad necesaria para cada proyecto.
     * @param cantidadFinanciada          Arreglo que contiene la cantidad ya financiada para cada proyecto.
     * @param descripcionProyecto         Arreglo que contiene la descripción de cada proyecto.
     * @param recompensa1                 Arreglo que contiene la primera recompensa de cada proyecto.
     * @param recompensa2                 Arreglo que contiene la segunda recompensa de cada proyecto.
     * @param recompensa3                 Arreglo que contiene la tercera recompensa de cada proyecto.
     * @param posicionUsuario             Posición en el arreglo de usuarios que corresponde al inversor actual.
     */
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

    /**
     * Muestra las inversiones realizadas por el inversor.
     * <p>
     * Esta función recorre los proyectos en los que el inversor ha invertido y muestra la cantidad invertida en cada uno. Si el inversor no ha realizado ninguna inversión, se muestra un mensaje indicando que no se han realizado inversiones.
     *
     * @param invertido     Arreglo de valores booleanos que indica si el inversor ha invertido en un proyecto específico (true si ha invertido, false si no).
     * @param cantInvertida Arreglo que contiene la cantidad de dinero invertida en cada proyecto.
     */
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

    /**
     * Permite gestionar la cartera digital del inversor, añadiendo saldo disponible.
     * <p>
     * Esta función muestra el saldo disponible del inversor y le permite añadir una cantidad de dinero a su saldo. Si la cantidad es válida (mayor a 0), se añade al saldo. Si la cantidad es inválida (menor o igual a 0), se muestra un mensaje de error.
     *
     * @param saldo           Arreglo que contiene el saldo disponible para cada usuario. El índice del usuario es determinado por el parámetro `posicionUsuario`.
     * @param posicionUsuario Índice que representa la posición del usuario en el arreglo `saldo`, permitiendo acceder a su saldo.
     */
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

    /**
     * Permite gestionar la lista de referidos de un inversor, añadiendo un nuevo referido a su lista.
     * <p>
     * Esta función muestra los referidos actuales del inversor y le permite añadir un nuevo referido proporcionando su correo electrónico. El correo se añade a la lista de referidos, separando los existentes con comas. Si no hay referidos, se indica que no existen referidos previos.
     *
     * @param referidos Cadena de texto que contiene los correos electrónicos de los referidos actuales del inversor, separados por comas.
     * @return La cadena actualizada con el nuevo referido añadido al final.
     */
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

    /**
     * Permite al usuario configurar su cuenta, incluyendo la opción de cambiar su nombre de usuario o contraseña.
     * <p>
     * Esta función muestra un menú con tres opciones:
     * - Cambiar el nombre de usuario.
     * - Cambiar la contraseña.
     * - Volver al menú principal.
     * Según la opción seleccionada por el usuario, se ejecuta la acción correspondiente, pidiendo al usuario la nueva información necesaria.
     * <p>
     * Si elige una opción inválida, se muestra un mensaje de error.
     */
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

    /**
     * Muestra un menú de opciones relacionadas con los proyectos disponibles en la plataforma.
     * El usuario puede seleccionar entre varias opciones para interactuar con los proyectos.
     * <p>
     * Las opciones disponibles son:
     * 1. Listar proyectos: Muestra una lista con los proyectos disponibles.
     * 2. Ver detalles de un proyecto: Muestra información detallada sobre un proyecto específico.
     * 3. Invertir en un proyecto: Permite al usuario realizar una inversión en un proyecto.
     * 4. Volver al menú principal: Regresa al menú anterior.
     *
     * @param saldo                       El saldo disponible del usuario para realizar inversiones.
     * @param nombresProyectos            Los nombres de los proyectos disponibles.
     * @param categoriasProyectos         Las categorías de los proyectos disponibles.
     * @param necesario                   Las cantidades necesarias para financiar cada proyecto.
     * @param financiado                  Las cantidades ya financiadas para cada proyecto.
     * @param descripciones               Las descripciones de los proyectos disponibles.
     * @param recompensa1                 Las recompensas asociadas al primer nivel de los proyectos.
     * @param recompensa2                 Las recompensas asociadas al segundo nivel de los proyectos.
     * @param recompensa3                 Las recompensas asociadas al tercer nivel de los proyectos.
     * @param invertidoEnProyecto         Un arreglo booleano que indica si el usuario ha invertido en cada proyecto.
     * @param cantidadInvertidaEnProyecto El monto invertido por el usuario en cada proyecto.
     * @param posicionUsuario             La posición del usuario en el arreglo de usuarios (para acceder a su saldo e inversiones).
     */
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

    /**
     * Muestra un listado de los proyectos disponibles en la plataforma.
     * Para cada proyecto, se muestra su número de identificación, nombre, categoría,
     * cantidad necesaria para financiarlo y cantidad financiada hasta el momento.
     * <p>
     * El formato de salida es:
     * <pre>
     * N° | Proyecto              | Categoría     | Necesario | Financiado
     * ---------------------------------------------------------------
     * 1  | Proyecto X            | Tecnología    | 5000.00   | 3000.00
     * 2  | Proyecto Y            | Salud         | 2000.00   | 1500.00
     * </pre>
     *
     * @param nombres    Los nombres de los proyectos disponibles.
     * @param categorias Las categorías de los proyectos disponibles.
     * @param necesario  Las cantidades necesarias para financiar cada proyecto.
     * @param financiado Las cantidades ya financiadas para cada proyecto.
     */
    public static void listarProyectos(String[] nombres, String[] categorias, double[] necesario, double[] financiado) {
        System.out.println("\n--- Listado de Proyectos ---");
        System.out.printf("%-3s | %-20s | %-12s | %-10s | %-10s\n", "N°", "Proyecto", "Categoría", "Necesario", "Financiado");
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", i + 1, nombres[i], categorias[i], necesario[i], financiado[i]);
        }
    }

    /**
     * Muestra los detalles completos de un proyecto seleccionado por el usuario.
     * El usuario debe ingresar el número del proyecto para visualizar su nombre, categoría,
     * descripción, cantidad necesaria, cantidad financiada y recompensas asociadas.
     * Además, muestra un gráfico de barras del progreso de financiación y el porcentaje recaudado.
     *
     * @param nombres       Arreglo de nombres de los proyectos disponibles.
     * @param categorias    Arreglo de categorías de los proyectos disponibles.
     * @param descripciones Arreglo de descripciones de los proyectos disponibles.
     * @param necesario     Arreglo de cantidades necesarias para financiar cada proyecto.
     * @param financiado    Arreglo de cantidades ya financiadas para cada proyecto.
     * @param recompensa1   Arreglo de primeras recompensas de los proyectos disponibles.
     * @param recompensa2   Arreglo de segundas recompensas de los proyectos disponibles.
     * @param recompensa3   Arreglo de terceras recompensas de los proyectos disponibles.
     */
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

    /**
     * Permite al inversor realizar una inversión en un proyecto seleccionado.
     * El inversor elige el proyecto en el que desea invertir, especifica la cantidad a invertir
     * y la cantidad restante necesaria para financiar el proyecto. La inversión se realiza
     * si el inversor tiene suficiente saldo y la cantidad a invertir no excede el monto necesario
     * para completar el proyecto.
     *
     * @param saldo                       Arreglo de saldos disponibles para cada usuario en la plataforma.
     * @param necesario                   Arreglo de cantidades necesarias para financiar cada proyecto.
     * @param financiado                  Arreglo de cantidades ya financiadas para cada proyecto.
     * @param invertidoEnProyecto         Arreglo que indica si el usuario ha invertido en el proyecto.
     * @param cantidadInvertidaEnProyecto Arreglo con la cantidad invertida por el usuario en cada proyecto.
     * @param posicionUsuario             Índice que representa la posición del usuario en el arreglo de saldos.
     */
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

    /**
     * Muestra los detalles de un proyecto, incluyendo su nombre, categoría, descripción,
     * cantidad necesaria y cantidad financiada. También muestra las recompensas asociadas
     * al proyecto si están disponibles.
     *
     * @param nombre      Nombre del proyecto.
     * @param categoria   Categoría del proyecto.
     * @param descripcion Descripción detallada del proyecto.
     * @param necesario   Cantidad de dinero necesaria para financiar el proyecto.
     * @param financiado  Cantidad de dinero que ha sido financiada hasta el momento.
     * @param recompensa1 Recompensa 1 asociada al proyecto.
     * @param recompensa2 Recompensa 2 asociada al proyecto.
     * @param recompensa3 Recompensa 3 asociada al proyecto.
     */
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

    /**
     * Busca si un usuario introducido se encuentra en el array de usuarios.
     *
     * @param usuarioIntroducido El nombre del usuario que se busca en el array.
     * @param tipoDeUsuario      El array de usuarios en el que se realizará la búsqueda.
     * @return true si el usuario está en el array, false si no.
     */
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

    /**
     * Busca la posición de un usuario en el array de usuarios.
     *
     * @param usuario            El array de usuarios.
     * @param usuarioIntroducido El nombre del usuario cuya posición se busca.
     * @return El índice del usuario en el array, o -1 si no se encuentra.
     */
    public static int buscaPosicionUsuarioEnArray(String[] usuario, String usuarioIntroducido) {
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i].equals(usuarioIntroducido)) {
                return i; // Retorna la posición del usuario
            }
        }
        return -1; // Si no se encuentra el usuario
    }

    /**
     * Busca la primera posición vacía en un array de usuarios.
     *
     * @param usuario El array de usuarios en el que se busca la primera posición vacía.
     * @return El índice de la primera posición vacía, o -1 si no hay posiciones vacías.
     */
    public static int buscaPrimeraPosicionVacia(String[] usuario) {
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i].isEmpty()) {
                return i; // Retorna la primera posición vacía
            }
        }
        return -1; // Si no hay posiciones vacías
    }

}