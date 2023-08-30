package org.example.escape_room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "okno1";
        List<Boolean> booleans = new ArrayList<>();
        booleans.add(false);
        booleans.add(false);
        booleans.add(false);
        booleans.add(false);
        List<String> items = new ArrayList<>(List.of("okno1", "okno2", "okno3", "okbubi"));
        System.out.println(booleans);

        //metoda ktora porowna dwa stringi i zobaczy w w drugim stringu jest poszukiwany string
        String regex = "^okno.*$";
        int count = 0;
        for (String s : items) {
            if (s.matches(regex)) {
               count++;
            }
        }

        System.out.println(count);


        //count = 0;
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

   /*    for (String item : items) {
           if (item.matches(regex)) {
               count++;
           }
       }*/



       if (choice.matches(regex)) {
           System.out.println(booleans);
           for(int i = 0; i < count; i++) {
               booleans.set(i,true);
           }
       }
        System.out.println(booleans);

        //System.out.println(count);
        //System.out.println(booleans);


    }
}
