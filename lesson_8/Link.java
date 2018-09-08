package ru.lessons8;

public class Link {

    private int data;
    public Link next;

    Link(int data){
        this.data=data;
    }

    public int getKey(){
        return this.data;
    }

    public void display(){
        System.out.print(data + " ");
    }
}
