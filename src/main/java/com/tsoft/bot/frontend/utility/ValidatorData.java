package com.tsoft.bot.frontend.utility;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorData {

    public static void main(String[] args) {



        String dniiii = "74542681";
        String ruc = "10542683412";
        String letra = "AaagfgAfgfgfg";
        String numero = "05454400424";
        System.out.println(" DNI: " + validarDNI(dniiii));
        System.out.println(" RUC: " + validarRUC(ruc));
        System.out.println(" solo letras: " + validarSoloLetras(letra));
        System.out.println(" solo nume 2: " + validarSoloNumeros(numero));

    }


    public static boolean validarDNI(String dni) {
        Pattern patron = Pattern.compile("[0-9]{8}");
        Matcher mat = patron.matcher(dni);
        if (!mat.matches()) {
            return false;
        }
        return true;
    }


    public static boolean validarRUC(String ruc) {
        Pattern patron = Pattern.compile("[12]{1}[0]{1}[0-9]{9}");
        Matcher mat = patron.matcher(ruc);

        if (!mat.matches()) {
            return false;
        }
        return true;
    }


    public static boolean validarSoloLetras(String palabra) {
        Pattern patron = Pattern.compile("[a-zA-Z]+");
        Matcher mat = patron.matcher(palabra);
        if (!mat.matches()) {
            return false;
        }
        return true;
    }

    public static boolean validarSoloNumeros(String numero) {
        Pattern patron = Pattern.compile("[0-9]+");
        Matcher mat = patron.matcher(numero);
        if (!mat.matches()) {
            return false;
        }
        return true;
    }



}
