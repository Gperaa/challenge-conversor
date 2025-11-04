package com.conversor.main;

import com.conversor.http.ApiClient;
import com.conversor.service.CurrencyConverter;
import com.conversor.util.UserMenu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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

            System.out.println(converter.convert(baseCode, targetCode, amount));
        }
    }
}
