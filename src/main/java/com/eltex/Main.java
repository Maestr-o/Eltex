package com.eltex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var discount = 0.02;
        final var discountStart = 3_000;
        final Scanner scanner = new Scanner(System.in);
        String currencySymbol = "";
        int currency;

        while (currencySymbol.isEmpty()) {
            System.out.println("Введите валюту: 1 – RUB, 2 – BYN, 3 – KZT");
            currency = scanner.nextInt();
            if (currency == 1) {
                currencySymbol = "₽";
                break;
            } else if (currency == 2) {
                currencySymbol = "BYN";
                break;
            } else if (currency == 3) {
                currencySymbol = "₸";
            } else {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }

        System.out.println("Введите сумму покупок за прошлый год:");
        final var clientYearlyPurchases = scanner.nextInt();
        final double totalDiscount;

        if (clientYearlyPurchases > discountStart) {
            totalDiscount = clientYearlyPurchases * discount;
        } else {
            totalDiscount = 0;
        }

        if (totalDiscount > 0) {
            System.out.printf("Попробуйте нашу новую подписку и сэкономьте %.0f%%\n", discount * 100);
        }
        System.out.printf("За прошлый год вы бы сэкономили с подпиской %s %s\n", totalDiscount, currencySymbol);
    }
}