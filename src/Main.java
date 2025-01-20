import java.util.Scanner;

import static biblioteca.Funciones.*;
import static biblioteca.FuncionesComprobacionCadenas.registroDeUsuario;

/**
 * La clase <code>Main</code> es la clase principal que gestiona el flujo del programa de acceso y operación
 * de una plataforma de inversión. Permite a los usuarios iniciar sesión, registrarse, y acceder a diferentes
 * menús según su rol (Administrador, Gestor o Inversor).
 * <p>
 * El sistema permite a los administradores gestionar usuarios y proyectos, a los gestores crear y modificar proyectos,
 * y a los inversores ver y financiar proyectos. Además, implementa un sistema de bloqueos de cuenta tras múltiples intentos
 * fallidos de inicio de sesión.
 * </p>
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * Este método gestiona el login de los usuarios y el acceso a los menús correspondientes según su rol.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de los usuarios y contraseñas
        String admin = "administrador";
        String passAdmin = "administrador";
        String[] passGestor = {"gestor1", "gestor2", "", "", "", "", "", "", "", ""};
        String[] passInversor = {"inversor1", "inversor2", "", "", "", "", "", "", "", ""};
        String[] inversor = {"inversor1", "inversor2", "", "", "", "", "", "", "", ""};
        String[] gestor = {"gestor1", "gestor2", "", "", "", "", "", "", "", ""};
        boolean estaEnArray;

        // Variables de los inversores
        boolean[] invertidoEnProyecto = {false, false, false};
        double[] cantidadInvertidaEnProyecto = {0.0, 0.0, 0.0};
        double[] saldoDisponibleInversor = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        String referidosInversor = "";

        // Variables de los bloqueos
        final int MAX_INTENTOS = 3;
        int[] intentos = {MAX_INTENTOS, MAX_INTENTOS, MAX_INTENTOS}; // [0]=gestor, [1]=inversor1, [2]=inversor2

        // Posición de usuario en los arrays: Gestor -> 0 / Inversor1 -> 1 / Inversor2 -> 2
        boolean[] bloqueados = {false, false, false};

        // Variables de proyectos
        String[] nombreProyecto = {"", "", ""};
        String[] descripcionProyecto = {"", "", ""};
        String[] categoriaProyecto = {"", "", ""};
        String[] fechaInicio = {"", "", ""};
        String[] fechaFin = {"", "", ""};
        double[] cantidadNecesaria = {0, 0, 0};
        double[] cantidadFinanciada = {0, 0, 0};
        String[] recompensa1 = {"", "", ""};
        String[] recompensa2 = {"", "", ""};
        String[] recompensa3 = {"", "", ""};
        int[] proyectosCreados = {0};

        // Control de acceso
        while (true) {
            int opcionLogin;
            do {
                System.out.println("\n------ Menú de Login ------");
                System.out.println("1. Inicio de Sesión");
                System.out.println("2. Registrarse");
                System.out.println("3. Salir");
                System.out.println("Elige una opción: ");
                opcionLogin = sc.nextInt();
                sc.nextLine();
                if (opcionLogin == 3) {
                    System.out.println("Saliendo del programa...");
                    return; // Terminar el programa
                }
                if (opcionLogin == 2) {
                    registroDeUsuario(inversor, gestor, passInversor, passGestor);
                } else if (opcionLogin != 1) {
                    System.out.println("Opción inválida.");
                }
            } while (opcionLogin != 1);

            // Solicitar el nombre de usuario e iniciar sesión
            System.out.println("\nIntroduce el usuario (o escribe 'salir' para terminar):");
            String usuarioIntroducido = sc.nextLine().toLowerCase().trim();

            if (usuarioIntroducido.equals("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            // Comprobar si el usuario es un gestor
            estaEnArray = buscaStringEnArray(usuarioIntroducido, gestor);
            if (estaEnArray) {
                int posicionUsuario = buscaPosicionUsuarioEnArray(gestor, usuarioIntroducido);
                if (bloqueados[0]) {
                    System.out.println("La cuenta del Gestor está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentos[0] > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passGestor[posicionUsuario])) {
                        System.out.println("Has accedido como Gestor.");
                        // Mostrar el menú gestor
                        while (true) {
                            int opcion = menuPrincipalGestor();
                            if (opcion == 1) {
                                mostrarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto, cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1, recompensa2, recompensa3);
                            } else if (opcion == 2) {
                                crearProyecto(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto, cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1, recompensa2, recompensa3);
                            } else if (opcion == 3) {
                                modificarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto, cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1, recompensa2, recompensa3);
                            } else if (opcion == 4) {
                                int opcionConfiguracion = menuConfiguracion();
                                if (opcionConfiguracion == 1) {
                                    gestor[posicionUsuario] = cambioNombre();
                                }
                                if (opcionConfiguracion == 2) {
                                    cambioPassword(passGestor, posicionUsuario);
                                }
                                if (opcionConfiguracion == 3) {
                                    System.out.println("Volviendo...");
                                }
                            } else if (opcion == 5) {
                                System.out.println("Saliendo del menú Gestor...");
                                break;
                            } else {
                                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                            }
                        }
                        break;
                    } else {
                        intentos[0]--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentos[0] + " intentos.");
                        if (intentos[0] == 0) {
                            bloqueados[0] = true;
                            System.out.println("La cuenta del Gestor ha sido bloqueada.");
                        }
                    }
                }
            }

            // Comprobar si el usuario es un inversor
            estaEnArray = buscaStringEnArray(usuarioIntroducido, inversor);
            if (estaEnArray) {
                int posicionUsuario = buscaPosicionUsuarioEnArray(inversor, usuarioIntroducido);
                if (bloqueados[posicionUsuario]) {
                    System.out.println("La cuenta del Inversor " + posicionUsuario + " está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentos[posicionUsuario] > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passInversor[posicionUsuario])) {
                        System.out.println("Has accedido como Inversor.");
                        menuInversor1(saldoDisponibleInversor, referidosInversor, invertidoEnProyecto, cantidadInvertidaEnProyecto, nombreProyecto, categoriaProyecto, cantidadNecesaria, cantidadFinanciada, descripcionProyecto, recompensa1, recompensa2, recompensa3, posicionUsuario);
                        break;
                    } else {
                        intentos[posicionUsuario]--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentos[posicionUsuario] + " intentos.");
                        if (intentos[posicionUsuario] == 0) {
                            bloqueados[posicionUsuario] = true;
                            System.out.println("La cuenta del Inversor " + posicionUsuario + " ha sido bloqueada.");
                        }
                    }
                }
            }

            // Comprobar si el usuario es un administrador
            else if (usuarioIntroducido.equals(admin)) {
                while (true) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passAdmin)) {
                        System.out.println("Has accedido como Administrador.");
                        while (true) {
                            int opcion = menuPrincipalAdmin();
                            if (opcion == 1) {
                                panelDeControl(bloqueados);
                                for (int i = 0; i < bloqueados.length; i++) {
                                    if (!bloqueados[i]) {
                                        intentos[i] = MAX_INTENTOS;
                                    }
                                }
                            } else if (opcion == 2) {
                                mostrarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto, cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1, recompensa2, recompensa3);
                            } else if (opcion == 3) {
                                modificarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto, cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1, recompensa2, recompensa3);
                            } else if (opcion == 4) {
                                int opcionConfiguracion = menuConfiguracion();
                                if (opcionConfiguracion == 1) {
                                    admin = cambioNombre();
                                }
                                if (opcionConfiguracion == 2) {
                                    passAdmin = cambioPasswordAdmin(passAdmin);
                                }
                                if (opcionConfiguracion == 3) {
                                    System.out.println("Volviendo...");
                                }
                            } else if (opcion == 5) {
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }
                }
            } else {
                System.out.println("Usuario no reconocido.");
            }
        }
    }
}