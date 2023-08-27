package com.api.Coneccar.configuration;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
/**
 *
 * @author 12022546 & 12022134
 */
public class teste2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo C: ");
        String inputFileName = scanner.nextLine();
        String outputFileName = "tokens.txt";

        try {
            // Ler o arquivo de código fonte em C
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            StringBuilder sourceCode = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sourceCode.append(line).append("\n");
            }
            reader.close();

            // Definir as expressões regulares para os tokens
            String regex = "\\b(asm|auto|break|case|catch|char|class|const|continue|default|delete|do|double|else|enum|extern|float|for|friend|goto|if|inline|int|long|new|operator|private|protected|public|register|return|short|signed|sizeof|static|struct|switch|template|this|throw|try|typedef|union|unsigned|virtual|void|volatile|while)\\b|[\\(\\)\\[\\]\\{\\};,]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sourceCode);

            // Criar o arquivo de saída para os tokens
            FileWriter writer = new FileWriter(outputFileName);

            // Identificar e escrever os tokens no arquivo de saída
            while (matcher.find()) {
                String token = matcher.group();
                int tokenCode = getTokenCode(token);
                writer.write(token + " : " + tokenCode + "\n");
            }

            writer.close();
            System.out.println("Tokens foram salvos em " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    // Mapear tokens para códigos (apenas para fins de exemplo)
    private static int getTokenCode(String token) {
        switch (token) {
            case "asm":
                return 1;
            case "auto":
                return 2;
            case "break":
                return 3;
            case "case":
                return 4;
            case "catch":
                return 5;
            case "char":
                return 6;
            case "class":
                return 7;
            case "const":
                return 8;
            case "continue":
                return 9;
            case "default":
                return 10;
            case "delete":
                return 11;
            case "do":
                return 12;
            case "double":
                return 13;
            case "else":
                return 14;
            case "enum":
                return 15;
            case "extern":
                return 16;
            case "float":
                return 17;
            case "for":
                return 18;
            case "friend":
                return 19;
            case "goto":
                return 20;
            case "if":
                return 21;
            case "inline":
                return 22;
            case "int":
                return 23;
            case "long":
                return 24;
            case "new":
                return 25;
            case "operator":
                return 26;
            case "private":
                return 27;
            case "protected":
                return 28;
            case "public":
                return 29;
            case "register":
                return 30;
            case "return":
                return 31;
            case "short":
                return 32;
            case "signed":
                return 33;
            case "sizeof":
                return 34;
            case "static":
                return 35;
            case "struct":
                return 36;
            case "switch":
                return 37;
            case "template":
                return 38;
            case "this":
                return 39;
            case "throw":
                return 40;
            case "try":
                return 41;
            case "typedef":
                return 42;
            case "union":
                return 43;
            case "unsigned":
                return 44;
            case "virtual":
                return 45;
            case "void":
                return 46;
            case "volatile":
                return 47;
            case "while":
                return 48;
            case "(":
                return 49;
            case ")":
                return 50;
            case "{":
                return 51;
            case "}":
                return 52;
            case "[":
                return 53;
            case "]":
                return 54;
            case ";":
                return 55;
            case ",":
                return 56;
            case "-":
                return 57;
            case "+":
                return 58;
            case "*":
                return 59;
            case "/":
                return 60;
            case "=":
                return 61;
            case "==":
                return 62;
            case "!=":
                return 63;
            case "<":
                return 64;
            case ">":
                return 65;
            case "<=":
                return 66;
            case ">=":
                return 67;
            default:
                return 0; // Token desconhecido
        }
    }
}