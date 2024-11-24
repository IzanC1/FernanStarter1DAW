import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String admin = "administrador";
        final String passAdmin = "administrador";
        final String gestor = "gestor";
        final String passGestor = "gestor";
        final String inversor1 = "inversor1";
        final String passInversor1 = "inversor1";
        final String inversor2 = "inversor2";
        final String passInversor2 = "inversor2";

        int intentosGestor = 3;
        int intentosInversor1 = 3;
        int intentosInversor2 = 3;

        boolean bloqueadoGestor = false;
        boolean bloqueadoInversor1 = false;
        boolean bloqueadoInversor2 = false;

        while (true) {
            System.out.println("Introduce el usuario (o escribe 'salir' para terminar):");
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

                        while (true) {
                            System.out.println("\n--- Menú Gestor ---");
                            System.out.println("1. Opción Gestor");
                            System.out.println("2. Opción Gestor");
                            System.out.println("3. Salir");
                            System.out.print("Selecciona una opción: ");
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion == 1) {
                                System.out.println("Realizando opción Gestor 1...");
                            } else if (opcion == 2) {
                                System.out.println("Realizando opción Gestor 2...");
                            } else if (opcion == 3) {
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        }
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
                        }
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
                        }
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
                boolean adminAccedido = false;
                while (true) {
                    System.out.println("Introduce la contraseña:");
                    String contrasena = sc.nextLine().toLowerCase().trim();

                    if (contrasena.equals(passAdmin)) {
                        System.out.println("Has accedido como Administrador.");
                        adminAccedido = true;
                        break;
                    } else {
                        System.out.println("Contraseña incorrecta. Escribe 'salir' para abandonar o intenta nuevamente.");
                        String opcion = sc.nextLine().toLowerCase().trim();
                        if (opcion.equals("salir")) {
                            break;
                        }
                    }
                }

                if (adminAccedido) {
                    while (true) {
                        System.out.println("\n--- Menú Administrador ---");
                        System.out.println("1. Opción Administrador");
                        System.out.println("2. Opción Administrador");
                        System.out.println("3. Salir");
                        System.out.print("Selecciona una opción: ");
                        int opcion = sc.nextInt();
                        sc.nextLine();

                        if (opcion == 1) {
                            System.out.println("Realizando opción Administrador 1...");
                        } else if (opcion == 2) {
                            System.out.println("Realizando opción Administrador 2...");
                        } else if (opcion == 3) {
                            break;
                        } else {
                            System.out.println("Opción inválida.");
                        }
                    }
                }

            } else {
                System.out.println("Usuario no reconocido.");
            }
        }
    }
}
