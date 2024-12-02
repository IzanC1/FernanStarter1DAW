import java.util.Scanner;

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

        boolean bloqueadoGestor = false;
        boolean bloqueadoInversor1 = false;
        boolean bloqueadoInversor2 = false;

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
                if (bloqueadoGestor) {
                    System.out.println("La cuenta del Gestor está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosGestor > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passGestor)) {
                        System.out.println("Has accedido como Gestor.");
                        intentosGestor = 3;

                        // INICIO MENÚ GESTOR
                        while (true) {
                            System.out.println("\n\033[34m--- Menú Gestor ---\033[0m");
                            System.out.println("1. Mostrar todos los proyectos de la plataforma");
                            System.out.println("2. Crear un nuevo proyecto");
                            System.out.println("3. Modificar un proyecto existente");
                            System.out.println("4. Configuración");
                            System.out.println("5. Cerrar Sesión");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion == 1) {
                                System.out.println("\nMostrando todos los proyectos de la plataforma...");
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
                                    System.out.print("\033[35m[");
                                    for (int i = 0; i <= 100; i++) {
                                        if (i <= porcentaje) {
                                            System.out.print("■");
                                        } else {
                                            System.out.print("_");
                                        }
                                    }
                                    System.out.print("]\033[39m");
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
                                    System.out.print("\033[35m[");
                                    for (int i = 0; i <= 100; i++) {
                                        if (i <= porcentaje) {
                                            System.out.print("■");
                                        } else {
                                            System.out.print("_");
                                        }
                                    }
                                    System.out.print("]\033[39m");
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
                                    System.out.print("\033[35m[");
                                    for (int i = 0; i <= 100; i++) {
                                        if (i <= porcentaje) {
                                            System.out.print("■");
                                        } else {
                                            System.out.print("_");
                                        }
                                    }
                                    System.out.print("]\033[39m");
                                    System.out.println("\nEste proyecto ha recaudado el " + porcentaje + "%");
                                }

                            } else if (opcion == 2) {
                                if (proyectosCreados >= 3) {
                                    System.out.println("No se pueden crear mas proyectos. El limite son 3.");
                                    continue;
                                }

                                System.out.println("\nCreando un nuevo proyecto...");
                                System.out.print("Introduce el nombre del proyecto: ");
                                String nombre = sc.nextLine();
                                System.out.print("Introduce la descripción del proyecto: ");
                                String descripcion = sc.nextLine();
                                System.out.print("Introduce la categoría del proyecto: ");
                                String categoria = sc.nextLine();
                                System.out.print("Introduce la cantidad necesaria: ");
                                double cantidadNecesaria = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Introduce la cantidad financiada: ");
                                double cantidadFinanciada = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Introduce la fecha de inicio (formato DD/MM/AAAA): ");
                                String fechaInicio = sc.nextLine();
                                System.out.print("Introduce la fecha de fin (formato DD/MM/AAAA): ");
                                String fechaFin = sc.nextLine();
                                System.out.println("Introduce las recompensas:");
                                System.out.print("Recompensa 1: ");
                                String recompensa1 = sc.nextLine();
                                System.out.print("Recompensa 2: ");
                                String recompensa2 = sc.nextLine();
                                System.out.print("Recompensa 3: ");
                                String recompensa3 = sc.nextLine();
                                proyectosCreados++;

                                if (proyectosCreados == 1) {
                                    nombreProyecto1 = nombre;
                                    descripcionProyecto1 = descripcion;
                                    categoriaProyecto1 = categoria;
                                    cantidadNecesaria1 = cantidadNecesaria;
                                    cantidadFinanciada1 = cantidadFinanciada;
                                    fechaInicio1 = fechaInicio;
                                    fechaFin1 = fechaFin;
                                    recompensa1_1 = recompensa1;
                                    recompensa1_2 = recompensa2;
                                    recompensa1_3 = recompensa3;
                                } else if (proyectosCreados == 2) {
                                    nombreProyecto2 = nombre;
                                    descripcionProyecto2 = descripcion;
                                    categoriaProyecto2 = categoria;
                                    cantidadNecesaria2 = cantidadNecesaria;
                                    cantidadFinanciada2 = cantidadFinanciada;
                                    fechaInicio2 = fechaInicio;
                                    fechaFin2 = fechaFin;
                                    recompensa2_1 = recompensa1;
                                    recompensa2_2 = recompensa2;
                                    recompensa2_3 = recompensa3;
                                } else if (proyectosCreados == 3) {
                                    nombreProyecto3 = nombre;
                                    descripcionProyecto3 = descripcion;
                                    categoriaProyecto3 = categoria;
                                    cantidadNecesaria3 = cantidadNecesaria;
                                    cantidadFinanciada3 = cantidadFinanciada;
                                    fechaInicio3 = fechaInicio;
                                    fechaFin3 = fechaFin;
                                    recompensa3_1 = recompensa1;
                                    recompensa3_2 = recompensa2;
                                    recompensa3_3 = recompensa3;
                                }
                                System.out.println("Proyecto creado exitosamente.");
                            } else if (opcion == 3) {
                                System.out.println("\n1. Modificar proyecto 1 ");
                                System.out.println("2. Modificar proyecto 2 ");
                                System.out.println("3. Modificar proyecto 3 ");
                                System.out.println("4. Volver ");
                                int numProyecto = sc.nextInt();
                                sc.nextLine();
                                if (numProyecto == 4){
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
                                System.out.println("\nConfiguración de la cuenta: ");
                                System.out.println("¿Que opción desea?");
                                System.out.println("1. Cambiar nombre de usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Volver");
                                int opcionUsuarioPassword = sc.nextInt();
                                sc.nextLine();
                                if (opcionUsuarioPassword == 1) {
                                    System.out.println("Ingrese su nuevo nombre de usuario");
                                    gestor = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Has reestablecido su nombre de usuario");
                                }
                                if (opcionUsuarioPassword == 2) {
                                    System.out.println("Ingrese la nueva contraseña");
                                    passGestor = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Has reestablecido su contraseña");
                                }
                                if (opcionUsuarioPassword == 3) {
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
                            bloqueadoGestor = true;
                            System.out.println("La cuenta del Gestor ha sido bloqueada.");
                        }
                    }
                }

            } else if (usuario.equals(inversor1)) {
                if (bloqueadoInversor1) {
                    System.out.println("La cuenta del Inversor1 está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosInversor1 > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passInversor1)) {
                        System.out.println("Has accedido como Inversor1.");
                        intentosInversor1 = 3;

                        // INICIO MENÚ INVERSOR 1
                        while (true) {
                            // Menú principal inversor 1
                            System.out.println("\n\033[32m--- Menú Inversor 1 ---\033[0m");
                            System.out.println("1. Mis inversiones");
                            System.out.println("2. Proyectos Disponibles");
                            System.out.println("3. Cartera digital");
                            System.out.println("4. Referidos");
                            System.out.println("5. Configuración");
                            System.out.println("6. Cerrar sesión");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();

                            if (opcion == 1) {
                                System.out.println("\n--- Mis Inversiones ---");
                                // Mostrar inversiones para inversor 1
                                if (invertidoEnProyecto1_1) {
                                    System.out.println("Inversión en " + nombreProyecto1 + " por " + cantidadFinanciada1_1);
                                }
                                if (invertidoEnProyecto2_1) {
                                    System.out.println("Inversión en " + nombreProyecto2 + " por " + cantidadFinanciada2_1);
                                }
                                if (invertidoEnProyecto3_1) {
                                    System.out.println("Inversión en " + nombreProyecto3 + " por " + cantidadFinanciada3_1);
                                }
                                if (!invertidoEnProyecto1_1 && !invertidoEnProyecto2_1 && !invertidoEnProyecto3_1) {
                                    System.out.println("Aún no has realizado ninguna inversión.");
                                }
                            } else if (opcion == 2) {
                                while (true) {
                                    System.out.println("\n--- Proyectos Disponibles ---");
                                    System.out.println("1. Listar proyectos");
                                    System.out.println("2. Ver detalles de un proyecto");
                                    System.out.println("3. Invertir en un proyecto");
                                    System.out.println("4. Volver al menú principal");
                                    System.out.print("Selecciona una opción: ");
                                    int opcionProyectos = sc.nextInt();

                                    if (opcionProyectos == 1) {
                                        System.out.println("\n--- Listado de Proyectos ---");
                                        System.out.printf("%-3s | %-20s | %-12s | %-10s | %-10s\n", "N°", "Proyecto", "Categoría", "Necesario", "Financiado");
                                        System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", 1, nombreProyecto1, categoriaProyecto1, cantidadNecesaria1, cantidadFinanciada1);
                                        System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", 2, nombreProyecto2, categoriaProyecto2, cantidadNecesaria2, cantidadFinanciada2);
                                        System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", 3, nombreProyecto3, categoriaProyecto3, cantidadNecesaria3, cantidadFinanciada3);
                                    } else if (opcionProyectos == 2) {
                                        System.out.print("\nSelecciona el número del proyecto (1-3): ");
                                        int proyectoSeleccionado = sc.nextInt();
                                        // Mostrar detalles del proyecto
                                        if (proyectoSeleccionado == 1) {
                                            System.out.println("\n--- Detalles del Proyecto ---");
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Cantidad Necesaria: " + cantidadNecesaria1);
                                            System.out.println("Cantidad Financiada: " + cantidadFinanciada1);
                                            System.out.println("Cantidad Restante: " + (cantidadNecesaria1 - cantidadFinanciada1));
                                            System.out.println("Fecha inicio de apertura para recibir inversiones: " + fechaInicio1);
                                            System.out.println("Fecha fin de cierre de las inversiones: " + fechaFin1);
                                            System.out.println("*** RECOMPENSAS ***");
                                            System.out.println("Recompensa 1: " + recompensa1_1);
                                            System.out.println("Recompensa 2: " + recompensa1_2);
                                            System.out.println("Recompensa 3: " + recompensa1_3);
                                            sc.nextLine();
                                            sc.nextLine();
                                        } else if (proyectoSeleccionado == 2) {
                                            System.out.println("\n--- Detalles del Proyecto ---");
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Cantidad Necesaria: " + cantidadNecesaria2);
                                            System.out.println("Cantidad Financiada: " + cantidadFinanciada2);
                                            System.out.println("Cantidad Restante: " + (cantidadNecesaria2 - cantidadFinanciada2));
                                            System.out.println("Fecha inicio de apertura para recibir inversiones: " + fechaInicio2);
                                            System.out.println("Fecha fin de cierre de las inversiones: " + fechaFin2);
                                            System.out.println("*** RECOMPENSAS ***");
                                            System.out.println("Recompensa 1: " + recompensa2_1);
                                            System.out.println("Recompensa 2: " + recompensa2_2);
                                            System.out.println("Recompensa 3: " + recompensa2_3);
                                            sc.nextLine();
                                            sc.nextLine();
                                        } else if (proyectoSeleccionado == 3) {
                                            System.out.println("\n--- Detalles del Proyecto ---");
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Cantidad Necesaria: " + cantidadNecesaria3);
                                            System.out.println("Cantidad Financiada: " + cantidadFinanciada3);
                                            System.out.println("Cantidad Restante: " + (cantidadNecesaria3 - cantidadFinanciada3));
                                            System.out.println("Fecha inicio de apertura para recibir inversiones: " + fechaInicio3);
                                            System.out.println("Fecha fin de cierre de las inversiones: " + fechaFin3);
                                            System.out.println("*** RECOMPENSAS ***");
                                            System.out.println("Recompensa 1: " + recompensa3_1);
                                            System.out.println("Recompensa 2: " + recompensa3_2);
                                            System.out.println("Recompensa 3: " + recompensa3_3);
                                            sc.nextLine();
                                            sc.nextLine();
                                        } else {
                                            System.out.println("Proyecto no encontrado.");
                                        }
                                    } else if (opcionProyectos == 3) {
                                        System.out.print("\nSelecciona el número del proyecto para invertir (1-3): ");
                                        int proyectoInvertir = sc.nextInt();
                                        if (proyectoInvertir == 1 || proyectoInvertir == 2 || proyectoInvertir == 3) {
                                            double cantidadRestante = proyectoInvertir == 1 ? (cantidadNecesaria1 - cantidadFinanciada1) : proyectoInvertir == 2 ? (cantidadNecesaria2 - cantidadFinanciada2) : (cantidadNecesaria3 - cantidadFinanciada3);

                                            System.out.println("Cantidad restante para financiar: " + cantidadRestante);
                                            System.out.print("¿Cuánto deseas invertir? (Saldo disponible: " + saldoDisponibleInversor1 + "): ");
                                            double cantidadInvertir = sc.nextDouble();

                                            if (cantidadInvertir > 0 && cantidadInvertir <= saldoDisponibleInversor1 && cantidadInvertir <= cantidadRestante) {
                                                if (proyectoInvertir == 1) {
                                                    cantidadFinanciada1 += cantidadInvertir;
                                                    invertidoEnProyecto1_1 = true;  // Marcar como invertido
                                                } else if (proyectoInvertir == 2) {
                                                    cantidadFinanciada2 += cantidadInvertir;
                                                    invertidoEnProyecto2_1 = true;  // Marcar como invertido
                                                } else {
                                                    cantidadFinanciada3 += cantidadInvertir;
                                                    invertidoEnProyecto3_1 = true;  // Marcar como invertido
                                                }

                                                saldoDisponibleInversor1 -= cantidadInvertir;
                                                System.out.println("Inversión realizada con éxito.");
                                            } else {
                                                System.out.println("Cantidad inválida.");
                                            }
                                        } else {
                                            System.out.println("Proyecto no encontrado.");
                                        }
                                    } else if (opcionProyectos == 4) {
                                        break;
                                    } else {
                                        System.out.println("Opción inválida.");
                                    }
                                }
                            } else if (opcion == 3) {
                                System.out.println("\n--- Cartera Digital ---");
                                System.out.println("Saldo disponible: " + saldoDisponibleInversor1);
                                System.out.print("¿Cuánto deseas añadir a tu saldo? ");
                                double cantidad = sc.nextDouble();
                                if (cantidad > 0) {
                                    saldoDisponibleInversor1 += cantidad;
                                    System.out.println("Saldo añadido con éxito.");
                                } else {
                                    System.out.println("Cantidad inválida.");
                                }
                            } else if (opcion == 4) {
                                System.out.println("\n--- Referidos ---");
                                System.out.println("Referidos actuales: " + (referidosInversor1.isEmpty() ? "Ninguno" : referidosInversor1));
                                System.out.print("Introduce el correo del nuevo referido: ");
                                sc.nextLine();
                                String nuevoReferido = sc.nextLine();
                                referidosInversor1 += (referidosInversor1.isEmpty() ? "" : ", ") + nuevoReferido;
                                System.out.println("Referido añadido con éxito.");
                            } else if (opcion == 5) {
                                System.out.println("\n--- Configuración ---");
                                System.out.println("1. Cambiar nombre de usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Volver");
                                int configuracion = sc.nextInt();
                                sc.nextLine();

                                if (configuracion == 1) {
                                    System.out.print("Introduce el nuevo nombre de usuario: ");
                                    inversor1 = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Nombre de usuario cambiado.");
                                } else if (configuracion == 2) {
                                    System.out.print("Introduce la nueva contraseña: ");
                                    passInversor1 = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Contraseña cambiada.");
                                } else if (configuracion == 3) {
                                    System.out.println("Volviendo al menú...");
                                } else {
                                    System.out.println("Opción inválida.");
                                }
                            } else if (opcion == 6) {
                                System.out.println("Sesión cerrada.");
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        }
// FIN MENÚ INVERSOR 1

                        break;
                    } else {
                        intentosInversor1--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentosInversor1 + " intentos.");
                        if (intentosInversor1 == 0) {
                            bloqueadoInversor1 = true;
                            System.out.println("La cuenta del Inversor1 ha sido bloqueada.");
                        }
                    }
                }

            } else if (usuario.equals(inversor2)) {
                if (bloqueadoInversor2) {
                    System.out.println("La cuenta del Inversor2 está bloqueada. Contacte con el administrador.");
                    continue;
                }
                while (intentosInversor2 > 0) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passInversor2)) {
                        System.out.println("Has accedido como Inversor2.");
                        intentosInversor2 = 3;

                        // INICIO MENÚ INVERSOR 2
                        while (true) {
                            // Menú principal inversor 2
                            System.out.println("\n\033[32m--- Menú Inversor 2 ---\033[0m");
                            System.out.println("1. Mis inversiones");
                            System.out.println("2. Proyectos Disponibles");
                            System.out.println("3. Cartera digital");
                            System.out.println("4. Referidos");
                            System.out.println("5. Configuración");
                            System.out.println("6. Cerrar sesión");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();

                            if (opcion == 1) {
                                System.out.println("\n--- Mis Inversiones ---");
                                // Mostrar inversiones para inversor 2
                                if (invertidoEnProyecto1_2) {
                                    System.out.println("Inversión en " + nombreProyecto1 + " por " + cantidadFinanciada1_2);
                                }
                                if (invertidoEnProyecto2_2) {
                                    System.out.println("Inversión en " + nombreProyecto2 + " por " + invertidoEnProyecto2_2);
                                }
                                if (invertidoEnProyecto3_2) {
                                    System.out.println("Inversión en " + nombreProyecto3 + " por " + cantidadFinanciada3_2);
                                }
                                if (!invertidoEnProyecto1_2 && !invertidoEnProyecto2_2 && !invertidoEnProyecto3_2) {
                                    System.out.println("Aún no has realizado ninguna inversión.");
                                }
                            } else if (opcion == 2) {
                                while (true) {
                                    System.out.println("\n--- Proyectos Disponibles ---");
                                    System.out.println("1. Listar proyectos");
                                    System.out.println("2. Ver detalles de un proyecto");
                                    System.out.println("3. Invertir en un proyecto");
                                    System.out.println("4. Volver al menú principal");
                                    System.out.print("Selecciona una opción: ");
                                    int opcionProyectos = sc.nextInt();

                                    if (opcionProyectos == 1) {
                                        System.out.println("\n--- Listado de Proyectos ---");
                                        System.out.printf("%-3s | %-20s | %-12s | %-10s | %-10s\n", "N°", "Proyecto", "Categoría", "Necesario", "Financiado");
                                        System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", 1, nombreProyecto1, categoriaProyecto1, cantidadNecesaria1, cantidadFinanciada1);
                                        System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", 2, nombreProyecto2, categoriaProyecto2, cantidadNecesaria2, cantidadFinanciada2);
                                        System.out.printf("%-3d | %-20s | %-12s | %-10.2f | %-10.2f\n", 3, nombreProyecto3, categoriaProyecto3, cantidadNecesaria3, cantidadFinanciada3);
                                    } else if (opcionProyectos == 2) {
                                        System.out.print("\nSelecciona el número del proyecto (1-3): ");
                                        int proyectoSeleccionado = sc.nextInt();
                                        // Mostrar detalles del proyecto
                                        if (proyectoSeleccionado == 1) {
                                            System.out.println("\n--- Detalles del Proyecto ---");
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Cantidad Necesaria: " + cantidadNecesaria1);
                                            System.out.println("Cantidad Financiada: " + cantidadFinanciada1);
                                            System.out.println("Cantidad Restante: " + (cantidadNecesaria1 - cantidadFinanciada1));
                                            System.out.println("Fecha inicio de apertura para recibir inversiones: " + fechaInicio1);
                                            System.out.println("Fecha fin de cierre de las inversiones: " + fechaFin1);
                                            System.out.println("*** RECOMPENSAS ***");
                                            System.out.println("Recompensa 1: " + recompensa1_1);
                                            System.out.println("Recompensa 2: " + recompensa1_2);
                                            System.out.println("Recompensa 3: " + recompensa1_3);
                                            sc.nextLine();
                                            sc.nextLine();
                                        } else if (proyectoSeleccionado == 2) {
                                            System.out.println("\n--- Detalles del Proyecto ---");
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Cantidad Necesaria: " + cantidadNecesaria2);
                                            System.out.println("Cantidad Financiada: " + cantidadFinanciada2);
                                            System.out.println("Cantidad Restante: " + (cantidadNecesaria2 - cantidadFinanciada2));
                                            System.out.println("Fecha inicio de apertura para recibir inversiones: " + fechaInicio2);
                                            System.out.println("Fecha fin de cierre de las inversiones: " + fechaFin2);
                                            System.out.println("*** RECOMPENSAS ***");
                                            System.out.println("Recompensa 1: " + recompensa2_1);
                                            System.out.println("Recompensa 2: " + recompensa2_2);
                                            System.out.println("Recompensa 3: " + recompensa2_3);
                                            sc.nextLine();
                                            sc.nextLine();
                                        } else if (proyectoSeleccionado == 3) {
                                            System.out.println("\n--- Detalles del Proyecto ---");
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Cantidad Necesaria: " + cantidadNecesaria3);
                                            System.out.println("Cantidad Financiada: " + cantidadFinanciada3);
                                            System.out.println("Cantidad Restante: " + (cantidadNecesaria3 - cantidadFinanciada3));
                                            System.out.println("Fecha inicio de apertura para recibir inversiones: " + fechaInicio3);
                                            System.out.println("Fecha fin de cierre de las inversiones: " + fechaFin3);
                                            System.out.println("*** RECOMPENSAS ***");
                                            System.out.println("Recompensa 1: " + recompensa3_1);
                                            System.out.println("Recompensa 2: " + recompensa3_2);
                                            System.out.println("Recompensa 3: " + recompensa3_3);
                                            sc.nextLine();
                                            sc.nextLine();
                                        } else {
                                            System.out.println("Proyecto no encontrado.");
                                        }
                                    } else if (opcionProyectos == 3) {
                                        System.out.print("\nSelecciona el número del proyecto para invertir (1-3): ");
                                        int proyectoInvertir = sc.nextInt();
                                        if (proyectoInvertir == 1 || proyectoInvertir == 2 || proyectoInvertir == 3) {
                                            double cantidadRestante = proyectoInvertir == 1 ? (cantidadNecesaria1 - cantidadFinanciada1) : proyectoInvertir == 2 ? (cantidadNecesaria2 - cantidadFinanciada2) : (cantidadNecesaria3 - cantidadFinanciada3);

                                            System.out.println("Cantidad restante para financiar: " + cantidadRestante);
                                            System.out.print("¿Cuánto deseas invertir? (Saldo disponible: " + saldoDisponibleInversor2 + "): ");
                                            double cantidadInvertir = sc.nextDouble();

                                            if (cantidadInvertir > 0 && cantidadInvertir <= saldoDisponibleInversor2 && cantidadInvertir <= cantidadRestante) {
                                                if (proyectoInvertir == 1) {
                                                    cantidadFinanciada1 += cantidadInvertir;
                                                    invertidoEnProyecto1_2 = true;  // Marcar como invertido
                                                } else if (proyectoInvertir == 2) {
                                                    cantidadFinanciada2 += cantidadInvertir;
                                                    invertidoEnProyecto2_2 = true;  // Marcar como invertido
                                                } else {
                                                    cantidadFinanciada3 += cantidadInvertir;
                                                    invertidoEnProyecto3_2 = true;  // Marcar como invertido
                                                }

                                                saldoDisponibleInversor2 -= cantidadInvertir;
                                                System.out.println("Inversión realizada con éxito.");
                                            } else {
                                                System.out.println("Cantidad inválida.");
                                            }
                                        } else {
                                            System.out.println("Proyecto no encontrado.");
                                        }
                                    } else if (opcionProyectos == 4) {
                                        break;
                                    } else {
                                        System.out.println("Opción inválida.");
                                    }
                                }
                            } else if (opcion == 3) {
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
                            } else if (opcion == 4) {
                                System.out.println("\n--- Referidos ---");
                                System.out.println("Referidos actuales: " + (referidosInversor2.isEmpty() ? "Ninguno" : referidosInversor2));
                                System.out.print("Introduce el correo del nuevo referido: ");
                                sc.nextLine();
                                String nuevoReferido = sc.nextLine();
                                referidosInversor2 += (referidosInversor2.isEmpty() ? "" : ", ") + nuevoReferido;
                                System.out.println("Referido añadido con éxito.");
                            } else if (opcion == 5) {
                                System.out.println("\n--- Configuración ---");
                                System.out.println("1. Cambiar nombre de usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Volver");
                                int configuracion = sc.nextInt();
                                sc.nextLine();

                                if (configuracion == 1) {
                                    inversor2 = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Nombre de usuario cambiado.");
                                } else if (configuracion == 2) {
                                    passInversor2 = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Contraseña cambiada.");
                                } else if (configuracion == 3) {
                                    System.out.println("Volviendo al menú...");
                                } else {
                                    System.out.println("Opción inválida.");
                                }
                            } else if (opcion == 6) {
                                System.out.println("Sesión cerrada.");
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        }
                        // FIN MENÚ INVERSOR 2

                        break;
                    } else {
                        intentosInversor2--;
                        System.out.println("Contraseña incorrecta. Te quedan " + intentosInversor2 + " intentos.");
                        if (intentosInversor2 == 0) {
                            bloqueadoInversor2 = true;
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

                        // INICIO MENÚ ADMINISTRADOR
                        while (true) {
                            System.out.println("\n\033[38;5;214m--- Menú Administrador ---\033[39m");
                            System.out.println("1. Panel de control");
                            System.out.println("2. Mostrar todos los proyectos de la plataforma");
                            System.out.println("3. Modificar un proyecto existente");
                            System.out.println("4. Configuración");
                            System.out.println("5. Cerrar sesión");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion == 1) {
                                int opcionPanelControl;
                                do {
                                    System.out.println("\n--- Panel de Control ---");
                                    System.out.println("1. Bloquear usuario");
                                    System.out.println("2. Desbloquear usuario");
                                    System.out.println("3. Volver");
                                    opcionPanelControl = sc.nextInt();
                                    sc.nextLine();
                                } while (opcionPanelControl != 1 && opcionPanelControl != 2 && opcionPanelControl != 3);
                                switch (opcionPanelControl) {
                                    case 1:
                                        int opcionBloqueo;
                                        do {
                                            System.out.println("\n¿A qué usuario bloquear?");
                                            System.out.println("1. Usuario Inversor 1");
                                            System.out.println("2. Usuario Inversor 2");
                                            System.out.println("3. Usuario Gestor");
                                            System.out.println("4. Volver al Menú Administrador");
                                            opcionBloqueo = sc.nextInt();
                                            sc.nextLine();
                                        } while (opcionBloqueo != 1 && opcionBloqueo != 2 && opcionBloqueo != 3 && opcionBloqueo != 4);
                                        switch (opcionBloqueo) {
                                            case 1:
                                                bloqueadoInversor1 = true;
                                                intentosInversor1 = 0;
                                                System.out.println("Has bloqueado al Inversor 1 correctamente");
                                                break;
                                            case 2:
                                                bloqueadoInversor2 = true;
                                                intentosInversor2 = 0;
                                                System.out.println("Has bloqueado al Inversor 2 correctamente");
                                                break;
                                            case 3:
                                                bloqueadoGestor = true;
                                                intentosGestor = 0;
                                                System.out.println("Has bloqueado al Gestor correctamente");
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        int opcionDesbloqueo;
                                        do {
                                            System.out.println("\n¿A qué usuario desbloquear?");
                                            System.out.println("1. Usuario Inversor 1");
                                            System.out.println("2. Usuario Inversor 2");
                                            System.out.println("3. Usuario Gestor");
                                            System.out.println("4. Volver");
                                            opcionDesbloqueo = sc.nextInt();
                                            sc.nextLine();
                                        } while (opcionDesbloqueo != 1 && opcionDesbloqueo != 2 && opcionDesbloqueo != 3 && opcionDesbloqueo != 4);
                                        switch (opcionDesbloqueo) {
                                            case 1:
                                                bloqueadoInversor1 = false;
                                                intentosInversor1 = 3;
                                                System.out.println("Has desbloqueado al Inversor 1 correctamente");
                                                break;
                                            case 2:
                                                bloqueadoInversor2 = false;
                                                intentosInversor2 = 3;
                                                System.out.println("Has desbloqueado al Inversor 2 correctamente");
                                                break;
                                            case 3:
                                                bloqueadoGestor = false;
                                                intentosGestor = 3;
                                                System.out.println("Has desbloqueado al Gestor correctamente");
                                                break;
                                            case 4:
                                                break;
                                        }
                                    case 3:
                                        break;
                                }

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
                                    System.out.print("\033[35m[");
                                    for (int i = 0; i <= 100; i++) {
                                        if (i <= porcentaje) {
                                            System.out.print("■");
                                        } else {
                                            System.out.print("_");
                                        }
                                    }
                                    System.out.print("]\033[39m");
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
                                    System.out.print("\033[35m[");
                                    for (int i = 0; i <= 100; i++) {
                                        if (i <= porcentaje) {
                                            System.out.print("■");
                                        } else {
                                            System.out.print("_");
                                        }
                                    }
                                    System.out.print("]\033[39m");
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
                                    System.out.print("\033[35m[");
                                    for (int i = 0; i <= 100; i++) {
                                        if (i <= porcentaje) {
                                            System.out.print("■");
                                        } else {
                                            System.out.print("_");
                                        }
                                    }
                                    System.out.print("]\033[39m");
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
                                System.out.println("\n--- Configuración ---");
                                System.out.println("¿Que opción desea?");
                                System.out.println("1. Cambiar nombre de usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Volver");
                                int opcionAdminPassword = sc.nextInt();
                                sc.nextLine();
                                if (opcionAdminPassword == 1) {
                                    System.out.println("Ingrese su nuevo nombre de usuario");
                                    admin = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Has reestablecido su nombre de usuario");
                                }
                                if (opcionAdminPassword == 2) {
                                    System.out.println("Ingrese la nueva contraseña");
                                    passAdmin = sc.nextLine().toLowerCase().trim();
                                    System.out.println("Has reestablecido su contraseña");
                                }
                                if (opcionAdminPassword == 3) {
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