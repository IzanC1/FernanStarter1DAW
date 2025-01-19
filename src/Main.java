import java.util.Scanner;
import static utilidades.funcionesCadenas.*;
import static biblioteca.funcionesCorreo.*;
import static biblioteca.funcionesGenerales.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de los usuarios
        String admin = "administrador";
        String passAdmin = "administrador";
        /*String gestor = "gestor";
        String passGestor = "gestor";
        String inversor1 = "inversor1";*/
        String [] passGestor  = {"gestor1", "gestor2", "", "", "", "", "", "", "", ""};
        String [] passInversor  = {"inversor1", "inversor2", "", "", "", "", "", "", "", ""};
        String [] inversor  = {"inversor1", "inversor2", "", "", "", "", "", "", "", ""};
        String [] gestor  = {"gestor1", "gestor2", "", "", "", "", "", "", "", ""};
        boolean estaEnArray;

        // Variables de los inversores
        boolean [] invertidoEnProyecto = {false, false, false};
        double [] cantidadInvertidaEnProyecto = {0.0, 0.0, 0.0};

        double [] saldoDisponibleInversor  = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        double saldoDisponibleInversor2 = 0.0;

        String referidosInversor = "";


        // Variables de los bloqueos
        int intentosGestor = 3;
        int intentosInversor = 3;
        int intentosInversor2 = 3;

        // POSICIÓN DE USUARIO EN LOS ARRAYS: Gestor -> 0 / Inversor1 -> 1 / Inversor2 -> 2
        boolean[] bloqueados = {false, false, false};

        //Variables de proyectos: PROYECTO[0] -> PROYECTO 1 / PROYECTO[1] -> PROYECTO 2 / PROYECTO [2] -> PROYECTO 3
        String [] nombreProyecto = {"","",""};
        String [] descripcionProyecto = {"","",""};
        String [] categoriaProyecto = {"","",""};
        String [] fechaInicio = {"","",""};
        String [] fechaFin = {"","",""};
        double [] cantidadNecesaria = {0,0,0};
        double [] cantidadFinanciada = {0,0,0};
        String [] recompensa1 = {"","",""};
        String [] recompensa2 = {"","",""};
        String [] recompensa3 = {"","",""};
        int [] proyectosCreados = {0};


        // Control de acceso
        while (true) {
            int opcionLogin;
            do {
                System.out.println("\n------ Menú de Login ------");
                System.out.println("1. Inicio de Sesión");
                System.out.println("2. Registrarse");
                System.out.println("Elige una opcion: ");
                opcionLogin = sc.nextInt();
                sc.nextLine();
                if (opcionLogin == 2) registroDeUsuario(inversor, gestor, passInversor, passGestor);
                else if (opcionLogin != 1 && opcionLogin != 2) System.out.println("Opción inválida.");
            } while (opcionLogin != 1 && opcionLogin != 2);

            System.out.println("\nIntroduce el usuario (o escribe 'salir' para terminar):");
            String usuarioIntroducido = sc.nextLine().toLowerCase().trim();

            if (usuarioIntroducido.equals("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            estaEnArray = buscaStringEnArray(usuarioIntroducido, gestor);
            if (estaEnArray) {
                int posicionUsuario = buscaPosicionUsuarioEnArray(gestor, usuarioIntroducido);
                if (bloqueados[0]) {
                    System.out.println("La cuenta del Gestor está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosGestor > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passGestor[posicionUsuario])) {
                        System.out.println("Has accedido como Gestor.");
                        intentosGestor = 3;

                        //verificacionCorreo();

                        // INICIO MENÚ GESTOR
                        while (true) {
                            int opcion = menuPrincipalGestor();

                            if (opcion == 1) {
                                mostrarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto,
                                        cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1,
                                        recompensa2, recompensa3);

                            } else if (opcion == 2) {
                                crearProyecto(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto,
                                        cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1,
                                        recompensa2, recompensa3);

                            } else if (opcion == 3) {
                                modificarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto,
                                        cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1,
                                        recompensa2, recompensa3);

                            } else if (opcion == 4) {
                                int opcionConfiguracion = menuConfiguracion();
                                if (opcionConfiguracion == 1) {
                                    gestor[posicionUsuario] = cambioNombre(gestor[posicionUsuario]);
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
                                System.out.println("Opcion inválida. Por favor, selecciona una opcion válida.");
                            }

                        } // FIN MENÚ GESTOR
                        break;
                    } else {
                        intentosGestor--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentosGestor + " intentos.");
                        if (intentosGestor == 0) {
                            bloqueados[0] = true;
                            System.out.println("La cuenta del Gestor ha sido bloqueada.");
                        }
                    }
                }
            }
            estaEnArray = buscaStringEnArray(usuarioIntroducido, inversor);
            if (estaEnArray) {
                int posicionUsuario = buscaPosicionUsuarioEnArray(inversor, usuarioIntroducido);
                if (bloqueados[posicionUsuario]) {
                    System.out.println("La cuenta del Inversor "+posicionUsuario+" está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosInversor > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passInversor[posicionUsuario])) {
                        System.out.println("Has accedido como Inversor.");
                        intentosInversor = 3;

                        //verificacionCorreo();

                        // INICIO MENÚ INVERSOR
                        menuInversor1(saldoDisponibleInversor, referidosInversor,
                                invertidoEnProyecto,
                                cantidadInvertidaEnProyecto,
                                nombreProyecto,
                                categoriaProyecto,
                                fechaInicio, fechaFin,
                                cantidadNecesaria,
                                cantidadFinanciada,
                                descripcionProyecto,
                                recompensa1,
                                recompensa2,
                                recompensa3,
                                inversor, posicionUsuario);
                        // FIN MENÚ INVERSOR

                        break;
                    } else {
                        intentosInversor--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentosInversor + " intentos.");
                        if (intentosInversor == 0) {
                            bloqueados[1] = true;
                            System.out.println("La cuenta del Inversor1 ha sido bloqueada.");
                        }
                    }
                }

            } else if (usuarioIntroducido.equals(admin)) {
                while (true) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passAdmin)) {
                        System.out.println("Has accedido como Administrador.");

                        //verificacionCorreo();

                        // INICIO MENÚ ADMINISTRADOR
                        while (true) {
                            int opcion = menuPrincipalAdmin();

                            if (opcion == 1) {

                                panelDeControl(bloqueados);
                                if (bloqueados[0]) intentosGestor = 0;
                                else intentosGestor = 3;
                                if (bloqueados[1]) intentosInversor = 0;
                                else intentosInversor = 3;
                                /*if (bloqueados[2]) intentosInversor2 = 0;
                                else intentosInversor2 = 3;*/

                            } else if (opcion == 2) {
                                mostrarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto,
                                        cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1,
                                        recompensa2, recompensa3);

                            } else if (opcion == 3) {
                                modificarProyectos(proyectosCreados, nombreProyecto, descripcionProyecto, categoriaProyecto,
                                        cantidadNecesaria, cantidadFinanciada, fechaInicio, fechaFin, recompensa1,
                                        recompensa2, recompensa3);

                            } else if (opcion == 4) {
                                int opcionConfiguracion = menuConfiguracion();
                                if (opcionConfiguracion == 1) {
                                    admin = cambioNombre(admin);
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
                        // FIN MENÚ ADMINISTRADOR
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