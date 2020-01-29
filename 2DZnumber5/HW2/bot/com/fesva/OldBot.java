package com.fesva;
/*
����������� ������ ���, ������� ����� ��������� ��������� � �������. ������� LIST, ADD, EDIT, DELETE.
LIST ������ �������� ���� � �� ����������� ��������.
ADD - ��������� ���� � ����� ������ ��� ���� �� ����������� �����, ������� ��������� ���� �����, ���� ������� �����.
EDIT - �������� ���� � ��������� �������. DELETE - �������. ������� ������:

    LIST

    ADD �����-�� ����

    ADD 4 �����-�� ���� �� �������� �����

    EDIT 3 ����� �������� ����

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
