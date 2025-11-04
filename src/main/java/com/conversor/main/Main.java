package com.conversor.main;

import com.conversor.service.CurrencyConverter;
import com.conversor.util.UserMenu;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            UserMenu.displayOptions();
            int option = UserMenu.getUserOption();
            if (option == 7) {
                System.out.println("ENCERRANDO O PROGRAMA...");
                break;
            }
            double amount = UserMenu.getAmount();
            String baseCode = UserMenu.filterOptions(option).getFirst();
            String targetCode = UserMenu.filterOptions(option).getLast();


            CurrencyConverter converter = new CurrencyConverter();
            FileWriter fileWriter = new FileWriter("conversion_log.txt");
            fileWriter.write(converter.convert(baseCode, targetCode, amount).toString());
            fileWriter.close();

            System.out.println(converter.convert(baseCode, targetCode, amount));
        }
    }
}
