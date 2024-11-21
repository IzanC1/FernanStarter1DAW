import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String admin = "Administrador";
        String passAdmin = "Admin1234";
        String gestor = "Gestor";
        String passGestor = "Gestor1234";
        String inversor1 = "Inversor1";
        String passInversor1 = "Inversor1234";
        String inversor2 = "Inversor2";
        String passInversor2 = "Inversor5678";
        String loginNombre;
        String loginPass;
        int intentosGestor=1;
        int intentosInversor1=1;
        int intentosInversor2=1;
        boolean acceso = false;

        do {
            System.out.println("Introduce el usuario: ");
            loginNombre = sc.nextLine();
            System.out.println("Introduce la contraseña: ");
            loginPass = sc.nextLine();

            if (loginNombre.equals(gestor)) {
                if (intentosGestor >= 3) {
                    System.out.println("Tu cuenta Gestor ha sido bloqueada.");
                } else if (loginPass.equals(passGestor)) {
                    System.out.println("Has accedido como Gestor.");
                    acceso = true;
                } else {
                    System.out.println("ERROR: Contraseña incorrecta.");
                    intentosGestor++;
                }

            } else if (loginNombre.equals(inversor1)) {
                if (intentosInversor1 >= 3) {
                    System.out.println("Tu cuenta Inversor1 ha sido bloqueada.");
                } else if (loginPass.equals(passInversor1)) {
                    System.out.println("Has accedido como Inversor1.");
                    acceso = true;
                } else {
                    System.out.println("ERROR: Contraseña incorrecta.");
                    intentosInversor1++;
                }

            } else if (loginNombre.equals(inversor2)) {
            if (intentosInversor2 >= 3) {
                System.out.println("Tu cuenta Inversor2 ha sido bloqueada.");
            } else if (loginPass.equals(passInversor2)) {
                System.out.println("Has accedido como Inversor2.");
                acceso = true;
            } else {
                System.out.println("ERROR: Contraseña incorrecta.");
                intentosInversor2++;
            }

            } else if (loginNombre.equals(admin)) {
                if (loginPass.equals(passAdmin)) {
                    System.out.println("Has accedido como Administrador.");
                    acceso = true;
                } else {
                    System.out.println("ERROR: Contraseña incorrecta.");
                }
            }

        }while (!acceso);




    }

}