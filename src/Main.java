import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Referido a los datos de los trabajadores
        final String admin = "administrador";
        final String passAdmin = "administrador";
        final String gestor = "gestor";
        final String passGestor = "gestor";
        final String inversor1 = "inversor1";
        final String passInversor1 = "inversor1";
        final String inversor2 = "inversor2";
        final String passInversor2 = "inversor2";

        //Referido a los bloqueos
        int intentosGestor=0;
        int intentosInversor1=0;
        int intentosInversor2=0;
        boolean bloqueadoGestor = false;
        boolean bloqueadoInversor1 = false;
        boolean bloqueadoInversor2 = false;
        int opcionDesbloqueo;

        //Referido al control de acceso
        boolean esAdmin = false;
        boolean salir = false;
        boolean acceso = false;
        boolean esGestor = false;
        //Proyectos:
        //PROYECTO 1
        String nombreProyecto1 = "";
        String descripcionProyecto1 = "";
        String categoriaProyecto1 = "";
        double cantidadNecesariaProyecto1 = 0;
        double cantidadFinanciadaProyecto1 = 0;
        String fechaInicioProyecto1 = "";
        String fechaFinProyecto1 = "";
        String recompensa1Proyecto1 = "";
        String recompensa2Proyecto1 = "";
        String recompensa3Proyecto1 = "";
        //PROYECTO 2
        String nombreProyecto2 = "";
        String descripcionProyecto2 = "";
        String categoriaProyecto2 = "";
        double cantidadNecesariaProyecto2 = 0;
        double cantidadFinanciadaProyecto2 = 0;
        String fechaInicioProyecto2 = "";
        String fechaFinProyecto2 = "";
        String recompensa1Proyecto2 = "";
        String recompensa2Proyecto2 = "";
        String recompensa3Proyecto2 = "";
        //PROYECTO 3
        String nombreProyecto3 = "";
        String descripcionProyecto3 = "";
        String categoriaProyecto3 = "";
        double cantidadNecesariaProyecto3 = 0;
        double cantidadFinanciadaProyecto3 = 0;
        String fechaInicioProyecto3 = "";
        String fechaFinProyecto3 = "";
        String recompensa1Proyecto3 = "";
        String recompensa2Proyecto3 = "";
        String recompensa3Proyecto3 = "";
        int totalProyectos = 0;

        while (!acceso) {
            System.out.println("Introduce el usuario:");
            String usuario = sc.nextLine().toLowerCase().trim();
            System.out.println("Introduce la contraseña:");
            String contrasena = sc.nextLine().toLowerCase().trim();

            if (usuario.equals(gestor)) {
                if (bloqueadoGestor) {
                    System.out.println("La cuenta del Gestor está bloqueada. Contacte con el administrador.");
                } else if (contrasena.equals(passGestor)) {
                    System.out.println("Has accedido como Gestor.");
                    acceso = true;
                    esGestor = true;
                    intentosGestor = 0;
                } else {
                    intentosGestor++;
                    System.out.println("Contraseña incorrecta.");
                    if (intentosGestor >= 3) {
                        bloqueadoGestor = true;
                        System.out.println("La cuenta del Gestor ha sido bloqueada.");
                    }
                }
            } else if (usuario.equals(inversor1)) {
                if (bloqueadoInversor1) {
                    System.out.println("La cuenta del Inversor1 está bloqueada. Contacte con el administrador.");
                } else if (contrasena.equals(passInversor1)) {
                    System.out.println("Has accedido como Inversor1.");
                    acceso = true;
                    intentosInversor1 = 0;
                } else {
                    intentosInversor1++;
                    System.out.println("Contraseña incorrecta.");
                    if (intentosInversor1 >= 3) {
                        bloqueadoInversor1 = true;
                        System.out.println("La cuenta del Inversor1 ha sido bloqueada.");
                    }
                }
            } else if (usuario.equals(inversor2)) {
                if (bloqueadoInversor2) {
                    System.out.println("La cuenta del Inversor2 está bloqueada. Contacte con el administrador.");
                } else if (contrasena.equals(passInversor2)) {
                    System.out.println("Has accedido como Inversor2.");
                    acceso = true;
                    intentosInversor2 = 0;
                } else {
                    intentosInversor2++;
                    System.out.println("Contraseña incorrecta.");
                    if (intentosInversor2 >= 3) {
                        bloqueadoInversor2 = true;
                        System.out.println("La cuenta del Inversor2 ha sido bloqueada.");
                    }
                }
            } else if (usuario.equals(admin)) {
                if (contrasena.equals(passAdmin)) {
                    System.out.println("Has accedido como Administrador.");
                    acceso = true;
                    esAdmin = true;
                } else {
                    System.out.println("Contraseña incorrecta.");
                }
            } else {
                System.out.println("Usuario no reconocido.");
            }
        }

        while (!salir) {
            System.out.println("\n---- Menú Principal ----");
            if (esAdmin) {
                System.out.println("1. Desbloquear cuentas");
            } else {
                System.out.println("1. Crear proyecto");
            }
            System.out.println("2. Ver proyectos");
            System.out.println("3. Modificar proyecto");
            System.out.println("4. Eliminar proyecto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (esAdmin && opcion == 1) {
                System.out.println("---- Desbloquear Cuentas ----");
                System.out.println("1. Desbloquear Gestor (Estado actual: " + (bloqueadoGestor ? "Bloqueado" : "Desbloqueado") + ")");
                System.out.println("2. Desbloquear Inversor1 (Estado actual: " + (bloqueadoInversor1 ? "Bloqueado" : "Desbloqueado") + ")");
                System.out.println("3. Desbloquear Inversor2 (Estado actual: " + (bloqueadoInversor2 ? "Bloqueado" : "Desbloqueado") + ")");
                System.out.print("Elige una opción: ");
                opcionDesbloqueo = sc.nextInt();
                sc.nextLine();

                if (opcionDesbloqueo == 1) {
                    bloqueadoGestor = false;
                    System.out.println("La cuenta del Gestor ha sido desbloqueada.");
                } else if (opcionDesbloqueo == 2) {
                    bloqueadoInversor1 = false;
                    System.out.println("La cuenta del Inversor1 ha sido desbloqueada.");
                } else if (opcionDesbloqueo == 3) {
                    bloqueadoInversor2 = false;
                    System.out.println("La cuenta del Inversor2 ha sido desbloqueada.");
                } else {
                    System.out.println("Opción no válida.");
                }
            }

            if (opcion == 1) {
                if (!esGestor) {
                    System.out.println("Solo el Gestor puede crear proyectos.");
                } else if (totalProyectos >= 3) {
                    System.out.println("No se pueden crear más proyectos. Límite alcanzado.");
                } else {
                    System.out.println("Introduce el nombre del proyecto:");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce la descripción:");
                    String descripcion = sc.nextLine();
                    System.out.println("Introduce la categoría (arte, tecnología, etc.):");
                    String categoria = sc.nextLine();
                    System.out.println("Introduce la cantidad necesaria:");
                    double cantidadNecesaria = sc.nextDouble();
                    System.out.println("Introduce la cantidad financiada hasta ahora:");
                    double cantidadFinanciada = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la fecha de inicio:");
                    String fechaInicio = sc.nextLine();
                    System.out.println("Introduce la fecha de fin:");
                    String fechaFin = sc.nextLine();
                    System.out.println("Introduce la primera recompensa:");
                    String recompensa1 = sc.nextLine();
                    System.out.println("Introduce la segunda recompensa:");
                    String recompensa2 = sc.nextLine();
                    System.out.println("Introduce la tercera recompensa:");
                    String recompensa3 = sc.nextLine();

                    if (totalProyectos == 0) {
                        nombreProyecto1 = nombre;
                        descripcionProyecto1 = descripcion;
                        categoriaProyecto1 = categoria;
                        cantidadNecesariaProyecto1 = cantidadNecesaria;
                        cantidadFinanciadaProyecto1 = cantidadFinanciada;
                        fechaInicioProyecto1 = fechaInicio;
                        fechaFinProyecto1 = fechaFin;
                        recompensa1Proyecto1 = recompensa1;
                        recompensa2Proyecto1 = recompensa2;
                        recompensa3Proyecto1 = recompensa3;
                    } else if (totalProyectos == 1) {
                        nombreProyecto2 = nombre;
                        descripcionProyecto2 = descripcion;
                        categoriaProyecto2 = categoria;
                        cantidadNecesariaProyecto2 = cantidadNecesaria;
                        cantidadFinanciadaProyecto2 = cantidadFinanciada;
                        fechaInicioProyecto2 = fechaInicio;
                        fechaFinProyecto2 = fechaFin;
                        recompensa1Proyecto2 = recompensa1;
                        recompensa2Proyecto2 = recompensa2;
                        recompensa3Proyecto2 = recompensa3;
                    } else if (totalProyectos == 2) {
                        nombreProyecto3 = nombre;
                        descripcionProyecto3 = descripcion;
                        categoriaProyecto3 = categoria;
                        cantidadNecesariaProyecto3 = cantidadNecesaria;
                        cantidadFinanciadaProyecto3 = cantidadFinanciada;
                        fechaInicioProyecto3 = fechaInicio;
                        fechaFinProyecto3 = fechaFin;
                        recompensa1Proyecto3 = recompensa1;
                        recompensa2Proyecto3 = recompensa2;
                        recompensa3Proyecto3 = recompensa3;
                    }
                    totalProyectos++;
                    System.out.println("¡Proyecto creado con éxito!");
                }
            } else if (opcion == 2) {
                if (totalProyectos == 0) {
                    System.out.println("No hay proyectos disponibles.");
                } else {
                    if (!nombreProyecto1.isEmpty()) {
                        System.out.println("Proyecto 1: " + nombreProyecto1);
                        System.out.println("Descripción: " + descripcionProyecto1);
                        System.out.println("Categoría: " + categoriaProyecto1);
                        System.out.println("Cantidad necesaria: " + cantidadNecesariaProyecto1);
                        System.out.println("Cantidad financiada: " + cantidadFinanciadaProyecto1);
                        System.out.println("Fecha de inicio: " + fechaInicioProyecto1);
                        System.out.println("Fecha de fin: " + fechaFinProyecto1);
                        System.out.println("Recompensas: " + recompensa1Proyecto1 + ", " + recompensa2Proyecto1 + ", " + recompensa3Proyecto1);
                    }
                    if (!nombreProyecto2.isEmpty()) {
                        System.out.println("Proyecto 2: " + nombreProyecto2);
                        System.out.println("Descripción: " + descripcionProyecto2);
                        System.out.println("Categoría: " + categoriaProyecto2);
                        System.out.println("Cantidad necesaria: " + cantidadNecesariaProyecto2);
                        System.out.println("Cantidad financiada: " + cantidadFinanciadaProyecto2);
                        System.out.println("Fecha de inicio: " + fechaInicioProyecto2);
                        System.out.println("Fecha de fin: " + fechaFinProyecto2);
                        System.out.println("Recompensas: " + recompensa1Proyecto2 + ", " + recompensa2Proyecto2 + ", " + recompensa3Proyecto2);
                    }
                    if (!nombreProyecto3.isEmpty()) {
                        System.out.println("Proyecto 3: " + nombreProyecto3);
                        System.out.println("Descripción: " + descripcionProyecto3);
                        System.out.println("Categoría: " + categoriaProyecto3);
                        System.out.println("Cantidad necesaria: " + cantidadNecesariaProyecto3);
                        System.out.println("Cantidad financiada: " + cantidadFinanciadaProyecto3);
                        System.out.println("Fecha de inicio: " + fechaInicioProyecto3);
                        System.out.println("Fecha de fin: " + fechaFinProyecto3);
                        System.out.println("Recompensas: " + recompensa1Proyecto3 + ", " + recompensa2Proyecto3 + ", " + recompensa3Proyecto3);
                    }
                }


            } else if (opcion == 3) {
                if (!esGestor) {
                    System.out.println("Solo el Gestor puede modificar proyectos.");
                } else if (totalProyectos == 0) {
                    System.out.println("No hay proyectos disponibles para modificar.");
                } else {
                    System.out.println("Selecciona el número del proyecto a modificar:");
                    int proyecto = sc.nextInt();
                    sc.nextLine();
                    if (proyecto == 1 && !nombreProyecto1.isEmpty()) {
                        System.out.println("Introduce el nuevo nombre:");
                        nombreProyecto1 = sc.nextLine();
                        System.out.println("Introduce la nueva descripción:");
                        descripcionProyecto1 = sc.nextLine();
                        System.out.println("¡Proyecto modificado!");
                    } else if (proyecto == 2 && !nombreProyecto2.isEmpty()) {
                        System.out.println("Introduce el nuevo nombre:");
                        nombreProyecto2 = sc.nextLine();
                        System.out.println("Introduce la nueva descripción:");
                        descripcionProyecto2 = sc.nextLine();
                        System.out.println("¡Proyecto modificado!");
                    } else if (proyecto == 3 && !nombreProyecto3.isEmpty()) {
                        System.out.println("Introduce el nuevo nombre:");
                        nombreProyecto3 = sc.nextLine();
                        System.out.println("Introduce la nueva descripción:");
                        descripcionProyecto3 = sc.nextLine();
                        System.out.println("¡Proyecto modificado!");
                    } else {
                        System.out.println("Proyecto no válido.");
                    }
                }
            } else if (opcion == 4) {
                if (!esGestor) {
                    System.out.println("Solo el Gestor puede eliminar proyectos.");
                } else if (totalProyectos == 0) {
                    System.out.println("No hay proyectos disponibles para eliminar.");
                } else {
                    System.out.println("Selecciona el número del proyecto a eliminar:");
                    int proyecto = sc.nextInt();
                    sc.nextLine();
                    if (proyecto == 1 && !nombreProyecto1.isEmpty()) {
                        nombreProyecto1 = "";
                        descripcionProyecto1 = "";
                        System.out.println("¡Proyecto eliminado!");
                    } else if (proyecto == 2 && !nombreProyecto2.isEmpty()) {
                        nombreProyecto2 = "";
                        descripcionProyecto2 = "";
                        System.out.println("¡Proyecto eliminado!");
                    } else if (proyecto == 3 && !nombreProyecto3.isEmpty()) {
                        nombreProyecto3 = "";
                        descripcionProyecto3 = "";
                        System.out.println("¡Proyecto eliminado!");
                    } else {
                        System.out.println("Proyecto no válido.");
                    }
                    totalProyectos--;
                }
            } else if (opcion == 5) {
                salir = true;
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}