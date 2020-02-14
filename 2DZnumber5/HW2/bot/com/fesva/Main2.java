package com.fesva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {
    private static boolean debug = true; // false;
    private static ArrayList<String> deals = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getIndex(String[] inputTokens) {
        if (inputTokens.length >= 1 && inputTokens[1].matches("\\d+")) {
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
        if (parts[1] != null) {
            if (parts[1].matches("\\d+")) {
                //hasIndex = true;
                //n = Integer.parseInt(parts[1]);
                return true;
            } else {
                //hasIndex = false;
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean myHasText(String[] parts) throws Exception {
        if (parts[1] != null) {
            if (parts[1].matches("\\w+")) {
                //hasText1 = true;
                //s = parts[1];
                return true;
            } else {
                //hasText1 = false;
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
                //hasText = true;
                //s = parts[2];
                return true;
            } else {
                //hasText = false;
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SimpleBot simpleBot = getSimpleBot();
        while (true) {
            System.out.println("Please, Input Your Command:");

            String inputS = null;
            try {
                inputS = reader.readLine().trim();
                try {
                    String[] parts = inputS.split("\\s+", 3);

                    String command = null;
                    Integer index = 0;
                    String text = null;
                    boolean hasIndex = false;
                    boolean hasText = false;
                    boolean hasText2 = false;

                    try {
                        command = parts[0];
                        index = getIndex(parts);
                        //if (index == null) {
                            text = getText(parts);
                        //}
                        hasIndex = myHasIndex(parts);
                        if (!hasIndex) {
                            hasText = myHasText(parts);
                        }
                        hasText2 = myHasText2(parts);
                    } catch (Exception e) {
                        if (debug) System.out.println("Exception, Nothing to say " + e);
                    }

                    if (command.equals("EXIT")) {
                        break;
                    } else if (command.equals("ADD")) {
                        if (hasIndex && hasText) {
                            deals.add(index, text);
                            if (debug) {
                                System.out.println("ADD N S ");//
                            }
                        } else if (hasIndex) {
                            //if (debug) System.out.println("Only n ");//
                            if (deals.add(text)) System.out.println("Ok ");
                            else System.out.println("Not added String " + text);
                        } else if (hasText) {
                            if (deals.add(text)) {
                                System.out.println("Ok ADDing String ");
                            }
                        } else if (hasText2) {
                            if (deals.add(text)) System.out.println("Ok ADD String ");
                        } else System.out.println("You must enter your specifications for ADD ");

                    } else if (command.equals("LIST")) {
                        int i = 0;
                        for (String item : deals) {
                            i++;
                            System.out.println(
                                    java.lang.String.format("%d %s", i, item));
                        }
                    } else if (command.equals("DELETE")) {
                        if (hasIndex) {
                            deals.remove(index);
                        } else System.out.println("You must enter your number for DELETE ");
                    } else if (command.equals("EDIT")) {
                        if (hasIndex && hasText) {
                            deals.set(index, text);
                        } else System.out.println("You must enter your specifications for EDIT ");
                    } else {
                        System.out.println("Sorry, Unknown Command.");
                    }
                } catch (Exception e1) {
                    if (debug) System.out.println("Exception get" + e1);
                    throw e1;
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
        }
    }

    public static SimpleBot getSimpleBot() {
        SimpleBot simpleBot = new SimpleBot();
        return simpleBot;
    }
}
