package org.example.escape_room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadingCSV {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/org/example/escape_room/rooms.csv"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Ktory pokoj przygotowac?");
        int nr = sc.nextInt();

       /* String fileLine = scanner.nextLine();
        System.out.println(fileLine);
        String[] itemsArray = fileLine.split(";"); //TODO: to samo bez split iterujac litera po literze i rozpoznajac srednik ;
        System.out.println(Arrays.toString(itemsArray));

        List<String> items = Arrays.asList(itemsArray);
        System.out.println(items);*/
        List<String> lineNr = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            String fileLine = scanner.nextLine();
            if (i == nr - 1) {
                String[] lineArray = fileLine.split(";");
                lineNr = Arrays.asList(lineArray);

            }

        }
        System.out.println(lineNr);
    }
}
