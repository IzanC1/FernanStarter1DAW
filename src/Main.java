import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de los usuarios
        final String admin = "administrador";
        final String passAdmin = "administrador";
        final String gestor = "gestor";
        final String passGestor = "gestor";
        final String inversor1 = "inversor1";
        final String passInversor1 = "inversor1";
        final String inversor2 = "inversor2";
        final String passInversor2 = "inversor2";

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

                        // AQUÍ EMPIEZA EL MENÚ GESTOR
                        while (true) {
                            System.out.println("\n--- Menú Gestor ---");
                            System.out.println("1. Mostrar todos los proyectos de la plataforma");
                            System.out.println("2. Crear un nuevo proyecto");
                            System.out.println("3. Modificar un proyecto existente");
                            System.out.println("4. Salir");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion == 1) {
                                System.out.println("\nMostrando todos los proyectos de la plataforma...");
                                if (proyectosCreados == 0){
                                    System.out.println("No hay proyectos creados aun");
                                }
                                if (proyectosCreados >= 1){
                                    System.out.println("\nProyecto 1: ");
                                    System.out.println("Nombre: " + nombreProyecto1);
                                    System.out.println("Descripción: " + descripcionProyecto1);
                                    System.out.println("Categoría: " + categoriaProyecto1);
                                    System.out.println("Cantidad necesaria: " + cantidadNecesaria1);
                                    System.out.println("Cantidad financiada: " + cantidadFinanciada1);
                                    System.out.println("Fecha de inicio: " + fechaInicio1);
                                    System.out.println("Fecha de fin: " + fechaFin1);
                                    System.out.println("Recompensas: " + recompensa1_1 + ", " + recompensa1_2 + ", " + recompensa1_3);
                                }
                                if (proyectosCreados >= 2){
                                    System.out.println("\nProyecto 2:");
                                    System.out.println("Nombre: " + nombreProyecto2);
                                    System.out.println("Descripción: " + descripcionProyecto2);
                                    System.out.println("Categoría: " + categoriaProyecto2);
                                    System.out.println("Cantidad necesaria: " + cantidadNecesaria2);
                                    System.out.println("Cantidad financiada: " + cantidadFinanciada2);
                                    System.out.println("Fecha de inicio: " + fechaInicio2);
                                    System.out.println("Fecha de fin: " + fechaFin2);
                                    System.out.println("Recompensas: " + recompensa2_1 + ", " + recompensa2_2 + ", " + recompensa2_3);
                                }
                                if (proyectosCreados >= 3){
                                    System.out.println("\nProyecto 3:");
                                    System.out.println("Nombre: " + nombreProyecto3);
                                    System.out.println("Descripción: " + descripcionProyecto3);
                                    System.out.println("Categoría: " + categoriaProyecto3);
                                    System.out.println("Cantidad necesaria: " + cantidadNecesaria3);
                                    System.out.println("Cantidad financiada: " + cantidadFinanciada3);
                                    System.out.println("Fecha de inicio: " + fechaInicio3);
                                    System.out.println("Fecha de fin: " + fechaFin3);
                                    System.out.println("Recompensas: " + recompensa3_1 + ", " + recompensa3_2 + ", " + recompensa3_3);
                                }
                            } else if (opcion == 2) {
                                if (proyectosCreados >= 3){
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
                                System.out.println("\nModificando un proyecto...");
                                System.out.println("Selecciona el numero del proyecto a modificar (1, 2 o 3): ");
                                int numProyecto = sc.nextInt();
                                sc.nextLine();
                                if (numProyecto < 1 || numProyecto > proyectosCreados){
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

                                if (numProyecto == 1){
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
                                System.out.println("Saliendo del menú Gestor...");
                                break;
                            } else {
                                System.out.println("Opcion inválida. Por favor, selecciona una opcion válida.");
                            }

                        } // AQUÍ ACABA EL MENÚ GESTOR
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

                        // AQUÍ EMPIEZA EL MENÚ INVERSOR 1
                        while (true) {
                            System.out.println("\n--- Menú Inversor1 ---");
                            System.out.println("1. Opción Inversor1");
                            System.out.println("2. Opción Inversor1");
                            System.out.println("3. Salir");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion == 1) {
                                System.out.println("Realizando opción Inversor1 1...");
                            } else if (opcion == 2) {
                                System.out.println("Realizando opción Inversor1 2...");
                            } else if (opcion == 3) {
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        } // AQUÍ ACABA EL MENÚ INVERSOR 1

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

                        // AQUÍ EMPIEZA EL MENÚ INVERSOR 2
                        while (true) {
                            System.out.println("\n--- Menú Inversor2 ---");
                            System.out.println("1. Opción Inversor2");
                            System.out.println("2. Opción Inversor2");
                            System.out.println("3. Salir");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion == 1) {
                                System.out.println("Realizando opción Inversor2 1...");
                            } else if (opcion == 2) {
                                System.out.println("Realizando opción Inversor2 2...");
                            } else if (opcion == 3) {
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        } // AQUÍ ACABA EL MENÚ INVERSOR 2

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

                        // AQUÍ EMPIEZA EL MENÚ ADMINISTRADOR
                        while (true) {
                            System.out.println("\n--- Menú Administrador ---");
                            System.out.println("1. Panel de control");
                            System.out.println("2. Opción Administrador");
                            System.out.println("3. Salir");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion == 1) {

                                int opcionPanelControl = 0;
                                do {
                                    System.out.println("\n--- Panel de Control ---");
                                    System.out.println("1. Bloquear usuario");
                                    System.out.println("2. Desbloquear usuario");
                                    opcionPanelControl = sc.nextInt();
                                    sc.nextLine();
                                }while(opcionPanelControl != 1 && opcionPanelControl != 2);
                                switch (opcionPanelControl) {
                                    case 1:
                                        int opcionBloqueo = 0;
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
                                        int opcionDesbloqueo = 0;
                                        do {
                                            System.out.println("\n¿A qué usuario desbloquear?");
                                            System.out.println("1. Usuario Inversor 1");
                                            System.out.println("2. Usuario Inversor 2");
                                            System.out.println("3. Usuario Gestor");
                                            System.out.println("4. Volver al Menú Administrador");
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
                                        break;
                                }



                            } else if (opcion == 2) {
                                System.out.println("Realizando opción Administrador 2...");
                            } else if (opcion == 3) {
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        } // AQUÍ ACABA EL MENÚ ADMINISTRADOR

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
