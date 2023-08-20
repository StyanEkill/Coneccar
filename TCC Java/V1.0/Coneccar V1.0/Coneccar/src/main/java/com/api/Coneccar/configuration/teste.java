package com.api.Coneccar.configuration;

import java.util.Scanner;


public class teste {

    //função estatica para identificar if
    public static boolean verificadorIf(String p) {
        String[] palavraIf = {"if"};
        for (String palavra : palavraIf) { // itera cada elemento ou valor
            if (p.equals(palavra)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a entrada: ");
        String valor = scanner.next();

        int estado = 0;
        int aux = valor.length();
        int i = 0;

        while (i < aux) {
            char valorAtual = valor.charAt(i);

            switch (estado) {
                case 0:
                    if (Character.isDigit(valorAtual)) {
                        estado = 1; // numero inteiro
                    } else if (Character.isLetter(valorAtual)) {
                        estado = 2; // palavra
                    } else if (valorAtual == 'i') {
                        estado = 3; // if
                    } else {
                        estado = 4; // deu ruim
                    }
                    break;

                case 1: // numero inteiro
                    if (!Character.isDigit(valorAtual)) { // para verificar pois numero seguido de letras em veriáveis não são validas, além de simbolos é claro
                        estado = 4;
                    }
                    break;

                case 2: // palavra
                    if (!Character.isLetterOrDigit(valorAtual)) { // verificar se não tem simbolos
                        estado = 4;
                    }
                    break;

                case 3: // if
                    if (valorAtual != 'f') {
                        estado = 2; // Voltar ao Estado de Identificador
                    } else {
                        estado = 5; // Aceitar "if"
                    }
                    break;
            }

            i++; //soma i
        }

        if (estado == 1) {
            System.out.println("Número Inteiro");
        } else if (estado == 2) {
            if (verificadorIf(valor)) {
                System.out.println("Palavra reservada: " + valor);
            } else {
                System.out.println("Identificador");
            }
        } else if (estado == 5) {
            System.out.println("Palavra reservada: if");
        } else {
            System.out.println("Rejeitado");
        }
    }

}
