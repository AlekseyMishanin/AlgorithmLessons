package ru.mylife.LinkList.LinkedList;

public class LinkedListApp {
    public static void main (String[] args){
        LinkedList liList = new LinkedList();
        liList.insertFirst("Жора", 15);
        liList.insertFirst("Семен", 35);
        liList.insertFirst("Илья", 25);
        liList.deleteFirst();
        liList.insertLast("Симеон", 55);
        liList.insertLast("Владимир", 45);
        liList.insertLast("Игнат", 15);
        liList.insertLast("Григорий", 25);
        liList.deleteKey("Игнат");
        liList.display();
    }
}
