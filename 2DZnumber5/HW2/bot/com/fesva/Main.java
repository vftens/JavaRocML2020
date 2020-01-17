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

        //boolean debug = true;
        String[] parts;
        String inps;
        boolean n_bool; // ƒÀﬂ ◊»—À¿
        boolean s_bool;
        boolean s_bool1 = false; // ƒÀﬂ —“–Œ » Õ¿ 2-Ã Ã≈—“≈

        SimpleBot simpleBot = new SimpleBot();

        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            //simpleBot.
            String s = "";
            int n = 1;
            System.out.println("Please, Input Your Command:");
            //String
            inps = reader.readLine().trim();
            if (inps.equals("EXIT")) break;
            try {
                parts = inps.split("\\s");
                try {
                    n = Integer.parseInt(parts[1]);
                    n_bool = true;
                } catch (Exception e) {
                    n_bool = false;

                    try {
                        s = parts[1];
                        s_bool1 = true;
                    } catch (Exception e1) {
                        s_bool1 = false;
                    }
                }
                try {
                    //String
                    s = parts[2];
                    s_bool = true;
                } catch (Exception e) {
                    s_bool = false;
                }

                // Commands
                if (parts[0].equals("LIST")) {
                    for (String item : deals) {
                        System.out.println(item);
                    }
                } else if (parts[0].equals("ADD")) {
                    if (n_bool && s_bool) {
                        deals.add(n, s);
                    } else if (n_bool) {
                        //if (debug) System.out.println("Only n ");//
                        if (deals.add(s)) System.out.println("Ok ");
                        else System.out.println("Not added String " + s);
                    } else if (s_bool) {
                        if (deals.add(s)) System.out.println("Ok ADDing String ");
                    } else if (s_bool1) {
                        if (deals.add(s)) System.out.println("Ok ADD String ");
                    } else System.out.println("You must enter your specifications for ADD ");

                } else if (parts[0].equals("EDIT")) {
                    if (n_bool && s_bool) {
                        deals.set(n, s);
                    } else System.out.println("You must enter your specifications for EDIT ");

                } else if (parts[0].equals("DELETE")) {
                    if (n_bool) {
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
                System.out.println(simpleBot.sayInReturn(inps, true)); // œŒ√Œ¬Œ–»Ã
            }

        } // end while
        HelloTensorFlow htf = new HelloTensorFlow();
        htf.main("");
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

    //=simpleBot.SimpleBot();
}
