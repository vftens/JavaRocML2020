package com.fesva;
/*
–азработать список дел, которым можно управл€ть командами в консоли.  оманды LIST, ADD, EDIT, DELETE.
LIST должен выводить дела с их пор€дковыми номерами.
ADD - добавл€ть дело в конец списка или дело на определЄнное место, сдвига€ остальные дела вперЄд, если указать номер.
EDIT - замен€ть дело с указанным номером. DELETE - удал€ть. ѕримеры команд:

    LIST

    ADD  акое-то дело

    ADD 4  акое-то дело на четвЄртом месте

    EDIT 3 Ќовое название дела

    DELETE 7
 */

import java.util.ArrayList;
//import java.util.Map;

public class OldBot {

    private static ArrayList<String> deals = null;
    //if(inp == "LIST")LIST();

    public static boolean main(String[] args) {

        try {
            if (args[0].equals("LIST")) LIST(); //break;
            else if (args[0].equals("ADD")) ADD(Integer.parseInt(args[1]), args[2]);
            else if (args[0].equals("EDIT")) EDIT(Integer.parseInt(args[1]), args[2]);
            else if (args[0].equals("DELETE")) DELETE(Integer.parseInt(args[1]));
        }
        catch(Exception e)
        {
            System.out.println("Catch Exception " + e);
        }
        finally {
            return true;
        }
    }

    private static void LIST() {

        for(String item : deals){
            System.out.println(item);
        }
    }

    private static void ADD(int n, String s) {

        deals.add(n, s);
    }

    private static void EDIT (int n, String s){

        deals.add(n, s);

    }


    private static void DELETE (int n){

        deals.remove(n);
    }

    public static ArrayList<String> getDeals() {
        return deals;
    }

    public static void setDeals() {
        setDeals(0, "");
    }

    private static void setDeals(int i, String s) {
    }

    public static void setDeals(ArrayList<String> deals) {
        OldBot.deals = deals;
    }
}
