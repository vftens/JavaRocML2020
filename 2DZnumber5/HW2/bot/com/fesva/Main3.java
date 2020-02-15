package com.fesva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main3 {

    private static boolean debug = true; // false;
    private static ArrayList<String> deals = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //private static String[] parts;
    //private static String inputS;
    //private static boolean hasIndex = false; // index
    //private static boolean hasText; // text
    //private static boolean hasText1 = false; // text 2-j string
    //private static int n = 1;
    //private static String s = "";

    public static ArrayList<String> getDeals() {
        return deals;
    }

    public static Integer getIndex(String[] inputTokens) {
        if (inputTokens.length > 1 && inputTokens[1].matches("\\d+")) {
            return Integer.parseInt(inputTokens[1]);
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

    public static boolean myHasIndex(String[] parts) throws Exception {
        boolean result = false;
        if (parts[1] != null) {
            if (parts[1].matches("\\d+")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean myHasText(String[] parts) throws Exception {
        boolean result = false;
        if (parts[1] != null) {
            //hasText1 = false;
            if (parts[1].matches("\\w+")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean myHasText2(String[] parts) throws Exception {
        //s = parts[2];
        if (parts[2] != null) {
            if (parts[2].matches("\\w+")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public static void main(String[] args) throws Exception {
        SimpleBot simpleBot = getSimpleBot();
        // write your code here
        //reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            //simpleBot.
            System.out.println("Please, Input Your Command:");
            //String
            String inputS = reader.readLine().trim();
            if (inputS.equals("EXIT")) break;
            try {
                String[] parts = inputS.split("\\s+", 3);

                String command = null;
                Integer index = 0;
                String text = null;
                var hasIndex = false;
                boolean hasText = false;
                boolean hasText1 = false;
                try {
                    command = parts[0];
                    if (getIndex(parts) != null) {
                        index = getIndex(parts);
                    }
                    text = getText(parts);
                    if (index > deals.size()) {
                        index = deals.size() - 1;
                    }
                    /*
                    hasIndex = myHasIndex(parts);
                    //if (!hasIndex) {
                    hasText = myHasText(parts);
                    //}
                    hasText1 = myHasText2(parts);
                    if (debug) {
                        System.out.println("Before HasIndex " + index + " " + hasText + " " + text);
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

                     */
                } catch (Exception e) {
                    if (debug) System.out.println("Exception, Nothing to say " + e);// Nothing to say
                }
                // Commands
                if (command != null) {
                    switch (command) {
                        case "LIST":
                            int i = 0;
                            for (String item : deals) {
                                i++;
                                System.out.println(
                                        String.format("%d %s", i, item));
                            }
                            break;
                        case "ADD":
                            if (index == null) {
                                deals.add(text);
                            } else {
                                deals.add(index, text);
                            }

                        /*
                        if (hasIndex && hasText1) {
                            deals.add(n, s);
                            if (debug) {
                                System.out.println("ADD N S ");//
                            }
                        } else if (hasIndex) {
                            if (debug) System.out.print("Only n ");//
                            if (deals.add(s)) System.out.println("Ok ");
                            else System.out.println("Not added String " + s);
                        } else if (hasText) {
                            if (deals.add(s)) {
                                System.out.println("Ok ADDing String ");
                            }
                        } else if (hasText1) {
                            if (deals.add(s)) System.out.println("Ok ADD String ");

                         */

                            //else System.out.println("You must enter your specifications for ADD ");

                            break;
                        case "EDIT":
                            if (index != null && text != null) {
                                //if (hasIndex && hasText) {
                                deals.set(index, text); //(n, s);
                            } else System.out.println("You must enter your specifications for EDIT ");

                            break;
                        case "DELETE":
                            if (index != null && getDeals().size() <= 2) {
                                getDeals().remove(index); // n
                                if (debug) {
                                    System.out.println("Delete " + index);
                                }
                            } else System.out.println("You must enter your number for DELETE ");
                            break;
                        default:
                            System.out.println("Sorry, Unknown Command.");
                            break;
                    }
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
    }

    public static SimpleBot getSimpleBot() {
        SimpleBot simpleBot = new SimpleBot();
        return simpleBot;
    }
}
