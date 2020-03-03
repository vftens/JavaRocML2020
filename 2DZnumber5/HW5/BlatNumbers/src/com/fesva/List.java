package com.fesva;

import java.util.*;

public class List<S> {
    private static ArrayList<String> mylist;
    private static HashSet<String> hlist;
    private static TreeSet<String> tlist;

    public List(ArrayList<String> mylist) {
        List.mylist = mylist;
        this.hlist = new HashSet<>();
        this.tlist = new TreeSet<>();
    }

    public static void Sort(){
        System.out.println("list Size = " + mylist.size());
        Collections.sort(List.mylist);
    }

    public static void Add(String num) { // Добавляем варианты для поиска данных

        mylist.add(num);
        hlist.add(num);
        tlist.add(num);
    }

    static boolean nfound = false;

    public static void found(boolean x) {
        if (x) System.out.println("найден ");
        else System.out.println("не найден ");
    }

    public static void write(String command) { // Пишем результаты Поиска

        long start = Nano.nanoT();
        nfound = mylist.contains(command);
        long finish = Nano.nanoT();
        System.out.print("Поиск перебором: номер ");
        found(nfound);//найден/не найден,
        System.out.print("поиск занял ");
        long timeConsumedNanos = finish - start;
        //
        System.out.println(timeConsumedNanos + "нс");//34нс
        start = Nano.nanoT();
        if (binarySearch(mylist, command) != 0) {
            nfound = true;
        } else nfound = false; //
        finish = Nano.nanoT();
        System.out.print("Бинарный поиск: номер ");
        found(nfound);//найден/не найден,
        System.out.print("поиск занял ");
        timeConsumedNanos = finish - start;
        System.out.println(timeConsumedNanos + "нс");//34нс
        start = Nano.nanoT();
        nfound = hlist.contains(command);
        finish = Nano.nanoT();
        System.out.print("Поиск в HashSet: номер ");
        found(nfound);//найден/не найден,
        System.out.print("поиск занял ");
        timeConsumedNanos = finish - start;
        System.out.println(timeConsumedNanos + "нс");//34нс
        start = Nano.nanoT();
        nfound = tlist.contains(command);
        finish = Nano.nanoT();
        System.out.print("Поиск в TreeSet: номер ");
        found(nfound); //найден/не найден,
        System.out.print("поиск занял ");
        timeConsumedNanos = finish - start;
        System.out.println(timeConsumedNanos + "нс");//34нс
    }

    private static int binarySearch(ArrayList<String> mylist, String command) {
        return Collections.binarySearch(mylist, command);
    }
}
