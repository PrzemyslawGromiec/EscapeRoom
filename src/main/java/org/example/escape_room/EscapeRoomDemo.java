package org.example.escape_room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EscapeRoomDemo {

   /* Zaprojektuj program, w którym użytkownik będzie znajdował się w pokoju. Będą znajdować się w nim przedmioty:
   drzwi, okno i klucz.
    Użytkownik może wykonać wielokrotnie interakcje z jednym z wybranych przedmiotów
    (użyj narzędzia Scanner).
    Gra kończy się gdy uda mu się otworzyć drzwi.

    Jeśli użytkownik użyje:
    okno: - otworzy się lub zamknie
    klucz: - użytkownik zabierze klucz i klucz nie będzie się już pojawiał jako jedna z opcji
    drzwi: - otworzą się ale tylko jeśli użytkownik zabrał klucz, jeśli nie, pozostaną zamknięte

    Przy każdej próbie użycia obiektu powinien wyświetlić się stosowny komunikat.


    Zasada prostych narzędzi - rozwiązuj problem zawsze najprościej jak się tylko da chyba że natrafisz na konkretny problem (np. zaczynasz powtarzać ten sam kod)
    Zasada używalności - napisz kod, który można od razu użyć i zobaczyć efekt

    W przyszłości prawdopodobnie będą kolejne przedmioty z nowymi interakcjami
    mogą być pokoje z innymi przedmiotami

    //Po otworzeniu pokoju przechodzisz do kolejnego pomieszczenia w ktorym jest inna kombinacja obiektow , np. nie ma okna,
    otwarcie drzwi wymaga dwoch kluczy.
    - po przejsciu przez drzwi zmienia sie konfiguracja drugiego pokoju
    */

    // ukryte drzwi nie pojawia sie na liscie dopoki 2 okna nie zostana otwarte


    public static void main(String[] args) throws FileNotFoundException {
        int roomNr = 4;
        System.out.println("Mozesz wybrac pomiedzy: ");
        List<String> items = lineNR(roomNr);
       // System.out.println(items);
        Scanner scanner = new Scanner(System.in);


        List<Boolean> windowBooleanList = createWindowBooleanList(items);

        System.out.println(windowBooleanList);

        while (true) {
            System.out.println("wpisz swoj wybor");
            for (String item : items) {

                if (isAvaliable(item, windowBooleanList)) {
                    System.out.println(item);
                }
            }
            //System.out.println(items);

            System.out.println();
            String choice = scanner.nextLine();
            System.out.println("Wybrales: " + choice);
            System.out.println("Uzywam: " + choice);


            if (items.contains(choice) && isAvaliable(choice, windowBooleanList)) {
                if (choice.startsWith("okno")) {
                    int index = items.indexOf(choice);
                    System.out.println(windowBooleanList);
                    windowBooleanList.set(index, !windowBooleanList.get(index));
                    System.out.println(windowBooleanList);
                // System.out.println("Okno jest: " + (windowOpen ? "zamkniete" : "otwarte"));
            } else if (choice.equalsIgnoreCase("klucz")) {
                System.out.println("Zabrales klucz. ");
                items.remove("klucz");
            } else if (choice.equalsIgnoreCase("drzwi")) {
                System.out.println("Probujesz otworzyc drzwi.");
                if (!items.contains("klucz")) {
                    System.out.println("Otworzyles drzwi!");
                    roomNr++;
                    items = lineNR(roomNr);
                    System.out.println("Przechodzisz do kolejnego pokoju.");
                } else {
                    System.out.println("Nie masz klucza. Nie mozesz otworzyc drzwi. ");
                }
            }
            System.out.println("Jestes w pokoju nr: " + (roomNr));
        } else{
            System.out.println("nie ma takiego przedmiotu ");
        }
        if (items.isEmpty()) {
            System.out.println("Koniec");
            return;
        }
    }

}

    private static boolean isAvaliable(String item, List<Boolean> windowBooleanList) {
       if (!item.startsWith("ukryte") || isItBright(windowBooleanList)){
           return true;
       }
       return false;
    }


    private static boolean isItBright(List<Boolean> windowBooleanList) {
        for (int i =0; i < windowBooleanList.size(); i++) {
            if (!windowBooleanList.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static List<Boolean> createWindowBooleanList(List<String> items) {
        List<Boolean> windowBooleanList = new ArrayList<>();
        for (String item : items) {
            if(item.startsWith("okno")) {
                windowBooleanList.add(false);
            }
        }
        return windowBooleanList;
    }


    public static List<String> lineNR(int nr) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/java/org/example/escape_room/rooms.csv"));
        List<String> lineNr = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            if (sc.hasNext()) {
                String fileLine = sc.nextLine();
                if (i == nr - 1) {
                    String[] lineArray = fileLine.split(";");
                    lineNr.addAll(Arrays.asList(lineArray));
                }
            } else {
                lineNr = new ArrayList<>();
            }
        }
        return lineNr;
    }
}





/*
 boolean wzietyKlucz = false;
        boolean otwarte = true;

        System.out.println("Masz następujące opcje:");
        System.out.println("1. Okno");
        System.out.println("2. Drzwi");
        if (!wzietyKlucz) {
            System.out.println("3. Klucz");
        }
* */