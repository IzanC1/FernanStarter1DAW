import java.util.Scanner;

import static biblioteca.funciones.*;
import static biblioteca.funcionesCorreo.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de los usuarios
        String admin = "administrador";
        String passAdmin = "administrador";
        String gestor = "gestor";
        String passGestor = "gestor";
        String inversor1 = "inversor1";
        String passInversor1 = "inversor1";
        String inversor2 = "inversor2";
        String passInversor2 = "inversor2";

        // Variables de los inversores
        boolean invertidoEnProyecto1_1 = false;
        boolean invertidoEnProyecto2_1 = false;
        boolean invertidoEnProyecto3_1 = false;
        boolean invertidoEnProyecto1_2 = false;
        boolean invertidoEnProyecto2_2 = false;
        boolean invertidoEnProyecto3_2 = false;

        double cantidadFinanciada1_1 = 0.0;
        double cantidadFinanciada2_1 = 0.0;
        double cantidadFinanciada3_1 = 0.0;
        double cantidadFinanciada1_2 = 0.0;
        double cantidadFinanciada2_2 = 0.0;
        double cantidadFinanciada3_2 = 0.0;
        double saldoDisponibleInversor1 = 0.0;
        double saldoDisponibleInversor2 = 0.0;

        String referidosInversor1 = "";
        String referidosInversor2 = "";

        // Variables de los bloqueos
        int intentosGestor = 3;
        int intentosInversor1 = 3;
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

        //Variables de proyectos
        String nombreProyecto1 = "";
        String descripcionProyecto1 = "";
        String categoriaProyecto1 = "";
        String fechaInicio1 = "";
        String fechaFin1 = "";
        double cantidadNecesaria1 = 0;
        double cantidadFinanciada1 = 0;
        String recompensa1_1 = "";
        String recompensa1_2 = "";
        String recompensa1_3 = "";

        String nombreProyecto2 = "";
        String descripcionProyecto2 = "";
        String categoriaProyecto2 = "";
        String fechaInicio2 = "";
        String fechaFin2 = "";
        double cantidadNecesaria2 = 0;
        double cantidadFinanciada2 = 0;
        String recompensa2_1 = "";
        String recompensa2_2 = "";
        String recompensa2_3 = "";

        String nombreProyecto3 = "";
        String descripcionProyecto3 = "";
        String categoriaProyecto3 = "";
        String fechaInicio3 = "";
        String fechaFin3 = "";
        double cantidadNecesaria3 = 0;
        double cantidadFinanciada3 = 0;
        String recompensa3_1 = "";
        String recompensa3_2 = "";
        String recompensa3_3 = "";



        // Control de acceso
        while (true) {
            System.out.println("\nIntroduce el usuario (o escribe 'salir' para terminar):");
            String usuario = sc.nextLine().toLowerCase().trim();

            if (usuario.equals("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            if (usuario.equals(gestor)) {
                if (bloqueados[0]) {
                    System.out.println("La cuenta del Gestor está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosGestor > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passGestor)) {
                        System.out.println("Has accedido como Gestor.");
                        intentosGestor = 3;

                        verificacionCorreo();

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
                                    gestor = cambioNombre(gestor);
                                }
                                if (opcionConfiguracion == 2) {
                                    passGestor = cambioPassword(passGestor);
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

            } else if (usuario.equals(inversor1)) {
                if (bloqueados[1]) {
                    System.out.println("La cuenta del Inversor1 está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosInversor1 > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passInversor1)) {
                        System.out.println("Has accedido como Inversor1.");
                        intentosInversor1 = 3;

                        //verificacionCorreo();

                        // INICIO MENÚ INVERSOR 1
                        menuInversor1(saldoDisponibleInversor1, referidosInversor1,
                                invertidoEnProyecto1_1, invertidoEnProyecto2_1, invertidoEnProyecto3_1,
                                cantidadFinanciada1_1, cantidadFinanciada2_1, cantidadFinanciada3_1,
                                nombreProyecto1, nombreProyecto2, nombreProyecto3,
                                categoriaProyecto1, categoriaProyecto2, categoriaProyecto3,
                                cantidadNecesaria1, cantidadNecesaria2, cantidadNecesaria3,
                                cantidadFinanciada1, cantidadFinanciada2, cantidadFinanciada3,
                                descripcionProyecto1, descripcionProyecto2, descripcionProyecto3,
                                recompensa1_1, recompensa1_2, recompensa1_3,
                                recompensa2_1, recompensa2_2, recompensa2_3,
                                recompensa3_1, recompensa3_2, recompensa3_3);
                        // FIN MENÚ INVERSOR 1

                        break;
                    } else {
                        intentosInversor1--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentosInversor1 + " intentos.");
                        if (intentosInversor1 == 0) {
                            bloqueados[1] = true;
                            System.out.println("La cuenta del Inversor1 ha sido bloqueada.");
                        }
                    }
                }

            } else if (usuario.equals(inversor2)) {
                if (bloqueados[2]) {
                    System.out.println("La cuenta del Inversor2 está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosInversor2 > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passInversor2)) {
                        System.out.println("Has accedido como Inversor2.");
                        intentosInversor2 = 3;

                        //verificacionCorreo();

                        // INICIO MENÚ INVERSOR 2
                        menuInversor2(saldoDisponibleInversor2, referidosInversor2,
                                invertidoEnProyecto1_2, invertidoEnProyecto2_2, invertidoEnProyecto3_2,
                                cantidadFinanciada1_2, cantidadFinanciada2_2, cantidadFinanciada3_2,
                                nombreProyecto1, nombreProyecto2, nombreProyecto3,
                                categoriaProyecto1, categoriaProyecto2, categoriaProyecto3,
                                cantidadNecesaria1, cantidadNecesaria2, cantidadNecesaria3,
                                cantidadFinanciada1, cantidadFinanciada2, cantidadFinanciada3,
                                descripcionProyecto1, descripcionProyecto2, descripcionProyecto3,
                                recompensa1_1, recompensa1_2, recompensa1_3,
                                recompensa2_1, recompensa2_2, recompensa2_3,
                                recompensa3_1, recompensa3_2, recompensa3_3);
                        // FIN MENÚ INVERSOR 2

                        break;
                    } else {
                        intentosInversor2--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentosInversor2 + " intentos.");
                        if (intentosInversor2 == 0) {
                            bloqueados[2] = true;
                            System.out.println("La cuenta del Inversor2 ha sido bloqueada.");
                        }
                    }
                }

            } else if (usuario.equals(admin)) {
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
                                if (bloqueados[1]) intentosInversor1 = 0;
                                else intentosInversor1 = 3;
                                if (bloqueados[2]) intentosInversor2 = 0;
                                else intentosInversor2 = 3;

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
                                    passAdmin = cambioPassword(passAdmin);
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