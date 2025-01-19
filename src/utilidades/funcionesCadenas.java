package utilidades;
import java.util.Scanner;

public class funcionesCadenas {
    private static String[] usuarios = new String[100];
    private static String[] contrasenas = new String[100];
    private static int contadorUsuarios = 0;
    public static boolean contrasenaIguales (String password1, String password2){
        return password1.equals(password2);
    }

    public static boolean esPasswordFuerte (String password){
        if (password.length() < 8){
            return false;
        }

        boolean tieneminuscula = false;
        boolean tienemayuscula = false;
        boolean tienenumero = false;
        boolean tienesimbolo = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) tienemayuscula = true;
            if (Character.isUpperCase(c)) tieneminuscula = true;
            if (Character.isDigit(c)) tienenumero = true;
            if (esSimbolo(c)) tienesimbolo = true;
        }
        return tienemayuscula && tieneminuscula && tienenumero && tienesimbolo;
    }

    public static boolean esSimbolo (char c){
        return "-_.,*+@".indexOf(c) >= 0;
    }
    public static void registroDeUsuario () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de Usuario: ");
        String nuevoUsuario = sc.nextLine();
        System.out.println("Contraseña: ");
        String nuevaPassword = sc.nextLine();
        System.out.println("Repite la contraseña: ");
        String repetirPassword = sc.nextLine();

        if (!contrasenaIguales(nuevaPassword, repetirPassword)){
            System.out.println("Las contraseñas no son iguales");
            return;
        }

        if (!esPasswordFuerte(nuevaPassword)){
            System.out.println("La contraseña no es fuerte");
        }

        System.out.println("Tipo de usuario (Gestor o Inversor): ");
        String tipoUsuario = sc.nextLine();

        if (!tipoUsuario.equals("Gestor") && !tipoUsuario.equals("Inversor")){
            System.out.println("Solo los gestores y los inversores pueden crear una cuenta");
            return;
        }

        usuarios[contadorUsuarios] = nuevoUsuario;
        contrasenas[contadorUsuarios] = nuevaPassword;
        contadorUsuarios++;
        System.out.println("Usuario registrado con exito");
    }

    public static void inicioSesion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de Usuario: ");
        String nombreUsuario = sc.nextLine();

        int usuarioIndex = -1;
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].equals(nombreUsuario)){
                usuarioIndex = i;
                break;
            }
        }
        if (usuarioIndex == -1){
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.println("Contraseña: ");
        String password = sc.nextLine();

        if (contrasenas[usuarioIndex].equals(password)){
            System.out.println("Inicio de sesion exitoso. Bienvenido " + nombreUsuario);
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }



}
