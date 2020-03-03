package com.fesva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<String> mylist = new ArrayList<>();
        List<String> list = new List<>(mylist);
        // Генерация номеров первоначальная
        String chars[] = new String[]{"A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К", "Л", "М",
                "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч",
                "Ш", "Щ", "Э", "Ю", "Я"};

        for (int i = 0; i < chars.length; i++) {
            for (int ii = 0; ii < chars.length; ii++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 10; l++) {
                            for (int m = 0; m < 10; m++) {
                                String currChar = chars[i];
                                String currChar1 = chars[ii];
                                String number;
                                if (k == 0) {
                                    if (l == 0 && m == 0) continue; // region 01..199
                                    number = String.format("%s%s%d%d%d%s%d%d",
                                            currChar, currChar1, j, j, j, currChar, l, m);
                                } else {
                                    number = String.format("%s%s%d%d%d%s%d%d%d",
                                            currChar, currChar1, j, j, j, currChar, k, l, m);
                                }

                                List.Add(number);
                            }
                        }
                    }
                }
            }
        }

        List.Sort();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Какой номер вы ищете?");
        while (true) {
            try {
                String command = reader.readLine().trim();
                if (command.equals("quit"))
                    break;

                List.write(command);
                System.out.println("Попробуйте ввести другое ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
