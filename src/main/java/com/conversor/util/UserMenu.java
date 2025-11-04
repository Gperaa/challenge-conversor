package com.conversor.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserMenu {
    public static void displayOptions() {
        System.out.println("""
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
                ESCOLHA UMA MOEDA PARA CONVERSÃO
                
                1. DÓLAR -> REAL
                2. DÓLAR -> PESO ARGENTINO
                3. DÓLAR -> PESO COLOMBIANO
                4. REAL -> PESO ARGENTINO
                5. REAL -> PESO COLOMBIANO
                6. PESO ARGENTINO -> PESO COLOMBIANO
                7. SAIR
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
                """);
    }

    public static int getUserOption() {
        Scanner sc = new Scanner(System.in);
        List<Integer> options = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        int option = sc.nextInt();

        while (!options.contains(option)) {
            System.out.printf("%d NÃO É UMA OPÇÃO VÁLIDA TENTE NOVAMENTE ", option);
            option = sc.nextInt();
        }

        return option;
    }

    public static double getAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.print("INSIRA QUANTIDADE A SER CONVERTIDA: ");
        double amount = sc.nextDouble();

        while (amount < 0) {
            System.out.println("O VALOR DE CONVERSÃO NÃO PODE SER NEGATIVO TENTE NOVAMENTE");
            amount = sc.nextDouble();
        }

        return amount;
    }

    public static List<String> filterOptions(int option) {
        String baseCode = "";
        String targetCode = "";

        switch (option) {
            case 1:
                baseCode = "USD";
                targetCode = "BRL";
                break;
            case 2:
                baseCode = "USD";
                targetCode = "ARS";
                break;
            case 3:
                baseCode = "USD";
                targetCode = "COP";
                break;
            case 4:
                baseCode = "BRL";
                targetCode = "ARS";
                break;
            case 5:
                baseCode = "BRL";
                targetCode = "COP";
                break;
            case 6:
                baseCode = "ARS";
                targetCode = "COP";
                break;
        }

        return Arrays.asList(baseCode, targetCode);
    }
}