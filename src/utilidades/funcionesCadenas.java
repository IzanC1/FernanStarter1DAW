package utilidades;
import java.util.Scanner;
import static biblioteca.funcionesGenerales.*;

public class funcionesCadenas {

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
    public static void registroDeUsuario (String[] inversor, String [] gestor, String[] passInversor, String[] passGestor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de Usuario: ");
        String nuevoUsuario = sc.nextLine();
        System.out.println("Contraseña: ");
        String nuevaPassword = sc.nextLine();
        System.out.println("Repite la contraseña: ");
        String repetirPassword = sc.nextLine();

        if (!contrasenaIguales(nuevaPassword, repetirPassword)){
            System.out.println("Las contraseñas no son iguales");
        }

        if (!esPasswordFuerte(nuevaPassword)){
            System.out.println("La contraseña no es fuerte");
        }

        System.out.println("Tipo de usuario (Gestor o Inversor): ");
        String tipoUsuario = sc.nextLine();

        if (!tipoUsuario.equalsIgnoreCase("Gestor") && !tipoUsuario.equalsIgnoreCase("Inversor")){
            System.out.println("Solo los gestores y los inversores pueden crear una cuenta");
        }


        if (tipoUsuario.equalsIgnoreCase("Gestor")){
            boolean estaEnArray = buscaStringEnArray(nuevoUsuario, gestor);
            if (estaEnArray){
                System.out.println("ERROR. El usuario ya existe.");
            } else {
                int posicionGestor = buscaPrimeraPosicionVacia (gestor, nuevoUsuario);
                gestor[posicionGestor] = nuevoUsuario;
                passGestor[posicionGestor] = nuevaPassword;
                System.out.println("Usuario registrado con exito");
            }
        } else if (tipoUsuario.equalsIgnoreCase("Inversor")){
            boolean estaEnArray = buscaStringEnArray(nuevoUsuario, inversor);
            if (estaEnArray){
                System.out.println("ERROR. El usuario ya existe.");
            } else {
                int posicionInversor = buscaPrimeraPosicionVacia (inversor, nuevoUsuario);
                inversor[posicionInversor] = nuevoUsuario;
                passInversor[posicionInversor] = nuevaPassword;
                System.out.println("Usuario registrado con exito");
            }
        }

    }


}
