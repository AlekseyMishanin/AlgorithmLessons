package ru.lessons8;

import java.util.Random;

/*1. Реализовать программу, реализующую метод цепочек.*/

/*В методе Main создается экземпляр класса HashTable hTable размером в 10 элементов.
* В hTable вставляются 10 рандомных чисел. Результат выводится в консоль.
* Выполняется поиск в hTable эленмета со значением 10 и 103.
* В hTable добавляется элемент со значением 150. Результат выводится в консоль.
* В hTable удаляется элемент со значением 150. Результат выводится в консоль.*/


public class Main {

    public static void main(String[] args) {

        HashTable hTable = new HashTable(10);
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            hTable.insert(rand.nextInt(1000));
        }

        hTable.display();

        System.out.println("Find 10 in hashtable: " + hTable.find(10));
        System.out.println("Find 103 in hashtable: " + hTable.find(103));

        hTable.insert(150);
        hTable.display();

        hTable.delete(150);
        hTable.display();
    }
}
