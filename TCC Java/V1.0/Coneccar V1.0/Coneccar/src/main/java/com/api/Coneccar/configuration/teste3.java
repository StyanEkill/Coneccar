package com.api.Coneccar.configuration;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class teste3 {
        public static void main(String[] args) {
            try {
                // Abre o arquivo de entrada para leitura
                BufferedReader reader = new BufferedReader(new FileReader("codigo_fonte.c"));
                // Cria um arquivo de saída para gravar os tokens
                BufferedWriter writer = new BufferedWriter(new FileWriter("tokens.txt"));
                String line;

                // Lê cada linha do arquivo de entrada
                while ((line = reader.readLine()) != null) {
                    // Remove comentários da linha antes de tokenizar
                    line = removeComments(line);

                    // Divide a linha em tokens usando espaços em branco como separadores
                    String[] tokens = line.split("\s+");
                    // Processa cada token
                    for (String token : tokens) {
                        // Identifica o tipo de token
                        String tokenType = getTokenType(token);

                       // Verifica o ponto e vírgula no final da linha
                        if (token.equals(";")) {
                            writer.write("PONTO E VÍRGULA: ;\n");
                        } else {
                            // Grava o tipo de token e o próprio token no arquivo de saída
                            writer.write(tokenType + ": " + token + "\n");
                        }

                    }
                }

                // Fecha os arquivos
                reader.close();
                writer.close();
                System.out.println("Arquivo lido com sucesso!");
            } catch (IOException e) {
                System.out.println("Deu ruim em alguma coisa "+e);
                e.printStackTrace();
            }
        }
        // Remove comentários estilo C de uma linha
        private static String removeComments(String line) {
            // Expressão regular para remover comentários de uma linha
           return line.replaceAll("//.*|/\\*(.|[\\r\\n])*?\\*/", "");
        }

        // Identifica o tipo de token com base em padrões de expressão regular
        private static String getTokenType(String token) {
            // Adicione aqui seus padrões de expressão regular para diferentes tipos de tokens
            if (token.matches("[_a-zA-Z][_a-zA-Z0-9]")) {
                return "VARIÁVEL";
            } else if (token.matches("\\d+")) {
                return "LITERAL";
            } else if (token.matches("int|float|char|for|while|if|else|return|void|struct")) {
                return "IDENTIFICADOR";
            } else if (token.matches("[+\\-*/=<>]")) {
                return "OPERATOR";
            } else {
                return "UNKNOWN";
            }
        }
    }