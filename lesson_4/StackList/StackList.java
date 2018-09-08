package ru.mylife.LinkList.StackList;

import ru.mylife.LinkList.LinkedList.LinkedList;

public class StackList {
    private LinkedList list;
    public StackList(){
        list = new LinkedList();
    }
    public void push (String name, int age){
        list.insertFirst(name,age);
    }

    public String pop (){
        return list.deleteFirst().getName();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }
}
