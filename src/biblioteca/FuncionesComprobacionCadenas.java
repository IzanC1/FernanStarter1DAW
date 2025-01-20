package biblioteca;

import java.util.Scanner;

import static biblioteca.Funciones.*;

public class FuncionesComprobacionCadenas {

    // Validación de contraseñas
    public static boolean validarPassword(String contrasenia) {
        return contrasenia.length() >= 8 && contrasenia.matches(".*[A-Z].*") && contrasenia.matches(".*[a-z].*") && contrasenia.matches(".*[0-9].*");
    }

    public static boolean esPasswordFuerte(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean tieneminuscula = false;
        boolean tienemayuscula = false;
        boolean tienenumero = false;
        boolean tienesimbolo = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) tieneminuscula = true;
            if (Character.isUpperCase(c)) tienemayuscula = true;
            if (Character.isDigit(c)) tienenumero = true;
            if (esSimbolo(c)) tienesimbolo = true;
        }
        return tienemayuscula && tieneminuscula && tienenumero && tienesimbolo;
    }

    public static boolean esSimbolo(char c) {
        return "-_.,*+@".indexOf(c) >= 0;
    }

    // Entrada no vacía
    public static String obtenerEntradaNoVacia(String mensaje) {
        String entrada;
        do {
            entrada = obtenerEntrada(mensaje).trim();
            if (entrada.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    // Validación de fechas
    public static boolean validarFormatoFecha(String fecha) {
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Formato de fecha incorrecto. Use dd/mm/aaaa");
            return false;
        }

        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31 || anio < 2024) {
            System.out.println("Fecha inválida");
            return false;
        }
        return true;
    }

    public static boolean validarFechaFinPosterior(String fechaInicio, String fechaFin) {
        String[] partesInicio = fechaInicio.split("/");
        String[] partesFin = fechaFin.split("/");

        int anioInicio = Integer.parseInt(partesInicio[2]);
        int mesInicio = Integer.parseInt(partesInicio[1]);
        int diaInicio = Integer.parseInt(partesInicio[0]);

        int anioFin = Integer.parseInt(partesFin[2]);
        int mesFin = Integer.parseInt(partesFin[1]);
        int diaFin = Integer.parseInt(partesFin[0]);

        if (anioFin < anioInicio || (anioFin == anioInicio && mesFin < mesInicio) || (anioFin == anioInicio && mesFin == mesInicio && diaFin <= diaInicio)) {
            System.out.println("La fecha de fin debe ser posterior a la fecha de inicio");
            return false;
        }
        return true;
    }

    // Comparación de contraseñas
    public static boolean contrasenaIguales(String password1, String password2) {
        return password1.equals(password2);
    }

    // Registro de usuario con verificación por correo
    public static void registroDeUsuario(String[] inversor, String[] gestor, String[] passInversor, String[] passGestor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de Usuario: ");
        String nuevoUsuario = sc.nextLine();
        System.out.println("Contraseña: ");
        String nuevaPassword = sc.nextLine();
        System.out.println("Repite la contraseña: ");
        String repetirPassword = sc.nextLine();

        if (!contrasenaIguales(nuevaPassword, repetirPassword)) {
            System.out.println("Las contraseñas no son iguales");
            return;
        }

        if (!esPasswordFuerte(nuevaPassword)) {
            System.out.println("La contraseña no es fuerte");
            return;
        }

        System.out.println("Tipo de usuario (Gestor o Inversor): ");
        String tipoUsuario = sc.nextLine();

        if (!tipoUsuario.equalsIgnoreCase("Gestor") && !tipoUsuario.equalsIgnoreCase("Inversor")) {
            System.out.println("Solo los gestores y los inversores pueden crear una cuenta");
            return;
        }

        if (tipoUsuario.equalsIgnoreCase("Gestor")) {
            boolean estaEnArray = buscaStringEnArray(nuevoUsuario, gestor);
            if (estaEnArray) {
                System.out.println("ERROR. El usuario ya existe.");
            } else {
                int posicionGestor = buscaPrimeraPosicionVacia(gestor);
                gestor[posicionGestor] = nuevoUsuario;
                passGestor[posicionGestor] = nuevaPassword;
                // Llamada a la verificación por correo antes de completar el registro
                System.out.println("Te hemos enviado un código de verificación a tu correo. Por favor, verifica tu cuenta.");
                FuncionesCorreo.verificacionCorreo();
                System.out.println("Usuario registrado con éxito.");
            }
        } else if (tipoUsuario.equalsIgnoreCase("Inversor")) {
            boolean estaEnArray = buscaStringEnArray(nuevoUsuario, inversor);
            if (estaEnArray) {
                System.out.println("ERROR. El usuario ya existe.");
            } else {
                int posicionInversor = buscaPrimeraPosicionVacia(inversor);
                inversor[posicionInversor] = nuevoUsuario;
                passInversor[posicionInversor] = nuevaPassword;
                // Llamada a la verificación por correo antes de completar el registro
                System.out.println("Te hemos enviado un código de verificación a tu correo. Por favor, verifica tu cuenta.");
                FuncionesCorreo.verificacionCorreo();
                System.out.println("Usuario registrado con éxito.");
            }
        }
    }
}