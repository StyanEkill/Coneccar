package com.api.Coneccar.configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 12022546 & 12022134
 *
 **/

public class attTokens {
    public static void main(String[] args) {

        int i = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Lembre-se de incluir o arquivo de leitura na pasta do projeto\n");
        System.out.print("Digite o nome do arquivo C -> ");

        String arquivoLeitura = scanner.nextLine();
        String arquivoSaida = "tokens.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoLeitura+".c"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida));
            String linha;

            while ((linha = reader.readLine()) != null) {

                linha = removeComentarios(linha);

                String[] tokens = linha.split("[\\s\\(\\)\\*\\-\\+\\=\\&&\\||\\!\\!=/\\[\\]{}<>;,:]");

                // Divide usando espaços e sinais como separadores

                for (String token : tokens) {
                    token = token.trim();
                    if (!token.isEmpty()) {
                        String tokenType = tipoToken(token);
                        writer.write(i +": "+ tokenType + ": " + token + "\n");
                        i++;
                    }
                }
            }

            reader.close();
            writer.close();
            System.out.println("Arquivo lido com sucesso parceiro!");
        } catch (IOException e) {
            System.out.println("Deu ruim em alguma coisa "+e);
            e.printStackTrace();
        }
    }

    private static String removeComentarios(String linha) {
        // Expressão para tirar coments
        return linha.replaceAll("//.*|/\\*(.|[\\r\\n])*?\\*/", "");
    }

    private static String tipoToken(String token) {
        if (token.matches("\"[^\"]*\"|'[^']*'")) {
            return "TEXTO";
        } else if (token.matches("#include")) {
            return "INCLUDE";
        } else if (token.matches("asm|auto|break|case|catch|char|class|const|continue|default|delete|do|double|else|enum|extern|float|for|friend|goto|if|inline|int|long|new|operator|private|protected|public|register|return|short|signed|sizeof|static|struct|switch|template|this|throw|try|typedef|union|unsigned|virtual|void|volatile|while|printf")) {
            return "PALAVRA RESERVADA";
        } else if (token.matches("\\d+")) {
            return "INTEIRO";
        } else if (token.matches("\\d+\\.\\d+")) {
            return "FLOAT";
        } else if (token.matches("[_a-zA-Z][_a-zA-Z0-9]*")) {
            return "VARIÁVEL";
        } else if (token.matches("[\\(\\)\\*\\-\\+\\=\\&&\\||\\!\\!=\\-=\\+=/\\[\\]{}<>]")) {
            return "OPERADOR";
        } else if (token.equals(";")) {
            return "PONTO E VÍRGULA";
        } else if (token.equals(",")) {
            return "SEPARADOR";
        } else {
            return "NÃO IDENTIFICADO";
        }
    }
}
