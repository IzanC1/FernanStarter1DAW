import java.util.Scanner;

import static biblioteca.funciones.*;
import static biblioteca.funciones.GestorProyectos.*;
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

        boolean[] bloqueados = {false, false, false};
        // POSICIÓN DE USUARIO EN LOS ARRAYS: Gestor -> 0 / Inversor1 -> 1 / Inversor2 -> 2

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

        int proyectosCreados = 0;

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

                        //verificacionCorreo();

                        // INICIO MENÚ GESTOR
                        while (true) {
                            int opcion = menuPrincipalGestor();

                            if (opcion == 1) {
                                mostrarProyectos();

                            } else if (opcion == 2) {
                                crearProyecto();
                                if (proyectosCreados >= 3) {
                                    System.out.println("No se pueden crear mas proyectos. El limite son 3.");
                                }

                            } else if (opcion == 3) {
                                modificarProyecto();

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
                                System.out.println("\n--- Proyectos ---");
                                if (proyectosCreados == 0) {
                                    System.out.println("No hay proyectos creados aun");
                                }
                                if (proyectosCreados >= 1) {
                                    System.out.println("\nProyecto 1: ");
                                    System.out.println("Nombre: " + nombreProyecto1);
                                    System.out.println("Descripción: " + descripcionProyecto1);
                                    System.out.println("Categoría: " + categoriaProyecto1);
                                    System.out.println("Cantidad necesaria: " + cantidadNecesaria1);
                                    System.out.println("Cantidad financiada: " + cantidadFinanciada1);
                                    System.out.println("Fecha de inicio: " + fechaInicio1);
                                    System.out.println("Fecha de fin: " + fechaFin1);
                                    System.out.println("Recompensas: " + recompensa1_1 + ", " + recompensa1_2 + ", " + recompensa1_3);
                                    // BARRA DE PROGRESO PROYECTO 1
                                    int porcentaje = (int) ((cantidadFinanciada1 / cantidadNecesaria1) * 100);
                                    graficoBarras(porcentaje);
                                    System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
                                }

                                if (proyectosCreados >= 2) {
                                    System.out.println("\nProyecto 2:");
                                    System.out.println("Nombre: " + nombreProyecto2);
                                    System.out.println("Descripción: " + descripcionProyecto2);
                                    System.out.println("Categoría: " + categoriaProyecto2);
                                    System.out.println("Cantidad necesaria: " + cantidadNecesaria2);
                                    System.out.println("Cantidad financiada: " + cantidadFinanciada2);
                                    System.out.println("Fecha de inicio: " + fechaInicio2);
                                    System.out.println("Fecha de fin: " + fechaFin2);
                                    System.out.println("Recompensas: " + recompensa2_1 + ", " + recompensa2_2 + ", " + recompensa2_3);
                                    // BARRA DE PROGRESO PROYECTO 2
                                    int porcentaje = (int) ((cantidadFinanciada2 / cantidadNecesaria2) * 100);
                                    graficoBarras(porcentaje);
                                    System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
                                }

                                if (proyectosCreados >= 3) {
                                    System.out.println("\nProyecto 3:");
                                    System.out.println("Nombre: " + nombreProyecto3);
                                    System.out.println("Descripción: " + descripcionProyecto3);
                                    System.out.println("Categoría: " + categoriaProyecto3);
                                    System.out.println("Cantidad necesaria: " + cantidadNecesaria3);
                                    System.out.println("Cantidad financiada: " + cantidadFinanciada3);
                                    System.out.println("Fecha de inicio: " + fechaInicio3);
                                    System.out.println("Fecha de fin: " + fechaFin3);
                                    System.out.println("Recompensas: " + recompensa3_1 + ", " + recompensa3_2 + ", " + recompensa3_3);
                                    // BARRA DE PROGRESO PROYECTO 3
                                    int porcentaje = (int) ((cantidadFinanciada3 / cantidadNecesaria3) * 100);
                                    graficoBarras(porcentaje);
                                    System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
                                }

                            } else if (opcion == 3) {
                                System.out.println("\n1. Modificar proyecto 1 ");
                                System.out.println("2. Modificar proyecto 2 ");
                                System.out.println("3. Modificar proyecto 3 ");
                                System.out.println("4. Volver ");

                                int numProyecto = sc.nextInt();
                                sc.nextLine();

                                if (numProyecto == 4) {
                                    continue;
                                }
                                if (numProyecto < 1 || numProyecto > proyectosCreados) {
                                    System.out.println("Proyecto no válido.");
                                    continue;
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
                                    nombreProyecto1 = nuevoNombre;
                                    descripcionProyecto1 = nuevaDescripcion;
                                    categoriaProyecto1 = nuevaCategoria;
                                    cantidadNecesaria1 = nuevaCantidadNecesaria;
                                    cantidadFinanciada1 = nuevaCantidadFinanciada;
                                    fechaInicio1 = nuevaFechaInicio;
                                    fechaFin1 = nuevaFechaFin;
                                    recompensa1_1 = nuevaRecompensa1;
                                    recompensa1_2 = nuevaRecompensa2;
                                    recompensa1_3 = nuevaRecompensa3;
                                } else if (numProyecto == 2) {
                                    nombreProyecto2 = nuevoNombre;
                                    descripcionProyecto2 = nuevaDescripcion;
                                    categoriaProyecto2 = nuevaCategoria;
                                    cantidadNecesaria2 = nuevaCantidadNecesaria;
                                    cantidadFinanciada2 = nuevaCantidadFinanciada;
                                    fechaInicio2 = nuevaFechaInicio;
                                    fechaFin2 = nuevaFechaFin;
                                    recompensa2_1 = nuevaRecompensa1;
                                    recompensa2_2 = nuevaRecompensa2;
                                    recompensa2_3 = nuevaRecompensa3;
                                } else if (numProyecto == 3) {
                                    nombreProyecto3 = nuevoNombre;
                                    descripcionProyecto3 = nuevaDescripcion;
                                    categoriaProyecto3 = nuevaCategoria;
                                    cantidadNecesaria3 = nuevaCantidadNecesaria;
                                    cantidadFinanciada3 = nuevaCantidadFinanciada;
                                    fechaInicio3 = nuevaFechaInicio;
                                    fechaFin3 = nuevaFechaFin;
                                    recompensa3_1 = nuevaRecompensa1;
                                    recompensa3_2 = nuevaRecompensa2;
                                    recompensa3_3 = nuevaRecompensa3;
                                }

                                System.out.println("Proyecto modificado con éxito.");

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
                        } // FIN MENÚ ADMINISTRADOR
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