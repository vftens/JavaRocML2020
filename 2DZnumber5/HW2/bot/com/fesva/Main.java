package com.fesva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static boolean debug = false; //true;

    private static ArrayList<String> deals = new ArrayList<>();
    public SimpleBot simpleBot;

    private static BufferedReader reader;
    private static String[] parts;
    private static String inputS;
    private static boolean hasIndex = false; // index
    private static boolean hasText; // text
    private static boolean hasText1 = false; // text 2-j string
    private static int n = 1;
    private static String s = "";

    public static ArrayList<String> getDeals() {
        return deals;
    }

    public static boolean myHasIndex(String[] parts) throws Exception {
        if (parts[1] != null) {
            if (parts[1].matches("\\d+")) {
                hasIndex = true;
                n = Integer.parseInt(parts[1]);
                return true;
            } else {
                hasIndex = false;
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean myHasText(String[] parts) throws Exception {
        if (parts[1] != null) {
            if (parts[1].matches("\\w+")) {
                hasText1 = true;
                s = parts[1];
                return true;
            } else {
                hasText1 = false;
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean myHasText2(String[] parts) throws Exception {
        //s = parts[2];
        if (parts[2] != null) {
            if (parts[2].matches("\\w+")) {
                hasText = true;
                s = parts[2];
                return true;
            } else {
                hasText = false;
                return false;
            }
        } else {
            return false;
        }
    }

    public static void tryTensorflow() throws Exception {
        System.out.println("Switch on Tensorflow?[Y/N]");
        inputS = reader.readLine().trim();
        if (inputS.equals("Y") || inputS.equals("y")) {
            HelloTensorFlow htf = new HelloTensorFlow();
            htf.main(""); // ?????????
        }
        // htf.wait(1);
        // TODO: adding working with TF and GPT2
    }

    public static void main(String[] args) throws Exception {
        SimpleBot simpleBot = new SimpleBot();
        // write your code here
        reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            //simpleBot.
            System.out.println("Please, Input Your Command:");
            //String
            inputS = reader.readLine().trim();
            if (inputS.equals("EXIT")) break;
            try {
                parts = inputS.split("\\s");
                try {
                    if (debug) {
                        System.out.println("Before HasIndex");
                    }
                    if (!myHasIndex(parts)) {
                        if (debug) {
                            System.out.println("Inside HasIndex Then");
                        }
                        if (!myHasText(parts)) {
                            //s = parts[1];
                            if (debug) {
                                System.out.println("Inside HasText Then");
                            }
                        }
                    }
                    //String
                    if (!myHasText2(parts)) {
                        if (debug) {
                            System.out.println("Inside HasText2 Then");
                        }
                    }
                } catch (Exception e) {
                    // Nothing to say
                }
                // Commands
                if (parts[0] != null) {
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
                            if (debug) {
                                System.out.println("ADD N S ");//
                            }
                        } else if (hasIndex) {
                            //if (debug) System.out.println("Only n ");//
                            if (deals.add(s)) System.out.println("Ok ");
                            else System.out.println("Not added String " + s);
                        } else if (hasText) {
                            if (deals.add(s)) {
                                System.out.println("Ok ADDing String ");
                            }
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
                    } else System.out.println("Sorry, Unknown Command.");

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index Out of Bounds Exception, Please Use Appropriate Index. " + e);
            } catch (Exception e) {
                System.out.println("MY Exception " + e);
            } finally {
                System.out.println(simpleBot.sayInReturn(inputS, true)); //     //sayInReturn
            }
        } // end while
        tryTensorflow();
    }

    public SimpleBot getSimpleBot() {
        SimpleBot simpleBot = new SimpleBot();
        return simpleBot;
    }

    public void setSimpleBot(SimpleBot simpleBot) {
        this.simpleBot = simpleBot;
    }
}
