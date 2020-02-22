package com.fesva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static boolean debug = false; //true; //
    private static ArrayList<String> deals = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getIndex(String[] inputTokens) {
        if (inputTokens.length > 1 && inputTokens[1].matches("\\d{1,5}")) {
            int myindex = Integer.parseInt(inputTokens[1]);

            if (myindex > deals.size()) {
                myindex = deals.size() - 1;
            }
            return myindex;
        }
        return null;
    }

    private static String getText(String[] parts) {
        if (parts.length == 3) {
            if (getIndex(parts) != null) {
                // Для случая: ADD 3 text
                return parts[2];
            } else {
                // ADD some text
                return parts[1] + parts[2];
            }
        } else if (parts.length == 2) {
            // ADD text
            return parts[1];
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        SimpleBot simpleBot = getSimpleBot();  //simpleBot.
        while (true) {
            System.out.println("Please, Input Your Command:");
            //String
            String inputS = reader.readLine().trim();
            if (inputS.equals("EXIT")) break;

            String[] parts = inputS.split("\\s+", 3);

            String command = parts[0];
            Integer index = getIndex(parts);
            String text = getText(parts);
            // Commands
            switch (command) {
                case "LIST":
                    int i = 0;
                    for (String item : deals) {
                        i++;
                        System.out.printf("%d %s%n", i, item);
                    }
                    break;
                case "ADD":
                    if (index == null) {
                        deals.add(text);
                    } else if (text != null) {
                        deals.add(index, text);
                    } else {
                        System.out.println("You must enter your specifications for ADD ");
                    }
                    break;
                case "EDIT":
                    if (index != null && text != null) {
                        //if (hasIndex && hasText)
                        deals.set(index, text); //(n, s);
                    } else {
                        System.out.println("You must enter your specifications for EDIT ");
                    }
                    break;
                case "DELETE":
                    if (index != null) {
                        deals.remove((int) index);
                        if (debug) {
                            System.out.println("Delete " + index);
                        }
                    } else {
                        System.out.println("You must enter your number for DELETE ");
                    }
                    break;
                default:
                    System.out.println("Sorry, Unknown Command.");
                    break;
            }
            System.out.println(simpleBot.sayInReturn(inputS, true)); //     //sayInReturn
        } // end while
    }

    public static SimpleBot getSimpleBot() {
        SimpleBot simpleBot = new SimpleBot();
        return simpleBot;
    }
}