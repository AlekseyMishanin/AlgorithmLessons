package ru.mylife.LinkList.QueueList;

import ru.mylife.LinkList.LinkedList.LinkedList;

public class QueueList {
    private LinkedList list;

    public QueueList(){
        list = new LinkedList();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void insert(String name, int age){
        list.insertFirst(name, age);
    }

    public String delete (){
        return list.deleteLast().getName();
    }

    public void display(){
        list.display();
    }
}
