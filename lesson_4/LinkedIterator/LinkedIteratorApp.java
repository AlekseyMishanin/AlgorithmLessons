package ru.mylife.LinkList.LinkedIterator;

import ru.mylife.LinkList.LinkedList.LinkedList;

public class LinkedIteratorApp {

    public static void main (String[] a){
        LinkedList iList = new LinkedList();
        iList.insertFirst("Маркс", 150000);
        iList.insertFirst("Юпитер", 100000);
        iList.display();
        System.out.println();


        LinkedIterator iter = new LinkedIterator(iList);
        try {
            System.out.println("Начальное положение итератора - " + iter.getCurrent().getName());
            System.out.println();
            iter.nextLink();
        } catch (NullPointerException exc){;}
        iter.insertAfter("Луна", 90000);
        iter.insertBefore("Земля", 100800);
        iter.insertBefore("Земля1", 100801);
        iter.insertBefore("Земля2", 100802);
        iList.display();
        System.out.println();

        while (!iter.atEnd()){
            System.out.println("Удаляем из списка через итератор - " + iter.deleteCurrent().getName());
        }

    }
}
