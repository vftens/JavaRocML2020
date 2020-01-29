package com.fesva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Main {

    private static ArrayList<String> deals = new ArrayList<>();
    private SimpleBot simpleBot;

    public static ArrayList<String> getDeals() {
        return deals;
    }

    public static void main(String[] args) throws Exception {

        String[] parts;
        String inputS;
        boolean hasIndex = false; // ��� �����
        boolean hasText; // ��� ������
        boolean hasText1 = false; // ��� ������ �� 2-� �����

        SimpleBot simpleBot = new SimpleBot();

        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            //simpleBot.
            String s = "";
            int n = 1;
            System.out.println("Please, Input Your Command:");
            //String
            inputS = reader.readLine().trim();
            if (inputS.equals("EXIT")) break;
            try {
                parts = inputS.split("\\s");
                try {
                    n = Integer.parseInt(parts[1]);
                    if (parts[1].matches("\\d+")) {
                        hasIndex = true;
                    }
                } catch (Exception e) {
                    hasIndex = false;

                    try {
                        s = parts[1];
                        hasText1 = true;
                    } catch (Exception e1) {
                        hasText1 = false;
                    }
                }
                try {
                    //String
                    s = parts[2];
                    hasText = true;
                } catch (Exception e) {
                    hasText = false;
                }

                // Commands
                if (parts[0].equals("LIST")) {
                    int i = 0;
                    for (String item : deals) {
                        i++;
                        System.out.println(
                                java.lang.String.format("%d %s", i, item));
                    }
                } else if (parts[0].equals("ADD")) {
                    if (hasIndex && hasText) {
                        deals.add(n, s);
                    } else if (hasIndex) {
                        //if (debug) System.out.println("Only n ");//
                        if (deals.add(s)) System.out.println("Ok ");
                        else System.out.println("Not added String " + s);
                    } else if (hasText) {
                        if (deals.add(s)) System.out.println("Ok ADDing String ");
                    } else if (hasText1) {
                        if (deals.add(s)) System.out.println("Ok ADD String ");
                    } else System.out.println("You must enter your specifications for ADD ");

                } else if (parts[0].equals("EDIT")) {
                    if (hasIndex && hasText) {
                        deals.set(n, s);
                    } else System.out.println("You must enter your specifications for EDIT ");

                } else if (parts[0].equals("DELETE")) {
                    if (hasIndex) {
                        deals.remove(n);
                    } else System.out.println("You must enter your number for DELETE ");
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index Out of Bounds Exception, Please Use Appropriate Index. " + e);

            } catch (Exception e) {
                System.out.println("MY Exception " + e);
            } finally {
                System.out.println(simpleBot.sayInReturn(inputS, true)); // ���������
            }

        } // end while
        HelloTensorFlow htf = new HelloTensorFlow();
        htf.main(""); // ���������
        // htf.wait(1);
        // TODO: adding working with TF and GPT2

    }

    //sayInReturn

    public SimpleBot getSimpleBot() {
        SimpleBot simpleBot = new SimpleBot();
        return simpleBot;
    }

    public void setSimpleBot(SimpleBot simpleBot) {
        this.simpleBot = simpleBot;
    }
}
