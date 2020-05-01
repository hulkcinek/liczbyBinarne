package com.company;

public class Main {

    /*
    1. Zamiana liczby dziesietnej na binarna (iteracyjnie)
    2. Zamiana liczby dziesietnej na binarna (rekurencyjnie)
    3. Zamiana liczby binarnej na dziesietna (iteracyjnie)
    4. Zamiana liczby binarnej na dziesietna (rekurencyjnie)
     */

    public static String zamiana10na2iteracyjnie(int liczba) {
        String wynik = "";
        while (liczba>0){
            wynik = liczba%2 + wynik; // dopisanie z przodu zmiennej wynik
            liczba = liczba/2; // liczba /= 2;
        }
        return wynik;
    }
    // zasada dzialania ^ - XOR (ksor)
    /*
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
            return binarna.charAt(ktora) - '0';
        }
        return (zamiana2na10rekurencyjnie(binarna.charAt(ktora) - '0') < (binarna.length()-ktora-1)) +
                zamiana2na10rekurencyjnie(binarna, ktora+1);
    }


    /*
    Zastanowic sie nad zadaniami z rekurencja^
    (odpowiedzi sa baardzo podobne do wersji iteracyjnej)
    +
    https://pl.spoj.com/problems/SKARBFI.pdf
     */
    public static void main(String[] args) {
        System.out.println(zamiana10na2iteracyjnie(10));
        System.out.println(zamiana2na10iteracyjnie("1101011"));
        System.out.println(zamiana10na2rekurencyjnie(10));
        System.out.println(zamiana2na10rekurencyjnie("1101011", 0));
    }
}
