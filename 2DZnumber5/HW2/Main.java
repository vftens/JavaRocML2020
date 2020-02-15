package com.fesva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static boolean debug = false; //true;
    private static ArrayList<String> deals = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

    public static Integer getIndex(String[] inputTokens) {
        if (inputTokens.length >= 1 && inputTokens[1].matches("\\d+")) {
            return Integer.parseInt(inputTokens[1]);
        }
        return  null;
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
        while (true) {
            System.out.println("Please, Input Your Command:");

            String inputS = reader.readLine().trim();
            String[] parts = inputS.split("\\s+", 3);

            String command = parts[0];
            Integer index = getIndex(parts);
            String text = getText(parts);

            if (command.equals("EXIT")) {
                break;
            } else if (command.equals("ADD")) {
                if (index == null) {
                    deals.add(text);
                } else {
                    if (index > deals.size()) {
                        index = deals.size();
                    }
                    deals.add(index, text);
                }
            }
        }
    }

}
