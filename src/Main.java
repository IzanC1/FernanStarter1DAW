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
        String loginNombre ="";
        String loginPass ="";
        int contador = 0;

        do {
            System.out.println("Introduce el usuario: ");
            loginNombre = sc.nextLine();
            System.out.println("Introduce la contraseña: ");
            loginPass = sc.nextLine();
            contador++;
            if (contador>3){
                System.out.println("Cuenta bloqueada, consulta al admin.");
            }

        }while (loginNombre!=gestor || loginNombre!=inversor1 || loginNombre!=inversor2);



    }

}