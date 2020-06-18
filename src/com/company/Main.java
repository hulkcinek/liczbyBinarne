package com.company;

import java.util.Scanner;

public class Main {

    /*
    1. Zamiana liczby dziesietnej na binarna (iteracyjnie)
    2. Zamiana liczby dziesietnej na binarna (rekurencyjnie)
    3. Zamiana liczby binarnej na dziesietna (iteracyjnie)
    4. Zamiana liczby binarnej na dziesietna (rekurencyjnie)
     */

    // zasada dzialania ^ - XOR (ksor)
    /*
    Do zrobienia na potem: operacje arytmetyczne na liczbach binarnych

    OR: (daje true gdy co najmniej jedno jest prawdziwe)
    true || true => true
    true || false => true
    false || true => true
    false || false => false

    XOR: (daje true gdy tylko jedno jest prawdziwe)
    true ^ true => false
    true ^ false => true
    false ^ true => true
    false ^ false => false

    2^3
    XOR dla 2 i 3
    10
    11
    --
    01
    */

    public static String zamiana10na2iteracyjnie(int liczba) {
        String wynik = "";
        while (liczba>0){
            wynik = liczba%2 + wynik; // dopisanie z przodu zmiennej wynik
            liczba = liczba/2; // liczba /= 2;
        }
        return wynik;
    }

    public static int zamiana2na10iteracyjnie(String binarna) {
        int wynik = 0;
        for (int i = 0; i < binarna.length(); i++) {
            wynik += (binarna.charAt(i) - '0')*Math.pow(2,(binarna.length()-i-1)); // '0' - '0' da 0, '1' - '0' da 1 (odejma sie wieksze liczby, ale wynik i tak bedzie 0 / 1)
        }

        return wynik;
    }

    public static String zamiana10na2rekurencyjnie(int liczba) {
        int wynik;
        if(liczba > 0) {
            wynik = liczba % 2;
            return zamiana10na2rekurencyjnie(liczba / 2)  + wynik;
        }
        return "";
    }

    public static int zamiana2na10rekurencyjnie(String binarna, int ktora){
        if (ktora == binarna.length()-1) {
            return binarna.charAt(ktora) - '0'; // nie mnozymy przez 2^0 bo to i tak jest 1
        }

        int cyfra = (binarna.charAt(ktora) - '0');
        int wynik = (int)(cyfra*Math.pow(2,binarna.length()-1-ktora));

        return zamiana2na10rekurencyjnie(binarna, ktora+1)+wynik;
    }

    public static String zamiana10na8(int liczba) {
        int wynik;
        if(liczba > 0) {
            wynik = liczba % 8;
            return zamiana10na8(liczba / 8)  + wynik;
        }
        return "";
    }

    public static int zamiana8na10(String osemkowa, int ktora) {
        if (ktora == osemkowa.length()-1) {
            return osemkowa.charAt(ktora) - '0'; // nie mnozymy przez 2^0 bo to i tak jest 1
        }

        int cyfra = (osemkowa.charAt(ktora) - '0');
        int wynik = (int)(cyfra*Math.pow(8,osemkowa.length()-1-ktora));

        return zamiana8na10(osemkowa, ktora+1)+wynik;
    }

    public static String zamiana10na16(int liczba) {
        String wynik = "";
        if(liczba > 0) {
            int resztaZDzielenia = liczba % 16;
            if (resztaZDzielenia>9){
                wynik += (char)('A' + resztaZDzielenia-10); // mozna tez jako 'A' + resztaZDzielenia%10
            }else {
                wynik += resztaZDzielenia;
            }
            return zamiana10na16(liczba / 16)  + wynik;
        }
        return "";
    }


    // do dokonczenia bazujac na zamianie z 8 na 10
    public static int zamiana16na10(String szesnastkowa, int ktora) {
        if (ktora == szesnastkowa.length()-1) {
            return szesnastkowa.charAt(ktora) - '0'; // nie mnozymy przez 2^0 bo to i tak jest 1
        }
        int cyfra;
        if(szesnastkowa.charAt(ktora) >= 'A'){
            cyfra = szesnastkowa.charAt(ktora) - 'A' + 10;
        }else {
            cyfra = (szesnastkowa.charAt(ktora) - '0');
        }
        int wynik = (int)(cyfra*Math.pow(16,szesnastkowa.length()-1-ktora));

        return zamiana16na10(szesnastkowa, ktora+1)+wynik;
    }

    // mozna zrobic na zasadzie zamiany z input na 10, a potem z 10 na output
    public static String zamianaDowolna(int system, int systemWyjsciowy, String input){
        int dziesiatkowa = zamianaDowolnaNa10(input, system, 0);
        return zamiana10NaDowolna(dziesiatkowa);
    }

    private static int zamianaDowolnaNa10(String input, int system, int ktora) {
        if (ktora == input.length()-1) {
            return input.charAt(ktora) - '0'; // nie mnozymy przez 2^0 bo to i tak jest 1
        }
        int cyfra;
        if(input.charAt(ktora) >= 'A'){
            cyfra = input.charAt(ktora) - 'A' + 10;
        }else {
            cyfra = (input.charAt(ktora) - '0');
        }
        int wynik = (int)(cyfra*Math.pow(system,input.length()-1-ktora));

        return zamiana16na10(input, ktora+1)+wynik;
    }

    private static String zamiana10NaDowolna(int dziesiatkowa) {
        String wynik = "";
        if(dziesiatkowa > 0) {
            int resztaZDzielenia = dziesiatkowa % 16;
            if (resztaZDzielenia>9){
                wynik += (char)('A' + resztaZDzielenia-10); // mozna tez jako 'A' + resztaZDzielenia%10
            }else {
                wynik += resztaZDzielenia;
            }
            return zamiana10na16(dziesiatkowa / 16)  + wynik;
        }
        return "";
    }

    /*
        Jak napisac funkcje ktora zrobi konwersje z dowolnego systemu na dowolny w formie:
        public static String konwertuj(int systemWejsciowy, int systemWyjsciowy, String liczbaDoZamiany);
         */
    public static void main(String[] args) {
        System.out.println(zamiana10na2iteracyjnie(10));
        System.out.println(zamiana2na10iteracyjnie("1101011"));
        System.out.println(zamiana10na2rekurencyjnie(10));
        System.out.println(zamiana2na10rekurencyjnie("1101011", 0));
        System.out.println(zamiana10na8(37));
        System.out.println(zamiana8na10("45",0));
        System.out.println(zamiana10na16(934));
        System.out.println(zamiana16na10("3A6", 0));
        System.out.println();
        System.out.println(zamianaDowolna(16,8,"12E"));
        Scanner s = new Scanner(System.in);
    }
}
